<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="register" method="POST" modelAttribute="student">
	<table>
		<tr>
			<td>First Name</td>
			<td><form:input path="firstName" /></td>
		</tr>	
		<tr>
			<td>Last Name</td>
			<td><form:input path="lastName" /></td>
		</tr>
		<tr>
			<td>Email ID</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				<form:radiobuttons path="gender" items="${genders}"/>
			</td>
		</tr>
		<tr>
			<td>Course</td>
			<td>
				<form:select path="course" >
					<form:options items="${courses}"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Timings</td>
			<td>
				<form:checkboxes path="timings" items="${timingsInfo}"/>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Register" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>