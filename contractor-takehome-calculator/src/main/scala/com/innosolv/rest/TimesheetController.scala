package com.innosolv.rest

import com.innosolv.model.TimeSheet
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

@RestController
class TimesheetController {

  @RequestMapping(Array("/timesheets"))
  def listTimeSheets(): List[TimeSheet] = {
    List(TimeSheet("Naga", "Innosolv"), TimeSheet("Bindu", "Innosolv"))
  }

}
