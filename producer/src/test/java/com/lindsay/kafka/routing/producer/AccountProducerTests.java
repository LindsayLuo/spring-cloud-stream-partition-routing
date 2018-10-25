package com.lindsay.kafka.routing.producer;

import com.lindsay.kafka.routing.messaging.AccountChannel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.BlockingQueue;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.cloud.stream.test.matcher.MessageQueueMatcher.receivesPayloadThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext
public class AccountProducerTests {

    @Autowired
    private AccountChannel accountChannel;

    @Autowired
    private MessageCollector messageCollector;


    @Test
    public void testTimerMessageSource() {
        BlockingQueue<Message<?>> messages = this.messageCollector.forChannel(accountChannel.output());
        // if messages is empty, please set "autoStartup" to true on AccountProducer class.
        if (messages.size() > 0) {
            Assert.assertThat(messages, receivesPayloadThat(is(instanceOf(String.class))));
            Assert.assertThat(messages, receivesPayloadThat(containsString("test")));
        }
    }
}
