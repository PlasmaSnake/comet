<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="comet.beans.DAO.SQLDataRequestDAO, comet.beans.Coin, comet.beans.HistData, java.util.ArrayList, java.text.SimpleDateFormat"%>
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
<%
	SQLDataRequestDAO sqlDataReq = new SQLDataRequestDAO();
	Coin coinBasic = (Coin) request.getAttribute("coinBasicInfo");
	ArrayList<HistData> initData = sqlDataReq.getAllHistoricalData((coinBasic.getCoin_id()));
	String laterDate = initData.get(0).timestampToDate();//will initially be the latest time
	String earlierDate = initData.get(initData.size()-1).timestampToDate(); //will initially be the 14th day
%>
</head>
<header> 
<%@include file="navbar.jsp" %>
</header>
<body>
	<div class="container">
		<br />
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
			<strong>Note: </strong> Only displays a list of daily information for now.
		</div>
	</div>
	<div class="container" style="padding-top:5px; padding-bottom:10px;">
		<div class="row">
			<div class="col col-md-auto">
			    <div class="card-header">
				    <strong> <%= coinBasic.getSymbol() %> </strong>
				</div>
			  	<ul class="list-group">
					<li class="list-group-item">Coin Name: <%= coinBasic.getCoinName() %> </li>
				    <li class="list-group-item">Max Supply: <%= coinBasic.getMaxSupply() %></li>
			  	</ul>
			</div>
			
			<div class="col col-lg-2" >
					<%@include file="googleChart.jsp" %>
			</div>
		</div>
	</div>
	<div class="row">
		<%-- Have calendar selector OR drop down of date FROM to date TO --%>
	</div>
	<h4>From dates <%= laterDate %> to <%= earlierDate %></h4>
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
		<c:forEach items="<%=initData %>" var="data">
			<tr>
				<td>${data.timestampToDate()}</td>
				<td>${data.getHigh()}</td>
				<td><c:out value="${data.getLow()}"/></td>
				<td><c:out value="${data.getOpen()}"/></td>
				<td>${data.getClose()}</td>
				<td>${data.getVolumeTo()}</td>
				<td>${data.getVolumeFrom()}</td>
			</tr>
		</c:forEach>
	  </tbody>
	</table>
	
	<script src="<c:url value="/resources/bootstrap/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/popper/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
</body>
<%@include file="footer.jsp" %>
</html>