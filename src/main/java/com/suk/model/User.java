package com.suk.model;

public class User {
	
	private int userId; 
    private String userName; 
    private String email; 
    private String phoneNo; 
    private String Address; 
    private String password; 
    private String role;
    
    
    
    public User() {
		// TODO Auto-generated constructor stub
	}



	public User(int userId, String userName, String email, String phoneNo, String address, String password,
			String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.phoneNo = phoneNo;
		Address = address;
		this.password = password;
		this.role = role;
	}

	public User(String userName, String email, String phoneNo, String password) {
        super();
        this.userName = userName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password; // Updated: Encrypted password field
    }

    // Parameterized constructor with only username and password
    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password; // Updated: Encrypted password field
    }

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



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



	public String getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", Address=" + Address + ", password=" + password + ", role=" + role + "]";
	}
    
    
    
    
    
    
    
    
    
    
    
}