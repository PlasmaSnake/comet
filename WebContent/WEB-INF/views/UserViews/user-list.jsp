<%@page import="comet.beans.DAO.SQLDataRequestDAO, comet.beans.DAO.SQLDataInsertDAO, java.util.ArrayList, comet.beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	User userLoggedIn = (User) session.getAttribute("userLoggedIn");
	SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
	ArrayList<User> userList = sqlDataRequestDAO.getAllUsers();
%>
	<c:if test="${deleted.equals(true)}">
		<div class="container">
			<br />
			<div class="alert alert-info">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
				<strong>User deleted from database</strong>
			</div>
		</div>
	</c:if>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">User Name</th>
	      <th scope="col">Full Name</th>
	      <th scope="col">Email</th>
	      <th scope="col">Country</th>
	      <th scope="col">Admin?</th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
		<c:forEach items="<%=userList %>" var="u">
			<tr>
				<td>${u.getUsername()}</td>
				<td>${u.getFullName()}</td>
				<td><c:out value="${u.getEmail()}"/></td>
				<td><c:out value="${u.getCountry()}"/></td>
				<td>
					<c:choose>
						<c:when test="${u.getAdminRole() == 1 }">
							<c:out value="Yes"/>
						</c:when>
						<c:when test="${u.getAdminRole() != 1 }">
							<c:out value="No"/>
						</c:when>
					</c:choose>
				</td>
				<td>
					<c:if test="${!u.getUsername().equals(userLoggedIn.getUsername())}">
						<form action="deleteUser" method="post">
							<input type="hidden" name="userToDelete" value="${u.getUsername()}"> 
							<button type="submit" name="delete" value="delete" class="btn btn-danger">Delete</button>
						</form>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	  </tbody>
	</table>