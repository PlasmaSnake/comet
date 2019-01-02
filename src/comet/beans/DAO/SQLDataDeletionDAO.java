package comet.beans.DAO;

import java.sql.SQLException;

import comet.beans.User;
import comet.beans.DAOI.ConnectionAbstractDAO;
import comet.beans.DAOI.SQLDataDeletionDAOI;

public class SQLDataDeletionDAO extends ConnectionAbstractDAO implements SQLDataDeletionDAOI{

	@Override
	public boolean deleteAccount(String username) {
		try {
			this.connect();
			SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
			User u = sqlDataRequestDAO.requestUserInfo(username);
			
			//delete usercoins
			ps = conn.prepareStatement(SQL.DELETE_ALL_USER_COIN.getQuery());
			ps.setInt(1, u.getUser_id());
			ps.execute();
			
			//delete account information
			ps = conn.prepareStatement(SQL.DELETE_ACCOUNT.getQuery());
			ps.setString(1, username);
			ps.execute();
			return true;

		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose(); }
		return false;
	}

	@Override
	public boolean deleteCoin(String coinName) {
		try {
			this.connect();
			//delete basic coin
			ps = conn.prepareStatement(SQL.DELETE_COIN_BASIC_DATA.getQuery());
			ps.setString(1, coinName);
			ps.addBatch();
			
			//delete historical coin data
			ps = conn.prepareStatement(SQL.DELETE_COIN_HISTORICAL_DATA.getQuery());
			ps.setString(1, coinName);
			ps.addBatch();
			ps.executeBatch();
			
			return true;

		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose(); }
		return false;
	}

	//TODO Implement and test
	@Override
	public boolean removeUserCoin(int coin_id, int user_id) {
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.DELETE_USER_COIN.getQuery());
			ps.setInt(1,coin_id);
			ps.setInt(2, user_id);
			ps.execute();
			return true;

		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose(); }
		return false;
	}
	
}
