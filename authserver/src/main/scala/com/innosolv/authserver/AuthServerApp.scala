package com.innosolv.authserver

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}

@SpringBootApplication (scanBasePackageClasses = Array(classOf[AuthServerApp]) )
@EnableAutoConfiguration
class AuthServerApp {
}

object AuthServerApp {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(Array(classOf[AuthServerApp].asInstanceOf[AnyRef]), args)
  }
}
