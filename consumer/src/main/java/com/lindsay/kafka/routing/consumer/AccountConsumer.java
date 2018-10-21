package com.lindsay.kafka.routing.consumer;

import com.lindsay.kafka.routing.messaging.AccountChannel;
import com.lindsay.kafka.routing.pojo.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(AccountChannel.class)
public class AccountConsumer {

    private static final Logger logger = LoggerFactory.getLogger(AccountConsumer.class);

    @StreamListener(value = AccountChannel.ACCOUNT_INPUT)
    public void account(@Payload Account account, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("=======Received account : " + account + ", partition:" + partition + "=======");
    }
}
