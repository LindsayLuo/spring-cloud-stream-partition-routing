package com.lindsay.kafka.routing.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface AccountChannel {

    String ACCOUNT_OUTPUT = "account";

    @Output(AccountChannel.ACCOUNT_OUTPUT)
    MessageChannel output();
}
