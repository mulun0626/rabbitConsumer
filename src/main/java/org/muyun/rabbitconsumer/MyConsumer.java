package org.muyun.rabbitconsumer;

import com.rabbitmq.client.Channel;
import jakarta.annotation.Resource;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class MyConsumer {

    @Resource
    private RedisTemplate redisTemplate;

    /*
        监听队列:当队列中有消息、则监听器工作处理消息
     */
    @RabbitListener(queues = "my_boot_fanout_queue")
    public void process(Message message) {
        byte[] bytes = message.getBody();
        System.out.printf("接受到的消息:" + new String(bytes));
    }

    /*
        监听队列:当队列中有消息、则监听器工作处理消息.channel手动ack
     */
    @RabbitListener(queues = "my_boot_topic_queue")
    public void processTopic(Message message, Channel channel) throws IOException {
        // 到redis中获取
        String messId = message.getMessageProperties().getCorrelationId();
        if (redisTemplate.opsForValue().setIfAbsent(messId, "0", 10, TimeUnit.MINUTES)) {
            byte[] bytes = message.getBody();
            System.out.printf("接受到的消息:" + new String(bytes));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } else {
            String value = (String) redisTemplate.opsForValue().get(messId);
            if (value.equals("1")) {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            }
        }
    }
}
