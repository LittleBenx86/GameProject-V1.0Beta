package com.unicorn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.lang.String;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckCodeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// 设置request的字符编码格式
		request.setCharacterEncoding("utf-8");

		// 得到验证码输入框中的验证码的值
		String inpCode = request.getParameter("inp");
		
		// 获得session对象
		HttpSession session = request.getSession();

		// 得到session中验证码的值
		String tmpCode = (String) session.getAttribute("checkcode");

		System.out.println(tmpCode);
		System.out.println(new String(inpCode).toLowerCase());
		System.out.println("tm 我大check code servlet 被孙子调用了");
		
		//比较结果
		Boolean a = tmpCode.equals(new String(inpCode).toLowerCase());
		
		response.setContentType("text/json;charset=utf-8;");//设置应答response的字符编码格式
		
		//应答的结果
		String js = "";
		if(!a){
			js = "[{\"codeerr\":\"-1\"}]";
			System.out.println(js);
			response.getWriter().print(js);
		}else {
			js = "[{\"codeerr\":\"0\"}]";
			System.out.println(js);
			response.getWriter().print(js);
		}
			
	}

}
