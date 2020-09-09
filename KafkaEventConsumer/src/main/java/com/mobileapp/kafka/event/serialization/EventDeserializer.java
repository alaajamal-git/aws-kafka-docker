package com.mobileapp.kafka.event.serialization;

import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobileapp.kafka.eventconsumer.models.Event;

public class EventDeserializer implements Deserializer<Event> {

	@Override
	public Event deserialize(String arg0, byte[] evBytes) {
		ObjectMapper mapper = new ObjectMapper();
		Event developer = null;
		try {
			developer = mapper.readValue(evBytes, Event.class);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return developer;
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