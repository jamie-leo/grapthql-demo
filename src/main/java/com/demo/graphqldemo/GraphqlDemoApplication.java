package com.demo.graphqldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class GraphqlDemoApplication {
    private static final CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(GraphqlDemoApplication.class, args);

    }
}

