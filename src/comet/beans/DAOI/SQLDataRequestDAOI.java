package comet.beans.DAOI;

import java.util.ArrayList;
import java.util.TreeMap;

import comet.beans.Coin;
import comet.beans.HistData;
import comet.beans.User;


public interface SQLDataRequestDAOI {
	enum SQL{
		// TABLE DATA REQUESTS
		REQUEST_ACCOUNT_PW("SELECT pass FROM accounts WHERE username = ?"),
		REQUEST_ACCOUNT_DATA("SELECT * FROM accounts WHERE username = ?"),
		REQUEST_COIN_BASIC_DATA("SELECT * FROM coinbasicinfo "
				+ "WHERE ? = SYMBOL"),
		REQUEST_COIN_HISTORICAL_DATA_FROM_X_TO_Y("SELECT * FROM coinhistoricalinfo " 
				+ "WHERE ? = SYMBOL AND "
				+ "COIN_TIMESTAMP BETWEEN ? AND ?"),
		REQUEST_ALL_COIN_LATEST_HISTORICAL_DATA("SELECT distinct chi.*, coinbasicinfo.SYMBOL " + 
				"FROM COINHISTORICALINFO chi " + 
				"INNER JOIN " + 
				"    (SELECT COIN_ID, MAX(coin_timestamp) AS MaxDateTime " + 
				"    FROM COINHISTORICALINFO\r\n" + 
				"    GROUP BY coin_id) groupedhist " + 
				"ON chi.COIN_ID = groupedhist.coin_id " + 
				"AND chi.COIN_TIMESTAMP = groupedhist.MaxDateTime " + 
				"INNER JOIN coinbasicinfo ON chi.COIN_ID = coinbasicinfo.coin_id"),
		REQUEST_USER_COINS("SELECT * FROM usercoins JOIN accounts ON usercoins.userID = accounts.userID"), //TODO figure out joins
		
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

	/** Checks to see if User is in database
	 * @param username Username to be queried
	 * @param password Password to be checked
	 * @return true if username is in database AND has a matching password, false otherwise.
	 */
	public boolean validateUser(String username, String password);
	
	/** To be used after validateUser was confirmed to be valid.
	 * @param username
	 * @return Returns a user object. 
	 */
	public User requestUserInfo(String username);
	
	/** Retrieves all information about a specific coin
	 * @param coinSymbol
	 * @return true if basic info and historical data functions work. false if one fails
	 */
	// function for list of users?
	public boolean getAllCoinInfo(String coinSymbol);
	
	/**
	 * @param coinSymbol
	 * @return Coins coin
	 * Used to get the basic information of a coin.
	 */
	public Coin getBasicInfo(String coinSymbol);
	
	/** Retrieves historical data from time range values X to Y for graphing
	 * @param coinSymbol
	 * @return ArrayList<HistData> all data within the queried time range
	 */
	public ArrayList<HistData> getHistoricalDataFromXToY(String coinSymbol, long timeFrom, long timeTo);
	
	/** Retrieves first row of historical data of all coins for the coinlist/mycoinlist page
	 * @param coinSymbol
	 * @return TreeMap<String, HistData> data
	 */
	public TreeMap<String, HistData> getAllCoinsLatestHistoricalData();
	
	
	
	//TODO user coin stuff
	
	
	
}
