package comet.beans;

import javax.validation.constraints.Size;

/**
 * @author Mike
 * Class is to be used for User bean for password validation, change, and restriction.
 */
public class Password {
	
	@Size(min=4, max=50, message= "Password must be longer than {2} characters")
	private String password;
	
	@Size(min=4, max=50, message= "New Password must be longer than {2} characters")
	private String newPassword;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
