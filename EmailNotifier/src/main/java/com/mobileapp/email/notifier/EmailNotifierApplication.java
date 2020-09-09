package com.mobileapp.email.notifier;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import com.mobileapp.email.notifier.service.impl.Monitor;
import com.mobileapp.email.notifier.services.EmailService;


@SpringBootApplication
public class EmailNotifierApplication implements CommandLineRunner{
	@Autowired
	private EmailService e_service;
	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(EmailNotifierApplication.class, args);
		
	}
	

	@Override
    public void run(String... args) throws IOException {
		Socket client;
		int port=Integer.parseInt(env.getProperty("socket.port"));
		@SuppressWarnings("resource")
		ServerSocket socket=new ServerSocket(port);
		while(true) {
			client=socket.accept();
			new Monitor(client,e_service).start();;
		}
		

       

    }

   
    
}
