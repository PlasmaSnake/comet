<%@page import="java.text.SimpleDateFormat"%>
<%@page import="comet.beans.DAO.SQLDataRequestDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="comet.beans.*, java.util.TreeMap, java.util.Map.Entry, java.util.Date, java.util.ArrayList" %>
<%@page import="comet.beans.DAO.SQLDataRequestDAO, comet.beans.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ArrayList<Coin> coinList = new ArrayList<Coin>();
	SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
	TreeMap<String, HistData> latestData = sqlDataRequestDAO.getAllCoinsLatestHistoricalData();
	for (Entry<String, HistData> e: latestData.entrySet()) {
		Coin coin = sqlDataRequestDAO.getBasicInfo(e.getKey());
		coinList.add(coin);
	}
%>
	<table class="table table-striped table-hover">
	  <thead>
	    <tr>
	      <th scope="col">Coin Symbol</th>
	      <th scope="col">Coin Name</th>
	      <th scope="col">Latest Day High</th>
	      <th scope="col">Latest Day Low</th>
	      <th scope="col">Max Supply</th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
		<% for(Coin c: coinList){
			String symbol = c.getSymbol();
		%>
		    <tr class='clickable-row' data-href='./coininfo?coin=<%=symbol%>'>
		      <th scope="row"><% out.print(symbol); %></th>
		      <td><%=c.getCoinName()%></td>
		      <td>$<%=String.format("%,.2f",latestData.get(symbol).getHigh()) %></td>
		      <td>$<%=String.format("%,.2f",latestData.get(symbol).getLow()) %></td>
		      <td><%=String.format("%,.2f",c.getMaxSupply())%></td>
		      <td>Last updated on <%=latestData.get(symbol).timestampToDate()%></td>
		      <c:if test="${userLoggedIn != null}">
	  			  <td> 
						<form action="addToUserCoins" method="post">
							<input type="hidden" name="coinToAdd" value="<%= c.getCoin_id()%>"> 
							<button type="submit" value="submit" class="btn btn-success">Add to watch list ${coinBasicInfo.getCoin_id()}</button>
						</form>
				  </td>
			  </c:if>
		    </tr>
	    <%} // end of coin list table %>
	  </tbody>
	</table>