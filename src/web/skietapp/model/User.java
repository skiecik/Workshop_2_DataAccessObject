package web.skietapp.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {

	 private int id;
	 private String userName;
	 private String email;
	 private String password;
	 private int userGroup;
	
	 public User(String userName, String email, String password, int userGroup) {
		this.userName = userName;
		this.email = email;
		this.setPassword(password);
		this.userGroup = userGroup;
	}

	public User() {}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public int getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(int userGroup) {
		this.userGroup = userGroup;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setReadedPassword(String password) {
		this.password = password; 
	}
}
