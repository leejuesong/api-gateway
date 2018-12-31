package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableEurekaClient
public class DemoApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

//        MessageProducer producer = context.getBean(MessageProducer.class);
//        MessageListener listener = context.getBean(MessageListener.class);
//
//        producer.sendMessage("hello, world");
//        listener.latch.await(10, TimeUnit.SECONDS);
//
//        producer.sendGreetingMessage(new Greeting("greetings", "world"));
//        listener.greetingLatch.await(10, TimeUnit.SECONDS);

    }

//    @Bean
//    public MessageProducer messageProducer() {
//        return new MessageProducer();
//    }
//
//    @Bean
//    public MessageListener messageListener() {
//        return new MessageListener();
//    }
//
//    public static class MessageProducer {
//
//        @Autowired
//        private KafkaTemplate<String, String> kafkaTemplate;
//
//        @Autowired
//        private KafkaTemplate<String, Greeting> greetingKafkaTemplate;
//
////        @Value(value = "${message.topic.name}")
//        private String topicName = "topicName";
//
////        @Value(value = "${partitioned.topic.name}")
//        private String partionedTopicName;
//
////        @Value(value = "${filtered.topic.name}")
//        private String filteredTopicName;
//
////        @Value(value = "${greeting.topic.name}")
//        private String greetingTopicName = "greeting";
//
//        public void sendMessage(String message) {
//            kafkaTemplate.send(topicName, message);
//        }
//
////        public void sendMessageToPartion(String message, int partition) {
////            kafkaTemplate.send(partionedTopicName, partition, message);
////        }
//
//        public void sendMessageToFiltered(String message) {
//            kafkaTemplate.send(filteredTopicName, message);
//        }
//
//        public void sendGreetingMessage(Greeting greeting) {
//            greetingKafkaTemplate.send(greetingTopicName, greeting);
//        }
//    }
//
//    public static class MessageListener {
//
//        private CountDownLatch latch = new CountDownLatch(3);
//
//        private CountDownLatch partitionLatch = new CountDownLatch(2);
//
//        private CountDownLatch filterLatch = new CountDownLatch(2);
//
//        private CountDownLatch greetingLatch = new CountDownLatch(1);
//
//        @KafkaListener(topics = "topicName", groupId = "default", containerFactory = "kafkaListenerContainerFactory")
//        public void listenGroupFoo(String message) {
//            System.out.println("Received Messasge in group 'default': " + message);
//            latch.countDown();
//        }
//
////        @KafkaListener(topics = "topicName", groupId = "bar", containerFactory = "barKafkaListenerContainerFactory")
////        public void listenGroupBar(String message) {
////            System.out.println("Received Messasge in group 'bar': " + message);
////            latch.countDown();
////        }
//
////        @KafkaListener(topics = "topicName", containerFactory = "headersKafkaListenerContainerFactory")
////        public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
////            System.out.println("Received Messasge: " + message + " from partition: " + partition);
////            latch.countDown();
////        }
//
////        @KafkaListener(topicPartitions = @TopicPartition(topic = "${partitioned.topic.name}", partitions = { "0", "3" }))
////        public void listenToParition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
////            System.out.println("Received Message: " + message + " from partition: " + partition);
////            this.partitionLatch.countDown();
////        }
//
////        @KafkaListener(topics = "${filtered.topic.name}", containerFactory = "filterKafkaListenerContainerFactory")
////        public void listenWithFilter(String message) {
////            System.out.println("Recieved Message in filtered listener: " + message);
////            this.filterLatch.countDown();
////        }
//
//        @KafkaListener(topics = "greeting", containerFactory = "greetingKafkaListenerContainerFactory")
//        public void greetingListener(Greeting greeting) {
//            System.out.println("Recieved greeting message: " + greeting);
//            this.greetingLatch.countDown();
//        }
//    }

}

