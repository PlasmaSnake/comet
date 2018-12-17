<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="comet.beans.DAO.SQLDataRequestDAO"%>
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
<%@include file="navbar-user.jsp" %>
</header>
<body>
	<div class="content-area">
		<ul>
			<li style="font-size:50px;">Contact Us</li>
			<li>	
				michaelsy34@gmail.com
			</li>
			<li>
				<a href="https://github.com/PlasmaSnake" target="_blank"><img src="<c:url value="/resources/images/github.svg"/>" style="width: 64px; height: 64px;margin-top: 6px;margin-right:10px;"></a>
			</li>
			<li>
				<a href="https://www.linkedin.com/in/michaelsy34/" target="_blank"><img src="<c:url value="/resources/images/linkedin.svg"/>" style="width: 64px; height: 64px;margin-top: 6px;margin-right:10px;"></a>
			</li>
		</ul>
		<h2>Credits/Third Party Programs and Licenses</h2>
		
		<ul>
			<li>
				<a href = "https://www.platformbyps.org/" target="_blank">Platform By Per Scholas</a>
			</li>
		</ul>
		<ul>
			<li>
				<a href = "https://www.cryptocompare.com/api" target="_blank">Cryptocompare API</a>
			</li>
		</ul>
		<ul>
			<li>
				<a href = "https://aws.amazon.com/" target="_blank">Amazon Web Services</a>
			</li>
		</ul>
		
	</div>
	
	<script src="<c:url value="/resources/bootstrap/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/popper/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
	
</body>

<%@include file="../footer.jsp" %>
</html>