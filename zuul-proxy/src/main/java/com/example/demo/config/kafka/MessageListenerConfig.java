package com.example.demo.config.kafka;

import com.example.demo.models.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

@Configuration
public class MessageListenerConfig {

    @Bean
    public MessageListener listener() {
        return new MessageListener();
    }

    public static class MessageListener {
        private CountDownLatch latch = new CountDownLatch(3);

        private CountDownLatch partitionLatch = new CountDownLatch(2);

        private CountDownLatch filterLatch = new CountDownLatch(2);

        private CountDownLatch greetingLatch = new CountDownLatch(1);

//        @KafkaListener(topics = "topicName", groupId = "default", containerFactory = "kafkaListenerContainerFactory")
//        public void listenGroupFoo(String message) {
//            System.out.println("Received Messasge in group 'default': " + message);
//            latch.countDown();
//        }

//        @KafkaListener(topics = "topicName", groupId = "bar", containerFactory = "barKafkaListenerContainerFactory")
//        public void listenGroupBar(String message) {
//            System.out.println("Received Messasge in group 'bar': " + message);
//            latch.countDown();
//        }

//        @KafkaListener(topics = "topicName", containerFactory = "headersKafkaListenerContainerFactory")
//        public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//            System.out.println("Received Messasge: " + message + " from partition: " + partition);
//            latch.countDown();
//        }

//        @KafkaListener(topicPartitions = @TopicPartition(topic = "${partitioned.topic.name}", partitions = { "0", "3" }))
//        public void listenToParition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//            System.out.println("Received Message: " + message + " from partition: " + partition);
//            this.partitionLatch.countDown();
//        }

//        @KafkaListener(topics = "${filtered.topic.name}", containerFactory = "filterKafkaListenerContainerFactory")
//        public void listenWithFilter(String message) {
//            System.out.println("Recieved Message in filtered listener: " + message);
//            this.filterLatch.countDown();
//        }

        @KafkaListener(topics = "greeting", containerFactory = "greetingKafkaListenerContainerFactory")
        public void greetingListener(Greeting greeting) {
            System.out.println("Recieved greeting message: " + greeting);
            this.greetingLatch.countDown();
        }
    }
}
