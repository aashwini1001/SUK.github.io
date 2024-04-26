package com.suk.model;

import java.util.Date;

public class Student {
	

	private int rollNumber;
    private String name;
    private String fatherName;
    private Date dob;
    private String address;
    private String phone;
    private String email;
    private String course;
    private String branch;
public Student() {
	// TODO Auto-generated constructor stub
}
public Student(int rollNumber, String name, String fatherName, Date dob, String address, String phone, String email,
		String course, String branch) {
	super();
	this.rollNumber = rollNumber;
	this.name = name;
	this.fatherName = fatherName;
	this.dob = dob;
	this.address = address;
	this.phone = phone;
	this.email = email;
	this.course = course;
	this.branch = branch;
}
public int getRollNumber() {
	return rollNumber;
}
public void setRollNumber(int rollNumber) {
	this.rollNumber = rollNumber;
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
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
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
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
@Override
public String toString() {
	return "Student [rollNumber=" + rollNumber + ", name=" + name + ", fatherName=" + fatherName + ", dob=" + dob
			+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", course=" + course + ", branch="
			+ branch + "]";
}






}




