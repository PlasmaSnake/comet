package comet.beans;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
	private Set<String> savedCoins;
	
	public User() {
		username = "admin";
		password = "abc123";
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
	public User(String username, String password, String email, String fullName, String country, int adminRole){
		this(username, password, email, fullName, country);
		this.setAdminRole(adminRole);
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
	
	public Set<String> getSavedCoins() {
		return savedCoins;
	}
	
	public void insertSavedCoin(String coinSymbolToSave) {
		savedCoins.add(coinSymbolToSave);
	}
	
	public void removeSavedCoin(String symbolToDelete) {
		savedCoins.remove(symbolToDelete);
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
	
}
