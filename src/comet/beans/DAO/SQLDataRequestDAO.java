package comet.beans.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
			// if username is found in the database, check the password of that data
			if(rs.next()) {
				user = new User(
						rs.getString(2),//username
						rs.getString(3),//password
						rs.getString(4),//email
						rs.getString(5),//fullName
						rs.getString(6),//country
						rs.getInt(7),//admin role
						rs.getInt(1));//user_id
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose(); }
		return user;
	}
	
	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> userList = null;
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.REQUEST_ACCOUNTS.getQuery());
			rs = ps.executeQuery();
			// if username is found in the database, check the password of that data
			userList = new ArrayList<User>();
			while(rs.next()) {
				User user = new User(
						rs.getString(2),//username
						rs.getString(3),//password
						rs.getString(4),//email
						rs.getString(5),//fullName
						rs.getString(6),//country
						rs.getInt(7),//admin role
						rs.getInt(1));//user_id
				userList.add(user);
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose(); }
		return userList;
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
	public Coin getBasicInfoById(int coin_id) {
		Coin coin = null;
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.REQUEST_COIN_BASIC_DATA_BY_ID.getQuery());
			ps.setInt(1, coin_id);
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
	public ArrayList<HistData> getAllHistoricalData(int coin_id) {
		//TODO implement for graph
		ArrayList<HistData> data = null;
		try {
			this.connect();
			data = new ArrayList<HistData>();
			ps = conn.prepareStatement(SQL.REQUEST_COIN_ALL_HISTORICAL_DATA.getQuery());
			ps.setInt(1, coin_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				HistData info = new HistData(
						rs.getLong(2), //timestamp, 
						rs.getDouble(6), //high, 
						rs.getDouble(5), //low, 
						rs.getDouble(3), //open, 
						rs.getDouble(4), //close, 
						rs.getDouble(7), //volumeTo, 
						rs.getDouble(8)); //volumeFrom
				data.add(info);
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally { this.dispose(); }
		return data;
	}

	@Override
	public TreeMap<String, HistData> getAllCoinsLatestHistoricalData() {
		TreeMap<String, HistData> data = null;
		try {
			this.connect();
			data = new TreeMap<>();
			ps = conn.prepareStatement(SQL.REQUEST_ALL_COIN_LATEST_HISTORICAL_DATA.getQuery());
			rs = ps.executeQuery();
			while(rs.next()) {
				HistData info = new HistData(
						rs.getLong(2), //timestamp, 
						rs.getDouble(6), //high, 
						rs.getDouble(5), //low, 
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
	
	public ArrayList<HistData> getCoinLatestHistoricalData(int coinId) {
		ArrayList<HistData> data = null;
		try {
			this.connect();
			data = new ArrayList<>();
			ps = conn.prepareStatement(SQL.REQUEST_COIN_LATEST_HISTORICAL_DATA.getQuery());
			ps.setInt(1, coinId);
			rs = ps.executeQuery();
			while(rs.next()) {
				HistData temp = new HistData(
						rs.getLong(2), //timestamp, 
						rs.getDouble(6), //high, 
						rs.getDouble(5), //low, 
						rs.getDouble(3), //open, 
						rs.getDouble(4), //close, 
						rs.getDouble(7), //volumeTo, 
						rs.getDouble(8)); //volumeFrom
				data.add(temp);
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally { this.dispose(); }
		return data;
	}
	
	public Set<Integer> getUserCoinIDs(int user_id){
		Set<Integer> data = null;
		try {
			this.connect();
			data = new HashSet<>();
			ps = conn.prepareStatement(SQL.REQUEST_USER_COINS.getQuery());
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				data.add(rs.getInt(1));
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally {this.dispose();}
		return data;
	}
	
}
