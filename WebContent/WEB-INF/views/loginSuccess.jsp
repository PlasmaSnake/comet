<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="comet.beans.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success!</title>
</head>
<%
	User user = (User)request.getAttribute("user");
%>
<body>
	<h1>Header</h1>
	<hr>
	<h2>
		Welcome
		<%= user.getUsername() %></h2>
</body>
</html>