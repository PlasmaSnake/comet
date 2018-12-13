<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="comet.beans.User"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginDialog">
  Login
</button>
<!-- Modal -->
<div class="modal fade" id="loginDialog" tabindex="-1" role="dialog" aria-labelledby="loginLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="loginLabel">Sign in!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
		<form:form action="login_process" method="post" modelAttribute="userModel">
			<div class="modal-body">
				<table>
					<tr><td colspan="2"><form:errors path="username" cssStyle="color:red;"/></td></tr>
					<tr>
						<td>User Name: </td>
						<td><form:input type="text" id = "username" name="username" path="username" placeholder="apple1234" required="required"/></td>
					</tr>
					<tr><td colspan="2"><form:errors path="password" cssStyle="color:red;"/></td></tr>
					<tr>
						<td>Password: </td>
						<td><form:input type="password" name="password" path ="password" placeholder="6261abcd" required="required"/></td>
					</tr>
				</table>
			</div>
		    <div class="modal-footer">
		    	<div class="container col-md-12">
		    		<div class="row">
						<div class = "col-md-6">New User?&nbsp;<a href="signup">Sign up!</a> </div>
					    <div class = "col-md-6" style="justify-items:end;">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
					        <button type="submit" name="login" value="Login" class="btn btn-primary">Login</button>
				        </div>
			        </div>
		        </div>
	   	 	</div>
		</form:form>
    </div>
  </div>
</div>