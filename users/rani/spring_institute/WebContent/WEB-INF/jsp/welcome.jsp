<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Training Program</title>

</head>
<body class="body">
	<center>
		<h2>
			
		</h2>
		<br>
		<h2>
			
		</h2>
		<div class="h2">
			Login User:
			<c:out value="${userBean.userId}" />
		</div>
		<br>

		<table class="table">
			<tr>
				<td><a href="listStudent">List Students</a></td>
				<td><a href="createStudent">New Students</a></td>
			</tr><tr><td colspan="2"></td></tr>
			<tr><td colspan="2"></td></tr>
			<tr>
				<td><a href="listCourse">List Courses</a></td>
				
				<td><a href="createCourse">New Courses</a></td>
			</tr><tr><td colspan="2"></td></tr><tr><td colspan="2"></td></tr>
			<tr>
				<td><a href="listTeacher">List Teachers</a></td>
				
				<td><a href="createTeacher">New Teacher</a></td>
			</tr>
			<tr><td colspan="2"></td></tr><tr><td colspan="2"></td></tr>
			<tr>
				<td colspan="2"><a href="treeAction">Student Tree</a></td>
			</tr>
			<tr>
				<td ><a href="listStudCourse">Student Courses</a></td>
				<td><a href="displayCreateSC">New Student Courses</a></td>
			</tr>
			<tr>
				<td><a href="listTeachCourse">Teacher Courses</a></td>
				
				<td><a href="displayCreateTC">New Teacher Courses</a></td>
			</tr>
			<tr>
				<td colspan="2"><a href="logout">Log Out</a></td>
			</tr>
		</table>
	</center>
</body>
</html>