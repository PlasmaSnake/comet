<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="comet.beans.DAO.SQLDataInsertDAO, comet.beans.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Comet Coin Tracker</title>
<link href="<c:url value="/resources/stylesheets/css/style.css"/>" type="text/css" rel="stylesheet" />
<!-- Bootstrap -->
<link href="<c:url value="/resources/bootstrap/4.1.3/css/bootstrap.min.css"/>" rel="stylesheet" />
</head>
<header> 
	<%@include file="navbar.jsp" %>
</header>
<% 
	SQLDataInsertDAO daoInsert = new SQLDataInsertDAO();
	String message = "";
	User userModel = (User) request.getAttribute("userModel");
	String fullName = userModel.getFullName().isEmpty()?"":userModel.getFullName();
	String country= userModel.getCountry().isEmpty()?"":userModel.getCountry();
	int acctCreationGeneratedID = daoInsert.createAccount(
			userModel.getUsername(), 
			userModel.getPassword(), 
			userModel.getEmail(), 
			fullName, 
			country);
	// if it's -1, it is NOT inserted
	if(acctCreationGeneratedID < 0) {
		message = "Username or E-mail already exists. Log in!";
	}
	else {
		// redirect to home
		message = "Account successfully signed up!";
	}
%>
<body>
	<div>
		<h3><%=message %></h3>
		<div style="text-align:center;">
			<a href = "signup">Sign up</a> <br>
			<a href = "home">Return to home</a>
		</div>
	</div>
	<script src="<c:url value="/resources/bootstrap/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/popper/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
</body>
<%@include file="footer.jsp" %>
</html>