package com.innosolv.service

import com.innosolv.model.{CompanyEarningsAndExpenses, CompanyTaxCalculationResult}

object CompanyTaxCalculator {


  def calculate(in: CompanyEarningsAndExpenses): CompanyTaxCalculationResult = {
    val employersNi = NICalculator.calculateEmployerNi(in.directorsSalary)
    val totalExpenses = in.directorsSalary + in.expenses + employersNi
    val profit = in.earnings - totalExpenses
    val corpTax = profit * RateConfig.CorpTaxRate / BigDecimal(100)
    CompanyTaxCalculationResult(in.earnings, in.directorsSalary, in.expenses, employersNi, corpTax, profit)
  }

}
