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
<title><%=session.getAttribute("queriedCoin") %></title>
<link href="<c:url value="/resources/stylesheets/css/style.css"/>" type="text/css" rel="stylesheet" />
<!-- Bootstrap -->
<link href="<c:url value="/resources/bootstrap/4.1.3/css/bootstrap.min.css"/>" rel="stylesheet" />
</head>
<header> 
<%@include file="../navbar.jsp" %>
</header>
<%
// take model information and populate fields

%>
<body>
	<%-- TODO Graph IN HERE >> Just has range of days. don't do anything fancy, maybe separate each new month--%>
	
	<%-- Have calendar selector OR drop down of date FROM to date TO --%>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Date</th>
	      <th scope="col">Day High</th>
	      <th scope="col">Day Low</th>
	      <th scope="col">Day Open</th>
	      <th scope="col">Day Close</th>
	      <th scope="col">Volume To USD</th>
	      <th scope="col">Volume from USD</th>
	    </tr>
	  </thead>
	  <tbody>
		<%-- make wire frame for coin view --%>
	  </tbody>
	</table>
	
	<script src="<c:url value="/resources/bootstrap/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/popper/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
</body>
<%@include file="../footer.jsp" %>
</html>