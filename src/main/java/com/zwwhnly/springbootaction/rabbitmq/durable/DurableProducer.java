package com.zwwhnly.springbootaction.rabbitmq.durable;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class DurableProducer {
    private final static String EXCHANGE_NAME = "durable-exchange";
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
        // 创建一个Exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

        // 发送消息
        String message = "durable exchange test";
        AMQP.BasicProperties props = new AMQP.BasicProperties().builder().deliveryMode(2).build();
        channel.basicPublish(EXCHANGE_NAME, "", props, message.getBytes());

        // 关闭频道和连接
        channel.close();
        connection.close();
    }
}
