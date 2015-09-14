<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Student</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<script src="myjscript.js"></script>
</head>
<body class="body">
<s:actionerror/>
<s:actionmessage/>
	<center>

		<s:form action="createStudent">
			<div>
				<table align="left">
					<tr>
						<td><s:text name="New Student" /></td>
					</tr>
					<tr>

						<td><s:textfield type="text" name="studentBean.firstName"
								label="First Name" maxlength="20" /></td>
					</tr>
					<tr>
						<td><s:textfield type="text"  name="studentBean.lastName"
								label="Last Name" maxlength="20" /></td>
					</tr>
					<tr>
						<td><s:radio type="text" label="Gender" name="studentBean.gender"
								list="#{'Male':'Male','Female':'Female'}" /></td>
					</tr>

					<tr>

						<td><s:textfield type="date" name="studentBean.dateOfBirth" format="dd/MM/yyyy" label="Date Of Birth (dd/MM/yyyy)"/></td>
					</tr>
					<tr>

						<td><s:textfield  type="text" name="studentBean.phoneNo" label="Phone No"
							onkeydown="isNumberKey(event)" onkeyup="phonecheck"	maxlength="12" /></td>
					</tr>
					<tr>

						<td><s:textfield  type="text" name="studentBean.cellNo" label="Cell No"
								maxlength="12" /></td>
					</tr>
					<tr>

						<td><s:textfield  type="email" name="studentBean.emailId" label="Email Id" />
						</td>
					</tr>
					<tr>

						<td><s:textfield  type="text" name="studentBean.graduation"
								label="Graduation" /></td>
					</tr>
					<tr>

						<td><s:reset value="Clear"/>
			<s:submit value="Create"/><s:a href="welcome.jsp">Home</s:a></td>
					</tr>
				</table>
			</div>
		</s:form>
	</center>
</body>
</html>