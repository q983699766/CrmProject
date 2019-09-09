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
  			<br><br><br><center><h1 style="color: red;">修改职务信息</h1></center><br><br><br>
    <form class="layui-form layui-form-pane" action="sysdutyctlr/upadtee.do" method="post">
  <div class="layui-form-item">
    <label class="layui-form-label">职务名称</label>
    <div class="layui-input-block">
      <input type="text" name="dutName"  value="${u.dutName }" required  lay-verify="required" placeholder="请输入职务名称" autocomplete="off" class="layui-input">
    	<input type="hidden" name="dutId" value="${u.dutId }">
    </div>
  </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">所属部门</label>
    <div class="layui-input-block">
      <select name="secId" lay-verify="required">
      <option value="0">请选择--</option>
        <c:forEach items="${lss }" var="u">
    			<option value="${u.secId}">${u.secName}</option>
    		 </c:forEach>
      </select>
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">备注信息</label>
    <div class="layui-input-block">
      <textarea name="dutRemark" placeholder="请输入内容" class="layui-textarea">${u.dutRemark}</textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">所属公司</label>
    <div class="layui-input-block">
      <select name="comId" lay-verify="required">
      <option value="0">请选择--</option>
         <c:forEach items="${css }" var="k">
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
