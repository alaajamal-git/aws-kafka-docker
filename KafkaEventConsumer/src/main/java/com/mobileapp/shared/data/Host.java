package com.mobileapp.shared.data;

import java.io.Serializable;

public class Host implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1572891120080093632L;
	String name;
	String ip;
	int port;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Override
	public String toString() {
		return "Host [name=" + name + ", ip=" + ip + ", port=" + port + "]";
	}
	
	

}
