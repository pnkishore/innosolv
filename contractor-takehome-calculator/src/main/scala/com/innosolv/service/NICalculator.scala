package com.innosolv.service

import com.innosolv.service.RateConfig._

object NICalculator {

  def calculateEmployerNi(salary: BigDecimal): BigDecimal =
    List(EmployerNIBasicRate, EmployerNIHigherRate)
      .map(rate => applyRate(salary, rate))
      .sum

  def calculateEmployeeNi(salary: BigDecimal): BigDecimal =
    List(EmployeeNIBasicRate, EmployeeNIHigherRate, EmployeeNIAdditionalHigherRate)
      .map(rate => applyRate(salary, rate))
      .sum

  private[this] def applyRate(salary: BigDecimal, rate: NIRate): BigDecimal = {
    val earningsToTaxAtThisRate = rate.maxThreshold.map(_.min(salary)).getOrElse(salary) - rate.minThreshold
    Option(earningsToTaxAtThisRate)
      .find(_ > 0)
      .map(_ * rate.rate / BigDecimal(100))
      .getOrElse(BigDecimal(0))
  }
}
