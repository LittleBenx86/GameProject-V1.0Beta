package com.unicorn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unicorn.dao.AdminDao;
import com.unicorn.pojo.Admin;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CheckAdminIsExistServlet
 */
@WebServlet("/CheckAdminIsExistServlet")
public class CheckAdminIsExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdminIsExistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8;");
    	
    	String adminName = request.getParameter("adminName");
    	String adminPassword = request.getParameter("adminPassword");
    	String pwd = null;
    	JSONObject js = new JSONObject();
    	
    	HttpSession session = request.getSession();
    	
    	pwd = new AdminDao().getPasswordByQueryAdmin(adminName);
    	if(null != pwd && pwd.equals(adminPassword)) {
    		
			js.put("adminIsExist" , "exist");
			
			Admin admin = new Admin();
			admin.setAdminName(adminName);
			admin.setAdminPassword(pwd);
		if(null == session.getAttribute("loginedAdmin"))
			session.setAttribute("loginedAdmin", admin);
			response.getWriter().print(js);
    	} else if(null != pwd && !pwd.equals(adminPassword)) {
    		js.put("adminIsExist" , "existButpwdErr");
    		response.getWriter().print(js);
    	} else if(null == pwd) {
    		js.put("adminIsExist" , "no-exist");
    		response.getWriter().print(js);
    	} 
	}

}
