<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<script src="myjscript.js"></script>
</head>
<body class="body">
	<center>
		<form:form  action="loginUser"  method="post" modelAttribute="loginBean" >
			UserId<form:input   path="userId" /><form:errors path="userId"/>
			Password<form:input  path="password"/><form:errors path="password"/>
			<input type="submit" value="Login"/><input type="reset" value="Clear"/>
		</form:form>
		
	</center>
</body>
</html>