package com.Hibernet.HRMS;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	public int empId ; 
	public Employee() {
		super();
	}
	public Employee(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String name ;
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}
	
}
