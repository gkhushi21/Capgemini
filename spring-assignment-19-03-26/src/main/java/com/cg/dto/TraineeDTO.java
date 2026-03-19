package com.cg.dto;

public class TraineeDTO {
	private int tid;
	private String name;
	private String domain;
	private String location;
	
	
	public TraineeDTO() {
		
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public TraineeDTO(int tid, String name, String domain, String location) {
		this.tid = tid;
		this.name = name;
		this.domain = domain;
		this.location = location;
	}
	

}
