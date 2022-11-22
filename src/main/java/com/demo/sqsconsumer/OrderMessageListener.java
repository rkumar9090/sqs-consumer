package com.demo.sqsconsumer;

import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageListener {

    @SqsListener(value = "${orders.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(String message) {
        try {
            System.out.println("RECEIVED MESSAGE --> " + message);
        } catch (Exception e) {
            throw new RuntimeException("Cannot process message from SQS", e);
        }
    }
}