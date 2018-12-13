<%@page import="java.text.SimpleDateFormat"%>
<%@page import="comet.beans.DAO.SQLDataRequestDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="comet.beans.*, java.util.TreeMap, java.util.Map.Entry, java.util.Date, java.util.ArrayList" %>
<%
	//TODO 
	ArrayList<Coin> coinList = new ArrayList<Coin>();
	SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
	TreeMap<String, HistData> latestData = sqlDataRequestDAO.getAllCoinsLatestHistoricalData();
	for (Entry<String, HistData> e: latestData.entrySet()) {
		Coin coin = sqlDataRequestDAO.getBasicInfo(e.getKey());
		coinList.add(coin);
	}
%>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Coin Symbol</th>
	      <th scope="col">Coin Name</th>
	      <th scope="col">Latest Day High</th>
	      <th scope="col">Latest Day Low</th>
	      <th scope="col">Max Supply</th>
	      <th scope="col">Remove</th>
	    </tr>
	  </thead>
	  <tbody>
		<% for(Coin c: coinList){
			String symbol = c.getSymbol();
		%>
		    <tr class='clickable-row' data-href='/comet/coininfo?coin=${symbol}'>
		    <%--TODO: ADD a link to specific coin page --%>
		      <th scope="row"><% out.print(symbol); %></th>
		      <td><%=c.getCoinName()%></td>
		      <td>$<%=String.format("%,.2f",latestData.get(symbol).getHigh()) %></td>
		      <td>$<%=String.format("%,.2f",latestData.get(symbol).getLow()) %></td>
		      <td><%=String.format("%,.2f",c.getMaxSupply())%></td>
		      <td>Last updated on <%=new SimpleDateFormat("yyyy-MM-dd").format(new Date(latestData.get(symbol).getTimestamp()*1000))%></td>
		      <td>Remove coin</td> <%-- TODO --%>
		    </tr>
	    <%} // end of coin list table %>
	  </tbody>
	</table>