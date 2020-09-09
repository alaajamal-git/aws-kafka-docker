package com.mobileapp.email.notifier.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mobileapp.email.notifier.staticlist.ServiceLists;
import com.mobileapp.shared.data.Host;

@RestController
@RequestMapping("/services")
public class MonitorController {
	
	@GetMapping(value = "/up",produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<Host>> getRunningServices() {
		
		return new ResponseEntity<List<Host>>(ServiceLists.getActiveList(),HttpStatus.OK);
		
	}
	@GetMapping(value = "/down",produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<Host>> getDownServices() {
		
		return new ResponseEntity<List<Host>>(ServiceLists.getInacticList(),HttpStatus.OK);
		
	}
}
