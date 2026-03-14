package com.cg.bean;

import java.util.List;

public class SBU {
	private int sbuId;
	private String sbuName;
	private String sbuHead;
	private List<Employee> emplist;
	
	public SBU() {
		
	}
	
	public SBU(int sbuId, String sbuName, String sbuHead, List<Employee> emplist) {
		
		this.sbuId = sbuId;
		this.sbuName = sbuName;
		this.sbuHead = sbuHead;
		this.emplist = emplist;
	}
	public int getSbuId() {
		return sbuId;
	}
	public void setSbuId(int sbuId) {
		this.sbuId = sbuId;
	}
	public String getSbuName() {
		return sbuName;
	}
	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}
	public String getSbuHead() {
		return sbuHead;
	}
	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}
	public List<Employee> getEmplist() {
		return emplist;
	}
	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
    public void displaySbuWithEmployees() {
        System.out.println("SBU details");
        System.out.println("--------------");
        System.out.println("sbuCode=" + sbuId + ", sbuHead=" + sbuHead + ", sbuName=" + sbuName);
        System.out.println("Employee details:----------------");
        for(Employee e : emplist) {
        System.out.println(e);
        }
    }
	
	
	
}
