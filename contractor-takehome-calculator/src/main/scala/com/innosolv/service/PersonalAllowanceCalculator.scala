package com.innosolv.service

import com.innosolv.model.Earnings

object PersonalAllowanceCalculator {

  val PersonalAllowance = BigDecimal(11500)
  val PersonalAllowanceThreshold = BigDecimal(100000)
  val PersonalAllowanceAdjustmentFactor = BigDecimal(0.5)

  def calculate(in: Earnings) : BigDecimal = {
    val gross = in.grossIncome

    if (gross > PersonalAllowanceThreshold) {
      val adjusted = PersonalAllowance - ((gross - PersonalAllowanceThreshold) * PersonalAllowanceAdjustmentFactor)
      Option(adjusted).find(_ >= 0).getOrElse(BigDecimal(0))

    } else {
      PersonalAllowance
    }

  }

}
