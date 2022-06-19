package com.janwee.bookstore.order.domain;

import com.janwee.bookstore.common.domain.event.OrderRejected;
import com.janwee.bookstore.common.domain.event.TicketCreated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Slf4j
@EnableBinding({EventProcessor.class})
public class DomainEventHandler {
    private final OrderRepository orderRepo;

    @Autowired
    public DomainEventHandler(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @StreamListener(target = EventProcessor.eventFromBook,
            condition = "headers['type']=='TicketCreated'")
    @Transactional(rollbackFor = Throwable.class)
    public void handleTicketCreated(TicketCreated event) {
        log.info("Received event: {}", event);
        Order order = orderRepo.findById(event.getOrderId())
                .orElseThrow(OrderNotFoundException::new);
        order.create();
        orderRepo.save(order);
    }

    @StreamListener(target = EventProcessor.eventFromBook,
            condition = "headers['type']=='OrderRejected'")
    @Transactional(rollbackFor = Throwable.class)
    public void handleOrderRejected(OrderRejected event) {
        log.info("Received event: {}", event);
        Optional<Order> optOrder = orderRepo.findById(event.getOrderId());
        if (optOrder.isPresent()) {
            Order order = optOrder.get();
            order.reject();
            orderRepo.save(order);
        }
    }
}
