package comet.beans;

public class Users {
	private String username;
	private String password;
	
	public Users() {
		username = "admin";
		password = "abc123";
	}
	public Users(String username, String password){
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
