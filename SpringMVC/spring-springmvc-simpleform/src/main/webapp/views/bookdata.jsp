<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Book Information</h1>
<table>
	<tr>
		<td>Book Name</td>
		<td>${bookInfo.bookName}</td>
	</tr>
	<tr>
		<td>Author Name</td>
		<td>${bookInfo.authorName}</td>
	</tr>
	<tr>
		<td>Book Price</td>
		<td>${bookInfo.price}</td>
	</tr>
</table>
</body>
</html>