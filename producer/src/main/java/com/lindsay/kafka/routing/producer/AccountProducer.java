package com.lindsay.kafka.routing.producer;

import com.lindsay.kafka.routing.messaging.AccountChannel;
import com.lindsay.kafka.routing.pojo.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@EnableBinding(AccountChannel.class)
public class AccountProducer {

    private static final Logger logger = LoggerFactory.getLogger(AccountProducer.class);

    @Bean
    @InboundChannelAdapter(value = AccountChannel.ACCOUNT_OUTPUT, poller = @Poller(fixedDelay = "2000", maxMessagesPerPoll = "1"))
    public MessageSource<Account> timerMessageSource() {
        return () -> new GenericMessage<>(retrieveAccount());
    }

    private Account retrieveAccount() {
        Account testAccount = new Account();
        List<Long> ids = new ArrayList<>();
        ids.add(111L);
        ids.add(222L);
        ids.add(333L);
        testAccount.setId(ids.get(new Random().nextInt(3)));
        testAccount.setName("test");
        return testAccount;
    }

}
