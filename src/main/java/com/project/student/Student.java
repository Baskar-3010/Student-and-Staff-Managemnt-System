package com.project.student;

import java.io.Serializable;

public class Student implements Serializable {
	private String id;
	private String name;
	private String standard;
	private String address;
	private long phone;
	private double fees;
	private double feesRemaining;
	

	public Student(String id, String name, String standard, String address, long phone, double fees,
			double feesRemaining) {
		super();
		this.id = id;
		this.name = name;
		this.standard = standard;
		this.address = address;
		this.phone = phone;
		this.fees = fees;
		this.feesRemaining = feesRemaining;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public double getFeesRemaining() {
		return feesRemaining;
	}
	public void setFeesRemaining(double feesRemaining) {
		this.feesRemaining = feesRemaining;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", standard=" + standard + ", address=" + address + ", phone="
				+ phone + ", fees=" + fees + ", feesRemaining=" + feesRemaining + "]";
	}
	
	
}
