package com.unicorn.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicorn.dao.GameServerListDao;
import com.unicorn.pojo.Admin;
import com.unicorn.pojo.GameCompleteServer;
import com.unicorn.pojo.GameUser;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(urlPatterns= {"/adminjsp/*", "/userjsp/login.jsp/*"})
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest hsRequest = (HttpServletRequest) request;
		HttpServletResponse hsResponse=(HttpServletResponse)response;
		
		//用于获取当前页面的路径
		String servletPath = hsRequest.getServletPath();
		//获取session储存的admin信息
		Admin admin = (Admin)hsRequest.getSession().getAttribute("loginedAdmin");
		List<GameCompleteServer> list = new GameServerListDao().findGameServers();
		
		if("/adminjsp/server.jsp".equals(servletPath)) {
			if(null != admin) {
				if(null != list && list.size() > 0 
						&& null == hsRequest.getSession().getAttribute("gameServerList"))
					hsRequest.getSession().setAttribute("gameServerList", list);
				System.out.println(list.size());
			}
		} else if("/userjsp/login.jsp".equals(servletPath)) {
			if(null != list && list.size() > 0 
					&& null == hsRequest.getSession().getAttribute("gameServerList")) {
				hsRequest.getSession().setAttribute("gameServerList", list);
				System.out.println(list.size());
			}
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
