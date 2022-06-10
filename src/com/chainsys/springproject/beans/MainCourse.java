package com.chainsys.springproject.beans;

public class MainCourse {
	public String name;
}

class SouthIndian extends MainCourse {
	public SouthIndian() {
		name = "Rice";
	}
}

class NorthIndian extends MainCourse {
	public NorthIndian() {
		name = "Chapati";
	}
}

class Chinese extends MainCourse {
	public Chinese() {
		name = "Noodles";
	}
}
