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
 * Servlet implementation class AddGameServerServlet
 */
@WebServlet("/AddGameServerServlet")
public class AddGameServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GameServerListDao gslDao = new GameServerListDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameServerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * 用于添加游戏服务器的后台服务
     */
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
		String qq = request.getParameter("qq");
		String mainWeb = request.getParameter("mainWeb");
		String serverState = request.getParameter("serverState");
		String openTime = DateTimeFormateUtils.getDatetimeformatutils().
				formateOperation(new java.util.Date(), "yyyy.MM.dd HH:mm:ss");//格式化时间
		
		boolean flag = gslDao.addGameServer(serverId, serverIP, serverName, openTime, 
				threadType, brief, qq, mainWeb, serverState);
		
		JSONObject js = new JSONObject();
		
		if(true == flag) {
			js.put("addServer", "success");
			
			List<GameCompleteServer> list = new GameServerListDao().findGameServers();
			if(null != list) {
				 request.getSession().setAttribute("gameServerList", list);
			}
			
			response.getWriter().print(js);
			return ;
		}
		js.put("addServer", "fail");
		response.getWriter().print(js);
		return ;
	}

}
