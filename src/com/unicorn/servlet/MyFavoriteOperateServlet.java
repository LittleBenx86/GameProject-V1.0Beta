package com.unicorn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicorn.dao.MyFavoriteDao;
import com.unicorn.pojo.MyFavorite;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class MyFavoriteOperateServlet
 */
@WebServlet("/MyFavoriteOperateServlet")
public class MyFavoriteOperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MyFavoriteDao mfDao = new MyFavoriteDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFavoriteOperateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8;");
		
		String userId = request.getParameter("userId");
		String userServerId = request.getParameter("userServerId");
		String serverIP = request.getParameter("serverIP");
		String op = request.getParameter("op");
		Boolean flag = null;
		Boolean b = null;
		List<MyFavorite> list = null;
		JSONObject js = new JSONObject();
		
		if(null == userId && null == userServerId 
				&& null == serverIP && null == op) {
			js.put("myFavoriteOp", "null-err");
			response.getWriter().print(js);
		}
		
		switch(op) {
			case "add":
				flag = mfDao.isFavoriteExistes(serverIP, userServerId, userId);
				list = new ArrayList<MyFavorite>();
				if(null == flag || true == flag) {
					js.put("myFavoriteOp", "fail");
					response.getWriter().print(js);
					return ;
				}
				
				b = mfDao.addFavorite(serverIP, userServerId, userId);
				if(null == b || false == b) {
					js.put("myFavoriteOp", "fail");
					response.getWriter().print(js);
					return ;
				}
				
				js.put("myFavoriteOp", "success");
				response.getWriter().print(js);
				break;
			case "delete":
				flag = mfDao.isFavoriteExistes(serverIP, userServerId, userId);
				if(!flag){
					js.put("myFavoriteOp", "fail");
					response.getWriter().print(js);
					return ;
				}
				
				b = mfDao.deleteFavorite(serverIP, userServerId, userId);
				if(null == b || false == b) {
					js.put("myFavoriteOp", "fail");
					response.getWriter().print(js);
					return ;
				}
				
				js.put("myFavoriteOp", "success");
				response.getWriter().print(js);
				break;
			default:
				js.put("myFavoriteOp", "wrong-err");
				response.getWriter().print(js);
		}
		
	}
}
