package com.example.demo.config.kafka;

import com.example.demo.models.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

@Configuration
public class MessageProducerConfig {
    @Bean
    public MessageProducer producer() {
        return new MessageProducer();
    }

    public static class MessageProducer {

        @Autowired
        private KafkaTemplate<String, String> kafkaTemplate;

        @Autowired
        private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

        //        @Value(value = "${message.topic.name}")
        private String topicName = "topicName";

        //        @Value(value = "${partitioned.topic.name}")
        private String partionedTopicName;

        //        @Value(value = "${filtered.topic.name}")
        private String filteredTopicName;

        //        @Value(value = "${greeting.topic.name}")
        private String greetingTopicName = "greeting";

        public void sendMessage(String message) {
            kafkaTemplate.send(topicName, message);
        }

        public ListenableFuture<SendResult<String, String>> sendAndResult(String message) {
            return kafkaTemplate.send(topicName, message);
        }

//        public void sendMessageToPartion(String message, int partition) {
//            kafkaTemplate.send(partionedTopicName, partition, message);
//        }

        public void sendMessageToFiltered(String message) {
            kafkaTemplate.send(filteredTopicName, message);
        }

        public void sendGreetingMessage(Greeting greeting) {
            greetingKafkaTemplate.send(greetingTopicName, greeting);
        }
    }
}
