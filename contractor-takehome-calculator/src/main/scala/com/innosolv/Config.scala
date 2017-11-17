package com.innosolv

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.innosolv.rest.TimesheetController
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration, Primary}

@Configuration
@ComponentScan(basePackageClasses = Array(classOf[TimesheetController]))
class Config {

  @Bean
  @Primary
  def objectMapper: ObjectMapper = {
    val o = new ObjectMapper()
    o.registerModule(DefaultScalaModule)
    o
  }

}
