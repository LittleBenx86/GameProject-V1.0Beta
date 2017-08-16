package com.unicorn.pojo;

import java.io.Serializable;

public class MyFavorite implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -870051869542543196L;
	
	private String userId;
	private String userServerId;
	private String serverIP;
	
	public MyFavorite() {
		// TODO Auto-generated constructor stub
	}
	
	public MyFavorite(String userId, String userServerId, String serverIP) {
		this.userId = userId;
		this.userServerId = userServerId;
		this.serverIP = serverIP;
	}



	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserServerId() {
		return userServerId;
	}
	public void setUserServerId(String userServerId) {
		this.userServerId = userServerId;
	}
	public String getServerIP() {
		return serverIP;
	}
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getUserId()+"-->"+this.getUserServerId()+"<-->"+this.getServerIP();
	}
	
}
