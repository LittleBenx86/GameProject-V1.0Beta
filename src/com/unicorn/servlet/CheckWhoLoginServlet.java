package com.unicorn.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unicorn.dao.AdminDao;
import com.unicorn.dao.GameUserDao;
import com.unicorn.pojo.Admin;
import com.unicorn.pojo.GameUser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GameUserLoginServlet
 */
@WebServlet("/CheckWhoLoginServlet")
public class CheckWhoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GameUserDao guDao = new GameUserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckWhoLoginServlet() {
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
		String password = request.getParameter("password");
		String selectTpye = request.getParameter("select");
		String autoType = request.getParameter("autoType");
		String pwd = null;
		
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		
		if("user".equals((String)selectTpye))//用户登录,从数据库取出密码,再比较密码
			pwd = guDao.getPasswordByQueryUser(userName, serverId);
		else if("admin".equals((String)selectTpye))//admin登录,从数据库取出密码,再比较密码
			pwd = new AdminDao().getPasswordByQueryAdmin(userName);
		
		//登录失败的情况
		if(null == pwd) {//密码不存在,说明该用户不存在
			map.put("loginCallback", "not-exist");
			System.out.println(JSONObject.fromObject(map).toString());
			response.getWriter().print(JSONObject.fromObject(map));
		} else if(!pwd.equals(password)) {//或密码不正确
			map.put("loginCallback", "false");
			System.out.println(JSONObject.fromObject(map).toString());
			response.getWriter().print(JSONObject.fromObject(map));
		}
		
		//登录成功的情况
		map.put("loginCallback", "true");
		if("user".equals((String)selectTpye)) {
			map.put("who", "user");
			
			Cookie[] cookies = request.getCookies();
			if(null != cookies) for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
			}
			
			//载入数据
			Cookie cookie1 = new Cookie("loginedGameUser_userName", userName);
			cookie1.setMaxAge(60 * 60 * 2);
			cookie1.setPath("/");
			Cookie cookie2 = new Cookie("loginedGameUser_userPassword", pwd);//这里要使用加密
			cookie2.setMaxAge(60 * 60 * 2);
			cookie2.setPath("/");
			Cookie cookie3 = new Cookie("loginedGameUser_userServerId", serverId);
			cookie3.setMaxAge(60 * 60 * 2);
			cookie3.setPath("/");
			Cookie cookie4 = new Cookie("loginedGameUser_userAutoLogin", autoType);
			cookie4.setMaxAge(60 * 60 * 2);
			cookie4.setPath("/");
			
			//添加cookie
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			response.addCookie(cookie4);
			
			GameUser g = new GameUser();
			g.setServerId(serverId);
			g.setUserName(userName);
			g.setUserPassword(pwd);
			g.setUserId(new GameUserDao().getUserIdByQueryUser(userName, serverId));
			//设置session代理
			session.setAttribute("loginedGameUser", g);
			session.setAttribute("autoLogin", autoType);
		
		} else if("admin".equals((String)selectTpye)) {//管理员登录
			map.put("who", "admin");
			//管理员是没有自动登录的,不会存到cookie中
			Admin admin = new Admin();
			admin.setAdminName(userName);
			admin.setAdminPassword(pwd);
			//管理员的存在有效时间是在浏览器session失效前或loginout前
			if(null == session.getAttribute("loginedAdmin"))
				session.setAttribute("loginedAdmin", admin);
		}
		
		response.getWriter().print(JSONObject.fromObject(map));
	}
}
