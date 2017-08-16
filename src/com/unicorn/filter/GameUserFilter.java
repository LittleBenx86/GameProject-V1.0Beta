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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicorn.dao.GameServerListDao;
import com.unicorn.dao.GameUserDao;
import com.unicorn.dao.MyFavoriteDao;
import com.unicorn.pojo.Admin;
import com.unicorn.pojo.GameCompleteServer;
import com.unicorn.pojo.GameUser;
import com.unicorn.pojo.MyFavorite;

import net.sf.json.JSONObject;

/**
 * Servlet Filter implementation class GameUserFilter
 */
@WebFilter(urlPatterns= {"/userjsp/*"})
public class GameUserFilter implements Filter {
	
	private GameServerListDao gslDao = new GameServerListDao();
	
	private List<GameCompleteServer> list = null;
	private List<MyFavorite> list2 = null;
	private List<GameCompleteServer> list3 = null;
	
    /**
     * Default constructor. 
     */
    public GameUserFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest hsRequest = (HttpServletRequest) request;
		HttpServletResponse hsResponse=(HttpServletResponse)response;
		//用于获取当前页面的路径
		String servletPath = hsRequest.getServletPath();
		//获取session储存的用户信息
		GameUser gu = (GameUser)hsRequest.getSession().getAttribute("loginedGameUser");
//		String auto = (String)hsRequest.getSession().getAttribute("autoLogin");
		Cookie[] cookies = hsRequest.getCookies();//确保cookie里面存储的password是正确的
		
		String userName = null;
		String serverId = null;
		String userPassword = null;
		String autoLogin = null;
		String pwd = null;
		
		//fliter的过滤处理
		if("/userjsp/list.jsp".equals(servletPath)) {
			//正在运行的游戏服务器列表
			list3 = new GameServerListDao().findGameServersRunning();
			if(null != list3 && list3.size() > 0) {
				System.out.println("list web server in running list size:" + list3.size());
			}
			hsRequest.getSession().setAttribute("gameServerList_u", list3);
			
			//收藏列表
			if(null != gu)
				list2 = new MyFavoriteDao().queryMyFavoriteWithGameUser(new GameUserDao().
					getUserIdByQueryUser(gu.getUserName(), gu.getServerId()), gu.getServerId());
			if(null != list2 && list2.size() > 0) {
				System.out.println("myFavorites list size:" + list2.size());
			}
			hsRequest.getSession().setAttribute("myFavorites", list2);
		}else if("/userjsp/login.jsp".equals(servletPath)) {
			//获取所有的游戏服务器列表,先存储在session中,在最后页面显示时能够读取session的数据
			list = gslDao.findGameServersRunning();
			if(null != list && list.size() > 0)
				System.out.println("login server in running list size:" + list.size());
			hsRequest.getSession().setAttribute("gameServerList_u", list);
			
			//游戏服务器列表
			list3 = new GameServerListDao().findGameServers();
			if(null != list3 && list3.size() > 0)
				System.out.println("login server list size:" + list3.size());
			hsRequest.getSession().setAttribute("gameServerList", list3);
			
			if(null != gu) {//如果session中存有数据,session的优先级最高
				pwd = new GameUserDao().getPasswordByQueryUser(gu.getUserName(), gu.getServerId());
				
				if(null != pwd && pwd.equals(gu.getUserPassword())) {
					hsResponse.sendRedirect("/GameProject/userjsp/list.jsp");
				} 
			} else {//自动登录
				if(null != cookies && 4 == cookies.length - 1) {//多一个JSESSIONID
					//获取该应用下的所有cookie
					for (Cookie cookie : cookies) {
						if(cookie.getName().equals("loginedGameUser_userName")) {
							userName = cookie.getValue();
							if(null == userName)//为空指针删除该cookie
								cookie.setMaxAge(0);
						} else if(cookie.getName().equals("loginedGameUser_userPassword")) {
							userPassword = cookie.getValue();
							if(null == userPassword)//为空指针删除该cookie
								cookie.setMaxAge(0);
						} else if(cookie.getName().equals("loginedGameUser_userServerId")) {
							serverId = cookie.getValue();
							if(null == serverId)//为空指针删除该cookie
								cookie.setMaxAge(0);
						} else if(cookie.getName().equals("loginedGameUser_userAutoLogin")) {
							autoLogin = cookie.getValue();
							if(null == autoLogin)//为空指针删除该cookie
								cookie.setMaxAge(0);
						}
					}
					
					pwd = new GameUserDao().getPasswordByQueryUser(userName, serverId);
					//利用cookie的存储数据判断是否可以进行自动登录
					if(null != autoLogin && "yes".equals(autoLogin) && null != userPassword 
							&& null != pwd && pwd.equals(userPassword)) {//如果比较正确,就直接跳转到list页面
						GameUser g = new GameUser();
						g.setServerId(serverId);
						g.setUserName(userName);
						g.setUserPassword(pwd);
						g.setUserId(new GameUserDao().getUserIdByQueryUser(userName, serverId));
						//从cookie中读取数据后能够顺利登录要把数据存储到session中
						hsRequest.getSession().setAttribute("loginedGameUser", g);
						hsRequest.getSession().setAttribute("autoLogin", autoLogin);
						hsResponse.sendRedirect("/GameProject/userjsp/list.jsp");
					} else {//如果cookie的数据被人为改变,直接删除所有cookie
						for (Cookie cookie : cookies) {
							cookie.setMaxAge(0);
						}
					}
				}
			}
		}else if("/userjsp/regist.jsp".equals(servletPath)) {
			//游戏服务器列表
			list3 = new GameServerListDao().findGameServers();
			if(null != list3 && list3.size() > 0)
				System.out.println("regist server list size:" + list3.size());
			hsRequest.getSession().setAttribute("gameServerList", list3);
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
