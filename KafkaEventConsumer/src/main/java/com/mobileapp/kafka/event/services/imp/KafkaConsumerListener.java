package com.mobileapp.kafka.event.services.imp;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mobileapp.kafka.event.services.DBRepositoryService;
import com.mobileapp.kafka.event.services.KafkaConsumerService;
import com.mobileapp.kafka.eventconsumer.dbdata.EventEntity;
import com.mobileapp.kafka.eventconsumer.models.Event;
@Service
public class KafkaConsumerListener implements KafkaConsumerService{

	@Autowired
	DBRepositoryService dbservice;
	@KafkaListener(topics = {"test-5"})
	public void onMessege(ConsumerRecord<String, Event> record) {
		System.out.println(record.value());

		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		EventEntity entity=mapper.map(record.value(), EventEntity.class);
		System.out.println(entity);
		dbservice.save(entity);
	}
	
	
}
