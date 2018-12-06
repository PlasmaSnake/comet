package comet.beans;

import java.util.Set;

public class User {
	private String username;
	private String password;
	private Set<String> savedCoins;
	
	public Set<String> getSavedCoins() {
		return savedCoins;
	}
	
	public void insertSavedCoin(String coinSymbolToSave) {
		savedCoins.add(coinSymbolToSave);
	}
	public User() {
		username = "admin";
		password = "abc123";
	}
	public User(String username, String password){
		this.password = password;
		this.username = username;
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
	
}
