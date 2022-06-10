package com.chainsys.springproject.beans;

public class CalendarFactory {
	// The factory method is not static here
	// Calendar factory is also called as initiating bean because methods in this bean instantiates objects for other beans
	public Calendar createCalendar() {
		// The calendar constructor is default access modifier so, can be called here
		// The calendar class and the calendar factory class are both in the same package
		return new Calendar();
	}
	public Appointments createAppointment() {
		return new Appointments();
	}
}
