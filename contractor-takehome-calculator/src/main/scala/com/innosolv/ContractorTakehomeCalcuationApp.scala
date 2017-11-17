package com.innosolv

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}

@SpringBootApplication (scanBasePackageClasses = Array(classOf[Config]) )
@EnableAutoConfiguration
class ContractorTakehomeCalcuationApp {
}

object ContractorTakehomeCalcuationApp {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(Array(classOf[ContractorTakehomeCalcuationApp].asInstanceOf[AnyRef]), args)
  }
}
