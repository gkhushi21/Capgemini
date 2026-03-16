package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.cg.bean.Employee;
import com.cg.bean.HelloWorld;

@SpringBootApplication
//@ComponentScan("com")
//@PropertySource("classpath:data.properties")
public class FirstSpringBootProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FirstSpringBootProjectApplication.class, args);
//		HelloWorld h = ctx.getBean(HelloWorld.class);
//		System.out.println(h.sayHello("chhavi"));
		Employee emp = ctx.getBean(Employee.class);
		emp.printEmployeeDetails();
	}

}
