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
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Comet Coin Tracker</title>
<!-- Bootstrap -->
<link href="<c:url value="/resources/bootstrap/4.1.3/css/bootstrap.min.css"/>" rel="stylesheet" />
</head>
<header> 
	<%@include file="navbar.jsp" %>
</header>
<body>
	<div style="margin: 5px 0px 20% 0px; text-align:center;">
		<form:form action="signup_process" method="post" modelAttribute="userModel">
				<table style="margin: 0px auto;">
					<tr>
						<td>User Name: </td>
						<td><form:input type="text" path="username" name="username" placeholder="apple1234"/></td>
					</tr>
					<tr>
						<td>Password: </td>
						<td><form:input type="password" path="password" name="password" placeholder="6261abcd"/></td>
					</tr>
					<tr><td colspan="2"> <form:errors path="email" cssStyle="color:red;"/></td></tr>
					<tr>
						<td>E-mail: </td>
						<td><form:input type="text" path="email" name="email" placeholder="a1@domain.com"/></td>
					</tr>
					<tr>
						<td>Name: </td>
						<td><input type="text" name="fullName" placeholder="optional"/></td>
					</tr>
					<tr>
						<td>Country: </td>
						<td><input type="text" name="country" placeholder="optional"/></td>
					</tr>
					<tr><td colspan="2"><form:errors path="username" cssStyle="color:red;"/></td></tr>
					<tr><td colspan="2"><form:errors path="password" cssStyle="color:red;"/></td></tr>
				</table>
				<div style="text-align:center; margin:2px;">
			        <button type="submit" name="signup" value="signup" class="btn btn-primary">Sign Up</button>
				</div>
		</form:form>
	</div>
	<script src="<c:url value="/resources/bootstrap/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/popper/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
</body>
<%@include file="footer.jsp" %>
</html>