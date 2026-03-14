package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Car {
	@Value("${carname}")
	private String name;
	@Autowired
	@Qualifier("cng")
	private IEngine engine;
	@Autowired
	@Qualifier("JKTyre")
	private ITyre tyre;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IEngine getEngine() {
		return engine;
	}
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}
	public ITyre getTyre() {
		return tyre;
	}
	public void setTyre(ITyre tyre) {
		this.tyre = tyre;
	}
	
	
	public Car() {
		
	}
//	@Autowired
//	public Car(@Qualifier("cng")IEngine engine,@Qualifier("jk")ITyre tyre) {
//		this.engine = engine;
//		this.tyre = tyre;
//	}
   public void printCar() {
	   System.out.println("Car Name:"+name);
	   System.out.println("Engine Details:"+engine.getBHP());
	   System.out.println("Tyre Details:"+tyre.getTyreDetails());
   }
}
