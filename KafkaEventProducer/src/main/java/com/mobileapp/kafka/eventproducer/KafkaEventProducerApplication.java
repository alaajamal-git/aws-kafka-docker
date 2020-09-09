package com.mobileapp.kafka.eventproducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
//@EnableEurekaClient
public class KafkaEventProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaEventProducerApplication.class, args);
	}

//@Bean
    public NewTopic libraryEvents(){
        return TopicBuilder.name("test-1")
                .partitions(3)
                .replicas(3)
                .build();
    }
}
