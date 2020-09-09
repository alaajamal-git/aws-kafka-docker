package com.mobileapp.kafka.eventproducer.models;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Event implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8989411878974026141L;
	private String ip;
	private Type EventType;
	private Date date;
	
	
	@Override
	public String toString() {
		return "Event [ip=" + ip + ", EventType=" + EventType + ", date=" + date.toString() + "]";
	}

	private Event(String ip,  Date date, Type EventType) {
		this.ip=ip;
		this.EventType=EventType;
		this.date=date;
	}
	
	public static Event createEvent(String ip, Type eventType, Date date) {	
		return new Event(ip, date,eventType);
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Type getEventType() {
		return EventType;
	}
	public void setEventType(Type eventType) {
		EventType = eventType;
	}
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

