package com.mobileapp.kafka.eventconsumer.dbdata;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.mobileapp.kafka.eventconsumer.models.Type;

@Entity
public class EventEntity {
	@Id
	@GeneratedValue
	private long eventId;
	@Column(nullable = false)
	private String ip;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Type eventType;
	@Column(nullable = false)
	private Date date;

	public EventEntity() {
		// TODO Auto-generated constructor stub
	}

	public EventEntity(long eventId, String ip, Type eventType, Date date) {
		super();
		this.eventId = eventId;
		this.ip = ip;
		this.eventType = eventType;
		this.date = date;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Type getEventType() {
		return eventType;
	}

	public void setEventType(Type eventType) {
		this.eventType = eventType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
