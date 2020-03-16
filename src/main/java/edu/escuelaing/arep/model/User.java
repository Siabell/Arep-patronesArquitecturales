package edu.escuelaing.arep.model;

public class User {

	private long userId;
    private String name;
    private String email;
    private String userName;
    
	public User(long userId, String name, String email, String userName) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.userName = userName;
	}

	public User() {}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

    
}
