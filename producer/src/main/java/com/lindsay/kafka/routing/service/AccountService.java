package com.lindsay.kafka.routing.service;

import com.lindsay.kafka.routing.messaging.AccountChannel;
import com.lindsay.kafka.routing.pojo.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountChannel accountChannel;

    public void sendAccountMessage() {
        accountChannel.output().send(MessageBuilder.withPayload(retrieveAccount()).build());
    }

    private Account retrieveAccount() {
        Account testAccount = new Account();
        testAccount.setId(Integer.toUnsignedLong(new Random().nextInt(10)));
        testAccount.setName("test");
        LOGGER.info("Generate account:" + testAccount);
        return testAccount;
    }

}
