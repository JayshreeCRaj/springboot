<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add New Book</h1>
<form action="saveBook" method="post">
<table> 
	<tr>
		<td>Book Name</td>
		<td><input type="text" name="bookName"></td>
	</tr>
	<tr>
		<td>Author Name</td>
		<td><input type="text" name="authorName"></td>
	</tr>
	<tr>
		<td>Price</td>
		<td><input type="text" name="price"></td>
	</tr>
	<tr>
		<td><input type="submit" name="Register"></td>
	</tr>
</table>
</form>

</body>
</html>