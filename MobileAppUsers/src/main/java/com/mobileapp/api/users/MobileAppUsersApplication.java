package com.mobileapp.api.users;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;


import feign.Logger;
import feign.codec.Encoder;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class MobileAppUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppUsersApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplete() {
		return new RestTemplate();
	}
	@Bean
	public Logger.Level feignLoggerLevel(){
		
		return Logger.Level.FULL;
	}
	@Bean
	public Encoder feignEncoder() {

    	HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();

    	ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);

    	return new SpringEncoder(objectFactory);

	}
	/*
	 * @Bean public FeignErrorsRe getFeignErrors() {
	 * 
	 * return new FeignErrorsRe(); }
	 */
	 
}
