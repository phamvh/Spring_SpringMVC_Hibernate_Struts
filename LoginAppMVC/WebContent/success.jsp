<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="org.koushik.javabrains.dto.User"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
<h3>Login Successful!</h3>
<%
//User user = (User)session.getAttribute("user"); //this is when the redirecting servlet uses a response.sendRedirect()
//User user = (User)request.getAttribute("user"); //this is when the redirecting servlet uses a dispatcher
%>

This takes the id ("user") as the name of the returned object
<jsp:useBean id="user" class="org.koushik.javabrains.dto.User" scope="request">
   This in-between-tags code will be executed if the object "user" is not found, otherwise this code will be ignored
	<jsp:setProperty property="userName" name="user" value="NewUser"/>
</jsp:useBean>


Hello <%= /*user.getUserName() */%>
Hello <jsp:getProperty property="userName" name="user"/>

</body>
</html>