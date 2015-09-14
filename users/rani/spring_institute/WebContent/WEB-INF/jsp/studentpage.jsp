<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students Page</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<script src="myjscript.js"></script>
</head>
<body class="body">
	<center>
			
				<table align="left">
		<tr><th align="center" colspan="12">Students Information</th></tr>
			<tr>
				<th  colspan="6"><a href="welcome">Home</a>    <a href="createstudent">Add Student</a></th>
				<th colspan="6"></th>
			</tr>
			<tr>
				<th>Student Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date Of Birth</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Phone No</th>
				<th>Cell No</th>
				<th>Email-Id</th>
				<th>Graduation</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${studentList}" var="studentBean">
				<tr>
					<td><c:out value="${studentBean.firstName}" /></td>
					<td><c:out value="${studentBean.firstName}" /></td>
					<td><c:out value="${studentBean.lastName}" /></td>
					<td><c:out value="${studentBean.dateOfBirth}" /></td>
					<td><c:out value="${studentBean.age}" /></td>
					<td><c:out value="${studentBean.gender}" /></td>
					<td><c:out value="${studentBean.phoneNo}" /></td>
					<td><c:out value="${studentBean.cellNo}" /></td>
					<td><c:out value="${studentBean.emailId}" /></td>
					<td><c:out value="${studentBean.graduation}" /></td>
					<td> <a href="editStudent?studentBean.studentId=${studentBean.studentId}">Edit</a></td>
					<td><a href="deleteStudent?studentBean.studentId=${studentBean.studentId}">Delete</a></td>
							
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>