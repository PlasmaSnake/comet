package comet.beans.DAOI;

public interface SQLDataDeletionDAOI {
	//TODO CRUD operations on Accounts and UserCoins - SQL and Methods
	enum SQL{
		// TABLE DATA DELETION QUERIES
		DELETE_ACCOUNT("DELETE FROM accounts WHERE username=?"),
		DELETE_COIN_BASIC_DATA("DELETE FROM coinbasicinfo where symbol = ?"),
		DELETE_COIN_HISTORICAL_DATA("DELETE FROM coinhistoricalinfo where symbol = ?"),
		DELETE_USER_COIN("DELETE FROM usercoins where coin_id=? AND user_id =?"),
		DELETE_ALL_USER_COIN("DELETE FROM usercoins where user_id =?");
	
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
	public boolean deleteAccount(String username);
	
	/** Delete coin's historical and basic information from database
	 * @param coinName
	 */
	public boolean deleteCoin(String coinName);
	
	/** Removes the relation of a user and coin from the database table
	 * @param coin_id
	 * @param user_id
	 */
	public boolean removeUserCoin(int coin_id, int user_id);	
}
