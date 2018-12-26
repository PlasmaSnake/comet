package srcTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLNonTransientConnectionException;

import org.junit.After;
import org.junit.jupiter.api.Test;

import comet.beans.DAOI.ConnectionAbstractDAO;

class ConnectionAbstractDAOTest extends ConnectionAbstractDAO {

	@Test
	void testConnection() throws SQLNonTransientConnectionException {
		this.connect();
		assertNotNull(conn);
	}
	
	@After
	void destroyConnection() {
		this.dispose();
	}
}
