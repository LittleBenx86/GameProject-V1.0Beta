package com.unicorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.unicorn.pojo.MyFavorite;
import com.unicorn.util.JdbcHelper;

public class MyFavoriteDao {
	
	/**
	 * 
	 * @param serverIp
	 * @param userServerId
	 * @param userId
	 * @return
	 */
	public Boolean addFavorite(String serverIp, String userServerId, String userId) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		
		try {
			if(null != conn) {
				String sql = "insert into myfavorites(USERID, USERSERVERID, SERVERIP)" + 
						" values(?,?,?);";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, userId);
				ps.setString(2, userServerId);
				ps.setString(3, serverIp);
				
				int i = ps.executeUpdate();
				
				if(1 == i)
					return true;
				return false;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql state: " + e.getSQLState() +
					" --> " + e.getStackTrace() + "  -->" + e.getMessage());
			return null;
		}
		return null;
	}
	
	/**
	 * 
	 * @param serverIp
	 * @param userServerId
	 * @param userId
	 * @return
	 */
	public Boolean deleteFavorite(String serverIp, String userServerId, String userId) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		
		try {
			if(null != conn) {
				String sql = "delete from myfavorites where USERID=? and USERSERVERID=? and SERVERIP=?;";
				ps = conn.prepareStatement(sql);
				ps.setString(1, userId);
				ps.setString(2, userServerId);
				ps.setString(3, serverIp);
				
				int i = ps.executeUpdate();
				
				if(1 == i)
					return true;
				return false;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql state: " + e.getSQLState() +
					" --> " + e.getStackTrace() + "  -->" + e.getMessage());
			return null;
		}
		return null;
	}
	
	/**
	 * 
	 * @param serverIp
	 * @param userServerId
	 * @param userId
	 * @return
	 */
	public Boolean isFavoriteExistes(String serverIp, String userServerId, String userId) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			if(null != conn) {
				String sql = "select m.* from myfavorites m where m.USERID=? and m.USERSERVERID=? and m.SERVERIP=?;";
				ps = conn.prepareStatement(sql);
				ps.setString(1, userId);
				ps.setString(2, userServerId);
				ps.setString(3, serverIp);
				
				rs = ps.executeQuery();
				
				if(null == rs)
					return null;
				rs.last();
				System.out.println(rs.getRow());
				if(0 < rs.getRow())
					return true;
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql state: " + e.getSQLState() +
					" --> " + e.getStackTrace() + "  -->" + e.getMessage());
			return null;
		}
		return null;
	}
	
	/**
	 * 
	 * @param userId
	 * @param userServerId
	 * @return
	 */
	public List<MyFavorite> queryMyFavoriteWithGameUser(String userId, String userServerId){
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MyFavorite> list = new ArrayList<MyFavorite>();
		try {
			if(null != conn) {
				String sql = "select m.* from myfavorites m where m.USERID=? and m.USERSERVERID=?;";
				ps = conn.prepareStatement(sql);
				ps.setString(1, userId);
				ps.setString(2, userServerId);
				
				rs = ps.executeQuery();
				
				if(null == rs)
					return null;
				rs.last();
				System.out.println(rs.getRow());
				if(0 == rs.getRow())
					return null;
				rs.beforeFirst();
				
				while(rs.next()) {
					MyFavorite m = new MyFavorite();
					m.setUserId(rs.getString(1));
					m.setUserServerId(rs.getString(2));
					m.setServerIP(rs.getString(3));
					list.add(m);
				}
				
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql state: " + e.getSQLState() +
					" --> " + e.getStackTrace() + "  -->" + e.getMessage());
			return null;
		}
		return null;
	}
}
