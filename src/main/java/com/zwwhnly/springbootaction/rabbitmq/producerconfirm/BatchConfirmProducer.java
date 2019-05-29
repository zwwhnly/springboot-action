package com.zwwhnly.springbootaction.rabbitmq.producerconfirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

public class BatchConfirmProducer {
    private final static String EXCHANGE_NAME = "batch-confirm-exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接
        ConnectionFactory factory = new ConnectionFactory();
        // 设置 RabbitMQ 的主机名
        factory.setHost("localhost");
        // 创建一个连接
        Connection connection = factory.newConnection();
        // 创建一个通道
        Channel channel = connection.createChannel();
        // 创建一个Exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        long startTime = System.currentTimeMillis();

        int batchQty = 10000;
        int batchCount = 1000;
        int msgCount = 0;
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10000);
        try {
            channel.confirmSelect();
            while (msgCount <= batchQty) {
                String message = "batch confirm test";
                channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());

                msgCount++;

                // 将发送出去的消息存入缓存中，缓存可以是一个ArrayList或者BlockingQueue之类的
                blockingQueue.add(message);
                if (blockingQueue.size() >= batchCount) {
                    try {
                        if (channel.waitForConfirms()) {
                            // 将缓存中的消息清空
                            blockingQueue.clear();
                        } else {
                            // 将缓存中的消息重新发送
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        // 将缓存中的消息重新发送
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("发送10000条消息,批量confirm机制耗时：" + time);

        // 关闭频道和连接
        channel.close();
        connection.close();
    }
}
