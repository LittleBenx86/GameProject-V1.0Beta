package com.unicorn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicorn.dao.GameUserDao;

/**
 * Servlet implementation class CheckUserExistServlet
 */
@WebServlet("/CheckUserExistServlet")
public class CheckUserExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GameUserDao dao = new GameUserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserExistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8;");
    	
    	String userName = request.getParameter("username");
    	String serverId = request.getParameter("serverId");
    	
    	System.out.println(userName + ":" + serverId);
    	
    	boolean flag = dao.isGameUserExist(userName, serverId);
    	
		//应答的结果
		String js = "";
		if(!flag){
			js = "[{\"userexist\":\"false\"}]";
			System.out.println(js);
			response.getWriter().print(js);
			return ;
		}else {
			js = "[{\"userexist\":\"true\"}]";
			System.out.println(js);
			response.getWriter().print(js);
			return ;
		}
    }

}
