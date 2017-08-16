<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="width: 1903px; margin: 0px; padding: 0px;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="../js/bootstrap.css">  
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<title>战神传奇私服,热到爆炸!</title>
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
	/* body样式设定 */
	body{
		margin: 0px auto;
		padding: 0px;
		width: 1903px;
		padding-right: 0px !important;/* 解决<body class="modal-open" style="padding-right: 17px;"> */
		background: #bfd7ff url("/GameProject/ui/bg5.jpg") no-repeat center 0;/* 放置背景图 */
	}
	/* div的总体样式设定 */
	div{
		margin: 0px auto;
		padding: 0px;
	}
	
	/* 头部导航栏的div */
	.bannar{
		width: 996px;
	    height: 220px;
	    
	    overflow: hidden;
	    position: relative;
	    background: url("/GameProject/ui/long.jpg") no-repeat;/* 放置头部导航栏的背景图片 */
	    background-size: 100% 160%;
	    background-position: 0px -10px;
	}
	/* 放置战神传奇logo的div */
	div > .bannar_in{
		width: 250px;
	    height: 100px;
	    left: 50px;
	    
	    position: relative;
	    float: left;
	    background: url("/GameProject/ui/title.png") no-repeat;/* 战神传奇的logo */
	    background-size: 100%;
	}
	/* 放置收藏的div */
	div > .collection{
		width: 123px;
	    height: 106px;
	    left: 110px;
	    top: 80px;
	    
	    position: absolute;
	    float: left;
	    background: url("/GameProject/ui/collection.png") no-repeat;/* 收藏的图片 */
	    background-size: 100%;
	}
	/* 用户登录后div */
	.userLoginDiv{
		width: 250px;
	    height: 200px;
	    position: fixed;
	   	right: 0px;
	    top: 80px;
	    
	    border-radius: 5px;
	    background-color: #BFD7FF;
	    opacity: 0.75;
	}
	
	/* 用户登出后div */
	.userLogoutDiv{
		width: 250px;
	    height: 200px;
	    position: fixed;
	   	right: 0px;
	    top: 80px;
	    
	    border-radius: 5px;
	   	background-color: #BFD7FF;
	    opacity: 0.75;
	}
	
	/* 广告口号 */
	.sq{ 
		width: 996px;
	    height: 35px;
	    
	    background: url("/GameProject/ui/underlong.jpg") no-repeat;
	    background-size: 100%;
	}
	/* 私服游戏显示的div  */
	.content{
		width: 996px;
	}
	/* 私服游戏显示的table样式设定 */
	.tab{
		width: 996px;
		border: 0px;
		
		background-color: #006699;
	    font-weight: normal;
	    font-size: 12px;
	    line-height: 23px;
	    font-style: normal;
	    font-variant: normal;
	    text-align: center;
	}
	.th_tr_h{
		height: 50px;
		
		border-left-style: solid;
	}
	/* table footer */
	.foot_t{
		background-color: #ffff98;
	}
	.foot_t:hover{
		background-color: #ffffff;
	}
	.td_tr_f{
		border-left-style: solid;
		border-left-width: 1px;
		border-bottom-style: groove;
	}
	/* table body 显示私服数据 */
	.body_t{
		background-color: #ffff98;
	}
	.td_tr_b{
		border-left-style: solid;
		border-left-width: 2px;
		height: 60px;
		border-bottom-style: groove;
	}
	#look{
		color: red;
	}
	#look:hover{
		color: blue;
	}
	#collect:hover{
		color: green;
	}
	/* 鼠标放在指定位置的触发事件  */
	.tr_b:hover{
		background-color: #ffffff;
	}
	/* 私服数据定向的链接 */
	.a_tr_b{
		color: black;
		text-decoration: none;
	}
	/* 鼠标放在链接上的触发事件  */
	.a_tr_b:hover{
		color: red;
		text-decoration: underline;
	}
	
	/* 模态框样式设置 */
	/* 个人收藏模态框 */
	div > .modal-content.myFavorites{
		width: 1080px;
		left: -240px;
		
		position: relative;
	}
	/* 个人收藏模态框内的table */
	.mfTable{
		margin: 0px;
		padding: 0px;
		width: 1080px;
		left: -16px;
		border: 0px;
				
		position: relative;
	    font-weight: normal;
	    font-size: 5px;
	    line-height: 20px;
	    font-style: normal;
	    font-variant: normal;
	    text-align: center;
	}
	.th_tr_h_mf{
		height: 30px;
		left: -20px;
		
		border-style: groove; 
		border-left-style: solid;
		border-left-width: 1px;
	}
</style>
</head>
<body>
	<div class="bannar">
		<div class="bannar_in"></div>
		<div class="collection"></div>
	</div>
	<c:choose>
		<c:when test="${loginedGameUser != null}">
			<div class="userLoginDiv">
				<label><h4 style="margin-left: 50px;">用户:<font color="red" style="text-decoration: underline; margin-left: 10px;">${loginedGameUser.userName}</font></h4></label>
				<ul style="list-style: none;">
					<li><button class="btn btn-primary" data-toggle="modal" data-target="#personalModal"
					style="position: relative; left: 15%; width: 40%; height: 15%; margin: 10px;">个人中心</button></li>
					<li><button class="btn btn-primary" data-toggle="modal" data-target="#myFavoritesModal"
						style="position: relative; left: 15%; width: 40%; height: 15%; margin: 10px;">游戏收藏</button></li>
					<li><button class="btn btn-default logout" onclick="userLogout()"
					style="position: relative; left: 15%; width: 40%; height: 15%; margin: 10px;">退出登录</button></li>
				</ul>
			</div>
		</c:when>
		<c:when test="${loginedGameUser == null}">
			<div class="userLogoutDiv">
				<ul style="list-style: none;">
					<li><button class="btn btn-primary login" 
						style="position: relative;left: 15%; width: 40%; height: 15%; margin-top: 40px; margin-left: 10px;">登录私服</button>
					</li>
					<li>
						<a href="javascript:void(0)" 
							style="position: relative; left: 55%; width: 40%; margin-top:100px; margin-left: 10px; color: red;">忘记密码</a>
					</li>
					<li><button class="btn btn-primary regist" 
						style="position: relative; left: 15%; width: 40%; height: 15%; margin-top: 10px; margin-left: 10px;">注册私服</button></li>
				</ul>
			</div>
		</c:when>
	</c:choose>
	<script type="text/javascript">
		function userLogout(){
			$.ajax({
				dataType : "json",//这里不能大写JOSN
				contentType : "application/x-www-form-urlencoded;charset=utf-8;",
				type : "post",
				url : "/GameProject/GameUserLogoutServlet",
				async : true,//设置为异步
				data:{"gameUserLogout":"gameUserLogout"},
				success:function(data){
					if("success" === data.logout)
						window.location.reload();
					if("fail" === data.logout){
						window.location.reload();
						alert("user logout failed!");
					}
				},
				error:function(){
					window.location.reload();
					alert("user logout err");
				}
			});
		}
		$(document).ready(function(){
			$(".btn.btn-primary.login").click(function(){
				window.location.href = "/GameProject/userjsp/login.jsp";
			});
			$(".btn.btn-primary.regist").click(function(){
				window.location.href = "/GameProject/userjsp/regist.jsp";
			});
		});
	</script>
	
	<div class="sq"></div>
	<div class="content">
		<table cellspacing="1" cellpadding="5" align="center" class="tab">
			<thead class="head_t">
				<tr>
					<th width="8%" style="border-left-style: none; text-align: center;" class="th_tr_h">
						<font color="#ffffff" style="font-size: medium;">服务器名</font>
					</th>
					<th width="10%" style="text-align: center;" class="th_tr_h">
						<font color="#ffffff" style="font-size: medium;">服务器IP</font>
					</th>
					<th width="12%" style="text-align: center;" class="th_tr_h">
						<font color="#ffffff" style="font-size: medium;">开机时间[月/日/时]</font>
					</th>
					<th  width="8%" style="text-align: center;" class="th_tr_h">
						<font color="#ffffff" style="font-size: medium;">线路类别</font>
					</th>
					<th style="text-align: center;" class="th_tr_h">
						<font color="#ffffff" style="font-size: medium;">详细版本介绍</font>
					</th>
					<th width="8%" style="text-align: center;" class="th_tr_h">
						<font color="#ffffff" style="font-size: medium;">客服qq</font>
					</th>
					<th width="15%" style="text-align: center;" class="th_tr_h">
						<font color="#ffffff" style="font-size: medium;">游戏主页</font>
					</th>
				</tr>
			</thead>
			<tbody class="body_t"><!-- 放置私服数据 -->
				<c:if test="${sessionScope.loginedGameUser != null}">
					<c:forEach items="${sessionScope.gameServerList_u}" var="gsl">
						<tr class="tr_b">
							<td width="8%" style="border-left-style: none;" class="td_tr_b">
								<span style="font-size: medium;">${gsl.serverName}</span>
							</td>
							<td width="10%" style="text-align: center;" class="td_tr_b">
								<span style="font-size: medium;">${gsl.serverIP}</span>
							</td>
							<td width="12%" style="text-align: center;" class="td_tr_b">
								<span style="font-size: medium;">${gsl.openTime}</span>
							</td>
							<td width="6%" style="text-align: center;" class="td_tr_b">
								<span style="font-size: medium;">${gsl.threadType}</span>
							</td>
							<td style="text-align: center;" class="td_tr_b">
								<span style="font-size: medium;">${gsl.brief}</span>
							</td>
							<td width="8%" style="text-align: center;" class="td_tr_b">
								<span style="font-size: medium;">${gsl.QQ}</span>
							</td>
							<td width="15%" style="text-align: center;" class="td_tr_b">
								<a href="${gsl.mainWeb}" style="font-size: medium;" target="_blank" class="a_tr_b" id="look" title="${gsl.mainWeb}">点击查看</a>
								<c:choose>
									<c:when test="${sessionScope.myFavorites == null}">
										<a href="javascript:void(0)" style="font-size: medium;" class="a_tr_b" id="collect"
												onclick="addMyFavorite('${gsl.serverIP}','${loginedGameUser.userId}','${loginedGameUser.serverId}')">收藏</a>
									</c:when>
									<c:otherwise>
										<c:set var="exist" value="0" scope="session"></c:set>
										<c:forEach items="${sessionScope.myFavorites}" var="mf">
												<c:if test="${mf.userId == loginedGameUser.userId && mf.userServerId == loginedGameUser.serverId && mf.serverIP == gsl.serverIP}">
													<p hidden="hidden">${exist=1}</p>
												</c:if>
										</c:forEach>
										<c:if test="${exist == 1}">
											<a href="javascript:void(0)" style="font-size: medium;" class="a_tr_b" id="del_collect"
												onclick="deleteMyFavorite('${gsl.serverIP}','${loginedGameUser.userId}','${loginedGameUser.serverId}')">取消收藏</a>
										</c:if>
										<c:if test="${exist == 0}">
											<a href="javascript:void(0)" style="font-size: medium;" class="a_tr_b" id="collect"
												onclick="addMyFavorite('${gsl.serverIP}','${loginedGameUser.userId}','${loginedGameUser.serverId}')">收藏</a>
										</c:if>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		/* 添加收藏 */
		function addMyFavorite(serverIP, userId, userServerId){
			if(null != serverIP && null != userId && null !=  userServerId){
				console.info(userId);
				$.ajax({
					dataType : "json",//这里不能大写JOSN
					contentType : "application/x-www-form-urlencoded;charset=utf-8;",
					type : "post",
					url : "/GameProject/MyFavoriteOperateServlet",
					async : true,//设置为异步
					data:{"serverIP":serverIP, "userId":userId, "userServerId":userServerId, "op":"add"},
					success:function(data){
						if("success" === data.myFavoriteOp){
							window.location.reload();
							alert("收藏成功!");
						} else if("fail" === data.myFavoriteOp){
							alert("收藏失败!");
						} else if("null-err" === data.myFavoriteOp){
							alert("null 内部错误!");
						} else if("wrong-err" === data.myFavoriteOp){
							alert("wrong 内部错误!");
						}
					},
					error:function(){
						window.location.reload();
						alert("add favorite err");
					}
				});
			}
		}
		/* 删除收藏 */
		function deleteMyFavorite(serverIP, userId, userServerId){
			if(null != serverIP && null != userId && null !=  userServerId){
				var label = "#" +  serverIP;
				console.info(label);
				$.ajax({
					dataType : "json",//这里不能大写JOSN
					contentType : "application/x-www-form-urlencoded;charset=utf-8;",
					type : "post",
					url : "/GameProject/MyFavoriteOperateServlet",
					async : true,//设置为异步
					data:{"serverIP":serverIP, "userId":userId, "userServerId":userServerId, "op":"delete"},
					success:function(data){
						if("success" === data.myFavoriteOp){
							alert("取消收藏成功!");
							window.location.reload();
						} else if("fail" === data.myFavoriteOp){
							alert("取消收藏失败!");
						} else if("null-err" === data.myFavoriteOp){
							alert("null 内部错误!");
						} else if("wrong-err" === data.myFavoriteOp){
							alert("wrong 内部错误!");
						}
					},
					error:function(){
						window.location.reload();
						alert("delete favorite err");
					}
				});
			}
		}
	</script>
	
	<!-- 个人中心模态框 -->
	<div class="modal fade" id="personalModal" tabindex="-1" role="dialog" aria-labelledby="personalLabel" aria-hidden="true"
		data-backdrop="static" data-keyboard="true">
		<div class="modal-dialog">
			<div class="modal-content personal">
				<div class="modal-header">
					<button type="button" class="close confirm" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h3 class="modal-title" id="personalLabel" align="center" style="font-size: large; font-weight: bolder;">
						个人中心
					</h3>
				</div>
				<div class="modal-body">
					
				</div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
	
	<!-- 游戏收藏模态框 -->
	<div class="modal fade" id="myFavoritesModal" tabindex="-1" role="dialog" aria-labelledby="myFavoritesLabel" aria-hidden="true"
		data-backdrop="static" data-keyboard="true">
		<div class="modal-dialog">
			<div class="modal-content myFavorites">
				<div class="modal-header">
					<button type="button" class="close confirm" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h3 class="modal-title" id="myFavoritesLabel" align="center" style="font-size: large; font-weight: bolder;">
						我的游戏收藏
					</h3>
				</div>
				<div class="modal-body">
					<table class="mfTable">
						<thead>
							<tr>
								<th width="8%" style="border-left-style: none; text-align: center;" class="th_tr_h_mf">
									<font color="#ffffff" style="font-size: medium; color: black;">游戏区号</font>
								</th>
								<th width="10%" style="text-align: center;" class="th_tr_h_mf">
									<font color="#ffffff" style="font-size: medium; color: black;">游戏区名</font>
								</th>
								<th style="text-align: center;" class="th_tr_h_mf">
									<font color="#ffffff" style="font-size: medium; color: black;">详细版本介绍</font>
								</th>
								<th width="15%" style="text-align: center;" class="th_tr_h_mf">
									<font color="#ffffff" style="font-size: medium; color: black;">游戏主页</font>
								</th>
								<th width="15%" style="text-align: center;" class="th_tr_h_mf">
									<font color="#ffffff" style="font-size: medium; color: black;">修改操作</font>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${sessionScope.myFavorites != null}">
								<c:forEach items="${sessionScope.myFavorites}" var="mfs">
									<tr style="height: 50px;" id="${mfs.serverIP}">
										<c:forEach items="${sessionScope.gameServerList_u}" var="gsl">
											<c:if test="${gsl.serverIP == mfs.serverIP}">
												<td width="10%" style="text-align: center;" class="th_tr_h_mf">
													<span style="font-size: medium; color: black;">${gsl.serverId}</span>
												</td>
												<td width="8%" style="border-left-style: none; text-align: center;" class="th_tr_h_mf">
													<span style="font-size: medium;">${gsl.serverName}</span>
												</td>
												<td style="text-align: center;" class="th_tr_h_mf">
													<span style="font-size: medium;">${gsl.brief}</span>
												</td>
												<td width="15%" style="text-align: center;" class="th_tr_h_mf">
													<a href="${gsl.mainWeb}" target="_blank" style="font-size: medium;">${gsl.mainWeb}</a>
												</td>
											</c:if>
										</c:forEach>
										<td width="15%" style="text-align: center;" class="th_tr_h_mf">
											<button style="width: 80px; height: 30px;" 
												onclick="deleteMyFavorite_m('${mfs.serverIP}','${mfs.userId}','${mfs.userServerId}')">取消收藏</button>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
				<script type="text/javascript">
					/* 在模态框内删除收藏 */
					function deleteMyFavorite_m(serverIP, userId, userServerId){
						if(null != serverIP && null != userId && null !=  userServerId){
							$.ajax({
								dataType : "json",//这里不能大写JOSN
								contentType : "application/x-www-form-urlencoded;charset=utf-8;",
								type : "post",
								url : "/GameProject/MyFavoriteOperateServlet",
								async : true,//设置为异步
								data:{"serverIP":serverIP, "userId":userId, "userServerId":userServerId, "op":"delete"},
								success:function(data){
									if("success" === data.myFavoriteOp){
										document.getElementById(serverIP).style.display ='none';
									} else if("fail" === data.myFavoriteOp){
										alert("取消收藏失败!");
									} else if("null-err" === data.myFavoriteOp){
										alert("null 内部错误!");
									} else if("wrong-err" === data.myFavoriteOp){
										alert("wrong 内部错误!");
									}
								},
								error:function(){
									alert("delete favorite err");
								}
							});
						}
					}
					
					$(document).ready(function(){
						/* 个人收藏模态框事件部分 */
						$("#myFavoritesModal").on("hide.bs.modal", function(){//个人收藏模态框退出时刷新页面
							window.location.reload();
						});
					});
				</script>
				<!-- 网页底部 -->
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
</body>
</html>