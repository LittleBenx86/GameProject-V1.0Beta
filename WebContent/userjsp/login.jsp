<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
<style type="text/css">
/*
                         _oo0oo_
                        o8888888o
                        88" . "88
                        (| -_- |)
                        0\  =  /0
                      ___/`---'\___
                    .' \\|     |// '.
                   / \\|||  :  |||// \
                  / _||||| -:- |||||- \
                 |   | \\\  -  /// |   |
                 | \_|  ''\---/''  |_/ |
                 \  .-\__  '-'  ___/-. /
              ___'. .'  /--.--\  `. .'___
            ."" '<  `.___\_<|>_/___.' >' "".
           | | :  `- \`.;`\ _ /`;.`/ - ` : | |
           \  \ `_.   \_ __\ /__ _/   .-` /  /
       =====`-.____`.___ \_____/___.-`___.-'=====
                       `=---='

       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

             	             佛祖保佑         永无BUG
*/
	body{
		margin: 0px auto;
		padding: 0px;
	}
	
	/* 设置为静态的web需要auto */
	div{
		margin: 0px auto;
		padding: 0px;
	}
	/* 背景图所在的区域div */
	.main{
		width: 1920px;
		height: 792px;
		background-repeat: no-repeat;
		background-image: url("/GameProject/ui/bg.jpg");
		background-size: 1920px 792px ;
	}
	/* 战神传奇logo所在的div */
	div > .m1{
		width: 1200px;
		height: 792px;
	}
	/* 登录和注册所在的div */
	div > .m11{
		width: 100%;
		height: 32%;
	}
	/* 战神传奇的logo */
	.titleimg{
		position: relative;
		top: -25px;
		left: 252px;
	}
	
	/* 登录和注册的各类设置 */
	div > .m12{
		width: 100%;
		height: 68%;
	}
	/* 游戏登录caption图片所在div */
	div > .m12caption{
		width: 600px;
		height: 47px;
		display: block;
		background-image: url("/GameProject/ui/caption.PNG");
		background-size: 100%;
		position: relative;
		top: 50px;
	}
	/* 游戏登录body所在div:用于登录信息的输入操作 */
	div > .m12body{
		width: 600px;
		height: 300px;
		position: relative;
		top: 50px;
		background-color: #EFEFEF;
		opacity: 0.92;
	}
	/*  游戏登录caption图片所在div的左半部分的设置  */
	div > .m12body_l{
		width: 49.5%;
		height: 100%;
		position: relative;
		float: left;
		border-right-style: dashed;
	}
	/*  游戏登录caption图片所在div的右半部分的设置  */
	div > .m12body_r{
		width: 50%;
		height: 100%;
		position: relative;
		float: right;
	}
	/* 用户输入框所在的p标签 */
	.user_p{ 
		width: 231px;
		height: 26px;
		display: block;
		background: url("/GameProject/ui/user.png") no-repeat;
	}
	/* 用户输入框 */
	.user_inp{
		width: 180px;
		height: 23px;
		display: block;
		position: relative;
		top: 2px;
		margin: 0px 0px 0px 50px;
		padding: 0px;
		background-color: #E8E5D4;
		border: none;
	}
	/* 密码输入框所在的p标签 */
	.pwd_p{ 
		width: 231px;
		height: 26px;
		display: block;
		background: url("/GameProject/ui/pwd.png") no-repeat;
	}
	/* 密码输入框*/
	.pwd_inp{
		width: 180px;
		height: 24px;
		display: block;
		position: relative;
		top: 2px;
		margin: 0px 0px 0px 50px;
		padding: 0px;
		background-color: #E8E5D4;
		border: none;
	}
	/* 选择服务器大区的下拉框所在的p标签 */
	.sel_p{
		width: 230px;
		height: 26px;
		display: block;
	}
	/* 选择服务器大区的下拉框 */
	.sel_area{
		width: 230px;
		height: 26px;
		background-color: #E8E5D4;
	}
	/* 自动登录的选择框所在的p标签 */
	.auto_p{
		position: relative;
		top: -30px;
	}
	/* 用户的登陆类型 */
	.selectLogin{
		vertical-align: middle;
		margin-left: 40px;
		top: -20px;
	}
	/* 自动登录的选择框 */
	.autoLogin{
		vertical-align: middle;
		margin-left: 40px;
	}
	/* 忘记密码的修改链接  */
	.fg_pwd{
		vertical-align: middle;
		margin-left: 65px;
	}
	/* 开始游戏按钮所在的p标签 */
	.start_p{
		position: relative;
		top: -40px;
	}
	/* 开始游戏按钮 */
	.startbtn{
		width: 228px;
		height: 76px;
		display: block;
		background-image: url("/GameProject/ui/start_btn.png");
		background-size: 100%;
		margin-left: 40px;
		/* cursor: move; */
	}
	.startbtn:hover{
		background-image: url("/GameProject/ui/start_btn2.png");
	}
	/* 注册按钮所在的p标签 */
	.reg_p{
		vertical-align: middle;
		position: relative;
		top: 20%;
	}
	/* 注册按钮 */
	.regbtn{
		width: 228px;
		height: 76px;
		display: block;
		background-image: url("/GameProject/ui/regist_btn.png");
		background-size: 100%;
		margin-left: 40px;
		cursor: move;
	}
	.regbtn:hover{
		background-image: url("/GameProject/ui/regist_btn2.png");
	}
	/* 底部栏 */
	.bottom{
		width: 1920px;
		height: 200px;
		background-image: url("/GameProject/ui/copyright.jpg");
		background-size: 100%;
		background-repeat: no-repeat;
	}
	/* 底部标语 */
	.lab_e{
		position: relative;
		margin-left: 40%;
		top: 35%;
		font-size: 32;
		color: white;
	}	
</style>
<title>战神传奇私服,玩到你不想玩</title>
</head>
<body>
	<div class="main">
		<div class="m1">
			<div class="m11">
				<img class="titleimg" alt="" src="/GameProject/ui/title.png">
			</div>
			<div class="m12">
				<div class="m12caption"></div>
				<div class="m12body">
					<div class="m12body_l">
						<ul style="overflow: hidden; list-style: none;">
							<li>
								<p class="user_p">
									<input type="text" name="username" class="user_inp"/>
								</p>
							</li>
							<li>
								<p class="pwd_p">
									<input type="password" name="password" class="pwd_inp"/>
								</p>
							</li>
							<li>
								<p class="sel_p">
									<select class="sel_area" name="serverId">
										<c:forEach items="${sessionScope.gameServerList}" var="gsl" varStatus="status">
											<c:choose>
												<c:when test="${status.last}">
													<option value="${gsl.serverId}" selected="selected">${gsl.serverId}区----${gsl.serverName}</option>
												</c:when>
												<c:otherwise>
													<option value="${gsl.serverId}">${gsl.serverId}区----${gsl.serverName}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</p>
							</li>
						</ul>
						<p class="auto_p">
							<input name="select" value="admin" type="radio" class="selectLogin"><label>管理员</label>
							<input name="select" value="user" type="radio"  checked="checked" class="selectLogin"><label>用户</label>
							<br/>
							<input name="auto" value="yes" type="checkbox" class="autoLogin"/>
							<label>自动登录</label>
							<a class="fg_pwd" href="https://www.baidu.com" target="_blank">忘记密码</a>
						</p>
						<p class="start_p">
							<a class="startbtn"></a>
						</p>
					</div>
					<div class="m12body_r">
						<p class="reg_p">
							<span style="margin-left: 40px; color: red;">还没注册??!</span>
							<a class="regbtn" href="/GameProject/userjsp/regist.jsp"></a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- <audio src="/GameProject/bgm/三年幻想郷.mp3" autoplay hidden  loop controls> -->
	<audio src="/GameProject/bgm/三年幻想郷.mp3" autoplay hidden  loop controls>
		<source src="/GameProject/bgm/三年幻想郷.mp3" type="audio/mpeg"/>
	</audio>
	<div class="bottom">
		<label class="lab_e">本游戏没有赞助商,因为它不是一款游戏~\(≧▽≦)/~啦啦啦</label>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".startbtn").click(function(){
				var name = $("input[name=username]").val();
				var pwd = $("input[name=password]").val();
				var area = $("select[name=serverId]").val();//document.getElementsByName("serverId");
				/* 同类名的input输入框radio, ckeckbox在通过getElementsByName获取value时需要遍历确认checked状态 */
				var select = document.getElementsByName("select");
				var auto = document.getElementsByName("auto");
				var selectType ="";
				var autoType="no";//自动登录类型默认为no,即不自动登录
				//登录用户的类型为两种,由于同时为[class=select],所以获取值的时候是一数组,需要确认checked状态
				for(var i = 0; i < select.length; i++){
					if(select[i].checked == true)
						selectType = select[i].value;					
				}
				
				//确认自动登录的选择框是否被选中
				if(auto[0].checked == true)
					autoType = auto[0].value;
				
				//开始进行异步请求
				$.ajax({
					dataType: "json",
					contentType: "application/x-www-form-urlencoded;charset=utf-8;",
					type: "post",
					url: "/GameProject/CheckWhoLoginServlet",
					async: true,//异步请求
					data:{"username":name, "password":pwd, "serverId":area, "select":selectType, "autoType":autoType},
					success:function(data){
						if("false" === data.loginCallback){
							//密码错误,重载页面 
							window.location.reload();
							alert("密码错误,请重新登录");
						} else if("not-exist" === data.loginCallback){
							//用户不存在
							if(true === confirm("用户不存在,按确认键将跳转到注册页面"))
								window.location.href = "/GameProject/userjsp/regist.jsp";
						} else if("true" === data.loginCallback && "user" === data.who){
							window.location.href = "/GameProject/userjsp/list.jsp";
						} else if("true" === data.loginCallback && "admin" === data.who){
							window.location.href = "/GameProject/adminjsp/server.jsp";
						}
					},
					error:function(){
						alert("404");
					}
				}); 
			});
			
		});
	</script>
</body>
</html>