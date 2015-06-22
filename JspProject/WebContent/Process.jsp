<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="org.koushik.javabrains.dto.User" scope="request">

   This asks the server to look for the value of the HTTP parameter "username" and assign it to property "userName" of class User.
   If they share the same names, like in this case "userName", the no need to specify param="userName" anymore. It is assigned by default.
  <jsp:setProperty property="userName" name = "user" param="userName"/>
  
  If all the names of the properties of class User match the names of the HTTP params, then we can use a short cut to get them all, like this:
  <jsp:setProperty property="*" name = "user"/>
</jsp:useBean>


In these JSTL getters, name is the name of the object of User class created before, and by default it is the id "user"
And property is the name of the property of class User


Hello: <jsp:getProperty property="userName" name="user"/> <br/>
Address1: <jsp:getProperty property="address1" name="user"/> <br/>
Address2: <jsp:getProperty property="address2" name="user"/> <br/>
City: <jsp:getProperty property="city" name="user"/> <br/>
State: <jsp:getProperty property=""state name="user"/> <br/>
Zipcode: <jsp:getProperty property="zipcode" name="user"/> <br/>

</body>
</html>
















