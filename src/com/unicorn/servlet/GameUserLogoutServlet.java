package com.unicorn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AdminLogoutServlet
 */
@WebServlet("/GameUserLogoutServlet")
public class GameUserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameUserLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8;");
    	
    	String gameUserLogout = request.getParameter("gameUserLogout");
    	JSONObject js = new JSONObject();
    	
    	if(null != gameUserLogout && "gameUserLogout".equals(gameUserLogout)) {
    		if(null != request.getSession().getAttribute("loginedGameUser"))
    			request.getSession().removeAttribute("loginedGameUser");
    		
    		js.put("logout", "success");
    		response.getWriter().print(js);
    	} else {
    		js.put("logout", "fail");
    		response.getWriter().print(js);
    	}
    	
	}

}
