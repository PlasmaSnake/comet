package comet.beans.DAO;

import java.sql.SQLException;
import java.util.TreeMap;

import comet.beans.Coin;
import comet.beans.HistData;
import comet.beans.User;
import comet.beans.DAOI.ConnectionAbstractDAO;
import comet.beans.DAOI.SQLDataRequestDAOI;

/**
 * @author Students
 * This class requests data from the AWS comet Oracle SQL database.
 */
public class SQLDataRequestDAO extends ConnectionAbstractDAO implements SQLDataRequestDAOI {

	@Override
	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllCoinInfo(String coinSymbol) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Coin getBasicInfo(String coinSymbol) {
		Coin coin = null;
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.REQUEST_COIN_BASIC_DATA.getQuery());
			ps.setString(1, coinSymbol);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				coin = new Coin(
					rs.getInt(1), // coin id
					rs.getString(2), // Symbol
					rs.getString(3), // coin name
					rs.getLong(4)); // max supply
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally { this.dispose(); }
		return coin;
	}

	@Override
	public TreeMap<Integer, HistData> getHistoricalDataFromXToY(String coinSymbol, long timeFrom, long timeTo) {
		// TODO Auto-generated method stub
		return null;
	}
	//TODO implement
}
