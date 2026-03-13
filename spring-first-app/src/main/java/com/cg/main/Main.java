package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.HelloWorld;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		HelloWorld h = (HelloWorld)ctx.getBean("hello");
//		h.setName("Khushi");
		System.out.println(h.sayHello());
		System.out.println("language...");
		System.out.println(h.getLanguage());
		
		
//		HelloWorld h = (HelloWorld)ctx.getBean("hello");
//		HelloWorld h1 = (HelloWorld)ctx.getBean("hello");
//		h.setName("Khushi");
//		System.out.println(h.sayHello());
//		System.out.println(h1.sayHello());
//		System.out.println(h==h1);
		(( ClassPathXmlApplicationContext)ctx).close();
		
	}

}
