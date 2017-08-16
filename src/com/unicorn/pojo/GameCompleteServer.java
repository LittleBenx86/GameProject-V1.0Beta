package com.unicorn.pojo;

public class GameCompleteServer extends GameServer{

	/**
	 * 实现序列化接口
	 */
	private static final long serialVersionUID = 7679324245641144119L;
	
	/**
	 * 游戏服务器对象数据成员定义
	 */
	private String serverId;//服务器区号
	private String serverIP;//服务器IP
	private String serverName;//服务器的名称
	private String openTime;//服务器的开启时间
	private String closeTime;//服务器的关闭时间
	private String threadType;//服务器的线路类型
	private String brief;//游戏简介
	private String QQ;//客服QQ
	private String mainWeb;//游戏主页
	private String serverState;//服务器的运行状态
	
	/**
	 * 提供无参构造器
	 */
	public GameCompleteServer() {
		// TODO Auto-generated constructor stub
	}
	
	public GameCompleteServer(String serverId, String serverIP, String serverName, String openTime,
			String threadType, String brief, String qQ, String mainWeb) {
		this.serverId = serverId;
		this.serverIP = serverIP;
		this.serverName = serverName;
		this.openTime = openTime;
		this.threadType = threadType;
		this.brief = brief;
		this.QQ = qQ;
		this.mainWeb = mainWeb;
	}

	public GameCompleteServer(String serverId, String serverIP, String serverName, String openTime,
			String threadType, String brief, String qQ, String mainWeb, String serverState) {
		this.serverId = serverId;
		this.serverIP = serverIP;
		this.serverName = serverName;
		this.openTime = openTime;
		this.threadType = threadType;
		this.brief = brief;
		this.QQ = qQ;
		this.mainWeb = mainWeb;
		this.serverState = serverState;
	}
	
	public GameCompleteServer(String serverId, String serverIP, String serverName, String openTime, String closeTime,
			String threadType, String brief, String qQ, String mainWeb, String serverState) {
		this.serverId = serverId;
		this.serverIP = serverIP;
		this.serverName = serverName;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.threadType = threadType;
		this.brief = brief;
		this.QQ = qQ;
		this.mainWeb = mainWeb;
		this.serverState = serverState;
	}

	//提供setter and getter
	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getThreadType() {
		return threadType;
	}

	public void setThreadType(String threadType) {
		this.threadType = threadType;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		this.QQ = qQ;
	}

	public String getMainWeb() {
		return mainWeb;
	}

	public void setMainWeb(String mainWeb) {
		this.mainWeb = mainWeb;
	}

	public String getServerState() {
		return serverState;
	}

	public void setServerState(String serverState) {
		this.serverState = serverState;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
/*
	CREATE TABLE IF NOT EXISTS `gamserverlist`(
	`id` INT(10) NOT NULL auto_increment,
	`serverName` VARCHAR(25) NOT NULL,
	`serverIP` VARCHAR(15) NOT NULL,
	`serverId` VARCHAR(10) NOT NULL,
	`openTime` VARCHAR(25) NOT NULL,
	`closeTime` VARCHAR(25) NOT NULL,
	`threadType` VARCHAR(10) NOT NULL,
	`brief` VARCHAR(100) NOT NULL,
	`qq` varchar(15) NOT NULL,
	`mainWeb` VARCHAR(100) NOT NULL,
	`serverState` enum('0','1','2') NOT NULL DEFAULT '1',
	PRIMARY KEY(`id`)
	)DEFAULT CHARSET=utf8;
*/
