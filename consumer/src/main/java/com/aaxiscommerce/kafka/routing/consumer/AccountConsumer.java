package com.aaxiscommerce.kafka.routing.consumer;

import com.aaxiscommerce.kafka.routing.messaging.AccountChannel;
import com.aaxiscommerce.kafka.routing.pojo.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(AccountChannel.class)
public class AccountConsumer {

    private static final Logger logger = LoggerFactory.getLogger(AccountConsumer.class);

    @StreamListener(value = AccountChannel.ACCOUNT_INPUT)
    public void account(Account account) {
        logger.info("=======Recevied account : " + account);
    }
}
