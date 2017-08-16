<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%   
      String url = "/GameProject/userjsp/list.jsp";   //设置跳转的地址  
%>  
<html>  
   <head>              
        <meta http-equiv="refresh" content="5;url=<%=url %>">             
   </head>   
       <body>  
        <div align="center">  
            <h2 style=color:red>注册成功</h2>  
            <h2 style=color:red><span id=jump>5</span> 秒钟后页面将自动进入首页...</h2>  
            <h2><a href="javascript:void(0);" onclick="jumpToIndex()">点击此处立即跳转至首页</a></h2>  
        </div>       
      </body>  
        <script>  
             function countDown(secs){  
                       jump.innerText=secs;  
                       if(--secs>0)  
                                setTimeout("countDown("+secs+" )",1000);  
             }  
           	        
            function jumpToIndex(){  
                window.location.href='<%=url %>';  
            }  
            
            countDown(5);
       </script>  
</html>  