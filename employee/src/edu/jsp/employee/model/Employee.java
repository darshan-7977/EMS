package edu.jsp.employee.model;

public class Employee { // Entity Layer
	private String name;
	private int age;
	private int id;
	private double sal;
	private int contact;

	public Employee() {
		super();
	}

	public Employee(String name, int id, int age, double sal, int contact) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
		this.sal = sal;
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

}
