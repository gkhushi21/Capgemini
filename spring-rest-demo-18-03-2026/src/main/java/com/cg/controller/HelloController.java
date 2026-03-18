package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
public class HelloController {
	@GetMapping("abc/{name}")
	public String sayHello(@PathVariable String name) {
		return "Hello  "+name;
	}
	
//	@GetMapping("xyz")
//	public String sayHello1() {
//		return "Hello World xyz!!";
//	}
	
}
