package comet.beans.DAOI;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

public abstract class ConnectionAbstractDAO {
	private final String url = "jdbc:oracle:thin:@cometdb.cbbqesq1alra.us-east-2.rds.amazonaws.com:1521:cometdb"; // enter
																													// your
																													// own
																													// credentials
	private final String username = "PlasmaSnake";
	private final String password = "P4ssw0rd";
	private final Driver driver = new oracle.jdbc.driver.OracleDriver(); // ensure you have odjbc6 or similar as a
																			// referenced lib

	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	public void connect() throws SQLNonTransientConnectionException {
		try {
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new SQLNonTransientConnectionException(e.getMessage(), url + username + password);
		}
	}

	public void dispose() {
		try {
			if (!rs.equals(null))
				if (!rs.isClosed())
					rs.close();
			if (!ps.equals(null))
				if (!ps.isClosed())
					ps.close();
			if (!conn.equals(null))
				if (!conn.isClosed())
					conn.close();
		} catch (SQLException e) {
		} catch (NullPointerException e) {}
	}
}
