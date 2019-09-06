<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basepath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Insert title here</title>
	<link  rel="stylesheet" href="<%=basepath %>layui/css/layui.css" />
	<script src="<%=basepath %>layui/layui.js"></script>
</head>
<body>
<style>
table
{
    width: 500px;
    margin: 0 auto;
}

tr
{
    height: 50px;
}

input
{
    width: 300px;
    height: 30px;
    outline: none;
    border:1px solid grey;
}

</style>
					<center><h1>修改职位信息</h1></center>
    <form action="sysdutyctlr/upadtee.do" method="post"enctype="multipart/form-data" >
        <table>
            <tr>
                <td>职务名称</td>
                <td>
                <input type="text" id="userTel" name="dutName" value="${u.dutName }"><span style="color: red;"></span>
                <input type="hidden" name="dutId" value="${u.dutId }">
                </td>
            </tr>
            <tr>
            
                <td>所属部门</td>
                <td>
                 <select name="secId" style="width: 300px;height: 40px;font-size:27px;color:green;">
                  <option value="0">部门类型</option>
                  <c:forEach items="${lss }" var="u">
    			<option value="${u.secId}">${u.secName}</option>
    			  </c:forEach>
 				 </select>
                </td>
            </tr>
            <tr>
                <td>备注说明</td>
                <td><input type="text" name="dutRemark" value="${u.dutRemark}"></td>
            </tr>
            <tr>
                <td>所属公司</td>
                <td>
                 <select name="comId" style="width: 300px;height: 40px;font-size:27px;color:green;">
                  <option value="0">选择公司</option>
                  <c:forEach items="${css }" var="k">
    			<option value="${k.comId}">${k.comName}</option>
    			  </c:forEach>
 				 </select>
                </td>
            </tr>
            <tr>
                <td><input class="btn" type="submit" value="修改" ></td>
            </tr>
        </table>
    </form>
</body>
</html>
<script>
var userTel = document.getElementById("userTel");
//验证手机号的
//手机号是11位数
//手机号都是1开头的
//手机号的第二位。 3  4  5  6  7  8

userTel.onblur = function(){

    var regTel = /[A-Za-z0-9_\-\u4e00-\u9fa5]+/;
    if(  regTel.test(this.value)   ){
        this.nextElementSibling.innerHTML = "名称正确";
    }else{
        this.nextElementSibling.innerHTML = "名称输入有误";
    }

}

</script>