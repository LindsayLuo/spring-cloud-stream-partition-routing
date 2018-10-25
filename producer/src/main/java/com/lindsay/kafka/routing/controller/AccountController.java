package com.lindsay.kafka.routing.controller;

import com.lindsay.kafka.routing.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;


    @RequestMapping("account")
    public String sendAccount() {
        LOGGER.debug("controller : send account");
        accountService.sendAccountMessage();
        return "Send account successfully";
    }
}
