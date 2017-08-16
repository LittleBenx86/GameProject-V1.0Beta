package com.unicorn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcHelper {
	
	/**
	 * 单例设计模式:饿汉模式
	 * 为了数据库连接的可重用性,保持响应的快速性,最后再关闭数据库连接
	 */
	private static final JdbcHelper jh = new JdbcHelper();
	
	//构造方法不可访问
	private JdbcHelper() {
		// TODO Auto-generated constructor stub
	}
	
	public static JdbcHelper getJdbcHelper() {
		return jh;
	}
	
	public Connection getConnection(){
		
		Connection  conn = null;
		
		try {
			//通过反射的机制加载数据库的驱动,避免普通的加载方式对于驱动的二次加载
			Class.forName(PropertiesUtils.getValue("DriverClassName"));
			//通过读取配置文件读取相应的数据,进行数据库链接
			conn = DriverManager.getConnection(PropertiesUtils.getValue("url"),
					PropertiesUtils.getValue("username"),
					PropertiesUtils.getValue("password"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("jdbc properties class not found!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("jdbc connection err!");
		}
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		System.out.println(conn);
	}
}

/**
 * 数据库的employee表的创建方式:
 * 	     通过NAVIcat for MySQL的查询来建表
 * 		CREATE TABLE `employee`(
		`id` INT(10) NOT NULL auto_increment,
		`ename` VARCHAR(50) NOT NULL,
		`ephone` VARCHAR(11) NOT NULL,
		`eaddr` VARCHAR(50) NOT NULL,
		`esex` enum('男','女') NOT NULL DEFAULT '女',
		`hdate` DATE,
		`emonth_salary` INT,
		`partment` VARCHAR(50),
		PRIMARY KEY (`id`))DEFAULT CHARSET=utf8;
 */
