package srcTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comet.beans.User;
import comet.beans.DAO.SQLDataDeletionDAO;
import comet.beans.DAO.SQLDataInsertDAO;
import comet.beans.DAO.SQLDataRequestDAO;

class SQLDataDeletionDAOTest {
	SQLDataInsertDAO sqlDataInsertDAO = new SQLDataInsertDAO();
	SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
	SQLDataDeletionDAO sqlDataDeletionDAO = new SQLDataDeletionDAO();
	User userTest;
	
	@BeforeEach
	void setUp() throws Exception {
		userTest = new User("test", "test123", "test@test.test", "test", "testCountry");
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		SQLDataDeletionDAO sqlDataDeletionDAO = new SQLDataDeletionDAO();
		sqlDataDeletionDAO.deleteAccount("test");
	}
	
	@Test
	void testDeleteAccount() {
		sqlDataInsertDAO.createAccount(userTest.getUsername(), userTest.getPassword(), userTest.getEmail(), userTest.getFullName(), userTest.getCountry());
		assertTrue(sqlDataDeletionDAO.deleteAccount("test"));
	}

	@Test
	void testRemoveUserCoin() throws SQLException {
		sqlDataInsertDAO.createAccount(userTest.getUsername(), userTest.getPassword(), userTest.getEmail(), userTest.getFullName(), userTest.getCountry());
		User user = sqlDataRequestDAO.requestUserInfo(userTest.getUsername());
		sqlDataInsertDAO.assignUserCoin(2, user.getUser_id());
		assertTrue(sqlDataDeletionDAO.removeUserCoin(2, user.getUser_id()));
	}

}
