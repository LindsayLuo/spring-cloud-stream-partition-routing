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

import java.util.Random;

@EnableBinding(AccountChannel.class)
public class AccountProducer {

    private static final Logger logger = LoggerFactory.getLogger(AccountProducer.class);

    @Bean
    @InboundChannelAdapter(value = AccountChannel.ACCOUNT_OUTPUT, autoStartup = "false", poller = @Poller(fixedDelay = "2000", maxMessagesPerPoll = "1"))
    public MessageSource<Account> timerMessageSource() {
        return () -> {
            Account account = retrieveAccount();
            logger.info("poller:" + account);
            return new GenericMessage<>(account);
        };
    }

    private Account retrieveAccount() {
        Account testAccount = new Account();
        testAccount.setId(Integer.toUnsignedLong(new Random().nextInt(10)));
        testAccount.setName("test");
        return testAccount;
    }

}
