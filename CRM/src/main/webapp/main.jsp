<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
    <center>
    <h1>
    	欢迎你,${empty sessionScope.nowuser ? "游客":sessionScope.nowuser.userName},来到我的主页！
    </h1>
    	<c:if test="${empty sessionScope.nowuser}">
    		<a href="login.jsp">登录</a>
    	</c:if>
    	<c:if test="${not empty sessionScope.nowuser}">
    		<a href="logout.do" onclick="return confirm('是否确认退出？')">退出</a>
    	</c:if>
    	<br>
    </center>
  
  </body>
</html>
