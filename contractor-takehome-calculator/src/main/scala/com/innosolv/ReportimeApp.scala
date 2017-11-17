package com.innosolv

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}

@SpringBootApplication (scanBasePackageClasses = Array(classOf[Config]) )
@EnableAutoConfiguration
class ReportimeApp {
}

object ReportimeApp {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(Array(classOf[ReportimeApp].asInstanceOf[AnyRef]), args)
  }
}
