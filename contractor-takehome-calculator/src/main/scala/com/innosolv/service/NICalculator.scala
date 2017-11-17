package com.innosolv.service

object NICalculator {

  val EmployeeNiRules = List(
    NIRule(0, Some(8164), 0),
    NIRule(8164, Some(45032), 12),
    NIRule(45032, None, 2))

  val EmployerNiRules = List(
    NIRule(0, Some(8164), 0),
    NIRule(8164, None, 13.8))

  def calculateEmployerNi(salary: BigDecimal): BigDecimal =
    EmployerNiRules.filter(_.canApplyTo(salary)).map(_.niOn(salary)).sum

  def calculateEmployeeNi(salary: BigDecimal): BigDecimal =
    EmployeeNiRules.filter(_.canApplyTo(salary)).map(_.niOn(salary)).sum
}
