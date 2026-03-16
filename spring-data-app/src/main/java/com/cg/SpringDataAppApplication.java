package com.cg;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cg.entity.Employee;
import com.cg.repo.IEmployeeRepo;

@SpringBootApplication
public class SpringDataAppApplication {

	public static void main(String[] args) {
		ApplicationContext  ctx = SpringApplication.run(SpringDataAppApplication.class, args);
		IEmployeeRepo er=ctx.getBean(IEmployeeRepo.class);
		er.save(new Employee("Khushi",LocalDate.of(2004,01,29),85000));
		System.out.println("created-----");
	}
//         public Address getBean() {
//        	 Address add = new Address();
//        	 add.set
//         }
}
