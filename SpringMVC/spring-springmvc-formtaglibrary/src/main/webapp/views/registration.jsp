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
				<form:radiobutton path="gender" value="Male"/>Male
				<form:radiobutton path="gender" value="Female"/>Female
			</td>
		</tr>
		<tr>
			<td>Course</td>
			<td>
				<form:select path="course" >
					<form:option value="">Select</form:option>
					<form:option value="Java">Java</form:option>
					<form:option value="Spring">Spring</form:option>
					<form:option value="Unix">Unix</form:option>
					<form:option value="MySQL">MySQL</form:option>
					<form:option value="JavaScript">JavaScript</form:option>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Timings</td>
			<td>
				<form:checkbox path="timings" value="Morning"/>Morning
				<form:checkbox path="timings" value="Afternoon"/>Afternoon
				<form:checkbox path="timings" value="Evening"/>Evening
				<form:checkbox path="timings" value="Night"/>Night
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Register" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>