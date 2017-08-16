package com.unicorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.unicorn.util.JdbcHelper;

public class GameUserDao {
	
	
	public GameUserDao() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 游戏用户注册调用的dao函数
	 * @param userName
	 * @param userId
	 * @param userPhone
	 * @param userEmail
	 * @param password
	 * @param serverId
	 * @return
	 */
	public boolean gameUserRegist(String userName, String userId, String userPhone, 
			String userEmail, String password, String serverId) {
//		获取数据库的连接
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		try {
			if(null != conn) {
//				sql插入语句
				String sql = "insert into gameuser(userId, userName, userPhone, userEmail, userPassword, serverId) values(?,?,?,?,?,?);";
				
//				执行插入语句
				ps = conn.prepareStatement(sql);
				ps.setString(1, userId);
				ps.setString(2, userName);
				ps.setString(3, userPhone);
				ps.setString(4, userEmail);
				ps.setString(5, password);
				ps.setString(6, serverId);
				
				int i = ps.executeUpdate();
				
				if(1 == i)
					return true;
				return false;
				//因为如果插入不了数据会出现sqlexception,所以在catch内进行return false;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//throw new RuntimeException("insert new user:"+ userName + " failed!");
			System.out.println(e.getSQLState() + "-->" + "insert new user:"+ userName + " failed!");
			return false;
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("ps close err!");
			}
		}
	}

	/**
	 * 
	 * @param userName
	 * @param serverId
	 * @return
	 */
	public boolean isGameUserExist(String userName, String serverId) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			if(null != conn) {
				String sql = "select g.* from gameuser g where g.userName=? and g.serverId=?;";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, serverId);
				
				rs = ps.executeQuery();
				rs.last();
				System.out.println(rs.getRow());
				if(0 == rs.getRow())
					return false;
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("user exist check:" + e.getSQLState() + "-->" +
					e.getMessage());
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err");
			}
		}
		
		return false;
	}
	
	
	
	/**
	 * 通过用户名和所在的游戏大区查找用户
	 * @param userName
	 * @param serverId
	 * @return
	 */
	public String getPasswordByQueryUser(String userName, String serverId) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			if(null != conn) {
				String sql = "select g.userPassword from gameuser g where g.userName=? and g.serverId=?; ";
		
				ps = conn.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, serverId);
				
				rs = ps.executeQuery();
				rs.last();
				
				if(1 != rs.getRow())//如果一条数据都不存在,直接返回null值
					return null;
				
				rs.beforeFirst();
				rs.next();
				
				System.out.println(rs.getString(1));
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() + "-->" + e.getMessage());
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err");
			}
		}
		
		return null;
	} 
	
	/**
	 * 
	 * @param userName
	 * @param serverId
	 * @return
	 */
	public String getUserIdByQueryUser(String userName, String serverId) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			if(null != conn) {
				String sql = "select g.userId from gameuser g where g.userName=? and g.serverId=?; ";
		
				ps = conn.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, serverId);
				
				rs = ps.executeQuery();
				rs.last();
				
				if(1 != rs.getRow())//如果一条数据都不存在,直接返回null值
					return null;
				
				rs.beforeFirst();
				rs.next();
				
				System.out.println(rs.getString(1));
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() + "-->" + e.getMessage());
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err");
			}
		}
		
		return null;
	} 
	
	public static void main(String[] args) {
		GameUserDao dao = new GameUserDao();
//		System.out.println(dao.gameUserRegist("testname", "123456789123456789", "12345678912", "xxx@163.com", "123456"));
	}
}
