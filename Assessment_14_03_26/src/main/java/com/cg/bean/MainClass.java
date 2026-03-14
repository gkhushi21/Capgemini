package com.cg.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
	Librarian lb = (Librarian) ctx.getBean("librarian");
	lb.issueBook();
	ApplicationContext ctx1 = new ClassPathXmlApplicationContext("bean.xml");
	Librarian lb1 = (Librarian) ctx1.getBean("librarian");
	lb1.issueBook();
}
}
