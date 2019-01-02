<%@page import="java.text.SimpleDateFormat"%>
<%@page import="comet.beans.DAO.SQLDataRequestDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="comet.beans.*, java.util.TreeMap, java.util.Map.Entry, java.util.Date, java.util.ArrayList" %>
<%
	//Retrieves user coin ids from database
	User u = (User) session.getAttribute("userLoggedIn");
	SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();	
	u.setSavedCoins(sqlDataRequestDAO.getUserCoinIDs(u.getUser_id()));
	ArrayList<Coin> coinList = new ArrayList<Coin>();
	//for each coinid, get basic coin information and historical data of those coins.
	for(int coin_id:u.getSavedCoins()){
			Coin coin = sqlDataRequestDAO.getBasicInfoById(coin_id);
			coin.setDataPoints(sqlDataRequestDAO.getCoinLatestHistoricalData(coin_id));
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
		    <tr class='clickable-row' data-href='./coininfo?coin=<%=symbol%>'>
		    <%--TODO: ADD a link to specific coin page --%>
		      <th scope="row"><% out.print(symbol); %></th>
		      <td><%=c.getCoinName()%></td>
		      <td>$<%=String.format("%,.2f",c.getDataPoints().get(0).getHigh()) %></td>
		      <td>$<%=String.format("%,.2f",c.getDataPoints().get(0).getLow()) %></td>
		      <td><%=String.format("%,.2f",c.getMaxSupply())%></td>
		      <td>Last updated on <%=c.getDataPoints().get(0).timestampToDate()%></td>
		      <td>
					<form action="deleteUserCoin" method="post">
						<input type="hidden" name="coinToDelete" value="<%=c.getCoin_id()%>"> 
						<button type="submit" name="delete" value="delete" class="btn btn-danger">Remove coin</button>
					</form>
				</td>
		    </tr>
	    <%} // end of coin list table %>
	  </tbody>
	</table>