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
h1
{
   font-size: 40px;
   color: red;
}
</style>
				  <center><h1>添加公司信息</h1></center> 
    <form action="sycompanyctlr/goadde.do" method="post">
        <table>
            <tr>
                <td>公司名称</td>
                <td>
                <input type="text" name="comName">
                <input type="hidden" name="comId">
                </td>
            </tr>
            <tr>
                <td>公司代码</td>
                <td>
               <input type="text" name="comCode">
                </td>
            </tr>
            <tr>
                <td>公司邮箱</td>
                <td><input type="text" name="comEmail"></td>
            </tr>
            <tr>
                <td>联系人</td>
                <td><input type="text" name="comLinkman"></td>
            </tr>
            <tr>
                <td>公司地址</td>
                <td><input type="text" name="comAddress"></td>
            </tr>
            <tr>
                <td>固定电话</td>
                <td><input type="text" name="comPhone"></td>
            </tr>
             <tr>
                <td>移动电话</td>
                <td><input type="text" name="comYphone"></td>
            </tr>
             <tr>
                <td>传真</td>
                <td><input type="text" name="comFax"></td>
            </tr>
             <tr>
                <td>开户银行</td>
                <td><input type="text" name="comBank"></td>
            </tr>
             <tr>
                <td>银行账户</td>
                <td><input type="text" name="comBankuser"></td>
            </tr>
             <tr>
                <td>是否有效</td>
                <td><input type="text" name="comYesandno"></td>
            </tr>
             <tr>
                <td>备注信息</td>
                <td><input type="text" name="comRemark"></td>
            </tr>
            <tr>
             	<td></td>
                <td><input class="btn" type="submit" value="添加" ></td>
            </tr>
        </table>
    </form>
</body>
</html>
