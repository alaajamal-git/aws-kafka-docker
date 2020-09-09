package com.mobileapp.kafka.eventproducer.services;

import org.springframework.http.ResponseEntity;

import com.mobileapp.kafka.eventproducer.models.Event;

public interface PublishService {
	public ResponseEntity<?> publish(Event ev);
	
	
}
