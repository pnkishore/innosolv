package com.innosolv.model

case class PersonalEarnings(salary: BigDecimal, dividends: BigDecimal, otherTaxableIncome: BigDecimal) {
  val grossIncome = salary + dividends + otherTaxableIncome
}

case class CompanyEarningsAndExpenses(earnings: BigDecimal, directorsSalary: BigDecimal, expenses: BigDecimal)

case class CompanyTaxResult(revenue: BigDecimal, salary: BigDecimal, expenses: BigDecimal,
                            employersNi: BigDecimal, corpTax: BigDecimal, profit: BigDecimal) {

  def allExpenses = salary + expenses + employersNi
  def distributableProfit = profit - corpTax
}

case class PersonalTaxRateResult(rateType: String, salaryAndOther: BigDecimal, taxOnSalaryAndOthers: BigDecimal, dividends: BigDecimal, taxOnDividends: BigDecimal)

case class PersonalTaxResult(personalAllowance: BigDecimal, salaryAndOther:BigDecimal, dividends: BigDecimal, taxRateResults: List[PersonalTaxRateResult], ni: BigDecimal) {
  def totalTaxOnSalaryAndOthers = taxRateResults.map(_.taxOnSalaryAndOthers).sum
  def totalTaxOnDividends = taxRateResults.map(_.taxOnDividends).sum
  def totalTax = totalTaxOnSalaryAndOthers + totalTaxOnDividends
  def totalEarnings = salaryAndOther + dividends
  def totalTakehome = totalEarnings - totalTax - ni
}


//object Temp {
//
//  def test(in: List[Int], min: Int, max: Int): List[Int] = {
//    var needed = max - min
//    var consumedTotal = 0
//    var sum = 0
//    in.map {
//      x =>
//        if (needed > 0 && x > 0) {
//          sum += x
//          val available = if (sum > min) (sum - min - consumedTotal) else 0
//          val consumed = if (available <= needed) available else needed
//          consumedTotal += consumed
//          needed -= consumed
//          consumed
//        } else {
//          0
//        }
//    }
//  }
//
//  def main(args: Array[String]): Unit = {
//    println(test(List(5, 10, 0, 2, 2, 5), 10, 20))
//  }
//
//}