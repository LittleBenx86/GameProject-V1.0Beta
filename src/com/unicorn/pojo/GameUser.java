package com.unicorn.pojo;

import java.io.Serializable;

/**
 * 游戏用户对象
 * @author Unicorn
 *
 */
public class GameUser implements Serializable{
	/**
	 * 实现序列化接口
	 */
	private static final long serialVersionUID = -8223149528418632499L;
	/**
	 * 游戏用户的数据成员定义
	 */
	private String userName;//用户名
	private String userId;//用户的身份证
	private String userPhone;//用户的手机号码
	private String userEmail;//用户的邮箱
	private String userPassword;//用户的密码
	private String serverId;//用户所在服务器的区号
	/**
	 * 要符合JavaBean规范,提供无参构造器
	 */
	public GameUser() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 提供有参构造器
	 * @param userName 用户名
	 * @param userId	身份证号
	 * @param userPhone	手机号码
	 * @param userEmail	邮箱地址
	 * @param userPassword	密码
	 */
	public GameUser(String userName, String userId, String userPhone, String userEmail, String userPassword,String serverId ) {
		this.userName = userName;
		this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.serverId = serverId;
	}


//	符合JavaBean规范,提供setter and getter 
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	/**
	 * 重写tostring方法
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{ userName:"+this.getUserName() + ", userId:" + this.getUserId() + ", userPhone:" + 
				this.getUserPhone() + ", userEmail:" + this.getUserEmail() + "}" ;
	}
}

/**
 * CREATE TABLE IF NOT EXISTS `gameUser`(
	`id` INT(10) NOT NULL auto_increment, 
	`userId` VARCHAR(20) NOT NULL,
	`userName` VARCHAR(25) NOT NULL,
	`userPhone` VARCHAR(15) NOT NULL,
	`userEmail` VARCHAR(40) NOT NULL,
	`userPassword` VARCHAR(30) NOT NULL,
	`serverId` VARCHAR(10) NOT NULL,
	PRIMARY KEY(`id`)
	)DEFAULT CHARSET=utf8;
 */
