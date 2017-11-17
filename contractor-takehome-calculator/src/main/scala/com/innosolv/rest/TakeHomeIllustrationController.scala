package com.innosolv.rest

import com.innosolv.model.ContractorTakehomeCalculationResult
import com.innosolv.rest.response.TakeHomeIllustration
import com.innosolv.service.ContractorTakehomeCalculator
import org.springframework.web.bind.annotation.{CrossOrigin, RequestMapping, RequestParam, RestController}

import scala.math.BigDecimal.RoundingMode

@RestController
@CrossOrigin
class TakeHomeIllustrationController {

  @RequestMapping(Array("/take-home-illustrations"))
  def generateTakehomeIllustrations(
                                     @RequestParam("companyEarnings") companyEarnings: java.math.BigDecimal,
                                     @RequestParam("expenses") expenses: java.math.BigDecimal = new java.math.BigDecimal(0),
                                     @RequestParam("spouseShare") spouseShare: java.math.BigDecimal = new java.math.BigDecimal(0)): List[TakeHomeIllustration] = {

    /* calculate different take home options by changing salary element by 10000 successively */
    val salarySeq = for (x <- BigDecimal(0) until companyEarnings by 10000) yield x
    val salaryTargets = List(BigDecimal(8164)) ++ salarySeq.toList
    salaryTargets
      .flatMap(salary => ContractorTakehomeCalculator.calculate(companyEarnings, expenses, spouseShare, salary))
      .sortBy(_.totalTakehome)
      .reverse
      .map(toTakeHomeIllustration)
  }

  private[this] def toTakeHomeIllustration(in: ContractorTakehomeCalculationResult): TakeHomeIllustration = {

    TakeHomeIllustration(directorSalary = str(in.directorsTaxResult.salaryAndOther),
      expenses = str(in.companyTaxResult.expenses),
      employerNi = str(in.companyTaxResult.employersNi),
      corpTax = str(in.companyTaxResult.corpTax),
      distributableProfit = str(in.companyTaxResult.distributableProfit),
      dividends = str(in.directorsTaxResult.dividends),
      spouseDividends = str(in.spouseTaxResult.dividends),
      ni = str(in.directorsTaxResult.ni),
      payeTax = str(in.directorsTaxResult.totalTax),
      spousePayeTax = str(in.spouseTaxResult.totalTax),
      takeHome = str(in.directorsTaxResult.totalTakehome),
      spouseTakeHome = str(in.spouseTaxResult.totalTakehome),
      totalTakeHome = str(in.directorsTaxResult.totalTakehome + in.spouseTaxResult.totalTakehome)
    )

  }

  private[this] implicit def str(amount: BigDecimal) = amount.setScale(2, RoundingMode.HALF_UP).toString()

}
