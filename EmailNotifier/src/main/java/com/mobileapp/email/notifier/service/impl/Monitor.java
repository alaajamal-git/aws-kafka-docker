package com.mobileapp.email.notifier.service.impl;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.mobileapp.email.notifier.services.EmailService;
import com.mobileapp.email.notifier.staticlist.ServiceLists;
import com.mobileapp.shared.data.Host;

public class Monitor extends Thread {
	private Host host;
	private Socket client;
	private EmailService e_service;
	public Monitor(Socket client,EmailService e_service) {
		this.client = client;
		this.e_service=e_service;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream reader = new ObjectInputStream(client.getInputStream());
			host = (Host) reader.readObject();
			ServiceLists.getActiveList().add(host);
			System.out.println(host);
			while (true) {
				reader.readInt();
			}
		} 
		catch(EOFException e) {}
		catch (IOException e) {
			e_service.sendEmail(host);
			ServiceLists.getActiveList().remove(host);
			ServiceLists.getInacticList().add(host);
			System.out.println("Done!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
