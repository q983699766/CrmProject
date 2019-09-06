<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderTable.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/fresh-bootstrap-table.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.min.css" rel="stylesheet">
    <script type="text/javascript" src="assets/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap-table.js"></script>

  </head>
  
  <body>
     <table id="table"></table>
     <script type="text/javascript">
     	$(function(){
     		$('#table').bootstrapTable({
		    url: 'salCtl/salMessTable',
		    method:'post',
		    striped:true,//是否显示行间隔色
		    cache:false,//是否使用缓存，默认为true
		   // pagination:true, //是否显示分页
		    sortable:true,//是否启用排序
		    sortOrder:"asc", //排序方式
		   // sidePagination:"server",//分页方式为服务端分页，client客户端
		   // pageNumber:1,//初始化加载第一页，默认第一页，并记录
		   // pageSize:rows,	//每页记录的行数
		   // pageList:[10,25,50,100], //可供选择的每页行数
		    search:false,  //是否显示表格搜索，客户端的，所以不设置
		    strictSearch:true,
		    showColumns:true, //是否显示所有的列，或者选择显示的列
		    showRefresh:true,//是否显示刷新按钮
		    minimumCountColumns:2,//最少允许的列数
		    clickToSelect:true,//启用点击选中行
		    //height:500, //行高
		    uniqueId:"orderId", //主键列
		    showToggle: true, //是否显示详细视图和列表视图的切换按钮
	        cardView: false,  //是否显示详细视图
		    detailView: false,  //是否显示父子表
		    /* //设置请求的参数
            queryParams : function (params) {
                //这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
                var temp = {   
                    rows: params.limit,                         //页面大小
                    page: (params.offset / params.limit) + 1,   //页码
                    sort: params.sort,      //排序列名  
                    sortOrder: params.order //排位命令（desc，asc） 
                };
                return temp;
            }, */
		    columns: [{
                    checkbox: true,  
                    visible: true     //是否显示复选框          
                },{
			        field: 'orderId',
			        title: '订单编号'
			    }, {
			        field: 'createTime',
			        title: '创建日期',
			        //formatter: dateFormatter
			    }, {
			        field: 'invoiceNumber',
			        title: '发票编号'
			    },{
			        field: 'userId',
			        title: '用户id'
			    },{
			        field: 'customId',
			        title: '客户id'
			    },{
			        field: 'salMoney',
			        title: '销售金额'
			    },{
			        field: 'orderOutState',
			        title: '出库状态'
			    }, {
			        field: 'rebate',
			        title: '是否返利'
			    },{
			        field: 'orderState',
			        title: '订单状态'
			    },{
			        field: 'remark',
			        title: '备注'
			    },{
			        field: 'comId',
			        title: '公司id'
			    },{
                    field:'ID',
                    title: '操作',
                    width: 120,
                    align: 'center',
                    valign: 'middle',
                    //formatter: actionFormatter
                },
			    ],
			    onLoadSuccess: function () {
                },
                onLoadError: function () {
                    showTips("数据加载失败！");
                },
                onDblClickRow: function (row, $element) {
                    var id = row.ID;
                    EditViewById(id, 'view');
                },
			});
     	})
     
     </script>
  </body>
</html>
