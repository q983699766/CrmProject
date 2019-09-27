<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>订单管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/style.css" />
<link href="assets/css/codemirror.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="font/css/font-awesome.min.css" />
<!--[if lte IE 8]>
  	<link rel="stylesheet" href="assets/css/ace-ie.min.css" />
	<![endif]-->
<script src="js/jquery-1.9.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="Widget/Validform/5.3.2/Validform.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>
<script src="assets/js/jquery.dataTables.min.js"></script>
<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="assets/layer/layer.js" type="text/javascript"></script>
<script src="js/lrtk.js" type="text/javascript"></script>
<script src="assets/layer/layer.js" type="text/javascript"></script>
<script src="assets/laydate/laydate.js" type="text/javascript"></script>
<style type="text/css">
td {
	font-size: 12px;
}
</style>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>编号</th>
				<th>用户</th>
				<th>访问ip</th>
				<th>权限</th>
				<th>访问时间</th>
				<th>公司</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${SysLog.list}" var="bean">
				<tr>
				<td>${bean.logId}</td>
				<td>${bean.user.userName}</td>
				<td>${bean.accessIp}</td>
				<td>${bean.permission}</td>
				<td><fmt:formatDate value="${bean.accessTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td>${bean.company.comName}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr class="pagebotton">
				<td colspan="5" style="text-align: center"><a
					href="syslogctrl/showLOg?pageNum=${SysLog.firstPage }">首页</a>
					<a id="prePage"
					href="syslogctrl/showLOg?pageNum=${SysLog.prePage }">上一页</a>
					<a
					href="syslogctrl/showLOg?pageNum=${SysLog.nextPage }">下一页</a>
					<a
					href="syslogctrl/showLOg?pageNum=${SysLog.lastPage }">尾页</a>
					当前<span id="pageNum">${SysLog.pageNum}</span>/<span id="pages">${SysLog.pages}</span>页,共<span
					id="total">${SysLog.total}</span>条
				</td>
				<td colspan="1" style="text-align: center">
					<a href="syslogctrl/excle.do">导出excle表</a>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>