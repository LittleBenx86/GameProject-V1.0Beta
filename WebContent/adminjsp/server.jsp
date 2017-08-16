<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="../js/bootstrap.css">  
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/checkValidity.js"></script>
<title>战神传奇私服后台管理,防止老司机翻车而存在!</title>
<style type="text/css">
	/*  */
	body{
		margin: 0px auto;
		padding: opx;
	}
	div{
		margin: 0px auto;
		padding: opx;
	}
	
	.bannar{
		width: 1900px;
		height: 80px;
		background-color: #F5F5F5; 
	}
	div > .hello{
		width: 15%;
		height: 100%;
		position: relative;
		float: left;
		background-color: #F5F5F5;
		background-image: url("/GameProject/ui/title.png");
		background-size: 50%; 
		background-repeat: no-repeat;
		background-position: 55px -10px;
		border-top-left-radius: 15px;
		border-bottom-left-radius: 15px;
		border-right-style: groove;
	}
	/* session中存在管理员的登录资料时显示该div */
	div > .adminLogin_d{
		width: 300px;
		height: 100%;
		
		position: relative;
		float: right;
		right: 0px;
		
		background-color: #F5F5F5;
	}
	div > .adminLogout_d{
		width: 300px;
		height: 100%;
		
		position: relative;
		float: right;
		right: 0px;
		
		background-color: #F5F5F5;
	}
	
	/* 字体 */
	.ht_f{
		position: relative;
		top: 65%;
		left: 20%;
		font-weight: bolder;
	}
	
	.btn.btn-default{ 
		width: 250px;
		height: 80px;
		background-color: #F5F5F5;
		font-size: large;
		font-weight: bolder;
		
	}
	/* .btn.btn-default.active {
		background-color: orange !important;
	} */
	
	/* 模态框部分的样式设置 */
	.btn.btn-default.closeNewServer{
		width: 82px;
		height: 34px;
		font-size: small;
		font-weight: normal;
	}
	div > .modal-content{
		width: 900px;
		position: relative;
		left: -200px;
	}
	/* 新增服务器 */
	.newServerInp{
		width: 100%;
		height: 50px;
		
		display: block;
		position: relative;
		
		font-size: x-large;
	}
	/* 修改服务器  */
	.updateServerInp{
		width: 100%;
		height: 50px;
		
		display: block;
		position: relative;
		
		font-size: x-large;
	}
	/* 管理员登录模态框大小设置 */
	div > .modal-content.admin{
		width: 200px;
		position: relative;
		left: -200px;
	}
	
	/* 当前服务器运行列表 */
	.serverList{
		width: 80%;
		height: 820px;
		background-color: white;
	}
	.serverListTable{
		width: 100%;
		border-style: groove; 
	}
	.th_tr_h{
		text-align: center;
		font-size: large;
		background-color:#F5F5F5;
		border-top-style: groove;
		border-bottom-style: groove;
	}
	.td_tr_b{
		margin: 0px;
		padding: 0px;
		height: 80px;
	}
	.odd{
		background-color:#ffffff;
		border-bottom-style: groove;
	}
	.even{
		background-color:#F5F5F5;
		border-bottom-style: groove;
	}
	
	/* 底部栏 */
	.bottom{
		width: 1910px;
		height: 80px;
		
		position: fixed;
		bottom: 0px;
		right: 0px;
		left: -10px;
		
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
<script type="text/javascript">
	/* 监听网页是否加载完毕 */
	/* 获取浏览器页面的可见高度和宽度 */
	var _pageHeight = document.documentElement.clientHeight,
		_pageWidth = document.documentElement.clientWidth;
	/* 计算loading框距离顶部和左部的距离  */
	var _loadingTop = _pageHeight > 61 ? (_pageHeight - 61) / 2 : 0,
		_loadingLeft = _pageWidth > 215 ? (_pageWidth - 215) / 2 : 0; 	
	/* 在页面还在完成之前的显示效果 */
	var _loadingHtml = '<div id="loadingDiv" style="position:absolute;left:0;width:100%;height:' + 
				_pageHeight + 'px;top:0;background:#f3f8ff;opacity:1;filter:alpha(opacity=80);z-index:10000;"><div style="position: absolute; cursor1: wait; left: ' + 
				_loadingLeft + 'px; top:' + _loadingTop + 'px; width: auto; height: 57px; line-height: 57px; padding-left: 50px; padding-right: 5px; background: #fff url(/GameProject/ui/loading.gif) no-repeat scroll 5px 10px; border: 2px solid #95B8E7; color: #696969; font-family:\'Microsoft YaHei\';">页面加载中，请等待...</div></div>';
	document.write(_loadingHtml);
	/* 监听加载状态改变 */
	document.onreadystatechange = completeLoading;
	
	function completeLoading(){
		if("complete" == document.readyState){
			 var loadingMask = document.getElementById('loadingDiv');
		     loadingMask.parentNode.removeChild(loadingMask);
		}
	}
	
	$(document).ready(function(){
		/* 类样式设置部分 */
		/* 设置table tbody的奇偶行的类属性,通过css设置样式 */
		$(".serverListTable tbody tr:odd").addClass("odd");
		$(".serverListTable tbody tr:even").addClass("even");
		
		/* 页面切换显示和隐藏 */
		$(".btn#btn1").click(function(){
			if(true == $(".serverList").is(":hidden"))
				$(".serverList").show();
		});
		$(".btn#btn2").click(function(){
			if(false == $(".serverList").is(":hidden"))
				$(".serverList").hide();
			checkAllInputNotNull();//判断所有输入框是否不为空,不为空则让新增服务器的按钮激活,否则其状态不可用
		});
		$(".btn#btn3").click(function(){
			if(false == $(".serverList").is(":hidden"))
				$(".serverList").hide();
		});
		
		/* 新增game server的模态框事件部分 */
		$("#newServer").on("hide.bs.modal", function(){//新增服务器模态框退出时清空里面input框的值
			$(".newServerInp").val("");
			$(".serverList").show();
		});
		
		/* 确认添加新的game server */
		$(".btn.btn-primary.add").click(function(){
			var serverName = $("input[name=serverName]").val();
			var serverIP = $("input[name=serverIP]").val();
			var serverId = $("input[name=serverId]").val();
			var threadType = $("input[name=threadType]").val();
			var brief = $("input[name=brief]").val();
			var qq = $("input[name=qq]").val();
			var mainWeb = $("input[name=mainWeb]").val();
			var state = document.getElementsByName("serverState");
			var serverState = null;
			
			for(var i = 0; i < state.length; i++){//检测radio的checked状态
				if(true == state[i].checked)
					serverState = state[i].value;
			}
			
			if("" != serverName && "" != serverIP && "" != serverId && /* 这段代码是在做输入框不为空函数之前做的现在基本可以不用这段代码  */
					"" != threadType && "" != brief && "" != qq && "" != mainWeb){//输入框均有数据输入时
				$.ajax({
					dataType : "json",//这里不能大写JOSN
					contentType : "application/x-www-form-urlencoded;charset=utf-8;",
					type : "post",
					url : "/GameProject/AddGameServerServlet",
					async : true,//设置为异步
					data:{"serverName":serverName, "serverIP":serverIP, "serverId":serverId, "threadType":threadType,
						"brief":brief, "qq":qq, "mainWeb":mainWeb, "serverState":serverState},
					success:function(data){
						if("success" === data.addServer){
							/* 模态框隐藏并清空输入框的值 */
							$("#newServer").modal("hide");
							window.location.reload();//添加成功刷新页面
						}else if("fail" === data.addServer){
							$("#newServer").modal("hide");
						}
					},
					error:function(){
						alert("add game server err");
						$("#newServer").modal("hide");
					}
				});
			}
			else {
				alert("输入框不能有空");
			}
		});
		
	});
</script>
</head>
<body>
	<!-- 管理员没有登录的时候,即使进入到界面,也无法操作数据 -->
	<div class="bannar"><!-- 头部div,放置界面切换按钮 -->
		<div class="hello"><!-- 欢迎标语 ,放置传奇的logo -->
			<font class="ht_f" style="font-size: large;">战神传奇后台管理</font>
		</div>
		<div class="btn-group" data-toggle="buttons"><!-- 切换按钮 -->
			<c:if test="${sessionScope.loginedAdmin != null}">
				<label class="btn btn-default" id="btn1" >
					<input type="radio" name="option1" id="option1" value="1" checked="checked"/>
					<span style="position: relative; top: 21px;">当前运行服务器</span>
				</label>
				<label class="btn btn-default" id="btn2" data-toggle="modal" data-target="#newServer">
					<input type="radio" name="option2" id="option2" value="2"/>
					<span style="position: relative; top: 21px;">新增服务器</span>
				</label>
				<label class="btn btn-default" id="btn3">
					<input type="radio" name="option3" id="option3" value="3"/>
					<span style="position: relative; top: 21px;">用户管理</span>
				</label>
			</c:if>
			<c:if test="${sessionScope.loginedAdmin == null}">
				<label class="btn btn-default" >
					<input type="radio" name="option1"/>
					<span style="position: relative; top: 21px;">当前运行服务器</span>
				</label>
				<label class="btn btn-default">
					<input type="radio" name="option2" id="option2" value="2"/>
					<span style="position: relative; top: 21px;">新增服务器</span>
				</label>
				<label class="btn btn-default">
					<input type="radio" name="option3" id="option3" value="3"/>
					<span style="position: relative; top: 21px;">用户管理</span>
				</label>
			</c:if>
		</div>
		<c:choose>
			<c:when test="${sessionScope.loginedAdmin != null}">
				<div class="adminLogin_d">
					<span style="color: black; font-size: large; position: relative; top: 40%;">你好~</span>
					<c:if test="${sessionScope.loginedAdmin != null}">
						<span style="color: black; font-size: large; position: relative; top: 40%;">${loginedAdmin.adminName}</span>
					</c:if>
					<span style="color: black; font-size: large; position: relative; top: 40%;">~管理员</span>
					<button type="button" id="adminLogout" onclick="logout()"
					style="position: relative; float: right; top: 35%;">退出登录</button>
				</div>
			</c:when>
			<c:otherwise>
				<div class="adminLogout_d">
						<button type="button" id="adminLogin" data-toggle="modal" data-target="#adminLoginModal"
						style="position: relative; top: 35%; left: 38%;">管理员登录</button>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<script type="text/javascript">
		/* 管理员退出登录按钮的触发方法  */
		function logout(){
			$.ajax({
				dataType : "json",//这里不能大写JOSN
				contentType : "application/x-www-form-urlencoded;charset=utf-8;",
				type : "post",
				url : "/GameProject/AdminLogoutServlet",
				async : true,//设置为异步
				data:{"adminLogout":"adminLogout"},
				success:function(data){
					if("success" === data.logout)
						window.location.reload();
					if("fail" === data.logout){
						window.location.reload();
						alert("admin logout failed!");
					}
				},
				error:function(){
					window.location.reload();
					alert("admin logout err");
				}
			});
		}
	</script>
	
	<!-- 管理员登录模态框 -->
	<div class="modal fade" id="adminLoginModal" tabindex="-1" role="dialog" aria-labelledby="adminLoginLabel" aria-hidden="true"
		data-backdrop="static" data-keyboard="true">
		<div class="modal-dialog">
			<div class="modal-content admin">
				<div class="modal-header">
					<button type="button" class="close confirm" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h3 class="modal-title" id="newServerLabel" align="center" style="font-size: large; font-weight: bolder;">
						管理员登录
					</h3>
				</div>
				<div class="modal-body">
					<h4>   admin:</h4><input class="adminLoginInp" name="adminName" onblur="checkAdminInputNotNull()"/>
					<h4>password:</h4><input type="password" class="adminLoginInp" name="adminPassword" onblur="checkAdminInputNotNull()"/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary admin">确认登录</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		/* 管理员登录输入框输入不为空检测   */
		function checkAdminInputNotNull(){
			var adminName = $("input[name=adminName]").val();
			var adminPassword = $("input[name=adminPassword]").val();
			
			if("" != adminName && "" != adminPassword)
				$(".btn.btn-primary.admin").prop("disabled", false);
			else
				$(".btn.btn-primary.admin").prop("disabled", true);
		}
		
		$(document).ready(function(){
			$("button[id=adminLogin]").click(function(){
				checkAdminInputNotNull();/* 管理员登录输入框输入不为空检测   */
			});
			
			/* 隐藏登录输入框时清空输入  */
			$("#adminLoginModal").on("hide.bs.modal", function(){
				$("input[name=adminName]").val("");
				$("input[name=adminPassword]").val("")
			});
			
			/* 登录按钮  */
			$(".btn.btn-primary.admin").click(function(){
				var adminName = $("input[name=adminName]").val();
				var adminPassword = $("input[name=adminPassword]").val();
				
				$.ajax({
					dataType : "json",//这里不能大写JOSN
					contentType : "application/x-www-form-urlencoded;charset=utf-8;",
					type : "post",
					url : "/GameProject/CheckAdminIsExistServlet",
					async : true,//设置为异步
					data:{"adminName":adminName, "adminPassword":adminPassword},
					success:function(data){
						if("exist" === data.adminIsExist){
							/* 模态框隐藏并清空输入框的值 */
							$("#adminLoginModal").modal("hide");
							window.location.reload();
						}else if("no-exist" === data.adminIsExist){
							$("#adminLoginModal").modal("hide");
							alert("该管理员不存在");
						} else if("existButpwdErr" === data.adminIsExist){
							alert("密码错误,请重新填写");
						}
					},
					error:function(){
						$("#adminLoginModal").modal("hide");
						window.location.reload();
						alert("admin login err");
					}
				});
			});
			
		});
	</script>

	<!-- 新增newserver部分 -->
	<div class="modal fade" id="newServer" tabindex="-1" role="dialog" aria-labelledby="newServerLabel" aria-hidden="true"
		data-backdrop="static" data-keyboard="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close confirm" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h3 class="modal-title" id="newServerLabel" align="center" style="font-size: large; font-weight: bolder;">
						新增服务器
					</h3>
				</div>
				<div class="modal-body">
					<form action="">
						<h4>服务器名:</h4><input class="newServerInp" name="serverName" onblur="checkServerNameExist()"/>
						<span id="serverName" style="color: red;"></span>
						<br/>
						<h4>服务器IP:</h4><input class="newServerInp" name="serverIP" onblur="checkServerIPExist()"/>
						<span id="serverIP" style="color: red;"></span>
						<br/>
						<h4>服务器id:</h4><input class="newServerInp" name="serverId" onblur="checkServerIdExist()"/>
						<span id="serverId" style="color: red;"></span>
						<br/>
						<h4>服务器线路类型:</h4><input class="newServerInp" name="threadType" onblur="checkThreadTypeNotNull()"/>
						<span id="threadType" style="color: red;"></span>
						<br/>
						<h4>详细版本介绍:</h4><input class="newServerInp" name="brief"/>
						<br/>
						<h4>客服qq:</h4><input class="newServerInp" name="qq" onblur="checkQQNotNull()"/>
						<span id="qq" style="color: red;"></span>
						<br/>
						<h4>游戏主页:</h4><input class="newServerInp" name="mainWeb" onblur="checkMainWebNotNull()"/>
						<span id="mainWeb" style="color: red;"></span>
						<br/>
						<h4>服务器运行状态:</h4>
							<input name="serverState" type="radio" value="1" checked="checked" /><label style="font-size: large;">启用</label>
							<input name="serverState" type="radio" value="2" style="margin-left: 50px;"/><label style="font-size: large;">维护中</label>
							<input name="serverState" type="radio" value="0" style="margin-left: 50px;"/><label style="font-size: large;">停用</label>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary add">确认添加游戏服务器</button>
				</div>
			</div><!-- 模态框的content部分 -->
		</div><!-- 模态框的定义部分,类似table的声明 -->
	</div>
	<script type="text/javascript">
		//name
		function checkServerNameExist(){
			var serverName = $("input[name=serverName]").val();
			
			if("" != serverName){
				$.ajax({
					dataType : "json",//这里不能大写JOSN
					contentType : "application/x-www-form-urlencoded;charset=utf-8;",
					type : "post",
					url : "/GameProject/CheckServerIsExistServlet",
					async : true,//设置为异步
					data:{"serverName":serverName},
					success:function(data){
						if("no-exist" === data.serverIsExist){
							$("span[id=serverName]").hide();
						}else if("exist" === data.serverIsExist){
							$("span[id=serverName]").text("该服务器名已使用");
							$("span[id=serverName]").show();
						}else if("error" === data.serverIsExist){
							$("span[id=serverName]").text("err");
							$("span[id=serverName]").show();
						}
					},
					error:function(){
						alert("add game server err");
					}
				});
				checkAllInputNotNull();//判断所有输入框是否不为空,不为空则让新增服务器的按钮激活,否则其状态不可用
			} else {
				$("span[id=serverName]").text("服务器名不能为空");
				$("span[id=serverName]").show();
			}
		}
		//ip
		function checkServerIPExist(){
			var serverIP = $("input[name=serverIP]").val();
			if("" != serverIP){
				$.ajax({
					dataType : "json",//这里不能大写JOSN
					contentType : "application/x-www-form-urlencoded;charset=utf-8;",
					type : "post",
					url : "/GameProject/CheckServerIsExistServlet",
					async : true,//设置为异步
					data:{"serverIP":serverIP},
					success:function(data){
						if("no-exist" === data.serverIsExist){
							$("span[id=serverIP]").hide();
						}else if("exist" === data.serverIsExist){
							$("span[id=serverIP]").text("该服务器IP已使用");
							$("span[id=serverIP]").show();
						}else if("error" === data.serverIsExist){
							$("span[id=serverIP]").text("err");
							$("span[id=serverIP]").show();
						}
					},
					error:function(){
						alert("add game server err");
					}
				});
				checkAllInputNotNull();//判断所有输入框是否不为空,不为空则让新增服务器的按钮激活,否则其状态不可用
			} else {
				$("span[id=serverIP]").text("服务器IP不能为空");
				$("span[id=serverIP]").show();
			}
			
		}
		//id
		function checkServerIdExist(){
			var serverId = $("input[name=serverId]").val();
			
			if("" != serverId){
				$.ajax({
					dataType : "json",//这里不能大写JOSN
					contentType : "application/x-www-form-urlencoded;charset=utf-8;",
					type : "post",
					url : "/GameProject/CheckServerIsExistServlet",
					async : true,//设置为异步
					data:{"serverId":serverId},
					success:function(data){
						if("no-exist" === data.serverIsExist){
							$("span[id=serverId]").hide();
						}else if("exist" === data.serverIsExist){
							$("span[id=serverIP]").text("该服务器Id已使用");
							$("span[id=serverIP]").show();
						}else if("error" === data.serverIsExist){
							$("span[id=serverId]").text("err");
							$("span[id=serverId]").show();
						}
					},
					error:function(){
						alert("add game server err");
					}
				});
				checkAllInputNotNull();//判断所有输入框是否不为空,不为空则让新增服务器的按钮激活,否则其状态不可用
			} else {
				$("span[id=serverId]").text("服务器Id不能为空");
				$("span[id=serverId]").show();
			}
		}
		//threadtype
		function checkThreadTypeNotNull(){
			var str = $("input[name=threadType]").val();
			
			if("" == str){
				$("span[id=threadType]").text("线路类型不能为空");
				$("span[id=threadType]").show();
			} else {
				$("span[id=threadType]").hide();
			}
			checkAllInputNotNull();//判断所有输入框是否不为空,不为空则让新增服务器的按钮激活,否则其状态不可用
		}
		//qq
		function checkQQNotNull(){
			var str = $("input[name=qq]").val();
			
			if("" == str){
				$("span[id=qq]").text("线路类型不能为空");
				$("span[id=qq]").show();
			} else {
				$("span[id=qq]").hide();
			}
			checkAllInputNotNull();//判断所有输入框是否不为空,不为空则让新增服务器的按钮激活,否则其状态不可用
		}
		//mainweb
		function checkMainWebNotNull(){
			var str = $("input[name=mainWeb]").val();
			
			if("" == str){
				$("span[id=mainWeb]").text("线路类型不能为空");
				$("span[id=mainWeb]").show();
			} else {
				$("span[id=mainWeb]").hide();
			}
			checkAllInputNotNull();//判断所有输入框是否不为空,不为空则让新增服务器的按钮激活,否则其状态不可用
		}
		
		//check all input not null
		//判断所有输入框是否不为空,不为空则让新增服务器的按钮激活,否则其状态不可用
		function checkAllInputNotNull(){
			var mainWeb = $("input[name=mainWeb]").val();
			var serverName = $("input[name=serverName]").val();
			var serverId = $("input[name=serverId]").val();
			var qq = $("input[name=qq]").val();
			var threadType = $("input[name=threadType]").val();
			var serverIP = $("input[name=serverIP]").val();
			
			if("" != mainWeb && "" != serverName && "" != serverId &&
					"" != serverIP && "" != qq && "" != threadType){
				$(".btn.btn-primary").prop("disabled", false);//解除禁用
			}else 
				$(".btn.btn-primary").prop("disabled", true);//禁用新增服务器button
		}
	</script>
	<!-- 服务器运行列表 -->
	<div class="serverList">
		<table class="serverListTable">
			<thead>
				<tr>
					<th align="center" width="8%" class="th_tr_h">
						<font color="black">服务器名</font>
					</th>
					<th align="center" width="10%" class="th_tr_h">
						<font color="black">服务器IP</font>
					</th>
					<th align="center" width="5%" class="th_tr_h">
						<font color="black">服务器Id</font>
					</th>
					<th align="center" width="15%" class="th_tr_h">
						<font color="black">开机时间[年/月/日/时]</font>
					</th>
					<th align="center" width="10%" class="th_tr_h">
						<font color="black" >线路类别</font>
					</th>
					<th align="center" class="th_tr_h">
						<font color="black">详细版本介绍</font>
					</th>
					<th align="center" width="8%" class="th_tr_h">
						<font color="black">客服qq</font>
					</th>
					<th align="center" width="8%" class="th_tr_h">
						<font color="black">游戏主页</font>
					</th>
					<th align="center" width="8%" class="th_tr_h">
						<font color="black">服务器状态</font>
					</th>
					<th align="center" width="10%" class="th_tr_h">
						<font color="black">服务器管理</font>
					</th>
				</tr>
			</thead>
			<tbody class="tbody_stable">
				<c:forEach items="${sessionScope.gameServerList}" var="gsl">
					<tr>
						<td class="td_tr_b"  align="center" ><h4>${gsl.serverName}</h4></td>
						<td class="td_tr_b"  align="center">${gsl.serverIP}</td>
						<td class="td_tr_b"  align="center">${gsl.serverId}</td>
						<td class="td_tr_b"  align="center">${gsl.openTime}</td>
						<td class="td_tr_b"  align="center">${gsl.threadType}</td>
						<td class="td_tr_b"  align="center">${gsl.brief}</td>
						<td class="td_tr_b"  align="center">${gsl.QQ}</td>
						<td class="td_tr_b"  align="center">
							<a href="${gsl.mainWeb}" target="_blank" 
							style="display: block; margin: 0px; padding: 0px; position: relative; word-wrap:break-word;"
							title="${gsl.mainWeb}">
								点击查看
							</a>
						</td>
						<td class="td_tr_b"  align="center">
							<c:choose>
								<c:when test="${gsl.serverState == '0'}"><font color="red">停止运行</font></c:when>
								<c:when test="${gsl.serverState == '1'}"><font color="green">正在运行</font></c:when>
								<c:otherwise><font color="orange">维护中</font></c:otherwise>
							</c:choose>
						</td>
						<td class="td_tr_b"  align="center">
							<c:if test="${sessionScope.loginedAdmin == null}">
								<button type="button" id="updateGameServer" 
								style="position: relative; width: 50%; height: 40px;" disabled="disabled">
									修改
								</button>
							</c:if>
							<c:if test="${sessionScope.loginedAdmin != null}">
								<button type="button" id="updateGameServer" data-toggle="modal" data-target="#updateServer" class="btn btn-primary modi"
								style="position: relative; width: 50%; height: 40px;" onclick="updateServer('${gsl.serverName}','${gsl.serverIP}','${gsl.serverId}', '${gsl.serverState}')" >
									修改
								</button> 
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td class="td_tr_b"  align="center" style="border-bottom-style: none;"></td>
					<td class="td_tr_b"  align="center" style="border-bottom-style: none;"></td>
					<td class="td_tr_b"  align="center" style="border-bottom-style: none;"></td>
					<td class="td_tr_b"  align="center" style="border-bottom-style: none;"></td>
					<td class="td_tr_b"  align="center" style="border-bottom-style: none;"></td>
					<td class="td_tr_b"  align="center" style="border-bottom-style: none;"></td>
					<td class="td_tr_b"  align="center" style="border-bottom-style: none;"></td>
					<td class="td_tr_b"  align="center" style="border-bottom-style: none;"></td>
					<td class="td_tr_b"  align="center" style="border-bottom-style: none;"></td>
					<td class="td_tr_b"  align="center" style="border-bottom-style: none;"></td>
				</tr>
			</tfoot>
		</table>
	</div>
	
	<!-- 修改server模态框 -->
	<div class="modal fade" id="updateServer" tabindex="-1" role="dialog" aria-labelledby="updateServerLabel" aria-hidden="true"
		data-backdrop="static" data-keyboard="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close confirm" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h3 class="modal-title" id="updateServerLabel" align="center" style="font-size: large; font-weight: bolder;">
						修改服务器
					</h3>
				</div>
				<div class="modal-body">
					<form action="">
						<h4>服务器名:</h4><input class="updateServerInp" name="newServerName" readonly="readonly"/>
						<br/>
						<h4>服务器IP:</h4><input class="updateServerInp" name="newServerIP" readonly="readonly"/>
						<br/>
						<h4>服务器id:</h4><input class="updateServerInp" name="newServerId" readonly="readonly"/>
						<br/>
						<h4>服务器线路类型:</h4><input class="updateServerInp" name="newThreadType"/>
						<br/>
						<h4>详细版本介绍:</h4><input class="updateServerInp" name="newBrief"/>
						<br/>
						<h4>客服qq:</h4><input class="updateServerInp" name="newQQ"/>
						<br/>
						<h4>游戏主页:</h4><input class="updateServerInp" name="newMainWeb"/>
						<br/>
						<h4>服务器运行状态:</h4>
							<input name="newServerState" id="r1" type="radio" value="1"/><label style="font-size: large;">启用</label>
							<input name="newServerState" id="r2" type="radio" value="2" style="margin-left: 50px;"/><label style="font-size: large;">维护中</label>
							<input name="newServerState" id="r0" type="radio" value="0" style="margin-left: 50px;"/><label style="font-size: large;">停用</label>
							<input name="newServerState" id="r4" type="radio" value="3" style="margin-left: 50px;"/><label style="font-size: large;">重启</label>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary update">确认修改游戏服务器</button>
				</div>
			</div><!-- 模态框的content部分 -->
		</div><!-- 模态框的定义部分,类似table的声明 -->
	</div>
	<script type="text/javascript">
		function updateServer(serverName, serverIP, serverId, server_State){
			$("input[name=newServerName]").val(serverName);
			$("input[name=newServerIP]").val(serverIP);
			$("input[name=newServerId]").val(serverId);
			if("0" === server_State)
				$(":radio[name=newServerState][id=r0]").prop("checked",true);
			else if("1" === server_State)
				$(":radio[name=newServerState][id=r1]").prop("checked",true);
			else if("2" === server_State)
				$(":radio[name=newServerState][id=r2]").prop("checked",true);
			else if("3" === server_State)
				$(":radio[name=newServerState][id=r3]").prop("checked",true);
			
			$(".btn.btn-primary.update").click(function(){
				var threadType = $("input[name=newThreadType]").val();
				var brief = $("input[name=newBrief]").val();
				var QQ = $("input[name=newQQ]").val();
				var mainWeb = $("input[name=newMainWeb]").val();
				var state = document.getElementsByName("newServerState");
				var serverState = null;
				for(var i = 0; i < state.length; i++){
					if(true == state[i].checked){
						if(server_State == state[i].value)
							serverState = "-1";
						else 
							serverState = state[i].value;
					}
						
				}
				
				$.ajax({
					dataType : "json",//这里不能大写JOSN
					contentType : "application/x-www-form-urlencoded;charset=utf-8;",
					type : "post",
					url : "/GameProject/UpdateGameServerServlet",
					async : true,//设置为异步
					data:{"serverId":serverId, "serverName":serverName, "serverIP":serverIP, "threadType":threadType, 
						"brief":brief, "QQ":QQ, "mainWeb":mainWeb, "serverState":serverState},
					success:function(data){
						if("success" === data.updateServer){
							$("#updateServer").modal("hide");
							/* serverListSessionLoad(); */
							window.location.reload();
						}else if("fail" === data.updateServer){
							$("#updateServer").modal("hide");
							alert("更新服务器失败");
						}else if("error" === data.updateServer){
							alert("内部错误, 更新服务器失败");
						}
					},
					error:function(){
						alert("update game server err");
					}
				});
			});
		}
	</script>
	
	<div class="bottom">
		<label class="lab_e">防止老司机翻车的后台~\(≧▽≦)/~啦啦啦</label>
	</div>
</body>
</html>