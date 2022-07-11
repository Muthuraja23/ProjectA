package com.chainsys.springproject.autowire;

import org.springframework.beans.factory.annotation.Autowired;

public class CarServices {
	@Autowired
	private Car car;
	public void startTrip() {
		car.start();
	}
}
