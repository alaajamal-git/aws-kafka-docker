package com.mobileapp.email.notifier.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mobileapp.email.notifier.services.EmailService;
import com.mobileapp.shared.data.Host;

@Service
public class SendMail implements EmailService{
	@Autowired
    private JavaMailSender javaMailSender;

	public void sendEmail(Host host) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("alaa.jamal@stud.uni-obuda.hu");

        msg.setSubject("Critical");
        msg.setText("Host: "+host.getName()+" on uri: "+host.getIp()+":"+host.getPort()+" is now out of service!");

        javaMailSender.send(msg);

    }
}
