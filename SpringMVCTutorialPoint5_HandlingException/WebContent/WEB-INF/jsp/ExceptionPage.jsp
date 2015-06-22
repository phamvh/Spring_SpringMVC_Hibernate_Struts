<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Exception Handling</title>
</head>
<body>

<h2>Spring MVC Exception Handling</h2>
<!-- Here you will access the exception instance via ${exception}. exception is probably a 
default name that spring provide for jsp to carry information of thrown exceptions in the code. 
However, note that the property name exceptionMsg has to match the property name of 
your custom exception (NameException). -->
<h3>${exception.exceptionMsg}</h3>

</body>
</html>