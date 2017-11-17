package com.innosolv.service

import com.innosolv.model._

import scala.math.BigDecimal.RoundingMode

object LimitedCompanyPayStructureGenerator {

  def generateIllustrations(revenue: BigDecimal, expenses: BigDecimal, spouseDividendsShare: BigDecimal, salaryStepUp: BigDecimal): List[PayStructureIllustration] = {
    val salaryIncrementalSeq = for (x <- BigDecimal(0) until revenue by salaryStepUp) yield x
    val salaryTargets = List(BigDecimal(8164)) ++ salaryIncrementalSeq.toList

    val result = salaryTargets.flatMap {
      salary =>
        val companyEarnings = CompanyEarningsAndExpenses(revenue, salary, expenses)
        val companyTaxResult = CompanyTaxCalculator.calculate(companyEarnings)
        val distributableProfit = companyTaxResult.distributableProfit;
        if (distributableProfit > 0) {
          val spouseDividends  = distributableProfit * spouseDividendsShare / 100
          val directorsDividends = distributableProfit - spouseDividends

          val directorsEarnings = PersonalEarnings(salary, directorsDividends, 0)
          val spouseEarnings = PersonalEarnings(0, spouseDividends, 0)

          val directorTaxResult = PersonalTaxCalculator.calculateTaxOnEarnings(directorsEarnings)
          val spouseTaxResult = PersonalTaxCalculator.calculateTaxOnEarnings(spouseEarnings)
          Some(PayStructureIllustration(directorsEarnings, directorTaxResult, spouseTaxResult, companyTaxResult))
        } else {
          None
        }
    }

    result
      .sortBy(x => x.directorsTaxResult.totalTakehome + x.spouseTaxResult.totalTakehome)
      .reverse
  }

}

case class PayStructureIllustration(directorsEarnings: PersonalEarnings,
                                    directorsTaxResult: PersonalTaxResult,
                                    spouseTaxResult: PersonalTaxResult,
                                    companyTaxResult: CompanyTaxResult)