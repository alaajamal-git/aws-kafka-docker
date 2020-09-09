package com.mobileapp.kafka.event.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mobileapp.kafka.eventconsumer.dbdata.EventEntity;
import com.mobileapp.kafka.eventconsumer.models.Event;
import com.mobileapp.kafka.eventconsumer.models.Type;

public interface DBRepositoryService extends CrudRepository<EventEntity, Long>{
	
	List<Event> findByDate(Date date);
	List<Event> findByEventType(Type eventType);
	List<Event> findByIp(String ip);

}
