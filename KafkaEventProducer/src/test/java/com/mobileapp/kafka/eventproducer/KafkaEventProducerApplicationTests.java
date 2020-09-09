package com.mobileapp.kafka.eventproducer;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import com.mobileapp.kafka.eventproducer.models.Event;
import com.mobileapp.kafka.eventproducer.models.Type;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(topics = {"test-5"},partitions = 1)
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
		"spring.kafka.admin.properties.bootstrap.servers=${spring.embedded.kafka.brokers}"})
@ActiveProfiles("prod")
class KafkaEventProducerApplicationTests {

	@Autowired
	TestRestTemplate resttemp;
	@Test
	void postkafka() {
		Event event=Event.createEvent("19.222.1.22", Type.CHECK, new Date());
		HttpEntity<Event> httpEntity= new HttpEntity<Event>(event);
		ResponseEntity<Event> res=resttemp.exchange("/events/publish", HttpMethod.POST, httpEntity, Event.class);
		System.out.print(res.getStatusCode());
	}

}
