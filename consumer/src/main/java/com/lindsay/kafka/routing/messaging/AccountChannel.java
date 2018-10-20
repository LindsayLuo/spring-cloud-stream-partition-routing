package com.lindsay.kafka.routing.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface AccountChannel {

    String ACCOUNT_INPUT = "account";

    @Input(AccountChannel.ACCOUNT_INPUT)
    SubscribableChannel input();
}
