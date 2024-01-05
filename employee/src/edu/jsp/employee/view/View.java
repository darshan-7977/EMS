package edu.jsp.employee.view;

import java.util.Scanner;

import edu.jsp.employee.controller.Controller;
import edu.jsp.employee.controller.SortByContact;
import edu.jsp.employee.controller.SortByID;
import edu.jsp.employee.controller.SortByName;
import edu.jsp.employee.controller.SortBySalary;
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
		System.out.println("4. Update EMPLOYEE");
		System.out.println("5. DELETE EMPLOYEE");
		System.out.println("6. EXIT");
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
			updateEmployee();
			break;
		}
		case 5: {
			deleteEmployee();
			break;
		}
		case 6: {
			this.loop = false;
			System.out.println("THANK YOU");
			break;
		}
		default:
			System.out.println("Invalid Choice please try again");
			break;
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
		}

		sortBasedOn();

		for (Employee e : controller.getAllEmployee()) {
			System.out.println("Employee ID: " + e.getId());
			System.out.println("Employee Name: " + e.getName());
			System.out.println("Employee Age: " + e.getAge());
			System.out.println("Employee Salary: " + e.getSal());
			System.out.println("Employee Contact: " + e.getContact());
//			System.out.println("__________THANK-YOU__________");
		}

	}

	public void deleteEmployee() {
		System.out.println("Enter Employee ID to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Employee Name: ");
		String name = scanner.nextLine();
		System.out.println("Enter Employee Age: ");
		int age = scanner.nextInt();
		System.out.println("Enter Employee Salary: ");
		double sal = scanner.nextDouble();
		System.out.println("Enter Employee Contact Number: ");
		int contact = scanner.nextInt();
		Employee employee = new Employee(name, id, age, sal, contact);
		for (Employee e : controller.getAllEmployee()) {
			if (employee.getId() == e.getId()) {
				if (employee.getName() == e.getName()) {
					if (employee.getContact() == e.getContact()) {
						if (employee.getSal() == e.getSal()) {
							controller.deleteEmployee(employee);
							System.out.println("Employee Deleted...");
							return;
						}
					}
				}
			}
		}
		System.out.println("Employee not found.");
	}

	public void updateEmployee() {
		if (controller.getAllEmployee().isEmpty()) {
			System.out.println("no employees present");
		} else {
//		getAllEmployee();
			System.out.println("Enter ID of Employee: ");
			int id = scanner.nextInt();

			for (Employee e : controller.getAllEmployee()) {
				if (id == e.getId()) {
					System.out.println("Choose");
					System.out.println("1. Update Emp ID");
					System.out.println("2. Update Emp Name");
					System.out.println("3. Update Emp Salary");
					System.out.println("4. Update Emp Age");
					System.out.println("5. Update Emp Contact");
					System.out.println("6. All details Update");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter Emp ID: ");
						int id1 = scanner.nextInt();
						scanner.next();
						e.setId(id1);
						System.out.println("ID Updated Successfully");
						break;

					case 2:
						System.out.println("Enter Emp Name: ");
						String name = scanner.nextLine();
						scanner.next();
						e.setName(name);
						System.out.println("Emp Name Updated Successfully");
						break;

					case 3:
						System.out.println("Enter Emp Salary: ");
						double sal = scanner.nextDouble();
						scanner.nextLine();
						e.setSal(sal);
						System.out.println("Emp Salary Updated Successfully");
						break;

					case 4:
						System.out.println("Enter Emp Age: ");
						int age = scanner.nextInt();
						scanner.next();
						e.setAge(age);
						System.out.println("Emp Age Updated Successfully");
						break;

					case 5:
						System.out.println("Enter Emp Contact: ");
						int contact = scanner.nextInt();
						scanner.next();
						e.setContact(contact);
						System.out.println("Emp Contact Updated Successfully");
						break;

					case 6:
						System.out.println("Enter Employee ID: ");
						int id2 = scanner.nextInt();
						scanner.next();
						System.out.println("Enter Employee Name: ");
						String name2 = scanner.nextLine();
						System.out.println("Enter Employee Age: ");
						int age1 = scanner.nextInt();
						scanner.next();
						System.out.println("Enter Employee Salary: ");
						double sal1 = scanner.nextDouble();
						scanner.next();
						System.out.println("Enter Employee Contact: ");
						int contact1 = scanner.nextInt();
						scanner.next();
						e.setId(id2);
						e.setName(name2);
						e.setAge(age1);
						e.setSal(sal1);
						e.setContact(contact1);
						System.out.println("Employee Details Updated Successfully.");
						break;

					default:
						System.out.println("Invalid choice.");
						break;
					}
				}
			}
		}

	}

	public void sortBasedOn() {
		System.out.println("Select Sort based on ");
		System.out.println("1. Sort by ID ");
		System.out.println("2. Sort by Name ");
		System.out.println("3. Sort by Salary ");
		System.out.println("4. Sort by Contact ");
		System.out.println("5. Don't Sort ");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			controller.sortedEmployee(new SortByID());
			break;

		case 2:
			controller.sortedEmployee(new SortByName());
			break;

		case 3:
			controller.sortedEmployee(new SortBySalary());
			break;

		case 4:
			controller.sortedEmployee(new SortByContact());
			break;

		default:
			System.out.println("Invalid Sorting Choice");
			break;
		}

	}

}
