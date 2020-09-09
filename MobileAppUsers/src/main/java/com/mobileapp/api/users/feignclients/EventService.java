package com.mobileapp.api.users.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mobileapp.api.users.ui.models.events.Event;

@FeignClient(name="eventproducer")
public interface EventService {
	
    @RequestMapping(method = RequestMethod.POST, value = "/events/publish", consumes = "application/json")
	public ResponseEntity<?> sendEvent(Event event);

}
