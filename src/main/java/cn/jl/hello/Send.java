package cn.jl.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class Send {

    private final static String QUEUE_NAMW = "hello";

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAMW, false, false, false, null);
        String message = "hello world!";
        channel.basicPublish("", QUEUE_NAMW, null, message.getBytes());
        System.out.println("send:[" + message + "]");
        channel.close();
        connection.close();
    }

}
