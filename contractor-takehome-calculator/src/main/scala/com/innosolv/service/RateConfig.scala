package com.innosolv.service

object RateConfig {

  case class PAYETaxRate(rateType: String, minThreshold: BigDecimal, maxThreshold: Option[BigDecimal], salaryRate: BigDecimal, dividendsRate: BigDecimal)
  val PAYEBasicRate = PAYETaxRate("Basic Rate", 0, Some(33500), 20, 7.5)
  val PAYEHigherRate = PAYETaxRate("Higher Rate", 33500, Some(150000), 40, 32.5)
  val PAYEAdditionalHigherRate = PAYETaxRate("Additional Higher Rate", 150000, None, 45, 38.1)
  val TaxFreeDividendsAllowance = BigDecimal(5000)


  case class NIRate(minThreshold: BigDecimal, maxThreshold: Option[BigDecimal], rate: BigDecimal)
  val EmployeeNIBasicRate = NIRate(0, Some(8164), 0);
  val EmployeeNIHigherRate = NIRate(8164, Some(45032), 12);
  val EmployeeNIAdditionalHigherRate = NIRate(45032, None, 2);
  val EmployerNIBasicRate = NIRate(0, Some(8164), 0);
  val EmployerNIHigherRate = NIRate(8164, None, 13.8);

  val CorpTaxRate:BigDecimal = 19

  val PersonalAllowance = BigDecimal(11500)
  val PersonalAllowanceThreshold = BigDecimal(100000)
  val PersonalAllowanceReducingFactor = BigDecimal(0.5)

}
