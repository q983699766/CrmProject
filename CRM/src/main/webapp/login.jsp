<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript">
		var isok = "${param.isok}"
		if(isok == "no"){
			alert("您未登录，请先登录！");
		}
	</script>
	
  </head>
  
  <body>
    
    <center>
    	<h1>用户登录</h1>
    	<h2 style="color: red">
    		${param.isfail=="nouser"? "用户名不存在！":"" }
    		${param.isfail=="error"? "用户名或密码错误！":"" }
    		${param.isfail=="codeerror"? "验证码错误！":"" }
    		${param.isfail=="unknown"? "用户名不存在！":"" }
    	</h2>
    	<form action="loginctlr/login.do" method="post">
    		用户名：<input type="text" name="uname" placeholder="请输入用户名">
    		<br><br>
    		密&nbsp;&nbsp;码：<input type="password" name="upass" placeholder="请输入密码">
    		<br><br>
    		验证码：<input name="randomcode" id="randomcode" size="8">
    		
    		<a href=javascript:randomcode_refresh()><img alt="" src="<%=basePath%>validatecode.jsp" align=""
    		id="randomcode_img" width="56" height="20" align='absMiddle'></a>
    		<script type="text/javascript">
    		function randomcode_refresh(){
				document.getElementById("randomcode_img").src = "<%=basePath%>validatecode.jsp?" + Math.random();   		
    		}
    		</script>
    		<br><br>
    		<input type="submit" value="登录">
    	</form>
    </center>
    
  </body>
</html>
