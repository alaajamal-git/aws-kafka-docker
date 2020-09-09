package com.mobileapp.api.users.ui.models.events;

import java.util.Date;

public class Event {

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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
