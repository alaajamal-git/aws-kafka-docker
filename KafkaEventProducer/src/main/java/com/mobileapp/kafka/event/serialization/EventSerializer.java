package com.mobileapp.kafka.event.serialization;

import java.util.Map;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobileapp.kafka.eventproducer.models.Event;

public class EventSerializer implements Serializer<Event> {

	@Override
	public byte[] serialize(String arg0, Event event) {
		byte[] serializedBytes = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			serializedBytes = objectMapper.writeValueAsString(event).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serializedBytes;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub
	}
}