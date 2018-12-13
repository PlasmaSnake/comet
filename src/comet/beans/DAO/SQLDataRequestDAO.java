package comet.beans.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
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
	public boolean validateUser(String username, String password) {
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.REQUEST_ACCOUNT_PW.getQuery());
			ps.setString(1, username);
			rs = ps.executeQuery();
			// if Username is found in the database, check the password of that data
			if(rs.next()) {
				if (password.equals(rs.getString(1))) return true;
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose(); }
		return false;
	}
	
	@Override
	public User requestUserInfo(String username) {
		User user = null;
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.REQUEST_ACCOUNT_DATA.getQuery());
			ps.setString(1, username);
			rs = ps.executeQuery();
			System.out.println("result set");
			// if username is found in the database, check the password of that data
			if(rs.next()) {
				System.out.println("I have gotten a result");
				user = new User(
						rs.getString(2),//username
						rs.getString(3),//password
						rs.getString(4),//email
						rs.getString(5),//fullName
						rs.getString(6),//country
						rs.getInt(7));//admin role
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose(); }
		return user;
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
	public ArrayList<HistData> getHistoricalDataFromXToY(String coinSymbol, long timeFrom, long timeTo) {
		//TODO implement for graph
		ArrayList<HistData> data = null;
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.REQUEST_COIN_HISTORICAL_DATA_FROM_X_TO_Y.getQuery());
			ps.setString(1, coinSymbol);
			ps.setLong(2, timeTo); // earlier time
			ps.setLong(3, timeFrom); // time closest to present 
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//add histdata info
//				HistData info = new HistData(timestamp, low, high, open, close, volumeTo, volumeFrom);
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally { this.dispose(); }
		return data;
	}

	@Override
	public TreeMap<String, HistData> getAllCoinsLatestHistoricalData() {
		TreeMap<String, HistData> data = null;
		//TODO test
		try {
			this.connect();
			data = new TreeMap<>();
			ps = conn.prepareStatement(SQL.REQUEST_ALL_COIN_LATEST_HISTORICAL_DATA.getQuery());
			rs = ps.executeQuery();
			while(rs.next()) {
				HistData info = new HistData(
						rs.getLong(2), //timestamp, 
						rs.getDouble(5), //low, 
						rs.getDouble(6), //high, 
						rs.getDouble(3), //open, 
						rs.getDouble(4), //close, 
						rs.getDouble(7), //volumeTo, 
						rs.getDouble(8)); //volumeFrom
				data.put(rs.getString(9), info); //coin symbol
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally { this.dispose(); }
		return data;
	}
}
