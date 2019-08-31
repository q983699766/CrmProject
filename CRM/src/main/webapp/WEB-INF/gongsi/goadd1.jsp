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

    <form action="sysdutyctlr/upadtee.do" method="post"enctype="multipart/form-data" >
        <table>
            <tr>
                <td>职务名称</td>
                <td>
                <input type="text" name="dutName" value="${u.dutName }">
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
             	<td></td>
                <td><input class="btn" type="submit" value="修改" ></td>
            </tr>
        </table>
    </form>
</body>
</html>
