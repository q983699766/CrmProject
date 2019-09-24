<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'eui.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link  rel="stylesheet" href="<%=basePath%>layui/css/layui.css" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<%=basePath%>layui/layui.js"></script>
  </head>
  
  <body>
  			<br><br><br><center><h1 style="color: red;">修改部门信息</h1></center><br><br><br>
    <form class="layui-form layui-form-pane" action="syBranchctlr/upBranch.do" method="post">
  <div class="layui-form-item">
    <label class="layui-form-label" >部门名称</label>
    <div class="layui-input-block">
      <input type="text" name="secName" value="${select.secName}" required  lay-verify="required" placeholder="请输入职务名称" autocomplete="off" class="layui-input">
    	 <input type="hidden" name="secId" value="${select.secId }" >
    </div>
  </div>
    <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">备注信息</label>
    <div class="layui-input-block">
      <textarea name="secComment" placeholder="请输入内容" class="layui-textarea">${select.secComment }</textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">所属公司</label>
    <div class="layui-input-block">
      <select name="comId" lay-verify="required">
      <option value=" ">请选择--</option>
          <option value="0">选择公司</option>
                  <c:forEach items="${as }" var="k">
    			<option value="${k.comId}">${k.comName}</option>
    			  </c:forEach>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
     <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="return t()">立即提交</button>
      <input type="reset" class="layui-btn layui-btn-primary">
    </div>
  </div>
</form>
 
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
});


</script>
  </body>
</html>
