package com.lrs.admin.entity;

/**
 * 系统用户
 * @author tyro
 *
 */
public class User {
	private String userId;
	private String username;
	private String nickName;
	private String password;
	private String picPath;
	private String status;
	
	private UserRole userRole;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public User() {
		super();
	}
	public User(String userId, String username, String nickName, String password, String picPath) {
		super();
		this.userId = userId;
		this.username = username;
		this.nickName = nickName;
		this.password = password;
		this.picPath = picPath;
	}
	
	
	public User(String userId, String username, String nickName, String password, String picPath, UserRole userRole) {
		super();
		this.userId = userId;
		this.username = username;
		this.nickName = nickName;
		this.password = password;
		this.picPath = picPath;
		this.userRole = userRole;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", nickName=" + nickName + ", password=" + password
				+ ", picPath=" + picPath + ", userRole=" + userRole + "]";
	}
	
	
}
