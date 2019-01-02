package srcTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comet.beans.DAO.SQLDataRequestDAO;
import comet.beans.Coin;
import comet.beans.User;

class SQLDataRequestTest{
	SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
	private User userTest;
	private Coin coinTest;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		userTest = sqlDataRequestDAO.requestUserInfo("admin");
		coinTest = sqlDataRequestDAO.getBasicInfo("BTC");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testValidateUser() {
		
		assertTrue(sqlDataRequestDAO.validateUser("admin", "abc1234"));
	}

	@Test
	void testRequestUserInfo() {
		assertNotNull(userTest);
	}
	
	
	@Test
	void testGetAllUsers() {
		ArrayList<User> userList = sqlDataRequestDAO.getAllUsers();
		assertNotNull(userList);
	}

	@Test
	void testGetBasicInfo() {
		assertNotNull(coinTest);
	}

	@Test
	void testGetBasicInfoById() {
		assertNotNull(sqlDataRequestDAO.getBasicInfoById(coinTest.getCoin_id()));
	}
	
	@Test
	void testGetAllHistoricalData() {
		assertNotNull(sqlDataRequestDAO.getAllHistoricalData(coinTest.getCoin_id()));
	}

	@Test
	void testGetAllCoinsLatestHistoricalData() {
		assertNotNull(sqlDataRequestDAO.getAllCoinsLatestHistoricalData());
	}
	@Test
	void testGetCoinLatestHistoricalData() {
		assertNotNull(sqlDataRequestDAO.getCoinLatestHistoricalData(coinTest.getCoin_id()));
	}
	
	@Test
	void testGetUserCoinIDs() {
		assertNotNull(sqlDataRequestDAO.getUserCoinIDs(userTest.getUser_id()));
	}
}
