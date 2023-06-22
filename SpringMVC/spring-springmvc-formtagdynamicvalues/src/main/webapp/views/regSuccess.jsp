<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration successful with below details</h1>
<table>
	<tr>
		<td>First Name</td>
		<td>${student.firstName}</td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td>${student.lastName}</td>
	</tr>
	<tr>
		<td>Email ID</td>
		<td>${student.email}</td>
	</tr>
	<tr>
		<td>Gender</td>
		<td>${student.gender}</td>
	</tr>
	<tr>
		<td>Course</td>
		<td>${student.course}</td>
	</tr>
	<tr>
		<td>Timings</td>
		<td>${student.timings[0]} ${student.timings[1]} ${student.timings[2]} ${student.timings[3]}</td>
	</tr>
</table>
</body>
</html>