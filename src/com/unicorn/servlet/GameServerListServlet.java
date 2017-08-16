package com.unicorn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unicorn.dao.GameServerListDao;
import com.unicorn.pojo.GameCompleteServer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GameServerListServlet
 */
@WebServlet("/GameServerListServlet")
public class GameServerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GameServerListDao gslDao = new GameServerListDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * 获取游戏服务器的运行列表
     */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8;");
		
		//在server.jsp onload的时候异步请求此页面获取服务器列表
		HttpSession session = request.getSession();
		//从数据库获取服务器列表
		List<GameCompleteServer> list = gslDao.findGameServers();
		JSONObject js = new JSONObject();
		
		if(null != list && null == session.getAttribute("gameServerList")) {
			session.setAttribute("gameServerList", list);//把数据存储到session中
			js.put("getList", "success");
			response.getWriter().print(js);
		} else if(null != list && null != session.getAttribute("gameServerList")) {
			js.put("getList", "success");
			response.getWriter().print(js);
		} else {
			js.put("getList", "fail");
			response.getWriter().print(js);
		}
	}
}
