<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admision Form</title>
</head>
<body>
<form action="/SpringMVC4_Request_ProcessForm/submitInfo" method="post">
<h1>Student Admission Form</h1>
<p>
   Student Name: <input type="text" name = "student_name">
</p>
<p>
   Major: <input type="text" name = "student_major">
</p>
<p>
   <input type="submit" value="Submit Form">
</p>
</form>
</body>
</html>