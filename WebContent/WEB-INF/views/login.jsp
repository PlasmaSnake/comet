<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="comet.beans.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comet Coin App</title>
</head>
<%
// if user stuff doesn't == user stuff
if(request.getParameter("login")!=null){
	Users user = new Users();
	user.setUsername(request.getParameter("userName"));
	user.setPassword(request.getParameter("password"));
	if ("test".equals(user.getUsername()) && "password".equals(user.getPassword())){
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
	} else { System.out.println("Username and Password does not match.");}
}
%>
<body>
	<h1>Sign in!</h1>
	<form method="post">
		<table>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="login" value="Login" />
				</td>
			</tr>
		</table>
	</form>
	<!-- TODO: make a successful/failure page  -->
	New User?
	<a href="signup">Sign up</a>
</body>
</html>