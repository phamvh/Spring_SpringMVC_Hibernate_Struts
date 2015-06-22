<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admision Form</title>
</head>
<body>
<form action="/SpringMVC5B_ModelAttribute_InitBinder/submitInfoUsingModelAttribute" method="post">
<h1>Student Admission Form</h1>
<p><font color="red"><form:errors path="stud.*"/></font></p>
<p>
   Student Name: <input type="text" name = "studentName">
</p>
<p>
   Major: <input type="text" name = "studentMajor">
</p>

<p>
   Phone: <input type="text" name = "studentPhone">
</p>

<p>
   Date of Birth (format ""yyyy-mm-dd"): <input type="text" name = "studentDOB"> <br/>
   See method initBinder() in the controller for details of how this is enforced.
</p>

<p>
   Skills: <select name="studentSkills" multiple>
   				<option value="Java Core">Java Core</option>
   				<option value="Spring MVC">Spring MVC</option>
   				<option value="Struts2">Struts2</option>
           </select>
</p>

<div>
<p>
  <b>Student Address:</b>
</p>
<p>
	Country: <input type="text" name = "studentAddress.country">
</p>
<p>
	City: <input type="text" name = "studentAddress.city">
</p>
<p>
	Street: <input type="text" name = "studentAddress.street">
</p>
<p>
	Zipcode: <input type="text" name = "studentAddress.zipcode">
</p>

</div>

<p>
   <input type="submit" value="Submit Form">
</p>
</form>
</body>
</html>