package com.innosolv.model

case class Earnings(salary: BigDecimal, dividends: BigDecimal, otherTaxableIncome: BigDecimal) {
  val grossIncome = salary + dividends + otherTaxableIncome
}

case class CompanyEarningsAndExpenses(earnings: BigDecimal, directorsSalary: BigDecimal, expenses: BigDecimal)

case class CompanyTaxCalculationResult(revenue: BigDecimal, salary: BigDecimal, expenses: BigDecimal,
                                       employersNi: BigDecimal, corpTax: BigDecimal, profit: BigDecimal) {
  def allExpenses = salary + expenses + employersNi

  def distributableProfit = profit - corpTax
}

case class PAYETaxRateResult(rateType: String,
                             salaryAndOther: BigDecimal,
                             taxOnSalaryAndOthers: BigDecimal,
                             dividends: BigDecimal,
                             taxOnDividends: BigDecimal)

case class PAYETaxCalculationResult(personalAllowance: BigDecimal, salaryAndOther: BigDecimal,
                                    dividends: BigDecimal, taxRateResults: List[PAYETaxRateResult],
                                    ni: BigDecimal) {

  def totalTaxOnSalaryAndOthers = taxRateResults.map(_.taxOnSalaryAndOthers).sum

  def totalTaxOnDividends = taxRateResults.map(_.taxOnDividends).sum

  def totalTax = totalTaxOnSalaryAndOthers + totalTaxOnDividends

  def totalEarnings = salaryAndOther + dividends

  def totalTakehome = totalEarnings - totalTax - ni
}

case class ContractorTakehomeCalculationResult(directorsEarnings: Earnings,
                                               directorsTaxResult: PAYETaxCalculationResult,
                                               spouseTaxResult: PAYETaxCalculationResult,
                                               companyTaxResult: CompanyTaxCalculationResult) {
  val totalTakehome = directorsTaxResult.totalTakehome + spouseTaxResult.totalTakehome
}