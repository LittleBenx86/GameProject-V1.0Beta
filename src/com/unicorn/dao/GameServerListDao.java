package com.unicorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.unicorn.pojo.GameCompleteServer;
import com.unicorn.util.JdbcHelper;


public class GameServerListDao {
	
	public GameServerListDao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 后台的服务器运行页面(server.jsp)
	 * 可见参数:
	 * 	服务器名称
	 *  服务器ip地址
	 *  服务器id编号
	 *  服务器开机时间
	 *  服务器关机机时间
	 *  服务器线路类型
	 *  服务器运行的游戏的简介
	 *  游戏客服的QQ
	 *  游戏主页的网址
	 *  服务器运行状态:0,关机;1,正常运行;2,服务器维护中;
	 * @return 所有的服务器
	 */
	public List<GameCompleteServer> findGameServers(){
		List<GameCompleteServer> list = new ArrayList<GameCompleteServer>();
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			if(null != conn) {
				String sql = "select g.* from gameserverlist g;";
				
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				rs.last();
				int i = rs.getRow();
				rs.beforeFirst();
				if(0 == i)
					return null;
				
				while(rs.next()!=false) {
					String serverName = rs.getString(2);
					String serverIP = rs.getString(3);
					String serverId = rs.getString(4);
					String openTime = rs.getString(5);
					String threadType = rs.getString(7);
					String brief = rs.getString(8);
					String qq = rs.getString(9);
					String mainWeb = rs.getString(10);
					String serverState = rs.getString(11);
					
					GameCompleteServer gc = new GameCompleteServer(serverId, serverIP, serverName, openTime, 
							threadType, brief, qq, mainWeb, serverState); 
					list.add(gc);
				}
				
				return list;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getStackTrace() + ":" + e.getSQLState() + "-->/n" + e.getMessage());
			return null;
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err!");
			}
		}
	}
	
	/**
	 * 前端的服务器观看页面(list.jsp)
	 * 可见参数:
	 * 	服务器名称
	 *  服务器ip地址
	 *  服务器id编号
	 *  服务器开机时间
	 *  服务器关机机时间
	 *  服务器线路类型
	 *  服务器运行的游戏的简介
	 *  游戏客服的QQ
	 *  游戏主页的网址
	 * @return 所有正在运行的服务器
	 */
	public List<GameCompleteServer> findGameServersRunning(){
		List<GameCompleteServer> list = new ArrayList<GameCompleteServer>();
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			if(null != conn) {
				String sql = "select g.* from gameserverlist g where g.serverState='1';";
				
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				rs.last();
				int i = rs.getRow();
				rs.beforeFirst();
				if(0 == i)
					return null;
				
				while(rs.next()!=false) {
					String serverName = rs.getString(2);
					String serverIP = rs.getString(3);
					String serverId = rs.getString(4);
					String openTime = rs.getString(5);
					String threadType = rs.getString(7);
					String brief = rs.getString(8);
					String qq = rs.getString(9);
					String mainWeb = rs.getString(10);
					String serverState = rs.getString(11);
					
					GameCompleteServer gc = new GameCompleteServer(serverId, serverIP, serverName, openTime, 
							threadType, brief, qq, mainWeb, serverState); 
					list.add(gc);
				}
				
				return list;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getStackTrace() + ":" + e.getSQLState() + "-->/n" + e.getMessage());
			return null;
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err!");
			}
		}
	}
	
	/**
	 * 添加新的游戏服务器
	 * @param serverId
	 * @param serverIP
	 * @param serverName
	 * @param openTime
	 * @param threadType
	 * @param brief
	 * @param qQ
	 * @param mainWeb
	 * @param serverState
	 * @return 返回插入结果,1:成功插入;其他:插入失败
	 */
	public boolean addGameServer(String serverId, String serverIP, String serverName, String openTime,
			String threadType, String brief, String qQ, String mainWeb, String serverState) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		
		try {
			if(null != conn) {
				String sql = "insert into gameserverlist(serverName,serverIP,serverId,openTime,threadType,brief,qq,mainWeb,serverState) values(?,?,?,?,?,?,?,?,?);";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, serverName);
				ps.setString(2, serverIP);
				ps.setString(3, serverId);
				ps.setString(4, openTime);
				ps.setString(5, threadType);
				ps.setString(6, brief);
				ps.setString(7, qQ);
				ps.setString(8, mainWeb);
				ps.setString(9, serverState);
				int i = ps.executeUpdate();
				
				if(1 == i)
					return true;
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getStackTrace() + ":" + e.getSQLState() + "-->/n" + e.getMessage());
			return false;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err!");
			}
		}
		return false;
	}
	
	/**
	 * 更新服务器的信息,只有服务器的IP地址和id是只读的不可修改
	 * 这里一旦修改了服务器的名称那么对应的另外两张表gameserver和gameuser都要修改,
	 * 由于这里由于时间的关系先不做联动,应该在数据库进行关联,以减少代码的逻辑操作
	 * @param serverId
	 * @param serverIP
	 * @param serverName
	 * @param openTime
	 * @param threadType
	 * @param brief
	 * @param qQ
	 * @param mainWeb
	 * @param serverState
	 * @return	返回修改的结果
	 */
	public Boolean updateGameServer(String serverId, String serverIP, String serverName, String openTime,
			String threadType, String brief, String qQ, String mainWeb, String serverState) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		
		try {
			if(null != conn) {
				String sql = "update gameserverlist g set g.openTime=?,g.threadType=?,g.brief=?,g.qq=?,g.mainWeb=?,g.serverState=? where g.serverIP=? and g.serverId=? and g.serverName=?;";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, openTime);
				ps.setString(2, threadType);
				ps.setString(3, brief);
				ps.setString(4, qQ);
				ps.setString(5, mainWeb);
				ps.setString(6, serverState);
				ps.setString(7, serverIP);
				ps.setString(8, serverId);
				ps.setString(9, serverName);
				
				int i = ps.executeUpdate();
				
				if(1 == i)
					return true;
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getStackTrace() + ":" + e.getSQLState() + "-->/n" + e.getMessage());
			return null;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err!");
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param serverId
	 * @param serverIP
	 * @param serverName
	 * @param openTime
	 * @param threadType
	 * @param brief
	 * @param qQ
	 * @param mainWeb
	 * @param serverState
	 * @param closeTime
	 * @return
	 */
	public Boolean updateGameServerWithCloseTime(String serverId, String serverIP, String serverName, String openTime,
			String threadType, String brief, String qQ, String mainWeb, String serverState, String closeTime) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		
		try {
			if(null != conn) {
				String sql = "update gameserverlist g set g.openTime=?,g.threadType=?,g.brief=?,g.qq=?,g.mainWeb=?,g.serverState=?,g.closeTime=? where g.serverIP=? and g.serverId=? and g.serverName=?;";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, openTime);
				ps.setString(2, threadType);
				ps.setString(3, brief);
				ps.setString(4, qQ);
				ps.setString(5, mainWeb);
				ps.setString(6, serverState);
				ps.setString(7, closeTime);
				ps.setString(8, serverIP);
				ps.setString(9, serverId);
				ps.setString(10, serverName);
				
				int i = ps.executeUpdate();
				
				if(1 == i)
					return true;
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getStackTrace() + ":" + e.getSQLState() + "-->/n" + e.getMessage());
			return null;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err!");
			}
		}
		return null;
	}
	
	/**
	 * 通过servername查找服务器
	 * @param serverName
	 * @return
	 */
	public Boolean queryGameServerByServerName(String serverName) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			if(null != conn) {
				String sql = "select g.* from gameserverlist g where g.serverName = ?;";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, serverName);
				rs = ps.executeQuery();
				rs.last();
				
				if(rs.getRow() >= 1)
					return true;
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getStackTrace() + ":" + e.getSQLState() + "-->/n" + e.getMessage());
			return null;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err!");
			}
		}
		return null;
	}
	
	/**
	 * 通过serverid查找服务器
	 * @param serverId
	 * @return
	 */
	public Boolean queryGameServerByServerId(String serverId) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			if(null != conn) {
				String sql = "select g.* from gameserverlist g where g.serverId = ?;";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, serverId);
				rs = ps.executeQuery();
				rs.last();
				
				if(rs.getRow() >= 1)
					return true;
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getStackTrace() + ":" + e.getSQLState() + "-->/n" + e.getMessage());
			return null;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err!");
			}
		}
		return null;
	}
	
	/**
	 * 通过serverip查找服务器
	 * @param serverIP
	 * @return
	 */
	public Boolean queryGameServerByServerIP(String serverIP) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if(null != conn) {
				String sql = "select g.* from gameserverlist g where g.serverIP = ?;";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, serverIP);
				rs = ps.executeQuery();
				rs.last();
				
				if(rs.getRow() >= 1)
					return true;
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getStackTrace() + ":" + e.getSQLState() + "-->/n" + e.getMessage());
			return null;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err!");
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param serverIP
	 * @param serverName
	 * @param serverId
	 * @return
	 */
	public GameCompleteServer queryOneGameServer(String serverIP, String serverName, String serverId) {
		Connection conn = JdbcHelper.getJdbcHelper().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if(null != conn) {
				String sql = "select g.* from gameserverlist g where g.serverIP = ? and g.serverName = ? and g.serverId = ?;";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, serverIP);
				ps.setString(2, serverName);
				ps.setString(3, serverId);
				rs = ps.executeQuery();
				rs.last();
				
				if(rs.getRow() >= 1) {
					rs.beforeFirst();
					rs.next();
					
					GameCompleteServer server = new GameCompleteServer();
					server.setBrief(rs.getString(8));
					server.setMainWeb(rs.getString(10));
					server.setQQ(rs.getString(9));
					server.setThreadType(rs.getString(7));
					server.setOpenTime(rs.getString(5));
					server.setCloseTime(rs.getString(6));
					server.setServerState(rs.getString(11));
					
					return server;
				}
				return null;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getStackTrace() + ":" + e.getSQLState() + "-->/n" + e.getMessage());
			return null;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("jdbc close err!");
			}
		}
		return null;
	}
}
