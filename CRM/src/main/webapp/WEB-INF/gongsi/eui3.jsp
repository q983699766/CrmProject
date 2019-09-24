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
  		<center><h1 style="color: red;">修改员工信息</h1></center><br><br><br>
    <form class="layui-form layui-form-pane" action="sysEmpuser/update.do" method="post" enctype="multipart/form-data" >
  <div class="layui-form-item">
    <label class="layui-form-label">员工姓名</label>
    <div class="layui-input-block">
      <input type="text"  name="empName" value="${se.empName }" required  lay-verify="required" placeholder="请输入公司名称" autocomplete="off" class="layui-input">
    	<input type="hidden" name="empId"value="${ se.empId}" >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">员工性别</label>
    <div class="layui-input-block">
      <input type="text"  name="empSix" value="${ se.empSix}" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">员工照片</label>
    <div class="layui-input-block">
      <input type="file"  name="files" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">身份证号</label>
    <div class="layui-input-block">
      <input type="text"   name="empNumber" value="${se.empNumber}" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">家乡地址</label>
    <div class="layui-input-block">
      <input type="text"   name="empAddress" value="${se.empAddress}" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">现在地址</label>
    <div class="layui-input-block">
      <input type="text"  name="empTadayadd" value="${se.empTadayadd }" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">员工学历</label>
    <div class="layui-input-block">
      <input type="text"  name="empEduca" value="${se.empEduca }" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">政治面貌</label>
    <div class="layui-input-block">
      <input type="text"  name="empFace" value="${ se.empFace}" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">毕业学校</label>
    <div class="layui-input-block">
      <input type="text"  name="empSchool" value="${se.empSchool }" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-block">
      <input type="text"  name="empPhone" value="${se.empPhone }" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
    <div class="layui-form-item">
    <label class="layui-form-label">网上联系方式</label>
    <div class="layui-input-block">
      <input type="text"  name="empMeshphone" value="${ se.empMeshphone}" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
    <div class="layui-form-item">
    <label class="layui-form-label">网上联系详情</label>
    <div class="layui-input-block">
      <input type="text" name="empContact" value="${se.empContact }" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">审核状态</label>
    <div class="layui-input-block">
             <select name="empState" required  lay-verify="required">
      <option value=" ">请选择--</option>
      <option value="1">审核通过</option>
      <option value="2">审核失败</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">职务编号</label>
    <div class="layui-input-block">
      <input type="text"  name="dutId" value="${se.dutId }" required  lay-verify="required" placeholder="请输入公司代码" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">员工状态</label>
    <div class="layui-input-block">
             <select name="empSysstate" required  lay-verify="required">
      <option value=" ">请选择--</option>
      <option value="1">在职</option>
      <option value="2">离职</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">备注信息</label>
    <div class="layui-input-block">
      <textarea name="empRemark" placeholder="请输入内容" class="layui-textarea">${se.empRemark }</textarea>
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">公司编号</label>
    <div class="layui-input-block">
          <select name="comId" required  lay-verify="required">
                  <option value=" ">请选择--</option>
                <c:forEach items="${m }" var="c">
               <option value="${c.comId}">${c.comName}</option>
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
	layui.use('form', function() {
		var form = layui.form;

	});
</script>
  </body>
</html>
