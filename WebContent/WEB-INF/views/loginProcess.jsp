<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="comet.beans.DAO.SQLDataRequestDAO, comet.beans.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Comet Coin Tracker</title>
</head>
<%
	SQLDataRequestDAO dao = new SQLDataRequestDAO();
	User user = (User) request.getAttribute("userModel");
	boolean test = dao.validateUser(user.getUsername(), user.getPassword());
%>
<body>
	<div>
		The name is: ${user.getUsername()} <br>
		Entered password is: ${user.getPassword() } <br>
		Does it match db password: <%=test %>
	</div>
</body>
</html>