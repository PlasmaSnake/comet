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
<title><%=session.getAttribute("coin") %></title>
<!-- Bootstrap -->
<link href="<c:url value="/resources/bootstrap/4.1.3/css/bootstrap.min.css"/>" rel="stylesheet" />
</head>
<header> 
<%@include file="navbar.jsp" %>
</header>
<body>

	
	<table>
	<tr>
		<td> coin info goes here:</td> <td> graph info goes here</td>
	</tr>
	<tr>
		<td> coin info goes here:</td> <td> graph info goes here</td>
	</tr>
	</table>
	
	<script src="<c:url value="/resources/bootstrap/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/popper/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
</body>
<%@include file="footer.jsp" %>
</html>