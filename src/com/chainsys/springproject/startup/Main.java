package com.chainsys.springproject.startup;


import com.chainsys.springproject.beans.Calendar;
import com.chainsys.springproject.test.TestAnnotationConfig;
import com.chainsys.springproject.test.TestCar;
import com.chainsys.springproject.test.TestClasspathXml;
import com.chainsys.springproject.test.TestXmlBeanFactory;

public abstract class Main {

	public static void main(String[] args) {
	TestClasspathXml.testAutoWire();
	}
	
}
