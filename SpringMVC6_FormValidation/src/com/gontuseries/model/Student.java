package com.gontuseries.model;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Size;

public class Student {
	private String studentName;
	/**
	 * This annotation comes from hibernate-validator. It is JSR303/349. It shows the restriction
	 * for the length of the studentMajor property. If the length does not satisfy this constraint,
	 * an error will be added to BindingResult. 
	 * 
	 * This also requires the controller method to add annotation @Valid to it.
	 * Without @Valid, spring will simply ignore this @Size annotation. This is good when
	 * you want to plug things in and out for testing purposes.
	 * See  StudentAdmissionController.submitInfoUsingModelAttribute(...) for details.
	 * 
	 * min and max are self-explanatory. message is a customized message to display to users
	 * using <form:errors path="stud.*"/> in the jsp file. A default-provided message is not
	 * very user-friendly, that's why it's a good idea to specify what message you want to display in
	 * case of errors.
	 * 
	 */
	@Size(min=4, max=20, message="Please enter a string that has between {min} and {max} characters.")
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
