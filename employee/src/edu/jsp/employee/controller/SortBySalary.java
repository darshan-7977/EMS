package edu.jsp.employee.controller;

import java.util.Comparator;

import edu.jsp.employee.model.Employee;

public class SortBySalary implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getSal() - o2.getSal());
	}

}
