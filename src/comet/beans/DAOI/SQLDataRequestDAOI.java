package comet.beans.DAOI;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import comet.beans.Coin;
import comet.beans.HistData;
import comet.beans.User;


public interface SQLDataRequestDAOI {
	enum SQL{
		// TABLE DATA REQUESTS
		REQUEST_ACCOUNT_PW("SELECT pass FROM accounts WHERE username = ?"),
		REQUEST_ACCOUNT_DATA("SELECT * FROM accounts WHERE username = ?"),
		REQUEST_ACCOUNTS("SELECT * FROM accounts"),
		REQUEST_COIN_BASIC_DATA("SELECT * FROM coinbasicinfo "
				+ "WHERE ? = SYMBOL"),
		REQUEST_COIN_BASIC_DATA_BY_ID("SELECT * FROM coinbasicinfo "
				+ "WHERE ? = coin_id"),
		REQUEST_COIN_ALL_HISTORICAL_DATA("SELECT * FROM "
				+ "(SELECT DISTINCT * FROM coinhistoricalinfo WHERE coin_id = ? ORDER BY coin_timestamp DESC) coinTable"),
		REQUEST_ALL_COIN_LATEST_HISTORICAL_DATA("SELECT distinct chi.*, coinbasicinfo.SYMBOL " + 
				"FROM COINHISTORICALINFO chi " + 
				"INNER JOIN " + 
				"    (SELECT COIN_ID, MAX(coin_timestamp) AS MaxDateTime " + 
				"    FROM COINHISTORICALINFO\r\n" + 
				"    GROUP BY coin_id) groupedhist " + 
				"ON chi.COIN_ID = groupedhist.coin_id " + 
				"AND chi.COIN_TIMESTAMP = groupedhist.MaxDateTime " + 
				"INNER JOIN coinbasicinfo ON chi.COIN_ID = coinbasicinfo.coin_id"),
		//TODO test query
		REQUEST_COIN_LATEST_HISTORICAL_DATA("SELECT * FROM "
				+ "(SELECT DISTINCT * FROM coinhistoricalinfo WHERE coin_id = ? ORDER BY coin_timestamp DESC) coinTable "
				+ "WHERE ROWNUM = 1"),
		REQUEST_USER_COINS("SELECT distinct coin_id FROM usercoins WHERE user_id = ?"),
		
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
	
	/** Retrieves all Users from accounts database table.
	 * @return userList
	 */
	public ArrayList<User> getAllUsers();

	
	/** Used to get the basic information of a coin by its symbol
	 * @param coinSymbol
	 * @return Coin coin
	 * 
	 */
	public Coin getBasicInfo(String coinSymbol);
	
	/** Used to get the basic information of a coin by its id
	 * @param coin_id
	 * @return Coin coin
	 */
	public Coin getBasicInfoById(int coin_id);
	
	/** Retrieves all historical data of a coin
	 * @param coinSymbol
	 * @return ArrayList<HistData> data
	 */
	public ArrayList<HistData> getAllHistoricalData(int coin_id);
	
	/** Retrieves first row of historical data of all coins for the coinlist/mycoinlist page
	 * @param coinSymbol
	 * @return TreeMap<String, HistData> data
	 */
	public TreeMap<String, HistData> getAllCoinsLatestHistoricalData();
	
	/** Retrieves first instance of historical data for a specific coin
	 * @param coinId
	 * @return TreeMap<String, HistData> data
	 */
	 ArrayList<HistData> getCoinLatestHistoricalData(int coinId);
	
	/** Retrieves all tracked coin ids from usercoin database
	 * @param user_id
	 * @return
	 */
	Set<Integer> getUserCoinIDs(int user_id);
	
	
}
