<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>销售统计</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="<%=basePath%>css/style.css"/>
	<link rel="stylesheet" href="<%=basePath%>assets/css/font-awesome.min.css" />
	<link href="<%=basePath%>assets/css/codemirror.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=basePath%>font/css/font-awesome.min.css" />
	<!--[if lte IE 8]>
		<link rel="stylesheet" href="assets/css/ace-ie.min.css" />
	<![endif]-->
	<!--[if IE 7]>
		<link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
	<![endif]-->
	<!--[if lte IE 8]>
		<link rel="stylesheet" href="assets/css/ace-ie.min.css" />
	<![endif]-->
	<script src="<%=basePath%>assets/js/ace-extra.min.js"></script>
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
			<!--[if !IE]> -->
	<script src="<%=basePath%>js/jquery-1.9.1.min.js" type="text/javascript"></script>       
	<!-- <![endif]-->
	<script src="<%=basePath%>assets/dist/echarts.js"></script>
	<script src="<%=basePath%>assets/js/bootstrap.min.js"></script>
	<title>交易</title>
</head>

<body>
<div class=" page-content clearfix">
 <div class="transaction_style">
   <ul class="state-overview clearfix">
    <li class="Info">
     <span class="symbol red"><i class="fa fa-jpy"></i></span>
     <span class="value"><h4>交易金额</h4><p class="Quantity color_red">${salMessageBean.totalMoney}</p></span>
    </li>
     <li class="Info">
     <span class="symbol  blue"><i class="fa fa-shopping-cart"></i></span>
     <span class="value"><h4>订单数量</h4><p class="Quantity color_red">${salMessageBean.orderCount}</p></span>
    </li>
     <li class="Info">
     <span class="symbol terques"><i class="fa fa-shopping-cart"></i></span>
     <span class="value"><h4>交易成功</h4><p class="Quantity color_red">${salMessageBean.successOrderCount}</p></span>
    </li>
     <li class="Info">
     <span class="symbol yellow"><i class="fa fa-shopping-cart"></i></span>
     <span class="value"><h4>交易失败</h4><p class="Quantity color_red">${salMessageBean.failOrderCount}</p></span>
    </li>
     <li class="Info">
     <span class="symbol darkblue"><i class="fa fa-jpy"></i></span>
     <span class="value"><h4>退款金额</h4><p class="Quantity color_red">${salMessageBean.totalRebate}</p></span>
    </li>
   </ul>
 
 </div>
    <div class="t_Record">
    <div id="main" style="height:400px; overflow:hidden; width:100%; overflow:auto" ></div>     
    </div> 
</div>
</body>
</html>
<script type="text/javascript">
     $(document).ready(function(){
		 
            $(".t_Record").width($(window).width()-60);
            //当文档窗口发生改变时 触发  
        $(window).resize(function(){
            $(".t_Record").width($(window).width()-60);
            });
    });
        
        
    require.config({
                paths: {
                    echarts: './assets/dist'
                }
            });
    require(
		[
			'echarts',
			'echarts/theme/macarons',
			'echarts/chart/line',   // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
			'echarts/chart/bar'
		],
		function (ec,theme) {
			var myChart = ec.init(document.getElementById('main'),theme);
			option = {
				title : {
					text: '月购买订单交易记录',
					subtext: '实时获取用户订单购买记录'
				},
				tooltip : {
					trigger: 'axis'
				},
				legend: {
					data:['所有订单','待付款','已付款','待发货']
				},
				toolbox: {
					show : true,
					feature : {
						mark : {show: true},
						dataView : {show: true, readOnly: false},
						magicType : {show: true, type: ['line', 'bar']},
						restore : {show: true},
						saveAsImage : {show: true}
					}
				},
				calculable : true,
				xAxis : [
					{
						type : 'category',
						data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
					}
				],
				yAxis : [
					{
						type : 'value'
					}
				],
				series : [
					{
						name:'所有订单',
						type:'bar',
						data:[parseInt('${salMessageBean.orderCountGroupByMonth[0]}'),
							 parseInt('${salMessageBean.orderCountGroupByMonth[1]}'), 
							 parseInt('${salMessageBean.orderCountGroupByMonth[2]}'),
							 parseInt('${salMessageBean.orderCountGroupByMonth[3]}'),
							 parseInt('${salMessageBean.orderCountGroupByMonth[4]}'),
							 parseInt('${salMessageBean.orderCountGroupByMonth[5]}'),
							 parseInt('${salMessageBean.orderCountGroupByMonth[6]}'),
							 parseInt('${salMessageBean.orderCountGroupByMonth[7]}'),
							 parseInt('${salMessageBean.orderCountGroupByMonth[8]}'),
							 parseInt('${salMessageBean.orderCountGroupByMonth[9]}'),
							 parseInt('${salMessageBean.orderCountGroupByMonth[10]}'),
							 parseInt('${salMessageBean.orderCountGroupByMonth[11]}')
							 ],
						markPoint : {
							data : [
								{type : 'max', name: '最大值'},
								{type : 'min', name: '最小值'}
							]
						}           
					},
					{
						name:'待付款',
						type:'bar',
						data:[parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[0]}'),
							 parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[1]}'), 
							 parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[2]}'),
							 parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[3]}'),
							 parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[4]}'),
							 parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[5]}'),
							 parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[6]}'),
							 parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[7]}'),
							 parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[8]}'),
							 parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[9]}'),
							 parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[10]}'),
							 parseInt('${salMessageBean.waitPayOrderCountGroupByMonth[11]}')
							 ],
						markPoint : {
							data : [
								{type : 'max', name: '最大值'},
								{type : 'min', name: '最小值'}
							]
						},
					},
					{
						name:'已付款',
						type:'bar',
						data:[parseInt('${salMessageBean.havePayOrderCountGroupByMonth[0]}'),
							 parseInt('${salMessageBean.havePayOrderCountGroupByMonth[1]}'), 
							 parseInt('${salMessageBean.havePayOrderCountGroupByMonth[2]}'),
							 parseInt('${salMessageBean.havePayOrderCountGroupByMonth[3]}'),
							 parseInt('${salMessageBean.havePayOrderCountGroupByMonth[4]}'),
							 parseInt('${salMessageBean.havePayOrderCountGroupByMonth[5]}'),
							 parseInt('${salMessageBean.havePayOrderCountGroupByMonth[6]}'),
							 parseInt('${salMessageBean.havePayOrderCountGroupByMonth[7]}'),
							 parseInt('${salMessageBean.havePayOrderCountGroupByMonth[8]}'),
							 parseInt('${salMessageBean.havePayOrderCountGroupByMonth[9]}'),
							 parseInt('${salMessageBean.havePayOrderCountGroupByMonth[10]}'),
							 parseInt('${salMessageBean.havePayOrderCountGroupByMonth[11]}')
							 ],
						markPoint : {
							data : [
								{type : 'max', name: '最大值'},
								{type : 'min', name: '最小值'}
							]
						},
					}, 
					{
						name:'待发货',
						type:'bar',
						data:[parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[0]}'),
							 parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[1]}'), 
							 parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[2]}'),
							 parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[3]}'),
							 parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[4]}'),
							 parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[5]}'),
							 parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[6]}'),
							 parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[7]}'),
							 parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[8]}'),
							 parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[9]}'),
							 parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[10]}'),
							 parseInt('${salMessageBean.waitPutOrderCountGroupByMonth[11]}')
							 ],
						markPoint : {
							data : [
								{type : 'max', name: '最大值'},
								{type : 'min', name: '最小值'}
							]
						},
					}
				]
			};
			myChart.setOption(option);
		}
	);
</script> 
