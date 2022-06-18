package com.janwee.bookstore.order.infrastructure.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventProcessor {
    String eventOutput = "event-out";

    @Output(eventOutput)
    MessageChannel eventOutput();
}