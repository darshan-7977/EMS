package edu.jsp.employee.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.jsp.employee.model.Employee;

public class Controller { // Logic Layer

	// list to store the employees details in arrayList
	private List<Employee> employees = new ArrayList<>();

	// method to add the employees to the list
	public Employee saveEmployee(Employee employee) {
		if (employee != null) {
			employees.add(employee);
			return employee;
		} else {
			return null;
		}
	}

	// method to remove the employee from the list
	public Employee deleteEmployee(Employee target) {
		if (target != null) {
			for (Employee e : employees) {
				if (e.getId() == target.getId()) {
					employees.remove(e);
					return e;
				}
			}
			return null;
		} else {
			return null;
		}
	}

	// this method helps to retrieve all the employees
	public List<Employee> getAllEmployee() {
		return sortedEmployee(null);
	}

	// this method helps to retrieve a specific employee
	public Employee getEmployee(int id) {
		if (id > 0) {
			for (Employee e : employees) {
				if (e.getId() == id) {
					return e;
				}
			}
			return null;
		} else {
			return null;
		}
	}

	public List<Employee> sortedEmployee(Comparator<Employee> comparator) {
		if (comparator instanceof SortByID) {
			Collections.sort(employees, comparator);
			return employees;
		} else if (comparator instanceof SortByName) {
			Collections.sort(employees, comparator);
			return employees;
		} else if (comparator instanceof SortBySalary) {
			Collections.sort(employees, comparator);
			return employees;
		} else if (comparator instanceof SortByContact) {
			Collections.sort(employees, comparator);
			return employees;
		} else {
			return employees;
		}

	}

}
