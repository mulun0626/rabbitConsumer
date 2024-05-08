package org.muyun.rabbitconsumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitConfig {

    private static String EXCHANGE_NAME = "my_boot_fanout_exchange";

    private static String QUENE_NAME = "my_boot_fanout_queue";


    private static String TopicExchangeName = "my_boot_fanout_topic";

    private static String TOPIC_QUENE_NAME = "my_boot_topic_queue";


    /*
        声明交换机
     */
    @Bean
    public FanoutExchange fanoutExchange () {
        return new FanoutExchange(EXCHANGE_NAME, true, false);
    }

    /*
        声明队列
     */
    @Bean
    public Queue queue () {
        return new Queue(QUENE_NAME, true, false, false);
    }

    /*
        声明绑定关系
     */
    @Bean
    public Binding queueBinding (Queue queue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }


    /*
        声明Topic交换机
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TopicExchangeName);
    }

    /*
        声明topic队列
     */
    @Bean
    public Queue topicQueue () {
        return new Queue(TOPIC_QUENE_NAME, true, false, false);
    }

    /*
        声明topic绑定关系
     */
    @Bean
    public Binding topicBinding (Queue topicQueue, TopicExchange TopicExchangeName) {
        return BindingBuilder.bind(topicQueue).to(TopicExchangeName).with("produce.*");
    }

}
