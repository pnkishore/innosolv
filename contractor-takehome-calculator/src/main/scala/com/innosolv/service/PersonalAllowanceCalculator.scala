package com.innosolv.service

import com.innosolv.model.Earnings
import RateConfig._

object PersonalAllowanceCalculator {


  def calculate(in: Earnings) : BigDecimal = {
    val gross = in.grossIncome
    if (gross > PersonalAllowanceThreshold) {
      val adjusted = PersonalAllowance - ((gross - PersonalAllowanceThreshold) * PersonalAllowanceReducingFactor)
      Option(adjusted).find(_ >= 0).getOrElse(BigDecimal(0))

    } else {
      PersonalAllowance
    }
  }

}
