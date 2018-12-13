<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="comet.beans.DAO.SQLDataRequestDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<form:form action="modify_user_process" method="post" modelAttribute="loggedInUser">
				<table style="margin: 0px auto;">
					<tr><td>Modify your account:</td></tr>
					<tr>
						<td>Old password: </td>
						<td><form:input type="password" path="oldpassword" name="oldpassword" placeholder="6261abcd"/></td>
					</tr>
					<tr>
						<td>New Password: </td>
						<td><form:input type="password" path="password" name="password" placeholder="abcd6261"/></td>
					</tr>
					<tr>
						<td>Change Primary E-mail: </td>
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
					<tr><td colspan="2"><form:errors path="oldpassword" cssStyle="color:red;"/></td></tr>
					<tr><td colspan="2"><form:errors path="password" cssStyle="color:red;"/></td></tr>
					<tr><td colspan="2"><form:errors path="email" cssStyle="color:red;"/></td></tr>
					<tr><td colspan="2">${input_error}${pass_changed}</td></tr>
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

<%@include file="../footer.jsp" %>
</html>