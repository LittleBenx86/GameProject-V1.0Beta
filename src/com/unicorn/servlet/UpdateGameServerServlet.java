package com.unicorn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicorn.dao.GameServerListDao;
import com.unicorn.pojo.GameCompleteServer;
import com.unicorn.util.DateTimeFormateUtils;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdateGameServerServlet
 */
@WebServlet("/UpdateGameServerServlet")
public class UpdateGameServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGameServerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8;");
		
		String serverName = request.getParameter("serverName");
		String serverIP = request.getParameter("serverIP");
		String serverId = request.getParameter("serverId");
		String threadType = request.getParameter("threadType");
		String brief = request.getParameter("brief");
		String qq = request.getParameter("QQ");
		String mainWeb = request.getParameter("mainWeb");
		String serverState = request.getParameter("serverState");
		String openTime = null;
		String closeTime = null;
		String originServerState = null;
		GameCompleteServer gcs = null;

		Boolean flag = null;
		
		if(null != serverName && null != serverIP && null != serverId)
			gcs = new GameServerListDao().queryOneGameServer(serverIP, serverName, serverId);
		
		if("" == threadType || null == threadType)
			threadType = gcs.getThreadType();
		
		if("" == brief || null == brief)
			brief = gcs.getBrief();
		
		if("" == qq || null == brief)
			qq = gcs.getQQ();
		
		if("" == mainWeb || null == mainWeb)
			mainWeb = gcs.getMainWeb();
		
		if(serverState.equals("-1") || serverState.equals(""))
			originServerState = gcs.getServerState();
		
		switch(serverState) {
			//停用
			case "0":
				closeTime = DateTimeFormateUtils.getDatetimeformatutils().
						formateOperation(new java.util.Date(), "yyyy.MM.dd HH:mm:ss");
				flag = new GameServerListDao().updateGameServerWithCloseTime(serverId, serverIP, serverName, 
						openTime, threadType, brief, qq, mainWeb, serverState, closeTime);
				break;
			//启用
			case "1":
				openTime = DateTimeFormateUtils.getDatetimeformatutils().
						formateOperation(new java.util.Date(), "yyyy.MM.dd HH:mm:ss");
				flag = new GameServerListDao().updateGameServer(serverId, serverIP, serverName, 
						openTime, threadType, brief, qq, mainWeb, serverState);
				break;
			//维护
			case "2":
				openTime = gcs.getOpenTime();
				closeTime = DateTimeFormateUtils.getDatetimeformatutils().
						formateOperation(new java.util.Date(), "yyyy.MM.dd HH:mm:ss");
				flag = new GameServerListDao().updateGameServerWithCloseTime(serverId, serverIP, serverName, 
						openTime, threadType, brief, qq, mainWeb, serverState, closeTime);
				break;
			//重启
			case "3":
				openTime = DateTimeFormateUtils.getDatetimeformatutils().
						formateOperation(new java.util.Date(), "yyyy.MM.dd HH:mm:ss");
				flag = new GameServerListDao().updateGameServer(serverId, serverIP, serverName, 
						openTime, threadType, brief, qq, mainWeb, "1");
				break;
			default:
				if(null == gcs.getCloseTime() || gcs.getCloseTime().equals(""))
					closeTime = "";
				else 
					closeTime = gcs.getCloseTime();
				flag = new GameServerListDao().updateGameServerWithCloseTime(serverId, serverIP, serverName, 
						gcs.getOpenTime(), threadType, brief, qq, mainWeb, originServerState, closeTime);
				break;
		}
		
		JSONObject js = new JSONObject();
		
		if(null != flag && true == flag) {
			js.put("updateServer", "success");
			
			//重新代理session中的服务器列表数据
			List<GameCompleteServer> list = new GameServerListDao().findGameServers();
			if(null != list) {
				 request.getSession().setAttribute("gameServerList", list);
			}
		
			response.getWriter().print(js);
		} else if(null != flag && false == flag) {
			js.put("updateServer", "fail");
			response.getWriter().print(js);
		} else if(null == flag) {
			js.put("updateServer", "error");
			response.getWriter().print(js);
		}
	}

}
