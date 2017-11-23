package com.innsolv.resourceserver.api;

import com.innsolv.resourceserver.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @RequestMapping("/account")
    public Account get(@RequestParam("accNumber") long accNo) {
        return new Account(accNo, BigDecimal.valueOf(10000));
    }


}
