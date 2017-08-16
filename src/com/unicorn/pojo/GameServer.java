package com.unicorn.pojo;

import java.io.Serializable;

/**
 * 游戏服务器对象
 * @author Unicorn
 *
 */
public class GameServer implements Serializable{
	/**
	 * 实现序列化接口
	 */
	private static final long serialVersionUID = -5889311657686913922L;
	/**
	 * 游戏服务器对象数据成员定义
	 */
	private String serverId;//服务器区号
	private String serverIP;//服务器IP
	private String serverName;//服务器的名称
	
	/**
	 * 要符合JavaBean规范,提供无参构造器
	 */
	public GameServer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 提供有参构造器
	 * @param serverId	服务器区号
	 * @param serverName	服务器名称
	 * @param serverIP	服务器地址
	 */
	public GameServer(String serverId, String serverName, String serverIP) {
		this.serverId = serverId;
		this.serverName = serverName;
		this.serverIP = serverIP;
	}

//	符合JavaBean规范,提供setter and getter 
	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getServerId()+"区--"+this.getServerName();
	}
}
/*
 *CREATE TABLE IF NOT EXISTS `gameServer`(
	`serverIP` VARCHAR(15) NOT NULL,
	`serverId` VARCHAR(10) NOT NULL,
	`serverName` VARCHAR(25) NOT NULL,
	PRIMARY KEY(`serverIP`)
	)DEFAULT CHARSET=utf8; 
	
	
 */


