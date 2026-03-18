package com.cg.service;

import java.util.List;

import com.cg.entity.Employee;

public interface IEmployeeService {
	public List<Employee> getAllEmployee();
	public Employee createEmployee(Employee emp);
	public Employee getEmployee(int empid);
	public String removeEmployee(int empid);
	public Employee updateEmployee(Employee e);
	public List<Employee> getEmployeeByName(String name);

}
