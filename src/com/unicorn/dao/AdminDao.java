package com.unicorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.unicorn.util.JdbcHelper;

public class AdminDao {
	
	/**
	 * 通过adminname查询admin是否存在
	 * @param adminName
	 * @return
	 */
	public boolean isAdminExist(String adminName) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			if(null != conn) {
				String sql = "select a.* from admin a where a.adminName=?;";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, adminName);
				
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
	 * 通过管理员的账户名查找管理员
	 * @param adminName
	 * @return
	 */
	public String getPasswordByQueryAdmin(String adminName) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			if(null != conn) {
				String sql = "select a.adminPassword from admin a where a.adminName=?; ";
		
				ps = conn.prepareStatement(sql);
				ps.setString(1, adminName);
				
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
			return null;
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
	
}
