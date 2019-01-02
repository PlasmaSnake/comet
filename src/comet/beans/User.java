package comet.beans;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import comet.beans.DAO.SQLDataRequestDAO;


public class User {
	
	@NotNull
	@Size(min=4, max=14, 
	message= "Username must be between {2} and {1} characters")
	private String username;
	
	@NotNull
	@Size(min=4, max=50, message= "Password must be longer than {2} characters")
	private String password;
	
	@Email
	private String email;
	
	private String fullName;
	private String country;
	private int adminRole;
	private int user_id;
	private Set<Integer> savedCoinIds;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public User() {
		setAdminRole(-1);
	}
	public User(String username, String password, String email){
		this.password = password;
		this.username = username;
		this.email = email;
		fullName = "";
		country = "";
	}
	
	public User(String username, String password, String email, String fullName, String country){
		this(username, password, email);
		this.fullName = fullName;
		this.country = country;
	}
	public User(String username, String password, String email, String fullName, String country, int adminRole, int user_id){
		this(username, password, email, fullName, country);
		this.setAdminRole(adminRole);
		this.user_id = user_id;
	}
	
	// Get user coin information
	public Coin getCoinFromSavedCoinID(int coin_id) {
		Coin coin = new Coin();
		SQLDataRequestDAO sqlDataRequestDAO = new SQLDataRequestDAO();
		if(savedCoinIds.contains(coin_id)) coin = sqlDataRequestDAO.getBasicInfoById(coin_id);
		return coin;
	}
	
	// VALIDATED CHANGES
	public boolean changePassword(String oldPassword, String newPassword) {
		if (validatePassword(oldPassword)) {
			this.password = newPassword;
			return true;
		}
		return false;
	}
	
	public boolean changeCountry(String oldPassword, String newCountry) {
		if (validatePassword(oldPassword)) {
			this.country = newCountry;
			return true;
		}
		return false;
	}
	
	public boolean changeName(String oldPassword, String newName) {
		if (validatePassword(oldPassword)) {
			this.country = newName;
			return true;
		}
		return false;
	}
	
	public boolean validatePassword(String password) {
		return (this.password.equals(password));
	}
	
	// GETTERS AND SETTERS
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public Set<Integer> getSavedCoins() {
		return savedCoinIds;
	}
	
	public void setSavedCoins(Set<Integer> coinIds) {
		savedCoinIds = coinIds;
	}
	
	public void insertSavedCoin(int coinIdToSave) {
		savedCoinIds.add(coinIdToSave);
	}
	
	public void removeSavedCoin(int coinIdToDelete) {
		savedCoinIds.remove(coinIdToDelete);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(int adminRole) {
		this.adminRole = adminRole;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) { return true;}
		
		if (!(obj instanceof User)) return false;
		
		User user = (User) obj;
		return this.username.equals(user.username) && 
				this.password.equals(user.password) && 
				this.email.equals(user.email) && 
				this.fullName.equals(user.fullName) && 
				this.country.equals(user.country) &&
				this.savedCoinIds == user.savedCoinIds && 
				this.adminRole == user.adminRole;
	}
	
}
