<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  		<center><h1 style="color: red;">修改公司信息</h1></center><br><br><br>
    <form class="layui-form layui-form-pane" action="sycompanyctlr/updatee.do" method="post">
  <div class="layui-form-item">
    <label class="layui-form-label">公司名称</label>
    <div class="layui-input-block">
      <input type="text" name="comName"  value="${update.comName}" required  lay-verify="required" placeholder="请输入公司名称" autocomplete="off" class="layui-input">
    	<input type="hidden" name="comId" value="${ update.comId}">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">公司代码</label>
    <div class="layui-input-block">
      <input type="text"  name="comCode" value="${update.comCode }" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">公司邮箱</label>
    <div class="layui-input-block">
      <input type="text"   name="comEmail" value="${update.comEmail }" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">联系人</label>
    <div class="layui-input-block">
      <input type="text"   name="comLinkman" value="${ update.comLinkman}" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">公司地址</label>
    <div class="layui-input-block">
      <input type="text"   name="comAddress" value="${ update.comAddress}"required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">固定电话</label>
    <div class="layui-input-block">
      <input type="text"  name="comPhone" value="${update.comPhone }" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">移动电话</label>
    <div class="layui-input-block">
      <input type="text"  name="comYphone" value="${ update.comYphone}" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">传真</label>
    <div class="layui-input-block">
      <input type="text"  name="comFax" value="${update.comFax }" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">开户银行</label>
    <div class="layui-input-block">
             <select   name="comBank">
      <option value="0">请选择--</option>
      <option value="1">招商银行</option>
      <option value="2">中国银行</option>
      <option value="3">建设银行</option>
      <option value="4">邮政银行</option>
      <option value="5">平安银行</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">银行账户</label>
    <div class="layui-input-block">
      <input type="text"  name="comBankuser" value="${update.comBankuser }" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">是否有效</label>
    <div class="layui-input-block">
             <select  name="comYesandno">
      <option value="0">请选择--</option>
      <option value="1">有效</option>
      <option value="2">无效</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">备注信息</label>
    <div class="layui-input-block">
      <textarea name="comRemark" placeholder="请输入内容" class="layui-textarea">${update.comRemark }</textarea>
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
	layui.use('form', function() {
		var form = layui.form;

	});
</script>
  </body>
</html>
