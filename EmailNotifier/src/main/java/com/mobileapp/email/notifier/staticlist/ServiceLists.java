package com.mobileapp.email.notifier.staticlist;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.mobileapp.shared.data.Host;
@Component
public class ServiceLists {
	
	private  static  ArrayList<Host> activeList;
	private  static ArrayList<Host> inacticList;
	
	public ServiceLists() {
		activeList=new ArrayList<>();
		inacticList=new ArrayList<>();
	}
	public synchronized static ArrayList<Host> getActiveList() {
		return activeList;
	}
	
	public synchronized static ArrayList<Host> getInacticList() {
		return inacticList;
	}
	
	

}
