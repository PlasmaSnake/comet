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
		<div class="card" style="width: 24rem;margin:auto;">
		  <div class="card-body">
		  	<form action = "updatename" method="post">
			    <p class="card-text">Full Name: ${userLoggedIn.getFullName()}</p>
			    <input type="text" name="fullName" placeholder="John Doe"/>
			    <button type="submit" name="changeName" value="changeName" class="btn btn-primary">Change Name</button>
			</form>
		  </div>
		</div>
		
		<div class="card" style="width: 24rem;margin:auto;">
		  <div class="card-body">
			<p class="card-text">Change password here</p>
			<div class ="error-msg">${password_error }</div>
		  		<form:form action = "updatepassword" method="post" modelAttribute="passwordval">
				    <p class="card-text"><form:errors path="password" cssStyle="color:red;"/></p>
				   	<form:input type="password" path="password" name="password" placeholder="Enter old password"/>
				   	<p class="card-text"><form:errors path="newPassword" cssStyle="color:red;"/></p>
				    <form:input type="password" path="newPassword" name="newPassword" placeholder="abcdef123456"/>
				    <br>
				    <button type="submit" name="changePass" value="changePass" class="btn btn-primary">Change Password</button>
				</form:form>
		  </div>
		</div>
				<div class="card" style="width: 24rem;margin:auto;">
		  <div class="card-body">
		  	<form action = "updatecountry" method="post">
			    <p class="card-text">Country: ${userLoggedIn.getCountry()}</p>
			    <input type="text" name="country" placeholder="United States"/>
			    <button type="submit" name="changeCountry" value="changeCountry" class="btn btn-primary">Change Country</button>
			</form>
		  </div>
		</div>
	
	<script src="<c:url value="/resources/bootstrap/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/popper/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
	
</body>

<%@include file="../footer.jsp" %>
</html>