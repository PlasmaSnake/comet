<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="comet.beans.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Comet Coin Tracker</title>
<!-- Bootstrap -->
<link href="<c:url value="/resources/bootstrap/4.1.3/css/bootstrap.min.css"/>" rel="stylesheet" />
</head>
<header> 
<%@include file="navbar.jsp" %>
</header>
<body>
<%
	// do sql gathering in here and put basic data into a coin. 
	Coins c = new Coins();
	// then do more sql gathering for inserting data
	
%>



	<div class="container">
		<br />
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
			<strong>Success!</strong> It is working as we expected.
		</div>
	</div>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Coin Symbol</th>
	      <th scope="col">Coin Name</th>
	      <th scope="col">High</th>
	      <th scope="col">Low</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${coinList}" var="item">
		    <tr>
		      <th scope="row">${item.getSymbol() }</th>
		      <td>${item.getCoinName() }</td>
		      <td>1</td>
		      <td>-1</td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	
	<script src="<c:url value="/resources/bootstrap/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/popper/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
</body>
</html>