<%@page import="java.text.SimpleDateFormat"%>
<%@page import="comet.beans.DAO.SQLDataRequestDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="comet.beans.*, java.util.TreeMap, java.util.Map.Entry, java.util.Date, java.util.ArrayList" %>
<%
	// do sql gathering in here and put basic data into a coin. 
	// maybe make cookies to prevent
	ArrayList<Coin> coinList = new ArrayList<Coin>();
	SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
	TreeMap<String, HistData> latestData = sqlDataRequestDAO.getAllCoinsLatestHistoricalData();
	for (Entry<String, HistData> e: latestData.entrySet()) {
		Coin coin = sqlDataRequestDAO.getBasicInfo(e.getKey());
		coinList.add(coin);
	}
	// then do more sql gathering for inserting data
%>
	<div class="container">
		<br />
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
			<strong>Note: </strong> A max supply of 0 means there is no maximum.
		</div>
	</div>
	
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Coin Symbol</th>
	      <th scope="col">Coin Name</th>
	      <th scope="col">Day High</th>
	      <th scope="col">Day Low</th>
	      <th scope="col">Max Supply</th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
		<% for(Coin c: coinList){
			String symbol = c.getSymbol();
		%>
		    <tr>
		    <%--TODO: ADD a link to specific coin page --%>
		      <th scope="row"><% out.print(symbol); %></th>
		      <td><%=c.getCoinName()%></td>
		      <td>$<%=String.format("%,.2f",latestData.get(symbol).getHigh()) %></td>
		      <td>$<%=String.format("%,.2f",latestData.get(symbol).getLow()) %></td>
		      <td><%=String.format("%,.2f",c.getMaxSupply())%></td>
		      <td>Last updated on <%=new SimpleDateFormat("yyyy-MM-dd").format(new Date(latestData.get(symbol).getTimestamp()*1000))%></td>
		    </tr>
	    <%} // end of coin list table %>
	  </tbody>
	</table>