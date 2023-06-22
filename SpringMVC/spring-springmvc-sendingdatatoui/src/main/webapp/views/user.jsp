<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> User Information </h1>
<table>
	<tr>
		<td>User ID:</td>
		<td>${user.userId}</td>
	</tr>
	<tr>
		<td>First Name:</td>
		<td>${user.firstName}</td>
	</tr>
	<tr>
		<td>Email ID:</td>
		<td>${user.emailId}</td>
	</tr>
</table>
</body>
</html>