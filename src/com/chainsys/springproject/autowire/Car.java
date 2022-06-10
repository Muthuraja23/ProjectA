package com.chainsys.springproject.autowire;

import org.springframework.beans.factory.annotation.Autowired;
public class Car {
	@Autowired
	private Engine petrolEngine;
	@Autowired
	private Wheel alloy;
	public Engine getPetrolEngine() {
		return petrolEngine;
	}
	public Car() {
		System.out.println("1 Car Object created "+ hashCode());
	}

	public void start() {
		petrolEngine.start();
	}
	public void stop() {
		petrolEngine.stop();
	}
	public void move() {
		alloy.rotate();
	}
}
