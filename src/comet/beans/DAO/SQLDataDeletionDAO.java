package comet.beans.DAO;

import java.sql.SQLException;

import comet.beans.DAOI.ConnectionAbstractDAO;
import comet.beans.DAOI.SQLDataDeletionDAOI;

public class SQLDataDeletionDAO extends ConnectionAbstractDAO implements SQLDataDeletionDAOI{

	@Override
	public void deleteAccount(String username) {
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.DELETE_ACCOUNT.getQuery());
			ps.setString(1, username);
			ps.execute();

		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose(); }
	}

	@Override
	public void deleteCoin(String coinName) {
		try {
			this.connect();
			//delete basic coin
			ps = conn.prepareStatement(SQL.DELETE_COIN_BASIC_DATA.getQuery());
			ps.setString(1, coinName);
			ps.execute();
			
			//delete historical coin data
			ps = conn.prepareStatement(SQL.DELETE_COIN_HISTORICAL_DATA.getQuery());
			ps.setString(1, coinName);
			ps.execute();

		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose(); }
	}

	//TODO Implement and test
	@Override
	public void removeUserCoin(String coinName) {
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.DELETE_USER_COIN.getQuery());
			ps.setString(1, coinName);
			ps.execute();

		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose(); }
	}
	
	//TODO Implement UserCoin and then test this
	protected int getUserCoin_CoinID(String coinName, String username) {
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.GET_USERCOIN_COIN_ID.getQuery());
			ps.setString(1, coinName);
			ps.setString(2, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose(); }
		return -1;
	}
	
}
