package com.cg.bean;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements IEngine {
 public String getBHP() {
	 return "2000 CC";
 }
}
