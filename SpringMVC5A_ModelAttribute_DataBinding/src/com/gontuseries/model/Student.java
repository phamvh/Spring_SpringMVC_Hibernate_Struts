package com.gontuseries.model;

import java.util.ArrayList;
import java.util.Date;

public class Student {
	private String studentName;
	private String studentMajor;
	private Long studentPhone;
	private Date studentDOB;
	private ArrayList<String> studentSkills;
	private Address studentAddress;

	public Address getStudentAddress(){
		return studentAddress;
	}
	
	public void setStudentAddress(Address studentAddress){
		this.studentAddress = studentAddress;
	}
	
	public Long getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(Long studentPhone) {
		this.studentPhone = studentPhone;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentMajor() {
		return studentMajor;
	}
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}

}
