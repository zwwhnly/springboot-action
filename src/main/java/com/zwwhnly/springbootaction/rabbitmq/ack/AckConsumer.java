package com.zwwhnly.springbootaction.rabbitmq.ack;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class AckConsumer {
    private final static String QUEUE_NAME = "durable-queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接
        ConnectionFactory factory = new ConnectionFactory();
        // 设置 RabbitMQ 的主机名
        factory.setHost("localhost");
        // 创建一个连接
        Connection connection = factory.newConnection();
        // 创建一个通道
        Channel channel = connection.createChannel();
        // 创建队列消费者
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                //int result = 1 / 0;
                System.out.println("Received Message '" + message + "'");

                long deliveryTag = envelope.getDeliveryTag();
                channel.basicAck(deliveryTag, false);
            }
        };
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
