package comet.beans;

import java.util.TreeMap;

import comet.beans.DAO.SQLDataRequestDAO;

public class Coin {
	private int coin_id;
	private String symbol;
	private String coinName;
	private double maxSupply;
	private TreeMap<Long, HistData> dataPoints;
	
	public Coin(){
	}
	
	public Coin(int coin_id, String symbol, String coinName, double maxSupply) {
		this.coin_id = coin_id;
		this.symbol = symbol;
		this.coinName = coinName;
		this.maxSupply = maxSupply;
	}
	
	public int getCoin_id() {
		return coin_id;
	}
	public void setCoin_id(int coin_id) {
		this.coin_id = coin_id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCoinName() {
		return coinName;
	}
	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}
	public double getMaxSupply() {
		return maxSupply;
	}
	public void setMaxSupply(double maxSupply) {
		this.maxSupply = maxSupply;
	}
	public TreeMap<Long, HistData> getDataPoints() {
		return dataPoints;
	}
	public void insertDataPointsFromDB() {
		try {
			SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
			//TODO Insert datapoints from historical db
		} catch (Exception e) { e.printStackTrace();}
		
	}
	
	public void insertDataPoint(HistData point) {
		dataPoints.put(point.getTimestamp(), point);
	}
	
	
}
