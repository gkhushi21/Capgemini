package com.cg;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.exception.EmployeNotFoundException;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringRestDemoApplicationTests {
   
//	@Autowired
//	private IEmployeeService service;
//	void testEmployeeById()
//	{
//		assertNotNull(service.getEmployee(200));
//		assertThrows(EmployeNotFoundException.class,()->service.getEmployee(222));
//	}
//	@Test
//	void contextLoads() {
//	}
	
	
	@Mock
	private IEmployeeRepo repo;
	@InjectMocks
	private EmployeeService service;
	
	
	@Test
	void testEmployeeById() {
		EmployeeDTO edto = new EmployeeDTO("simran",LocalDate.of(2002,02 ,02),34000.0);
		edto.setEmployeeId(1001);
		Employee emp = EntityMapper.convertObjectToEntity(edto);
		Optional<Employee> op = Optional.of(emp);
		when(repo.findById(1001)).thenReturn(op);
		assertNotNull(service.getEmployee(1001));
	}

	
	@Test
	void testEmployeeByIdWithException() {
		when(repo.findById(1002)).thenThrow(EmployeNotFoundException.class);
		assertThrows(EmployeNotFoundException.class ,()->service.getEmployee(1002));
	}
	
	
	@Test
	void testEmployeebyName() {
		List<Employee>li=new ArrayList<>();
		EmployeeDTO edto = new EmployeeDTO("Riya",LocalDate.of(2000, 10, 20),76000.0);
		edto.setEmployeeId(270);
		li.add(EntityMapper.convertObjectToEntity(edto));
		when(repo.findByName("Riya")).thenReturn(li);
		assertNotNull(service.getEmployeeByName("Riya"));
		
		
	}
	
	@Test
	void TestGetAllEmployee(){
		List<Employee>li=new ArrayList<Employee>();
		EmployeeDTO edto=new EmployeeDTO("Rahul", LocalDate.of(2002,4,12),54000.00);
		edto.setEmployeeId(221);
		li.add(EntityMapper.convertObjectToEntity(edto));
		when(repo.findAll()).thenReturn(li);
		assertNotNull(service.getAllEmployee());
	}
	
	@Test
	void TestDeleteEmployee() {

		    int id = 1001;
      Employee emp = new Employee("Simran", LocalDate.of(2002,2,2), 34000.0);
		    emp.setEmpid(id);
		    Optional<Employee> op=Optional.of(emp);
		    when(repo.findById(id)).thenReturn(op);

		 if(service.getEmployee(id)!=null) {
		    assertEquals("Employee Deleted",  service.removeEmployee(id));

		}else {
			assertEquals("Employee not found", service.removeEmployee(id));
		}
	}
	
	@Test
	void TestCreateEmployee() {
		EmployeeDTO edto1 = new EmployeeDTO("Raj",LocalDate.of(2001,10, 24),50000.0);
//		edto1.setEmployeeId(100);
		Employee emp = EntityMapper.convertObjectToEntity(edto1);
		when(repo.saveAndFlush(any(Employee.class))).thenReturn(emp);
		EmployeeDTO result = service.createEmployee(edto1);
		assertEquals(edto1.getEmployeeId(),result.getEmployeeId());
		assertEquals(edto1.getFullName(),result.getFullName());
	}
	
	@Test
	void TestUpdateEmployee() {
		   
		    Employee e = new Employee("Rama", LocalDate.of(2002, 10, 12), 34000.00);
		    e.setEmpid(101);
		    Optional<Employee> op = Optional.of(e);
		    when(repo.findById(101)).thenReturn(op);
		    when(repo.saveAndFlush(any(Employee.class))).thenReturn(e);
		    Employee result = service.updateEmployee(e);
		    assertEquals(e.getEmpid(), result.getEmpid());
		    assertEquals(e.getName(), result.getName());
//		    verify(repo,times(1)).saveAndFlush(e);
			
	
	}
}
