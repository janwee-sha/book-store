package com.janwee.bookstore.order.application;

import com.janwee.bookstore.order.domain.Order;

public class OrderServerApplicationTest {
    private static final Order ORDER1 = Order.createOrder();

    public void whenOrderPersisted_thenEventPublished() {

    }
}