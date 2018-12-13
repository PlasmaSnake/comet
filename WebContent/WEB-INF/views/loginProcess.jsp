<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="comet.beans.DAO.SQLDataRequestDAO, comet.beans.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/stylesheets/css/style.css"/>" type="text/css" rel="stylesheet" />
<!-- Bootstrap -->
<link href="<c:url value="/resources/bootstrap/4.1.3/css/bootstrap.min.css"/>" rel="stylesheet" />
<title>Comet Coin Tracker</title>
</head>
<%
	SQLDataRequestDAO dao = new SQLDataRequestDAO();
	User user = (User) request.getAttribute("userModel");
	boolean test = dao.validateUser(user.getUsername(), user.getPassword());
	if (test) {
		request.getSession().setAttribute("userLoggedIn", dao.requestUserInfo(user.getUsername()));
		response.sendRedirect("u/");
	}
%>
<header> 
	<%@include file="navbar.jsp" %>
</header>
<body>
	<div class="error-msg">${login_error }</div>
	<div class="content-area">
		<form:form action="login_page_process" method="post" modelAttribute="userModel">
			<table style="margin: 0px auto;">
				<tr>
					<td>User Name: </td>
					<td><form:input type="text" path="username" name="username" placeholder="apple1234" required="required"/></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><form:input type="password" path="password" name="password" placeholder="6261abcd" required="required"/></td>
				</tr>
				<tr><td colspan="2"><form:errors path="username" cssStyle="color:red;"/></td></tr>
				<tr><td colspan="2"><form:errors path="password" cssStyle="color:red;"/></td></tr>
			</table>
			<div style="text-align:center; margin:2px;">
		        <button type="submit" name="signup" value="signup" class="btn btn-primary">Log-In</button>
			</div>
			<div>New User?&nbsp;<a href="signup">Sign up!</a> </div>
		</form:form>
	</div>
</body>
</html>