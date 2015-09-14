<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses Page</title>

</head>
<body class="body">
	<center>
		<h2>
			
		</h2>
		<br>
		<h2>
			
		</h2>
		<table class="table">
			<c:forEach items="${courseList}" var="courseBean" >
				<tr>
					<td><c:out  value="${courseBean.courseId}" /></td>
					<td><c:out value="${courseBean.courseName}" /></td>
					<td><c:out value="${courseBean.courseFee}" /></td>
					<td><c:out value="${courseBean.courseHours}" /></td>

					<td><a href="editCourse?courseId=${courseBean.courseId}">
							Edit</a>

						</td>
					<td><a href="deleteCourse?courseId=${courseBean.courseId}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="welcome">Home</a></td>
				
				<td><a href="createCourse">Add Courses</a></td>
			</tr>
		</table>
	</center>
</body>
</html>