package com.mobileapp.kafka.event.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.mobileapp.kafka.eventconsumer.models.Event;


public interface KafkaConsumerService {
	
	public void onMessege(ConsumerRecord<String, Event> record);

}
