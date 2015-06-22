package com.gontuseries.model;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Size;

public class Student {
	private String studentName;
	/**
	 * See the previous tutorial for details about this annotation.
	 * Note that here, parameter [message] is no longer given in the annotation @Size.
	 * Instead, it comes from a source file (properties file).
	 * 
	 * When an error happens due to this restriction of @Size, spring will search for messages in
	 * the source files with the following keys, order in the priority by spring:
	 * 
	 *     1.  Size.stud.studentMajor  -> [annotation].[object reference name].[property name]
	 *     2.  Size.studentMajor       -> [annotation].[property name]
	 *     3.  Size.java.lang.String   -> [annotation].[type of property]
	 *     4.  Size                    -> [annotation]
	 *     5.  no key found, then spring uses its default message.
	 *     
	 * For this reason, no needs to specify what message spring must use in here.   
	 * Note that some config needs to be added in the xml file so that spring can create a class
	 * that is responsible for loading all the messages from properties file. See xml file for details. Here it is quoted:
	 *         <bean id="messageSource"
			         class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
			         <property name="basename" value="/WEB-INF/studentmessages.properties"></property>			   
			   </bean>  
	
	 * Still not sure, how to include the name of a specific message from the resource file in here. 
	 * Anyway, if ambiguity happens and we need to specify a specific message for this, then we can just
	 * put the message inside @Size like in the previous tutorial, like this:
	 *      @Size(min=4, max=20, message="Size must be at least {min} and at most {max}")
	 */
	@Size(min=4, max=20)
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
