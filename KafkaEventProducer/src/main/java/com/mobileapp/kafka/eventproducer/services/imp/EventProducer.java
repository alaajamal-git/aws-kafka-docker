package com.mobileapp.kafka.eventproducer.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.mobileapp.kafka.eventproducer.models.Event;
import com.mobileapp.kafka.eventproducer.services.PublishService;

@Service
public class EventProducer implements PublishService{
	@Autowired
    KafkaTemplate<Integer,Event> kafkaTemplate;

	@Override
	public ResponseEntity<?> publish(Event event) {
		//ProducerRecord<Integer,String> producerRecord = buildProducerRecord(key, value, topic);
        //ListenableFuture<SendResult<Integer,String>> listenableFuture =  kafkaTemplate.send(producerRecord);


        ListenableFuture<SendResult<Integer,Event>> listenableFuture =  kafkaTemplate.sendDefault(null,event);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, Event>>() {
            @Override
            public void onFailure(Throwable ex) {
            		System.out.print("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFf");

            }

            @Override
            public void onSuccess(SendResult<Integer, Event> result) {

        		System.out.print("succeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeed");

            }
        });


		
		return new ResponseEntity<Event>(HttpStatus.OK);
	}

}
