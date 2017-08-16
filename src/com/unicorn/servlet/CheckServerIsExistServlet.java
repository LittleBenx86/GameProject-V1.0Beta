package com.unicorn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicorn.dao.GameServerListDao;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CheckServerIsExistServlet
 */
@WebServlet("/CheckServerIsExistServlet")
public class CheckServerIsExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServerIsExistServlet() {
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
		String serverId = request.getParameter("serverId");
		String serverIP = request.getParameter("serverIP");
		
		JSONObject js = new JSONObject();
		
		//servername
		if(null != serverName) {
			Boolean flag = new GameServerListDao().queryGameServerByServerName(serverName);
			//服务器不存在
			if(false == flag) {
				js.put("serverIsExist", "no-exist");
				response.getWriter().print(js);
			} else if(true == flag) {
				//服务器存在
				js.put("serverIsExist", "exist");
				response.getWriter().print(js);
			}else if(null == flag) {
				js.put("serverIsExist", "error");
				response.getWriter().print(js);
			}
		}
		
		//serverid
		if(null != serverId) {
			Boolean flag = new GameServerListDao().queryGameServerByServerId(serverId);
			//服务器不存在
			if(false == flag) {
				js.put("serverIsExist", "no-exist");
				response.getWriter().print(js);
			} else if(true == flag) {
				//服务器存在
				js.put("serverIsExist", "exist");
				response.getWriter().print(js);
			}else if(null == flag) {
				js.put("serverIsExist", "error");
				response.getWriter().print(js);
			}
		}
		
		//serverip
		if(null != serverIP) {
			Boolean flag = new GameServerListDao().queryGameServerByServerIP(serverIP);
			//服务器不存在
			if(false == flag) {
				js.put("serverIsExist", "no-exist");
				response.getWriter().print(js);
			} else if(true == flag) {
				//服务器存在
				js.put("serverIsExist", "exist");
				response.getWriter().print(js);
			}else if(null == flag) {
				js.put("serverIsExist", "error");
				response.getWriter().print(js);
			}
		}
	}

}
