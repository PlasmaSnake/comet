package srcTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import comet.beans.User;
import comet.beans.DAO.SQLDataInsertDAO;
import comet.beans.DAO.SQLDataRequestDAO;

class SQLDataInsertDAOTest {
	SQLDataInsertDAO sqlDataInsertDAO = new SQLDataInsertDAO();
	SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
	@Test
	void testCreateFullConstructorAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateAccountPassword() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateAccountCountry() {
		sqlDataInsertDAO.updateAccountCountry("admin", "United States");
		User user = sqlDataRequestDAO.requestUserInfo("admin");
		assertTrue(user.getCountry().equals(("United States")));
	}

	@Test
	void testUpdateAccountFullName() {
		fail("Not yet implemented");
	}

	@Test
	void testAssignUserCoin() {
		fail("Not yet implemented");
	}

}
