package com.rubix.Employees;

public class Employee {
	
	int id;
	
	private String companyName;
	
	private String deptName;
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	Employee (int eid) {
		this.id = eid;
	}
		
	public void display() {
		System.out.println("My Employee Id is " + id +" from Constructor Injection");
		System.out.println("My companyName is " + companyName +" from dependency injection of getter and setter");
		System.out.println("My department is " + deptName + " from dependency injection of getter and setter");
	}

}
