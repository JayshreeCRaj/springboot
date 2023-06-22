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
<h1>Add New Book</h1>
<p>${success}</p>
<br>
<form:form action="addBook" method="post" modelAttribute="book">
	<table>
		<tr>
			<td>Book Name</td>
			<td><form:input path="bookName"/></td>
		</tr>
		<tr>
			<td>Author Name</td>
			<td><form:input path="authorName"/></td>
		</tr>
		<tr>
			<td>Book Price</td>
			<td><form:input path="bookPrice"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Add Book"/></td>
		</tr>
	</table>
</form:form>
<a href="viewBooks">View Books</a>
</body>
</html>