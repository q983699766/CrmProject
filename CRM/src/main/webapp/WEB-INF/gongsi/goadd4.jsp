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
select {
	 width: 300px;
    height: 30px;
	color:green;
}
</style>
				  <center><h1>修改公司信息</h1></center> 
    <form action="sycompanyctlr/updatee.do" method="post">
        <table>
            <tr>
                <td>公司名称</td>
                <td>
                <input type="text" name="comName" value="${update.comName}">
                <input type="hidden" name="comId" value="${ update.comId}">
                </td>
            </tr>
            <tr>
                <td>公司代码</td>
                <td>
               <input type="text" name="comCode" value="${update.comCode }">
                </td>
            </tr>
            <tr>
                <td>公司邮箱</td>
                <td><input type="text" name="comEmail" value="${update.comEmail }"></td>
            </tr>
            <tr>
                <td>联系人</td>
                <td><input type="text" name="comLinkman" value="${ update.comLinkman}"></td>
            </tr>
            <tr>
                <td>公司地址</td>
                <td><input type="text" name="comAddress" value="${ update.comAddress}"></td>
            </tr>
            <tr>
                <td>固定电话</td>
                <td><input type="text" name="comPhone" value="${update.comPhone }"></td>
            </tr>
             <tr>
                <td>移动电话</td>
                <td><input type="text" name="comYphone" value="${ update.comYphone}"></td>
            </tr>
             <tr>
                <td>传真</td>
                <td><input type="text" name="comFax" value="${update.comFax }"></td>
            </tr>
             <tr>
                <td>开户银行</td>
                <td>
                  <select   name="comBank">
      <option value="0">请选择--</option>
      <option value="1">招商银行</option>
      <option value="2">中国银行</option>
      <option value="3">建设银行</option>
      <option value="4">邮政银行</option>
      <option value="5">平安银行</option>
      </select>
            </tr>
             <tr>
                <td>银行账户</td>
                <td><input type="text" name="comBankuser" value="${update.comBankuser }"></td>
            </tr>
             <tr>
                <td>是否有效</td>
                <td>
                <select   name="comYesandno">
      			<option value="0">请选择--</option>
      			<option value="1">有效</option>
      			<option value="2">无效</option>
     			 </select>
                </td>
            </tr>
             <tr>
                <td>备注信息</td>
                <td><input type="text" name="comRemark" value="${update.comRemark }"></td>
            </tr>
            <tr>
             	<td></td>
                <td><input class="btn" type="submit" value="修改" ></td>
            </tr>
        </table>
    </form> 
</body>
</html>
