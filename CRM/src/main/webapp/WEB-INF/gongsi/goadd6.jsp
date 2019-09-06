<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
	<base href="<%=basepath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Insert title here</title>
</head>
<body>
<style>
table
{
    width: 800px;
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
select {
	 width: 300px;
    height: 30px;
	color:green;
}
</style>
					<center><h1>修改员工信息</h1></center>
    <form action="sysEmpuser/update.do" method="post" enctype="multipart/form-data" >
        <table>
            <tr>
                <td>员工姓名</td>
                <td>
                <input type="text" name="empName" value="${se.empName }">
                <input type="hidden" name="empId"value="${ se.empId}" >
                </td>
                 <td>员工性别</td>
                <td><input type="text" name="empSix" value="${ se.empSix}"></td>
            </tr>
            <tr>
                <td>员工照片</td>
                <td><input type="file" name="files"></td>
                 <td>身份证号</td>
                <td><input type="text" name="empNumber" value="${se.empNumber}"></td>
            </tr>
            <tr>
                <td>家乡地址</td>
                <td><input type="text" name="empAddress" value="${se.empAddress}"></td>
                 <td>现在地址</td>
                <td><input type="text" name="empTadayadd" value="${se.empTadayadd }"></td>
            </tr>
            <tr>
                <td>员工学历</td>
                <td><input type="text" name="empEduca" value="${se.empEduca }"></td>
                <td>政治面貌</td>
                <td><input type="text" name="empFace" value="${ se.empFace}"></td>
            </tr>
            <tr>
                <td>毕业学校</td>
                <td><input type="text" name="empSchool" value="${se.empSchool }"></td>
                <td>联系电话</td>
                <td><input type="text" name="empPhone" value="${se.empPhone }"></td>
            </tr>
           
            <tr>
                <td>网上联系方式</td>
                <td><input type="text" name="empMeshphone" value="${ se.empMeshphone}"></td>
                 <td>网上联系详情</td>
                <td><input type="text" name="empContact" value="${se.empContact }"></td>
            </tr>
           
            <tr>
                <td>审核状态</td>
                <td>
                <select   name="empState">
     		 <option value="0">请选择--</option>
     		 <option value="1">审核通过</option>
      		<option value="2">审核失败</option>
      				</select>
      		       </td>  
      		        <td>职务编号</td>
                <td><input type="text" name="dutId" value="${se.dutId }"></td>
            </tr>
            <tr>
              <td>员工状态</td>
                <td>
                	 <select   name="empSysstate" >
      <option value="0">请选择--</option>
      <option value="1">在职</option>
      <option value="2">离职</option>
      </select>
            </td>
             <td>备注信息</td>
                <td><input type="text" name="empRemark" value="${se.empRemark }"></td>
            </tr>
            <tr>
              <td>公司编号</td>
                <td>
                 <select name="comId">
                  <option value="0">请选择--</option>
                <c:forEach items="${m }" var="c">
               <option value="${c.comId}">${c.comName}</option>
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
