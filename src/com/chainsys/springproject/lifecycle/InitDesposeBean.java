package com.chainsys.springproject.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InitDesposeBean implements DisposableBean, InitializingBean {
private String city;
private long pincode;
public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public long getPincode() {
	return pincode;
}

public void setPincode(long pincode) {
	this.pincode = pincode;
}
	@Override
	public void afterPropertiesSet() throws Exception {
System.out.println("afterPropertiesSet method called");
	}

	@Override
	public void destroy() throws Exception {
System.out.println("Destroy method called");
	}
	public InitDesposeBean() {
		System.out.println("InitDespose object created" + hashCode());	
	}
	
// After constructor
	public void setUp() {
		System.out.println("Starting........");
	}

	public void close() {
		System.out.println("Closing........");
	}
	public void print() {
		System.out.println("Print called........");
	}
}
