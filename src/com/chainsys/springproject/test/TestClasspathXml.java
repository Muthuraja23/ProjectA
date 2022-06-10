package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.autowire.Car;
import com.chainsys.springproject.beans.Actor;
import com.chainsys.springproject.beans.Calendar;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.Scoreboard;
import com.chainsys.springproject.lifecycle.AnnotationLc;
import com.chainsys.springproject.lifecycle.InitDesposeBean;
import com.chainsys.springproject.lifecycle.LifeCycleBean;

public class TestClasspathXml {
	public static void testA() {
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Raja");
		emp.print();
	}

	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
		// Employee emp = ac.getBean(Employee.class);
		Employee emp = (Employee) ac.getBean("emp");
		emp.setId(101);
		emp.setName("Mutha");
		emp.print();
		Customer cmr = ac.getBean(Customer.class);
		cmr.setId(200);
		cmr.setName("Raja");
		cmr.print();
	}

	public static void testC() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
		Employee emp = ac.getBean(Employee.class);
		Customer cmr = ac.getBean(Customer.class);
		// lazy-init="true" for customer. An object is created now (firstcall to
		// getBean() method for Customer.class
		Employee secondemp = ac.getBean(Employee.class);
		Customer secondcmr = ac.getBean(Customer.class);
		System.out.println(emp.hashCode());
		System.out.println(secondemp.hashCode());
		System.out.println(cmr.hashCode());
		System.out.println(secondcmr.hashCode());
	}

	public static void testPrototype() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
		Actor hero = ac.getBean(Actor.class);
		Actor heroine = ac.getBean(Actor.class);
		Actor comedian = ac.getBean(Actor.class);
		Actor friend = ac.getBean(Actor.class);
		System.out.println(hero.hashCode());
		System.out.println(heroine.hashCode());
		System.out.println(comedian.hashCode());
		System.out.println(friend.hashCode());
	}

	public static void testBeanWithConstructor() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");

	}

	public static void testFactoryMethod() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
		Scoreboard sb = ac.getBean("sb1", Scoreboard.class);
		sb.targetScore = 199;
		System.out.println(sb.targetScore);
		Scoreboard sb2 = ac.getBean("sb2", Scoreboard.class);
		System.out.println(sb2.targetScore);
	}

	public static void testCalendarFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
		Calendar today = ac.getBean(Calendar.class);
		today.day = 9;
		today.month = "june";
		today.year = 2022;
		System.out.println(today.day);
		System.out.println(today.month);
		System.out.println(today.year);
	}

	public static void testLunchFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml");
		Lunch nvsilunch = ac.getBean("nvsilunch", Lunch.class);
		Lunch vsilunch = ac.getBean("vsilunch", Lunch.class);
		Lunch nilunch = ac.getBean("nilunch", Lunch.class);
		Lunch chlunch = ac.getBean("chlunch", Lunch.class);
		System.out.println("---------");
		nvsilunch.serve();
		System.out.println("---------");
		vsilunch.serve();
		System.out.println("---------");
		nilunch.serve();
		System.out.println("---------");
		chlunch.serve();
	}

	public static void testSetterDi() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml");
		Employee emp = ac.getBean("emp2", Employee.class);
		emp.print();
	}

	public static void testLifeCycle() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
		LifeCycleBean life = ac1.getBean(LifeCycleBean.class);
		life.print();
		life=null;
//		System.gc();
		ac1.close();
		ac1=null;
	}
	public static void testInitDestroyBean() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
		InitDesposeBean init=ac1.getBean(InitDesposeBean.class);
		init.print();
	}
	public static void testAnnotionLc() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
		AnnotationLc anlc=ac1.getBean(AnnotationLc.class);
		anlc.print();
		anlc=null;
		
	}
	public static void testAutoWire() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Autowire.xml");
		Car car = ac1.getBean(Car.class);
		car.start();
		car.move();
		car=null;
		ac1.close();
	}
}