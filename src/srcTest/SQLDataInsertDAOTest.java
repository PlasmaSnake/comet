package srcTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comet.beans.Coin;
import comet.beans.User;
import comet.beans.DAO.SQLDataDeletionDAO;
import comet.beans.DAO.SQLDataInsertDAO;
import comet.beans.DAO.SQLDataRequestDAO;

class SQLDataInsertDAOTest {
	SQLDataInsertDAO sqlDataInsertDAO = new SQLDataInsertDAO();
	SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
	SQLDataDeletionDAO sqlDataDeletionDAO = new SQLDataDeletionDAO();
	User userTest;
	Coin coinTest;
		
	@BeforeEach
	void setUp() throws Exception {
		userTest = new User("test", "test123", "test@test.test", "test", "testCountry");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		SQLDataDeletionDAO sqlDataDeletionDAO = new SQLDataDeletionDAO();
		sqlDataDeletionDAO.deleteAccount("test");
	}
	
	// INSERT - UPDATE TEST (non JSON part)
	@Test
	void testCreateFullConstructorAccount() {
		sqlDataInsertDAO.createAccount(userTest.getUsername(), userTest.getPassword(), userTest.getEmail(), userTest.getFullName(), userTest.getCountry());
		User compareUser = sqlDataRequestDAO.requestUserInfo("test");
		assertTrue(compareUser.getUsername().equals(userTest.getUsername()));
	}

	@Test
	void testUpdateAccountPassword() {
		sqlDataInsertDAO.updateAccountPassword(userTest.getUsername(), "test1234");
		User compareUser = sqlDataRequestDAO.requestUserInfo(userTest.getUsername());
		assertTrue(compareUser.getPassword().equals("test1234"));
	}

	@Test
	void testUpdateAccountCountry() {
		sqlDataInsertDAO.updateAccountCountry("test", "United States");
		User user = sqlDataRequestDAO.requestUserInfo("test");
		assertTrue(user.getCountry().equals(("United States")));
	}

	@Test
	void testUpdateAccountFullName() {
		sqlDataInsertDAO.updateAccountFullName("test", "Test Sy");
		User user = sqlDataRequestDAO.requestUserInfo("test");
		assertTrue(user.getFullName().equals(("Test Sy")));
	}

	@Test
	void testAssignUserCoin() throws SQLException{
		User compareUser = sqlDataRequestDAO.requestUserInfo("test");
		// bitcoin test
		sqlDataInsertDAO.assignUserCoin(2, compareUser.getUser_id());
		Set<Integer> testCoinIDSet = sqlDataRequestDAO.getUserCoinIDs(compareUser.getUser_id());
		assertTrue(testCoinIDSet.contains(2));
	}

}
