package com.suk.model;

import java.util.Date;

public class Teacher {
	
	private int employeeId;
    private String name;
    private String fatherName;
    private String address;
    private Date dob;
    private String phone;
    private String email;
    private String education;
    private String department;
    

    
    public Teacher() {
		// TODO Auto-generated constructor stub
	}



	public Teacher(int employeeId, String name, String fatherName, String address, Date dob, String phone, String email,
			String education, String department) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.fatherName = fatherName;
		this.address = address;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.education = education;
		this.department = department;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getFatherName() {
		return fatherName;
	}



	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	@Override
	public String toString() {
		return "Teacher [employeeId=" + employeeId + ", name=" + name + ", fatherName=" + fatherName + ", address="
				+ address + ", dob=" + dob + ", phone=" + phone + ", email=" + email + ", education=" + education
				+ ", department=" + department + "]";
	}
    
    
    
    
	
	
}
