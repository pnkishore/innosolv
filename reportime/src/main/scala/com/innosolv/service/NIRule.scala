package com.innosolv.service

case class NIRule(minThreshold: BigDecimal, maxThreshold: Option[BigDecimal], rate: BigDecimal) {
  def canApplyTo(amount: BigDecimal): Boolean = amount > minThreshold

  def niOn(amount: BigDecimal): BigDecimal =
    amountToTaxAtThisRate(amount) * rate / BigDecimal(100)

  private[this] def amountToTaxAtThisRate(amount: BigDecimal) =
    maxThreshold.map(_.min(amount)).getOrElse(amount) - minThreshold
}