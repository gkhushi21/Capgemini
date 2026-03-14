package com.cg.bean;

public class Employee {
private int employeeid;
private String employeeName;
private double salary;
private SBU businessUnit;
//private String businessUnit;
private int age;


@Override
public String toString() {
	return "Employee [employeeid=" + employeeid + ", employeeName=" + employeeName + ", empsalary=" + salary + ", empAge="
			+ age + "]";
}
public int getEmployeeid() {
	return employeeid;
}
public void setEmployeeid(int employeeid) {
	this.employeeid = employeeid;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
//public String getBusinessUnit() {
//	return businessUnit;
//}
//public void setBusinessUnit(String businessUnit) {
//	this.businessUnit = businessUnit;
//}


public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public SBU getBusinessUnit() {
	return businessUnit;
}
public void setBusinessUnit(SBU businessUnit) {
	this.businessUnit = businessUnit;
}

public Employee() {
	
}
public Employee(int employeeid, String employeeName, double salary, SBU businessUnit, int age) {
	this.employeeid = employeeid;
	this.employeeName = employeeName;
	this.salary = salary;
	this.businessUnit =businessUnit;
	this.age = age;
}
public String getSbuDetails(){
	return "sbu [sbuId=" +businessUnit.getSbuId() + ", sbuName=" +businessUnit.getSbuName() +  ", sbuHead =" + businessUnit.getSbuHead()+"]";
}
public void showDetails() {
	System.out.println("---Employee Details---");
	System.out.println(toString());
//	System.out.println("Employee ID:"+employeeid);
//	System.out.println("Employee Name :"+employeeName);
//	System.out.println("Employee Salary :"+salary);
//	System.out.println("Employee BU:"+businessUnit);
//	System.out.println("Employee Age:"+age);
//	System.out.println("Employee Age:"+age);
	System.out.print("SBU DETAILS = ");
	System.out.println(getSbuDetails());
	
	
}
}
