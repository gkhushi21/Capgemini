package com.cg.bean;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCar {
public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
	Car c = (Car)ctx.getBean("car");
//	c.setName("XUV-3XO");
//	Scanner sc = new Scanner(System.in);
//	System.out.println("Enter EngineType(Petrol or CNG)");
//	String eType = sc.next();
//	System.out.println("Enter Tyre choice(MRF or JK)");
//	String tyre = sc.next();
//	
//	IEngine e = (IEngine)ctx.getBean(eType.toLowerCase());
//	ITyre t = (ITyre)ctx.getBean(tyre.toLowerCase());
//	c.setEngine(e);
//	c.setTyre(t);
	c.printCar();
	
	
}
}
