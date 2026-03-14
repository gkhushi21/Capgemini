package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.Employee;
import com.cg.bean.SBU;

public class EmployeeMain {
public static void main(String[]args) {
	 ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
     Employee emp = (Employee) ctx.getBean("employee");
     emp.showDetails();
     System.out.println(" ");
     SBU sbu1 = (SBU)ctx.getBean("sbu");
     sbu1.displaySbuWithEmployees();
   
}
}
