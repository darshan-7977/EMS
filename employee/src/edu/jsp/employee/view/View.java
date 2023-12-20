package edu.jsp.employee.view;

import java.util.Scanner;

import edu.jsp.employee.controller.Controller;
import edu.jsp.employee.model.Employee;

public class View { // Presentation Layer

	Scanner scanner = new Scanner(System.in);
	Controller controller = new Controller();
	boolean loop = true;

	public static void main(String[] args) {
		View view = new View();
		while (view.loop) {
			view.mainView();
		}
	}

	public void mainView() {
		System.out.println("--------------------WELCOME--------------------");
		System.out.println("1. SAVE EMPLOYEE");
		System.out.println("2. GET EMPLOYEE");
		System.out.println("3. GET ALL EMPLOYEE");
		System.out.println("4. DELETE EMPLOYEE");
		System.out.println("5. EXIT");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 1: {
			saveEmployee();
			break;
		}
		case 2: {
			getEmployee();
			break;
		}
		case 3: {
			getAllEmployee();
			break;
		}
		case 4: {
			deleteEmployee();
			break;
		}
		case 5: {
			this.loop = false;
			System.out.println("THANK YOU");
			break;
		}
		default:
			System.out.println("Invalid Choice please try again");
		}
	}

	public void saveEmployee() {

		System.out.println("Enter Employee id: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Employee Name: ");
		String name = scanner.nextLine();

		System.out.println("Enter the Employee age: ");
		int age = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Employee Salary: ");
		double sal = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Enter Employee contact no: ");
		int contact = scanner.nextInt();
		scanner.nextLine();

		Employee employee = new Employee(name, id, age, sal, contact);

		if (controller.saveEmployee(employee) != null) {
			System.out.println("Employee Saved Successfully");
			System.out.println();
		} else {
			System.out.println("Something went wrong");
			System.out.println();
		}
	}

	public void getEmployee() {
		System.out.println("Enter Employee id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Employee employee = controller.getEmployee(id);
		if (employee != null) {
			System.out.println("Employee ID: " + employee.getId());
			System.out.println("Employee Name: " + employee.getName());
			System.out.println("Employee Age: " + employee.getAge());
			System.out.println("Employee Salary: " + employee.getSal());
			System.out.println("Employee Contact No: " + employee.getContact());
			System.out.println();
		} else {
			System.out.println("Employee not found..");
			System.out.println();
		}
	}

	public void getAllEmployee() {
		if (controller.getAllEmployee().isEmpty()) {
			System.out.println("No Employees are present");
			return;
		} else {
			System.out.println("List is empty");
		}
	}

	public void deleteEmployee() {
		getAllEmployee();
		System.out.println("Enter Employee id to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Employee Name: ");
		String name = scanner.nextLine();
		System.out.println("Enter Employee Age: ");
		int age = scanner.nextInt();
		System.out.println("Enter Employee Salary: ");
		double sal = scanner.nextDouble();
		scanner.next();
		System.out.println("Enter Employee Contact Number: ");
		int contact = scanner.nextInt();
		scanner.next();
		Employee employee = new Employee(name, id, age, sal, contact);
		for(Employee e : controller.getAllEmployee()) {
			if(employee.getId()==e.getId()) {
				if(employee.getName()==e.getName()) {
					if(employee.getContact()==e.getContact()) {
						if(employee.getSal()==e.getSal()) {
							if(employee.getAge()==e.getAge()) {
								controller.deleteEmployee(e);
								System.out.println("Employee Deleted...");
								return;
							}
						}
					}
				}
			}
			System.out.println("Employee not found.");
		}
	}
	
	public void updateEmployee() {
		getAllEmployee();
		
	}
	
	

}
