package com.innosolv.service

import com.innosolv.model.{CompanyEarningsAndExpenses, CompanyTaxResult}

object CompanyTaxCalculator {
  val CorpTaxRate:BigDecimal = 19

  def calculate(in: CompanyEarningsAndExpenses): CompanyTaxResult = {
    val employersNi = NICalculator.calculateEmployerNi(in.directorsSalary)
    val totalExpenses = in.directorsSalary + in.expenses + employersNi
    val profit = in.earnings - totalExpenses
    val corpTax = profit * CorpTaxRate / BigDecimal(100)
    CompanyTaxResult(in.earnings, in.directorsSalary, in.expenses, employersNi, corpTax, profit)
  }

}
