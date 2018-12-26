package comet.beans.DAOI;

public interface SQLDataDeletionDAOI {
	//TODO CRUD operations on Accounts and UserCoins - SQL and Methods
	enum SQL{
		// TABLE DATA DELETION QUERIES
		DELETE_ACCOUNT("DELETE FROM accounts WHERE username=?"),
		DELETE_COIN_BASIC_DATA("DELETE FROM coinbasicinfo where symbol = ?"),
		DELETE_COIN_HISTORICAL_DATA("DELETE FROM coinhistoricalinfo where symbol = ?"),
		DELETE_USER_COIN("DELETE FROM usercoins where coin_id=?"),
		
		//For user coin deletion
		GET_USERCOIN_COIN_ID("SELECT coin_id FROM coinbasicinfo where symbol = ? AND user_id = ?");
		
		
		private String query;
		private SQL(String s) {
			this.query = s;
		}
		public String getQuery() {
			return query;
		}
	}
	
	/** Delete account from database
	 * @param username
	 */
	public void deleteAccount(String username);
	
	/** Delete coin's historical and basic information from database
	 * @param coinName
	 */
	public void deleteCoin(String coinName);
	
	/** Removes the relation of a user and coin from the database table
	 * @param coinName
	 */
	public void removeUserCoin(String coinName);
}
