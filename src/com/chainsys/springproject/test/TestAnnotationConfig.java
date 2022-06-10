package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chainsys.springproject.appconfig.AppConfig;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;

public class TestAnnotationConfig {

	public static void testA() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Employee emp = ac.getBean(Employee.class);
		emp.setId(201);
		emp.setName("Raj");
		emp.print();
		Employee secondemp = ac.getBean(Employee.class);
	
	}
	
}
