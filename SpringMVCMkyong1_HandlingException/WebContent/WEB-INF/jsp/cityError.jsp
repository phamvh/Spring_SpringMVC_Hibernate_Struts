<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Exception Handling</title>
</head>
<body>

<h2>City Error: This is a GLOBAL advice thank to the use of @ControllerAdvice in class ControllerAdviceForCity. 
Check out that class for details.</h2>

<h3>${exceptionMsg}</h3>

</body>
</html>