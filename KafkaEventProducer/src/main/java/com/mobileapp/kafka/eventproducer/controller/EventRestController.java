package com.mobileapp.kafka.eventproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobileapp.kafka.eventproducer.models.Event;
import com.mobileapp.kafka.eventproducer.services.PublishService;

@RestController
@RequestMapping("/events")
public class EventRestController {
	@Autowired
	PublishService publishservice;
	
	
	
	@PostMapping("/publish")
	public void createKafkaEvent(@RequestBody Event event) {
		publishservice.publish(event);
		System.out.println(event.getIp());
		
	}

}
