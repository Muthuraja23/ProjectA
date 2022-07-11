package com.chainsys.springproject.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resources;

public class Car {
	@Autowired
	private Engine petrolEngine;
	@Autowired
	private Wheel alloy;
	public Engine getPetrolEngine() {
		return petrolEngine;
	}
	public Car() {
		System.out.println("Car Object created "+ hashCode());
	}
	public void begin () {
		System.out.println("Start Annotation......");
	}
	public void stop() {
		petrolEngine.stop();
	}
	public void start() {
		petrolEngine.start();
	}
	
	public void move() {
		alloy.rotate();
	}
}

@Component("SportsCar")
class SportsCar extends Car{
	public SportsCar() {
		System.out.println("Sports car object created " + hashCode());
	}
}

@Component("SedanCar")
class SedanCar extends Car{
	public SedanCar() {
		System.out.println("Sedan car object created " + hashCode());
	}
}