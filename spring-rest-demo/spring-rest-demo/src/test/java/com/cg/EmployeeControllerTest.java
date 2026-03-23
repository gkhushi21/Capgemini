package com.cg;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.controller.EmployeeController;
import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;
import com.cg.service.IEmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private IEmployeeService service;

	@Test
	void getEmployeeByIdApiTest() throws Exception {
		EmployeeDTO edto = new EmployeeDTO("Asher", LocalDate.of(2001, 10, 10), 34000.0);
		when(service.getEmployee(1)).thenReturn(edto);

		mockMvc.perform(get("/api/employee/1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.fullName").value("Asher"));
		
	}
	
	
	@Test
	void getAllEmployeeApiTest() throws Exception {
		EmployeeDTO edto1 = new EmployeeDTO("Asher", LocalDate.of(2001, 10, 10), 34000.0);
		EmployeeDTO edto2 = new EmployeeDTO("Kartik", LocalDate.of(2005, 9, 10), 45000.0);
		EmployeeDTO edto3 = new EmployeeDTO("Kriti", LocalDate.of(2001, 12, 11), 39000.0);
		
		when(service.getAllEmployee()).thenReturn(List.of(edto1,edto2,edto3));

		mockMvc.perform(get("/api/employee")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].fullName").value("Asher"));
		
	}
	
	@Test
	void getEmployeebyNameApiTest() throws Exception{
		EmployeeDTO edto1 = new EmployeeDTO("Asher", LocalDate.of(2001, 10, 10), 34000.0);
		EmployeeDTO edto2 = new EmployeeDTO("Asher", LocalDate.of(2005, 9, 10), 45000.0);
		
		when(service.getEmployeeByName("Asher")).thenReturn(List.of(edto1,edto2));

		mockMvc.perform(get("/api/employee/name/Asher")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].fullName").value("Asher"))
				.andExpect(jsonPath("$[1].fullName").value("Asher"));
		
	}
	
	@Test
	void createEmployeeTestApi() throws Exception{
		EmployeeDTO e1 = new EmployeeDTO("Asher",LocalDate.of(2000,10, 10),43000.0);
		when(service.createEmployee(any(EmployeeDTO.class))).thenReturn(e1);

		ObjectMapper objectMapper = new ObjectMapper();
		 objectMapper.registerModule(new JavaTimeModule());
		mockMvc.perform(post("/api/employee").contentType(MediaType.APPLICATION_JSON)
		.content(objectMapper.writeValueAsString(e1))).andExpect(status().isOk())
		.andExpect(jsonPath("$.fullName").value("Asher"));
		
	}
	
	
	
	@Test
	void updateEmployeeTestApi() throws Exception{
		Employee e1 = new Employee("Asher",LocalDate.of(2000,10, 10),43000.0);
		when(service.updateEmployee(any(Employee.class))).thenReturn(e1);

		ObjectMapper objectMapper = new ObjectMapper();
		 objectMapper.registerModule(new JavaTimeModule());
		mockMvc.perform(put("/api/employee").contentType(MediaType.APPLICATION_JSON)
		.content(objectMapper.writeValueAsString(e1))).andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("Asher"));
		
	}
	
//	@Test
//	void deleteEmployeeApiTest() throws Exception {
//		Employee e1 = new Employee("Asher", LocalDate.of(2001, 10, 10), 34000.0);
//		when(service.removeEmployee(2)).thenReturn("Employee deleted");
//
//		mockMvc.perform(get("/api/employee/2")).andExpect(status().isOk())
//		 .andExpect(content().string("Employee deleted"));
//		
//	}
	
	
}
