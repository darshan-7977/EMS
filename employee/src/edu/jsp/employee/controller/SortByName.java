package edu.jsp.employee.controller;

import java.util.Comparator;

import edu.jsp.employee.model.Employee;

public class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
