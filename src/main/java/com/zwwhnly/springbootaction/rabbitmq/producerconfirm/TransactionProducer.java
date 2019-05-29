package com.zwwhnly.springbootaction.rabbitmq.producerconfirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TransactionProducer {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接
        ConnectionFactory factory = new ConnectionFactory();
        // 设置 RabbitMQ 的主机名
        factory.setHost("localhost");
        // 创建一个连接
        Connection connection = factory.newConnection();
        // 创建一个通道
        Channel channel = connection.createChannel();
        // 指定一个队列,不存在的话自动创建
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        long startTime = System.currentTimeMillis();

        channel.txSelect();
        int loopTimes = 10000;

        for (int i = 0; i < loopTimes; i++) {
            try {
                // 发送消息
                String message = "Hello World!" + i;
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

                channel.txCommit();
                System.out.println(" [x] Sent '" + message + "'");
            } catch (IOException e) {
                e.printStackTrace();
                channel.txRollback();
            }
        }

        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("发送10000条消息,事务机制耗时：" + time);

        // 关闭频道和连接
        channel.close();
        connection.close();
    }
}
