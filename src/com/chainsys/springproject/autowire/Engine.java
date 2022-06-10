package com.chainsys.springproject.autowire;

public class Engine {
	public void start() {
		System.out.println("Engine Started " + hashCode());
	}
	public void stop() {
		System.out.println("Engine Stopped " + hashCode());
	}
	public Engine() {
		System.out.println("Engine Object created "+ hashCode());
	}
}
