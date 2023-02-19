package com.project.staff;

import java.io.Serializable;

public class Staff implements Serializable{
	
	
	private static final long serialVersionUID = 3242262241665449309L;
	
	private String id;
	private String name;
	private String qualfication;
	private double yearsOfExperience;
	private long phone;
	private String Address;
	private double salary;
	private String isSalaryPaid;
	public Staff(String id, String name, String qualfication, long phone, double yearsOfExperience, String address, double salary,String isSalaryPaid ) {
		super();
		this.id = id;
		this.name = name;
		this.qualfication=qualfication;
		this.phone = phone;
		this.yearsOfExperience = yearsOfExperience;
		this.Address = address;
		this.salary = salary;
		this.isSalaryPaid=isSalaryPaid;
	}
	
	

	public String isSalaryPaid() {
		return isSalaryPaid;
	}



	public void setSalaryPaid(String isSalaryPaid) {
		this.isSalaryPaid = isSalaryPaid;
	}

	public String getQualfication() {
		return qualfication;
	}

	public void setQualfication(String qualfication) {
		this.qualfication = qualfication;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public double getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(double yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", qualfication=" + qualfication + ", yearsOfExperience="
				+ yearsOfExperience + ", phone=" + phone + ", Address=" + Address + ", salary=" + salary
				+ ", isSalaryPaid=" + isSalaryPaid + "]";
	}

	
	

	
}
