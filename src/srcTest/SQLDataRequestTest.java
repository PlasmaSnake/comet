package srcTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comet.beans.DAO.SQLDataRequestDAO;
import comet.beans.User;

class SQLDataRequestTest{
	//TODO Finish testing
	SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testValidateUser() {
		
		assertTrue(sqlDataRequestDAO.validateUser("admin", "abc123"));
	}

	@Test
	void testRequestUserInfo() {
		User test = sqlDataRequestDAO.requestUserInfo("admin");
		assertNotNull(test);
	}
	
	@Test
	void testGetAllUsers() {
		ArrayList<User> userList = sqlDataRequestDAO.getAllUsers();
		assertNotNull(userList);
	}

	@Test
	void testGetAllCoinInfo() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBasicInfo() {
		assertNotNull(sqlDataRequestDAO.getBasicInfo("BTC"));
	}

	@Test
	void testGetHistoricalDataFromXToY() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllCoinsLatestHistoricalData() {
		fail("Not yet implemented");
	}
	
}
