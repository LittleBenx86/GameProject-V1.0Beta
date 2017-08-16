package com.unicorn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unicorn.dao.GameUserDao;
import com.unicorn.pojo.GameUser;

import java.lang.String;
/**
 * Servlet implementation class GameUserRegistServlet
 */
@WebServlet("/GameUserRegistServlet")
public class GameUserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private GameUserDao guDao =  new GameUserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameUserRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置request和response的编码格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8;");
				
		String userName = request.getParameter("username");
		String userId = request.getParameter("id");
		String userPhone = request.getParameter("phone");
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("pwd");
		String serverId = request.getParameter("area");
		
		System.out.println("{" + userName + ";"+ userId + ";"+ userPhone +";" + userEmail + ";"+ serverId +"}");
		
		// 得到验证码输入框中的验证码的值
		String chkCode = request.getParameter("chkcode");
		
		// 获得session对象
		HttpSession session = request.getSession();

		// 得到session中验证码的值
		String tmpCode = (String) session.getAttribute("checkcode");

		System.out.println("老子的注册servlet被调戏了QAQ");
		
		//验证码的比较结果
		boolean flag = tmpCode.equals(new String(chkCode).toLowerCase());
		
		if(!flag){
			response.sendRedirect("/GameProject/jsp/regist.jsp?time=" + new java.util.Date().getTime());
		}
		
		//注册失败,跳转到registFailed页面
		boolean flag1 = guDao.gameUserRegist(userName, userId, userPhone, userEmail, userPassword, serverId);
		if(!flag1) {
			response.sendRedirect("/GameProject/userjsp/registFailed.jsp");
		}
		
		//注册成功,利用session代理该对象的数据
		GameUser gu = new GameUser();
		gu.setServerId(serverId);
		gu.setUserName(userName);
		gu.setUserPassword(userPassword);
		
		if(null == session.getAttribute("loginedGameUser") &&
				null == session.getAttribute("autoLogin"))//session为空时,说明时第一次登陆,将数据加入session代理
			session.setAttribute("loginedGameUser", gu);//session代理该gameuser对象
			session.setAttribute("autoLogin", "no");//注册成功默认是不自动登录
		
		//注册成功,跳转到registSuccess页面
		response.sendRedirect("/GameProject/userjsp/registSuccess.jsp");
	}
}
