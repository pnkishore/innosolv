package com.innosolv.service

import com.innosolv.model.{PersonalEarnings, PersonalTaxResult, PersonalTaxRateResult}

object PersonalTaxCalculator {

  case class TaxRate(rateType: String, minThreshold: BigDecimal, maxThreshold: Option[BigDecimal], salaryRate: BigDecimal, dividendsRate: BigDecimal)
  val BasicRate = TaxRate("Basic Rate", 0, Some(33500), 20, 7.5)
  val HigherRate = TaxRate("Higher Rate", 33500, Some(150000), 40, 32.5)
  val AdditionalHigherRate = TaxRate("Additional Higher Rate", 150000, None, 45, 38.1)
  val TaxFreeDividendsAlloance = BigDecimal(5000)

  def calculateTaxOnEarnings(earnings: PersonalEarnings): PersonalTaxResult = {
    val personalAllowance = PersonalAllowanceCalculator.calculate(earnings)
    val taxableIncome = applyPersonalAllowance(personalAllowance, earnings)

    val incomeAtBasicRate = mapEarningsToRate(taxableIncome, BasicRate)
    val incomeAtHigherRate = mapEarningsToRate(taxableIncome, HigherRate)
    val incomeAtAdditionalHigherRate = mapEarningsToRate(taxableIncome, AdditionalHigherRate)

    val finalTaxableIncome = applyDividendsAllowance(List(incomeAtBasicRate, incomeAtHigherRate, incomeAtAdditionalHigherRate))
    val taxRateResults =
      List((finalTaxableIncome(0), BasicRate), (finalTaxableIncome(1), HigherRate), (finalTaxableIncome(2), AdditionalHigherRate))
      .map(e => caculateTaxAtRate(e._1, e._2))
    val ni = NICalculator.calculateEmployeeNi(earnings.salary)

    PersonalTaxResult(personalAllowance, earnings.salary + earnings.otherTaxableIncome, earnings.dividends, taxRateResults, ni)
  }

  private[this] def caculateTaxAtRate(earnings: PersonalEarnings, rate: TaxRate): PersonalTaxRateResult = {
    val salaryAndOther = earnings.salary + earnings.otherTaxableIncome
    val taxOnSalaryAndOther = salaryAndOther * rate.salaryRate / BigDecimal(100)
    val taxOnDividends = earnings.dividends * rate.dividendsRate / BigDecimal(100)
    PersonalTaxRateResult(rate.rateType, salaryAndOther, taxOnSalaryAndOther, earnings.dividends, taxOnDividends)
  }

  private[this] def applyDividendsAllowance(ratewiseIncome: List[PersonalEarnings]): List[PersonalEarnings] = {
    var availableAllowance = TaxFreeDividendsAlloance
    ratewiseIncome.map {
      income =>
        val freeDividendsAtCurrentRate = availableAllowance.min(income.dividends)
        availableAllowance -= freeDividendsAtCurrentRate
        val dividends = income.dividends - freeDividendsAtCurrentRate
        income.copy(dividends = dividends)
    }
  }

  private[this] def mapEarningsToRate(earnings: PersonalEarnings, rate: TaxRate): PersonalEarnings =  {
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
    PersonalEarnings(result(0), result(2), result(1))
  }

  private[this] def applyPersonalAllowance(personalAllowance: BigDecimal, in: PersonalEarnings): PersonalEarnings = {
    val adjustedSalary = applyPersonalAllowance(in.salary, personalAllowance)
    val adjustedOtherIncome = applyPersonalAllowance(in.otherTaxableIncome, adjustedSalary._2)
    val adjustedDividends = applyPersonalAllowance(in.dividends, adjustedOtherIncome._2)
    PersonalEarnings(adjustedSalary._1, adjustedDividends._1, adjustedOtherIncome._1)
  }

  private[this] def applyPersonalAllowance(earnings: BigDecimal, remainingPA: BigDecimal): (BigDecimal, BigDecimal) = {
    if (earnings > remainingPA) (earnings - remainingPA, 0)
    else (0, remainingPA - earnings)
  }
}