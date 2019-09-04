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
			<center><h1>添加员工信息</h1></center> 
    <form action="sysEmpuser/add.do" method="post" enctype="multipart/form-data" >
        <table>
            <tr>
                <td>员工姓名</td>
                <td>
                <input type="text" name="empName"  >
                <input type="hidden" name="empId" >
                </td>
            </tr>
            <tr>
                <td>员工性别</td>
                <td><input type="text" name="empSix"></td>
            	</tr>
            <tr>
                <td>员工照片</td>
                <td><input type="file" name="files"></td>
            </tr>
            <tr>
                <td>身份证号</td>
                <td><input type="text" name="empNumber"></td>
            </tr>
            <tr>
                <td>家乡地址</td>
                <td><input type="text" name="empAddress"></td>
            </tr>
            <tr>
                <td>现在地址</td>
                <td><input type="text" name="empTadayadd"></td>
            </tr>
            <tr>
                <td>员工学历</td>
                <td><input type="text" name="empEduca"></td>
            </tr>
            <tr>
                <td>政治面貌</td>
                <td><input type="text" name="empFace"></td>
            </tr>
            <tr>
                <td>毕业学校</td>
                <td><input type="text" name="empSchool"></td>
            </tr>
            <tr>
                <td>联系电话</td>
                <td><input type="text" name="empPhone"></td>
            </tr>
            <tr>
                <td>网上联系方式</td>
                <td><input type="text" name="empMeshphone"></td>
            </tr>
            <tr>
                <td>网上联系详情</td>
                <td><input type="text" name="empContact"></td>
            </tr>
            <tr>
                <td>审核状态</td>
                <td><input type="text" name="empState"></td>
            </tr>
            <tr>
              <td>职务编号</td>
                <td><input type="text" name="dutId"></td>
            </tr>
            <tr>
              <td>员工状态</td>
                <td><input type="text" name="empSysstate"></td>
            </tr>
            <tr>
              <td>备注信息</td>
                <td><input type="text" name="empRemark"></td>
            </tr>
            <tr>
              <td>公司编号</td>
                <td><input type="text" name="comId"></td>
            </tr>
            <tr>
             	<td></td>
                <td><input class="btn" type="submit" value="添加" ></td>
            </tr>
        </table>
    </form>
</body>
</html>
