package comet.beans.DAO;

import java.util.TreeMap;

import comet.beans.Coins;
import comet.beans.HistData;
import comet.beans.Users;
import comet.beans.DAOI.ConnectionAbstractDAO;
import comet.beans.DAOI.SQLDataRequestDAOI;

/**
 * @author Students
 * This class requests data from the AWS comet Oracle SQL database.
 */
public class SQLDataRequestDAO extends ConnectionAbstractDAO implements SQLDataRequestDAOI {

	@Override
	public boolean validateUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllCoinInfo(String coinSymbol) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Coins getBasicInfo(String coinSymbol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeMap<Integer, HistData> getHistoricalDataFromXToY(String coinSymbol, long timeFrom, long timeTo) {
		// TODO Auto-generated method stub
		return null;
	}
	//TODO implement
}
