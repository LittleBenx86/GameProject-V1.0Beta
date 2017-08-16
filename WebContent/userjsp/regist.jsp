<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
<!-- <script type="text/javascript" src="http://s.xnimg.cn/ajax/zepto/zepto-1.1.0.all.min.js"></script> -->
<script type="text/javascript" src="../js/checkValidity.js"></script>
<title>注册成为战神传奇老司机!</title>
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

	/*  */
	body{
		margin: 0px;
		padding: 0px;
	}
	
	div{
		margin: 0px auto;
		padding: 0px;
	}
	/* 放置剑(sword)的图片div */
	.title{
		width: 1903px;
		height: 220px;
		background-color:#F7EEDF;
	}
	/* 放置剑(sword)的图片*/
	div > .sword{
		width: 30%;
		height: 98%;
		position: relative;
		top: 11%;
		float: right;
		background-image: url("/GameProject/ui/sword3.png");
		background-size: 100%;
	}
	
	/* 放置游戏人物的图片div */
	.left{
		width: 650px;
		height: 753px;
		float: left;
		background-color: #F7EEDF;
	}
	/* 放置游戏人物的图片*/
	.girl{
		width: 60%;
		height: 85.5%;
		float:right;
		position: relative;
		top: 14.5%;
		right: -7px;
		background-image: url("/GameProject/ui/girl.png");
		background-repeat: no-repeat;
		background-size: 98%;
		background-position: 1px 35px;
	}
	
	/* 放置注册信息输入的div */
	.right{
		width: 1250px;
		height: 751px;
		position: absolute;
		left: 650px;
		background-color: #F7EEDF;
		border-top-style: solid;
		border-left-style: solid;
	}
	/* 放置游戏人物图片  */
	div > .man{
		width: 45%;
		height: 85%;
		position: absolute;
		margin-left: 55%;
		margin-top: 9%;
		background: url("/GameProject/ui/man.png") no-repeat;
		background-size: 88%;
		background-position: 89px 0px;
	}
	div > .inp_d{
		width: 68%;
		height: 100%;
		position: relative;
		float: left;
		background: #F3DC78;
		opacity: 0.88;
	}
	.inp_f{
		width: 75%;
		height: 80%;
		position: relative;
		margin-left: 25%;
		margin-top: 15%;
	}
	.inp_f input.invalid {
         border: 2px solid #f47575;
     } 
	.inp{
		width: 220px;
		height: 25px;
		border: groove;
		border-color: black;
	}
	.sel_s{
		width: 214px;
		height: 30px;
		border: groove;
		border-color: black;
	}
	/* 设置输入框的字体 */
	input{
		font-size: medium;
	}
	
	/* submit按钮 */
	.combtn{
		width: 210px;
		height: 50px;
		border: groove;
		background: url("/GameProject/ui/comp.png") no-repeat;
		position: relative;
		margin-left: 19%;
		margin-top: 10%;
		cursor: move;
	}
	.combtn:hover{
		background: url("/GameProject/ui/comp2.png") no-repeat;
	}
	
	/* 放置月亮的图片div */
	.moon{
		width: 250px;
		height: 250px;
		position: absolute;
		top: 100px;
		left: 525px;
		background-image: url("/GameProject/ui/moon.png");
		background-repeat: no-repeat;
		background-size: 100%;
	}
	
	/* 放置战神传奇的标题图片div */
	.zstitle{
		width: 550px;
		height: 300px;
		position: absolute;
		top: 100px;
		left: 200px;
		background-image: url("/GameProject/ui/title.png");
		background-repeat: no-repeat;
		background-size: 100%;
	}
	/* 底部栏 */
	.bottom{
		width: 1920px;
		height:100px;
		background-image: url("/GameProject/ui/copyright.jpg");
		background-size: 100%;
		background-repeat: no-repeat;
		clear: both;
	}
	.lab_e{
		position: relative;
		margin-left: 40%;
		top: 35%;
		font-size: 32;
		color: white;
	}	
	
	/* 弹框validity气泡的样式设定 */
	.error{
	     position: absolute;
	     border: 1px solid #f0f0f0;
	     border-radius: 5px;
	     padding: 15px 10px;
	     background-color: white;
	     font-size: 14px;
	     color: #282828;
	     box-shadow: 0 0 20px #282828;
	 }
	.error:after{
	    content: "";
	    position: absolute;
	    top: -8px;
	    left: 10px;
	    border-left: 8px solid transparent;
	    border-right: 8px solid transparent;
	    border-bottom: 8px solid white;
	}
	 .error:after{
	     content: "";
	     position: absolute;
	     top: -8px;
	     left: 10px;
	     border-left: 8px solid transparent;
	     border-right: 8px solid transparent;
	     border-bottom: 8px solid white;
	 }
	 .error:before{
	     content: "!";
	     display: inline-block;
	     background-color: rgb(250,168,50);
	     font-size: 16px;
	     width: 18px;
	     height: 18px;
	     line-height: 18px;
	     color: white;
	     border-radius: 2px;
	     text-align: center;
	     margin-right: 5px;
	     margin-bottom: 5px;
	     vertical-align: middle;
	 }
	 .error span{
	     display: inline-block;
	     vertical-align: top;
	     line-height: 18px;
	 }
</style>
<script type="text/javascript">
	$(document).ready(function(){
		/* 刷新验证码 */
		$(".code").click(
			function() {
				this.src = "/GameProject/CodeServlet?time="+ new Date().getTime();
			});	
	});
</script>
</head>
<body>
	<div class="title">
		<div class="sword"></div>
	</div>
	<div class="left">
		<div class="girl"></div>
	</div>
	<div class="right">
		<div class="man"></div>
		<div class="inp_d">
			<form action="/GameProject/GameUserRegistServlet" method="post" class="inp_f">
				<ul style="list-style: none;">
					<li>
						<p>
							<label>用户昵称:</label><input class="inp" name="username" type="text" required=""/><label style="color: red;">*</label>
						</p>
					</li>
					<li>
						<p>
							<label>手机号码:</label><input class="inp" name="phone" type="text" 
							pattern="^1[3,5,8]\d{9}" pm="手机号码长度为11位" required=""/><label style="color: red;">*</label>
							<span style="color: red; position: relative; left: 5px;">手机号为13,15,18开头</span>
						</p>
					</li>
					<li>
						<p>
							<label>邮箱地址:</label><input class="inp" name="email" type="email" required=""><label style="color: red;">*</label>
						</p>
					</li>
					<li>
						<p>
							<label>身份证号:</label><input class="inp" name="id" type="text"  
								pattern="^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$" 
								pm="请输入15/18位的身份证号码"	required=""/><label style="color: red;">*</label>
							<span style="color: red; position: relative; left: 5px;">身份证件号为15/18位的</span>
						</p>
					</li>
					<li>
						<p>
							<label>大区选择:</label>
							<select class="sel_s" name="area" style="left: -5px;">
								<c:forEach items="${sessionScope.gameServerList}" var="gsl" varStatus="status">
									<c:choose>
										<c:when test="${status.last}">
											<option value="${status.count}" selected="selected">${status.count}区----${gsl.serverName}</option>
										</c:when>
										<c:otherwise>
											<option value="${status.count}">${status.count}区----${gsl.serverName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</p>
					</li>
					<li>
						<p>
							<label>设置密码:</label><input class="inp" name="pwd" type="password" 
							t="password" pattern="^.{6,12}$" pm="密码长度为6~15位" required=""/><label style="color: red;">*</label>
						</p>
					</li>
					<li>
						<p>
							<label>再输密码:</label><input class="inp" name="a_pwd" type="password"
							 t="password" pattern="^.{6,12}$" pm="密码长度为6~15位" required=""/><label style="color: red;">*</label>
						</p>
					</li>
					<li>
						<p>
							<label>输验证码:</label><input class="inp" name="chkcode" pattern="^[0-9A-Za-z]{5}$" pm="验证码为5位字母或数字" required=""/><label style="color: red;">*</label><img src="/GameProject/CodeServlet" 
								class="code" id="validcode" style="position: relative; vertical-align: middle; left: 10px;">
								<br/>
							<span style="color: red; position: relative; left: 320px;">点击刷新验证码</span>
						</p>
					</li>
				</ul>
				<input type="submit" class="combtn" value=""></input>
			</form>
			<script type="text/javascript">
				/* 立即执行的匿名函数 */
				!function(){
			        function submitFunc(){
			            console.info("表单验证成功，准备提交");
			            
			            var name = document.getElementsByName("username");
				        var id = document.getElementsByName("area");
				        console.info(name.item(0).value + ":" + id.item(0).value); 
				        $.ajax({
				        	dataType: "json",
				        	contentType: "application/x-www-form-urlencoded;charset=utf-8;",
				        	type: "post",
				        	url: "/GameProject/CheckUserExistServlet",
				        	async: true,//该线程在此时最稳妥是单线程处理ajax请求
				        	data:{username:name.item(0).value, serverId:id.item(0).value},
				        	success:function(data){
				        		if("true" === data[0].userexist){
				        			console.info("exist!");
				        			window.history.back();
				        			$(".code").load(this.src="/GameProject/CodeServlet?time="+ new Date().getTime()); 
				        			alert("该用户名已被注册");
				        			return ;
				        		}else{
				        			console.info("not exist!");
				        			
				        			var code = document.getElementsByName("chkcode");
								    console.info(code.item(0).value);
								    
								 	/* 等待前面对于用户存在的判定的ajax请求结束在新开线程异步请求处理验证码 */
							        $.ajax({
										dataType : "json",//这里不能大写JOSN
										contentType : "application/x-www-form-urlencoded;charset=utf-8;",
										type : "post",
										url : "/GameProject/CheckCodeServlet",
										async : true,//设置为异步
										data : {inp : code.item(0).value},//验证码输入框的数据,发送到servlet(后台处理)
										success : function(data) {
											console.info(data.length + " " + data);
											console.info(data[0].codeerr);//data获得的数据是json对象,是一个数组形式,要通过下标访问
											if ("-1" == data[0].codeerr) {
												window.history.back();//返回上一页,除了password的,input框中的数据是不变的,
												alert("验证码错误");
											}else{
												 $("form").submit();//等待ajax异步处理完毕,再提交表单,不然在异步请求之前,表单就已经提交
											}
										}
									});
				        		}
				        	}
				        });
				        
			          
			        }
			        newFormCheck($(".inp_f")[0], false, submitFunc);
			    }();
			    
			    function checkPwdIdentity(){
			        if(this.form["pwd"].value !== this.form["a_pwd"].value){
			            return false;
			        }
			        return true;
			    }
	
			    function newFormCheck(form, checkAccountExist, submitHandler){
			        var checkRule = {
			            "a_pwd": {
			                check: checkPwdIdentity,
			                msg: "两次密码输入不一致"
			            }
			        };
			        
			        return new Form(form, {
			            errorMsgClass: "error",         //错误提示框的类，用于自定义样式
			            errorInputClass: "invalid",     //input无效的类名，用于自定义样式
			            rule: checkRule,
			            lang: "cn",
			            disableBrowserMsg: !(navigator.language || navigator.userLanguage).match(/cn/i)
			        }, submitHandler);
			   }
			</script>
		</div>
	</div>
	<div class="moon">
	</div>
	<div class="zstitle">
	</div>
	<div class="bottom">
		<label class="lab_e">本游戏没有赞助商,因为它不是一款游戏~\(≧▽≦)/~啦啦啦</label>
	</div>
</body>
</html>