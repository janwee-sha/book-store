package com.janwee.bookstore.order;

import com.janwee.bookstore.order.infrastructure.messaging.EventProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableBinding({Processor.class, EventProcessor.class})
public class OrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }

    @Bean
    public Supplier<String> textSupplier(){
        return ()->"Hello message from Order Service";
    }

}
