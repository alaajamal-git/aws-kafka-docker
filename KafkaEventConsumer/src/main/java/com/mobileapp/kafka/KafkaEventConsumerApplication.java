package com.mobileapp.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import com.mobileapp.kafka.eventconsumer.models.Event;

@SpringBootApplication
@EnableKafka
public class KafkaEventConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaEventConsumerApplication.class, args);
	}
	
	public Event getEvent() {
		return new Event();
		
		
	}

}
