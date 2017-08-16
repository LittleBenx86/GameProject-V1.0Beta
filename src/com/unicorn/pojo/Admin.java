package com.unicorn.pojo;

import java.io.Serializable;

/**
 * 游戏后台管理员对象
 * @author Unicorn
 *
 */
public class Admin implements Serializable{
	/**
	 * 实现序列化接口
	 */
	private static final long serialVersionUID = -3180042982969448486L;
	/**
	 * 游戏后台管理员对象数据成员定义
	 */
	private String adminName;//管理员名称
	private String adminPassword;//管理员密码
	private String adminPriority;//管理员的权限的优先级
	
	/**
	 * 要符合JavaBean规范,提供无参构造器
	 */
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 提供有参构造器
	 * @param adminName	管理员名称
	 * @param adminPassword	管理员密码
	 * @param adminPriority	管理员权限优先级
	 */
	public Admin(String adminName, String adminPassword, String adminPriority) {
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminPriority = adminPriority;
	}

//	要符合JavaBean规范,提供setter and getter
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminPriority() {
		return adminPriority;
	}

	public void setAdminPriority(String adminPriority) {
		this.adminPriority = adminPriority;
	}
	
	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getAdminName()+",权限级别:"+ this.getAdminPriority();
	}
	
}

/**
 * CREATE TABLE IF NOT EXISTS `admin`(
	`id` INT(10) NOT NULL auto_increment,
	`adminName` VARCHAR(25) NOT NULL,
	`adminPassword` VARCHAR(20) NOT NULL,
	`adminPriority` VARCHAR(5) NOT NULL,
	PRIMARY KEY(`id`)
	)DEFAULT CHARSET=utf8;
 * 
 */
