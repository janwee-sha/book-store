package com.janwee.bookstore.bookserver.infrastructure.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface EventProcessor {
    String eventFromOrder = "event-in-order";

    @Input(eventFromOrder)
    MessageChannel eventFromOrder();
}
