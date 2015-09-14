<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Student</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<script src="myjscript.js"></script>
</head>
<body class="body">
	<center>

		<form:form action="saveStudent">
			<form:hidden path="studentId"
				value="${studentBean.studentId}" />
				<table>
				<tr><td><form:label path="studentId" >Student Id</form:label></td><td>
			<form:label path="studentId" >${studentBean.studentId}</form:label></td></tr>
			<tr><td><form:label path="firstName" >First Name</form:label></td><td>
			<form:input path="firstName"
				value="${studentBean.firstName}" />
				<tr><td><form:label path="lastName" >Last Name</form:label></td><td>
			<form:input path="lastName"
				value="${studentBean.lastName}"  />
				<tr><td><form:label path="gender">Gender</form:label></td><td>
				
			<form:radiobuttons path="gender" 
								items="{'Male':'Male','Female':'Female'}" value="${studentBean.gender}"  />
			<tr><td><form:label path="age">${studentBean.age}</form:label></td><td>
			<tr><td><form:label path="dateOfBirth">Date Of Birth</form:label></td><td>
				
				<form:input path="dateOfBirth" format="dd/MM/yyyy"  value="${studentBean.dateOfBirth}"
				 /> </td></tr>
				<tr><td><form:label path="phoneNo">Phone No</form:label></td><td>
			<form:input path="phoneNo"
				value="${studentBean.phoneNo}"  /> </td></tr>
				<tr><td><form:label path="cellNo">Cell No</form:label></td><td>
			<form:input path="cellNo" value="${studentBean.cellNo}" /> </td></tr>
				<tr><td><form:label path="emailId">Email Id</form:label></td><td>
			<form:input path="emailId"
				value="${studentBean.emailId}" /></td></tr>
				<tr><td><form:label path="graduation">Graduation</form:label></td><td>
			<form:input path="graduation"
				value="${studentBean.graduation}" /></td></tr>
			<tr><td><input type="reset" value="Clear"/></td>
			<td><input type="submit" value="Update"/><a href="welcome">Home</a></td>
			</tr>
			</table>
		</form:form>
	</center>
</body>
</html>