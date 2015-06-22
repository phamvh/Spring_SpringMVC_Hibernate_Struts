<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- This ${welcomeMessage} comes from method addCommonObjectsToAllModelsOfThisController(Model model).
Check the method for details. -->
<h1>${welcomeMessage}</h1>
<h2>Congratulations. ${stud.studentName}, you have been accepted to program ${stud.studentMajor}!</h2>
<p>
    Your phone: ${stud.studentPhone}
</p>
<p>
    Your DOB: ${stud.studentDOB}
</p>
<p>
    Your skills: ${stud.studentSkills}
</p>
<p>
    <b>Your address:</b>
</p>
<p>
   Country: ${stud.studentAddress.country}
   </p>
<p>
   City: ${stud.studentAddress.city}
   </p>
<p>
   Street: ${stud.studentAddress.street}</p>
<p>
   Zipcode: ${stud.studentAddress.zipcode}</p>
</body>
</html>