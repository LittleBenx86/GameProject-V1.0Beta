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
@WebServlet("/AdminLogoutServlet")
public class AdminLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8;");
    	
    	String adminLogout = request.getParameter("adminLogout");
    	JSONObject js = new JSONObject();
    	
    	if(null != adminLogout && "adminLogout".equals(adminLogout)) {
    		if(null != request.getSession().getAttribute("loginedAdmin"))
    			request.getSession().removeAttribute("loginedAdmin");
    		
    		js.put("logout", "success");
    		response.getWriter().print(js);
    	} else {
    		js.put("logout", "fail");
    		response.getWriter().print(js);
    	}
    	
	}

}
