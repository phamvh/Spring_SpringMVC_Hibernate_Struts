package com.gontuseries.model;

import java.beans.PropertyEditorSupport;
/**
 *  This is a customized editor class. The purpose of this class is, for example:
 *  Where we have a field from a form, which can only accept text, but the real value
 *  represented by that text can be different from String, such as Date, therefore
 *  requires a parsing process to parse a String to a Date, and assigns the parsed value
 *  to the date property of a model. 
 *  
 *  Spring provides many customized editor classes already, including one for Date.
 *  
 *  Here, we just create a simple customized editor for String, which checks if name has gender info or not.
 *  If not, we add Ms. to the front.

 */
public class CustomNameEditor extends PropertyEditorSupport{
	/**
	 * Input from the form is String. We need to parse this String to turn it into approriate type.
	 * In this case, we just check if it has gender info.
	 */
	@Override
	public void setAsText(String studentName) throws IllegalArgumentException{
		if(studentName==null  || studentName.isEmpty())
				setValue("");
		else{
			if(studentName.startsWith("Mr.") || studentName.startsWith("Ms."))
					setValue(studentName);
			else{
				setValue("Ms. "+studentName);
			}
		}
	}
}
