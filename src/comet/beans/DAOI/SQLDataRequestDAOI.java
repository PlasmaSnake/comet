package comet.beans.DAOI;

import java.util.TreeMap;

import comet.beans.Coins;
import comet.beans.HistData;
import comet.beans.Users;

public interface SQLDataRequestDAOI {
	enum SQL{
		// TABLE DATA REQUESTS
		REQUEST_ACCOUNT_USER_PW("SELECT username, pass FROM accounts WHERE username = ? AND pass = ?"),
		REQUEST_ACCOUNT_DATA("SELECT * FROM accounts"), //TODO 
		REQUEST_COIN_BASIC_DATA("SELECT * FROM coinbasicinfo"
				+ "WHERE ? = SYMBOL"),
		REQUEST_COIN_HISTORICAL_DATA("SELECT * FROM coinhistoricalinfo" 
				+ "WHERE ? = SYMBOL"),
		REQUEST_USER_COINS("SELECT * FROM usercoins"), //TODO
		
		// USED TO VERIFY COIN FOR USER COINS
		LOOK_FOR_COIN("SELECT coin_id FROM coinbasicinfo where symbol = ?");
		
		private String query;
		private SQL(String s) {
			this.query = s;
		}
		public String getQuery() {
			return query;
		}
	}
	//TODO Figure out methods
	
	/** Checks to see if User is in database
	 * @param user
	 * @return true if user has an account in database, false otherwise.
	 */
	public boolean validateUser(Users user);
	
	/** Retrieves all information about a specific coin
	 * @param coinSymbol
	 * @return true if basic info and historical data functions work. false if one fails
	 */
	public boolean getAllCoinInfo(String coinSymbol);
	/**
	 * @param coinSymbol
	 * @return Coins coin
	 * Used to get the basic information of a coin.
	 */
	public Coins getBasicInfo(String coinSymbol);
	
	/** Retrieves historical data from time range values X to Y
	 * @param coinSymbol
	 * @return TreeMap<Integer, HistData> data
	 */
	public TreeMap<Integer, HistData> getHistoricalDataFromXToY(String coinSymbol, long timeFrom, long timeTo);
	
}
