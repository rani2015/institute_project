<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Course</title>

</head>
<body class="body">
	<center>
	
		<form:form id="courseBean" action="updateCourse" modelAttribute="courseBean" method="post">
		<form:hidden path ="courseId" />
		<form:label path="courseId"  >${courseBean.courseId}</form:label>
		<form:label path="courseName" >Course Name</form:label>
		<form:input  path="courseName" value="${courseBean.courseName}" />
		
		
		<form:label   path="courseFee" >Course Fee</form:label>
		<form:input  path="courseFee"  value="${courseBean.courseFee}"/>
		
		<form:label   path="courseHours" >Course Hours</form:label>
		<form:input  path="courseHours"  value="${courseBean.courseHours}"/>
	
		<input type="reset" value="Clear"/>
			<input type="submit" value="Update"/><a href="welcome">Home</a>
		</form:form>
	</center>
</body>
</html>