package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IEmployeeRepo;
import com.cg.entity.Employee;


@Service
public class EmployeeService implements IEmployeeService{
	@Autowired
public IEmployeeRepo erepo;
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		return erepo.findAll();
	}

	@Override
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return erepo.saveAndFlush(emp);
	}

	@Override
	public Employee getEmployee(int empid) {
		// TODO Auto-generated method stub
		Optional<Employee> e = erepo.findById(empid);
		if(e.isPresent()) {
			return e.get();
			
		}else {
		return null;
	}
	}
	@Override
	public String removeEmployee(int empid) {
		if(getEmployee(empid)!=null) {
			erepo.deleteById(empid);
			return "Employee removed";	
		}else
			return "employee not found";
		 
	}

	@Override
	public Employee updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		if(getEmployee(e.getEmpid())!= null)
		return erepo.saveAndFlush(e);
		else {
			return null;
		}
	}
	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		
		return erepo.findByName(name);
	}
	

}
