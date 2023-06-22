<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="bookform">Add New Book</a>
<table>
	<thead>
		<tr>
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Author Name</th>
			<th>Book Price</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.bookID}</td>
				<td>${book.bookName}</td>
				<td>${book.authorName}</td>
				<td>${book.bookPrice}</td>
				<td>
					<a href="edit?bookID=${book.bookID}">Edit</a>
					<a href="delete?bookID=${book.bookID}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>