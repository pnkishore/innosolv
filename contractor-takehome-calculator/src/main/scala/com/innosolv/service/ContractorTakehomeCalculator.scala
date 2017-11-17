package com.innosolv.service

import com.innosolv.model._

object ContractorTakehomeCalculator {

  /** Returns None if there isn't enough profit to accommodate given salary */
  def calculate(revenue: BigDecimal, expenses: BigDecimal, spouseDividendsShare: BigDecimal, salary: BigDecimal): Option[ContractorTakehomeCalculationResult] = {
    val companyEarnings = CompanyEarningsAndExpenses(revenue, salary, expenses)
    val companyTaxResult = CompanyTaxCalculator.calculate(companyEarnings)
    val distributableProfit = companyTaxResult.distributableProfit
    Option(distributableProfit)
      .find(_ > 0)
      .map(dp => {
        val spouseDividends = dp * spouseDividendsShare / 100
        val directorsDividends = dp - spouseDividends

        val directorsEarnings = Earnings(salary, directorsDividends, 0)
        val spouseEarnings = Earnings(0, spouseDividends, 0)

        val directorTaxResult = PAYETaxCalculator.calculate(directorsEarnings)
        val spouseTaxResult = PAYETaxCalculator.calculate(spouseEarnings)
        ContractorTakehomeCalculationResult(directorsEarnings, directorTaxResult, spouseTaxResult, companyTaxResult)
      })
  }

}
