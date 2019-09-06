<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
h1
{
   font-size: 40px;
   color: red;
}
</style>


		<center><h1>添加部门信息</h1></center> 
    <form action="syBranchctlr/upBranch.do" method="post" >
   
        <table>
            <tr>
                <td>部门名称</td>
                <td>
                <input type="text" name="secName" value="${select.secName}" >
                <input type="hidden" name="secId" value="${select.secId }" >
                </td>
            </tr>
            <tr>
                <td>备注信息</td>
                <td><input type="text" name="secComment" value="${select.secComment }"></td>
            </tr>
            <tr>
                <td>所属公司</td>
                <td>
                 <select name="comId" style="width: 300px;height: 40px;font-size:27px;color:green;">
                  <option value="0">选择公司</option>
                  <c:forEach items="${as }" var="k">
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
