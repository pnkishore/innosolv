package com.innosolv.service

import com.innosolv.model.{Earnings, PAYETaxCalculationResult, PAYETaxRateResult}
import RateConfig._

object PAYETaxCalculator {

  def calculate(earnings: Earnings): PAYETaxCalculationResult = {
    val personalAllowance = PersonalAllowanceCalculator.calculate(earnings)
    val taxableIncomeAfterPersonalAllowance = applyPersonalAllowance(personalAllowance, earnings)

    val incomeAtBasicRate = mapEarningsToRate(taxableIncomeAfterPersonalAllowance, PAYEBasicRate)
    val incomeAtHigherRate = mapEarningsToRate(taxableIncomeAfterPersonalAllowance, PAYEHigherRate)
    val incomeAtAdditionalHigherRate = mapEarningsToRate(taxableIncomeAfterPersonalAllowance, PAYEAdditionalHigherRate)

    val finalTaxableIncome = applyDividendsAllowance(List(incomeAtBasicRate, incomeAtHigherRate, incomeAtAdditionalHigherRate))
    val taxRateResults =
      List((finalTaxableIncome(0), PAYEBasicRate), (finalTaxableIncome(1), PAYEHigherRate), (finalTaxableIncome(2), PAYEAdditionalHigherRate))
      .map(e => calculateTaxAtRate(e._1, e._2))
    val ni = NICalculator.calculateEmployeeNi(earnings.salary)

    PAYETaxCalculationResult(personalAllowance, earnings.salary + earnings.otherTaxableIncome, earnings.dividends, taxRateResults, ni)
  }

  private[this] def calculateTaxAtRate(earnings: Earnings, rate: PAYETaxRate): PAYETaxRateResult = {
    val salaryAndOther = earnings.salary + earnings.otherTaxableIncome
    val taxOnSalaryAndOther = salaryAndOther * rate.salaryRate / BigDecimal(100)
    val taxOnDividends = earnings.dividends * rate.dividendsRate / BigDecimal(100)
    PAYETaxRateResult(rate.rateType, salaryAndOther, taxOnSalaryAndOther, earnings.dividends, taxOnDividends)
  }

  private[this] def applyDividendsAllowance(ratewiseIncome: List[Earnings]): List[Earnings] = {
    var availableAllowance = TaxFreeDividendsAllowance
    ratewiseIncome.map {
      income =>
        val freeDividendsAtCurrentRate = availableAllowance.min(income.dividends)
        availableAllowance -= freeDividendsAtCurrentRate
        val dividends = income.dividends - freeDividendsAtCurrentRate
        income.copy(dividends = dividends)
    }
  }

  private[this] def mapEarningsToRate(earnings: Earnings, rate: PAYETaxRate): Earnings =  {
    val allEarnings = List(earnings.salary, earnings.otherTaxableIncome, earnings.dividends)
    var needed = rate.maxThreshold.getOrElse(BigDecimal(Double.MaxValue)) - rate.minThreshold
    var consumedTotal: BigDecimal = 0
    var sum: BigDecimal = 0
    val result = allEarnings.map {
      thisEarnings =>
        if (needed > 0 && thisEarnings > 0) {
          sum += thisEarnings
          val available: BigDecimal = if (sum > rate.minThreshold) (sum - rate.minThreshold - consumedTotal) else 0
          val consumed = if (available <= needed) available else needed
          consumedTotal += consumed
          needed -= consumed
          consumed
        } else {
          BigDecimal(0)
        }
    }
    Earnings(result(0), result(2), result(1))
  }

  private[this] def applyPersonalAllowance(personalAllowance: BigDecimal, in: Earnings): Earnings = {
    val adjustedSalary = applyPersonalAllowance(in.salary, personalAllowance)
    val adjustedOtherIncome = applyPersonalAllowance(in.otherTaxableIncome, adjustedSalary._2)
    val adjustedDividends = applyPersonalAllowance(in.dividends, adjustedOtherIncome._2)
    Earnings(adjustedSalary._1, adjustedDividends._1, adjustedOtherIncome._1)
  }

  private[this] def applyPersonalAllowance(earnings: BigDecimal, personalAllowance: BigDecimal): (BigDecimal, BigDecimal) = {
    if (earnings > personalAllowance) (earnings - personalAllowance, 0)
    else (0, personalAllowance - earnings)
  }
}