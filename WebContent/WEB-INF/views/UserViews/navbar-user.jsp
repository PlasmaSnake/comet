<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="comet.beans.User" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <h1 class="text-hide" style="background-image: url('images/icon_placeholder.svg'); width: 32px; height: 32px;margin-top: 6px;margin-right:10px;">Comet</h1>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="home">Coin List</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="contact">Contact Us</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Account
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="mycoins">My Coins</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="settings">Settings</a>
        </div>
      </li>
      <li class="nav-item">
		<a class="nav-link" href="../logout">Log Out</a>
      </li>
      <c:if test="${userLoggedIn.getAdminRole()==1}"> 
	      <li class="nav-item">
			<a class="nav-link" href="admin">Admin Page</a>
	      </li>      
      </c:if>
    </ul>
  </div>
</nav>