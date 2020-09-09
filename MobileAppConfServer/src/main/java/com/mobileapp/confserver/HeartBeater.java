package com.mobileapp.confserver;


import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mobileapp.shared.data.Host;

@Component
public class HeartBeater implements CommandLineRunner{
	@Autowired
	private Environment environment;
	
	@Override
	public void run(String... args) throws Exception {
 		Socket socket=new Socket(environment.getProperty("notifier.address"), Integer.parseInt(environment.getProperty("notifier.port")));
		ObjectOutputStream out=new  ObjectOutputStream(socket.getOutputStream());
		Host host =new Host(); 
		host.setIp(InetAddress.getLocalHost().getHostAddress());
		host.setName(environment.getProperty("spring.application.name"));
		host.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		out.writeObject(host);
		
		while(true) {
			Thread.sleep(5000);
			out.write(1);
		}
        
		
	}

	
	
	
}
