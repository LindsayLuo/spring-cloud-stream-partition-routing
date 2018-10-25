package com.lindsay.kafka.routing.service;

import com.lindsay.kafka.routing.messaging.AccountChannel;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext
public class AccountServiceTests {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountChannel accountChannel;

    @Autowired
    private MessageCollector messageCollector;

    @Test
    public void testSendAccountMessage() {


        try {
            messageCollector.forChannel(accountChannel.output()).clear();

            Message<?> message = messageCollector.forChannel(accountChannel.output()).poll();
            assertThat(message).isNull();

            accountService.sendAccountMessage();

            message = messageCollector.forChannel(accountChannel.output()).take();
            assertThat(message).isNotNull();
            assertThat(message).isInstanceOf(GenericMessage.class);
            assertThat(message).hasFieldOrProperty("payload");
            JSONObject jsonObject = new JSONObject(message.getPayload().toString());
            Assert.assertEquals(jsonObject.get("name").toString(), "test");

            messageCollector.forChannel(accountChannel.output()).clear();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
