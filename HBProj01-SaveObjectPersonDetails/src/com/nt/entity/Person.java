package com.nt.entity;

public class Person {
	
	private Integer pid;
	private String pname;
	private String paddr;
	private Float psal;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPaddr() {
		return paddr;
	}
	public void setPaddr(String paddr) {
		this.paddr = paddr;
	}
	public Float getPsal() {
		return psal;
	}
	public void setPsal(Float psal) {
		this.psal = psal;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddr=" + paddr + ", psal=" + psal + "]";
	}
	
	
	

}
