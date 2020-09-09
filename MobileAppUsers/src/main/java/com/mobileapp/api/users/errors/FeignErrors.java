package com.mobileapp.api.users.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrors implements ErrorDecoder {
	Environment env;

	@Autowired
	public FeignErrors(Environment env) {
		this.env = env;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Exception decode(String methodKey, Response response) {

		
		return null;
	}

}
