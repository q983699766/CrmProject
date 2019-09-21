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

.goodslist {
	width: 46%;
	float: left;
	height: 200px;
	padding: 10px;
	overflow: auto;
}

.goodslist_a {
	font-size: 12px;
	display: inline-block;
	padding: 0px 0px 0px 5px;
	margin-right: 8px;
	margin-bottom: 5px;
}

#addgoods_num>table {
	width: 100%;
	text-align: center;
}

#addgoods_num span {
	cursor: pointer;
}

#addgoods_num>div {
	text-align: right;
	padding-right: 40px;
	font-size: 18px;
}
</style>
</head>

<body>
	<div class="page-content clearfix">
		<div class="administrator">
			<div class="d_Confirm_Order_style">
				<div class="search_style">
					<div class="title_names">搜索查询</div>
					<form action="salCtl/salMessCtl" method="post">
						<ul class="search_content clearfix">

							<li><select name="type">
									<option value="0">订单号</option>
									<option value="1">关键字</option>
							</select> <input name="message" type="text" class="text_add"
								placeholder="" style=" width:400px" /></li>
							<li style="width:90px;"><button type="submit"
									class="btn_search">
									<i class="fa fa-search"></i>查询
								</button></li>
						</ul>
					</form>
				</div>
				<!--操作-->
				<div class="border clearfix">
					<span class="l_f"> 
					<a href="javascript:" id="administrator_add" class="btn btn-warning"><i class="fa fa-plus"></i> 添加新订单</a> 
					<a href="javascript:" id="administrator_dele" class="btn btn-danger" ><i class="fa fa-trash"></i> 批量删除订单</a>
				 	<!-- <a href="javascript:" class="btn btn-danger"><i class="fa fa-thumb-tack bigger-120"></i> 批量审核</a> -->
					</span>
				</div>
				<!--订单列表-->
				<div class="clearfix administrator_style" id="administrator">
					<!-- 订单分类 -->
					<!-- <div class="left_style">
		<div id="scrollsidebar" class="left_Treeview">
			<div class="show_btn" id="rightArrow"><span></span></div>
			<div class="widget-box side_content" >
			<div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
			<div class="side_list"><div class="widget-header header-color-green2"><h4 class="lighter smaller">订单分类列表</h4></div>
			<div class="widget-body">
			<ul class="b_P_Sort_list">
				<li><i class="orange  fa fa-reorder"></i><a href="#">全部订单</a></li>
				<li><i class="fa fa-sticky-note pink "></i> <a href="#">食品类</a></li>
				<li><i class="fa fa-sticky-note pink "></i> <a href="#">数码配件</a> </li>
				<li><i class="fa fa-sticky-note pink "></i> <a href="#">手机</a></li>
				<li><i class="fa fa-sticky-note pink "></i> <a href="#">电脑</a></li>
				<li><i class="fa fa-sticky-note pink "></i> <a href="#">厨房用品</a></li>
				<li><i class="fa fa-sticky-note grey "></i> <a href="#">电子产品</a></li>
				<li><i class="fa fa-sticky-note red  "></i> <a href="#">红钻会员</a></li>
				<li><i class="fa fa-sticky-note blue "></i> <a href="#">家用电器</a></li>
				<li><i class="fa fa-sticky-note grey "></i> <a href="#">卫浴</a></li>
			</ul>
			</div>
		</div>
		</div>  
		</div>
	  	</div>
		 -->
					<!-- 订单表格 -->

				</div>
				<div class="table_menu_list" id="testIframe">
					<table class="table table-striped table-bordered table-hover"
						id="sample_table">
						<thead>
							<tr>
								<th width="25px"><label><input type="checkbox"
										class="ace"><span class="lbl"></span></label></th>
								<th style="font-size:12px;width:8%;">编号</th>
								<th style="font-size:12px;width:8%;">创建日期</th>
								<th style="font-size:12px;width:12%;">发票编号</th>
								<th style="font-size:12px;width:10%;">用户名</th>
								<th style="font-size:12px;width:10%;">客户名</th>
								<th style="font-size:12px;width:10%;">销售金额</th>
								<th style="font-size:12px;width:10%;">出库状态</th>
								<th style="font-size:12px;width:8%;">返利</th>
								<th style="font-size:12px;width:10%;">订单状态</th>
								<th style="font-size:12px;width:10%;">备注</th>
								<th style="font-size:12px;width:10%;">公司</th>
								<th style="font-size:12px;width:10%;">操作</th>
							</tr>
						</thead>
						<tbody onmouseover="setsend()">
							<c:forEach items="${data.list}" var="bean">
								<tr class="pageinfo">
									<td><label><input type="checkbox" class="ace"><span
											class="lbl"></span></label></td>
									<td>${bean.orderId }</td>
									<td><span><fmt:formatDate value="${bean.createTime }" pattern="yyyy-MM-dd"/></span><br>
										<span><fmt:formatDate value="${bean.createTime }" pattern="hh:mm:ss" /></span></td>
									<td>${bean.invoiceNumber }</td>
									<td>${bean.user.userName }</td>
									<td>${bean.custom.customName }</td>
									<td>${bean.salMoney }</td>
									<td class="td-status"><span
										class="label ${bean.orderOutState eq 1 ? 'label-success' : 'label-danger'} radius">${bean.orderOutState eq 1 ? "已出库" : "未出库"}</span></td>
									<td>${bean.rebate eq 1 ? '是' : '否' }</td>
									<td class="td-status"><c:choose>
											<c:when test="${bean.orderState eq 0}">
												<span class="label label-secondary radius">等待支付</span>
											</c:when>
											<c:when test="${bean.orderState eq 1}">
												<span class="label label-warning radius">支付完成</span>
											</c:when>
											<c:when test="${bean.orderState eq 2}">
												<span class="label label-success radius">交易成功</span>
											</c:when>
											<c:when test="${bean.orderState eq 3}">
												<span class="label label-danger radius">交易失败</span>
											</c:when>
											<c:when test="${bean.orderState eq 4}">
												<span class="label label-success radius">通过审核</span>
											</c:when>
										</c:choose></td>
									<td>${bean.remark }</td>
									<td>${bean.company.comName }</td>
									<td class="td-manage"><a
										onClick="member_send(this,${bean.orderId },${bean.orderOutState})"
										style="cursor:not-allowed" href="javascript:;" title="审核"
										class="btn btn-xs btn-success"><i
											class="fa fa-thumb-tack bigger-120"></i></a>
										<div style="height:3px;"></div> <a title="编辑"
										onclick="member_edit(this,${bean.orderId })"
										href="javascript:;" class="btn btn-xs btn-info"><i
											class="fa fa-list bigger-120"></i></a>
										<div style="height:3px;"></div> <a title="删除"
										href="javascript:;"
										onclick="member_del(this,${bean.orderId })"
										class="btn btn-xs btn-warning"><i
											class="fa fa-trash  bigger-120"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr class="pagebotton">
								<td colspan="13" style="text-align: center"><a
									href="salCtl/salMessCtl?pageNum=${data.firstPage }&type=${type}&message=${message}">首页</a>
									<a id="prePage"
									href="salCtl/salMessCtl?pageNum=${data.prePage }&type=${type}&message=${message}">上一页</a>
									<a
									href="salCtl/salMessCtl?pageNum=${data.nextPage }&type=${type}&message=${message}">下一页</a>
									<a
									href="salCtl/salMessCtl?pageNum=${data.lastPage }&type=${type}&message=${message}">尾页</a>
									当前<span id="pageNum">${data.pageNum}</span>/<span id="pages">${data.pages}</span>页,共<span
									id="total">${data.total}</span>条</td>
							</tr>
						</tfoot>
					</table>
				</div>

			</div>
		</div>
		<!--添加详情-->
		<div id="add_details" class="add_menber" style="display:none">
			<div class="form-group" style="margin-top:20px;">
				<label class="form-label">客户：</label>
				<div class="formControls ">
					<span class="select-box" style="width:150px;"> <select
						class="select" id="custom" size="1">
					</select>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="form-label">备注：</label>
				<div class="formControls">
					<textarea name="" cols="" rows="" id="remark" class="textarea"
						placeholder="添加备注信息...100个字符以内" dragonfly="true"
						onkeyup="checkLength(this);" style="margin:0px;"></textarea>
					<span class="wordage">剩余字数：<span id="sy" style="color:Red;">100</span>字
					</span>
				</div>
				<div class="col-4"></div>
			</div>
		</div>
		<div id="add_goods" class="add_menber" style="display:none">
			<div>
				<!-- 搜索商品 -->
				<br>
				<div class="form-group">
					<label class="form-label">商品种类：</label>&nbsp;&nbsp; <select name=""
						id="CcSPLB">
						<option value="%">全部</option>
					</select>
				</div>
				<div class="form-group">
					<label class="form-label">搜索商品：</label> <input type="text"
						id="serch_goods_text">
				</div>
				<!-- 商品列表 -->
				<p>&nbsp;&nbsp;&nbsp;商品列表</p>
				<div class="goodslist" id="goodslist1"></div>
				<div class="goodslist" id="goodslist2"></div>
				<div class="goodslist" style="height:40px">
					总价格(经销价)：￥<span id="totalMoney">0</span>
				</div>
			</div>
		</div>
		<div id="addgoods_num" style="display:none">
			<p>产品明细：</p>
			<table>
				<tr>
					<td>产品名：</td>
					<td id="spMc">oppo reno 数据线</td>
				</tr>
				<tr>
					<td>类型：</td>
					<td id="spLb">电子件</td>
				</tr>
				<tr>
					<td>规格说明：</td>
					<td id="ggSm">oppo</td>
				</tr>
				<tr>
					<td>单位：</td>
					<td id="dw">oppo</td>
				</tr>
				<tr>
					<td>零售价：</td>
					<td id="lsj">2499</td>
				</tr>
				<tr>
					<td>经销价：</td>
					<td id="jxj">2499</td>
				</tr>
				<tr>
					<td>备注：</td>
					<td id="bzxx">自在飞花轻似梦，无边丝雨细如愁</td>
				</tr>
				<tr>
					<td>库存：</td>
					<td id="kcSl">222</td>
				</tr>
			</table>
			<div>
				<span><i class="fa fa-minus bigger-120"></i></span> <span id="num"
					contenteditable="true"
					style="-webkit-user-select:text;min-width:20px;display:inline-block;text-align:center">1</span>
				<span><i class="fa fa-plus  bigger-120"></i></span>
			</div>
			<div>
				<span>总金额(经销价)：<span id="totalM"></span></span>
			</div>
		</div>
		<div id="order_details" style="display:none;padding:10px;">
			<table style="width:100%;text-align:center">
				<tr>
					<td>发票编号:</td>
					<td id="invoiceNumber">111111</td>
					<td>创建时间:</td>
					<td id="createTime">XXXX</td>
				</tr>
				<tr>
					<td>客户:</td>
					<td id="customName">XXXX</td>
					<td>操作用户:</td>
					<td id="userName">XXXX</td>
				</tr>
				<tr>
					<td>出库状态:</td>
					<td id="orderOutState">XXXX</td>
					<td>订单状态:</td>
					<td id="orderstate">XXXX</td>
				</tr>
				<tr>
					<td>销售金额:</td>
					<td id="salMoney">XXXX</td>
					<td>是否返利:</td>
					<td id="rebate">XXXX</td>
				</tr>
				<tr>
					<td colspan="1">备注:</td>
					<td colspan="3" id="remark1">XXXX</td>
				</tr>
			</table>
			<br>
			<script type="text/javascript">
				//初始化订单详情
				function orderDetails(m){
					$("#invoiceNumber").html(m.invoiceNumber);
					$("#createTime").html(m.createTime.substr(0,19).replace("T", " "));
					$("#customName").html(m.custom.customName);
					$("#userName").html(m.user.userName);
					if(m.orderOutState)$("#orderOutState").html("已出库");
					else $("#orderOutState").html("未出库");
					switch(m.orderState){
						case 0 :$("#orderstate").html("等待支付");break;
						case 1 :$("#orderstate").html("支付完成");break;
						case 2 :$("#orderstate").html("交易成功");break;
						case 3 :$("#orderstate").html("交易失败");break;
						case 4 :$("#orderstate").html("通过审核");break;
					};
					$("#salMoney").html(m.salMoney);
					if(m.rebate)$("#rebate").html("是");
					else $("#rebate").html("否");
					$("#remark1").html(m.remark);
					var list = m.salDetailsList;
					$("#sal_details_table tbody").html("");
					//初始化修改商品弹层
					$("#totalMoney").html(m.salMoney);
					$("#goodslist2").html("");
					goods = {			//全局变量 用于存放添加订单的信息
						"customId":0
						,"remark":""
						,"totalM":0
						,"list":[]
						,"orderId":m.orderId
					};
					for(var i in list){
						$("#sal_details_table tbody").append(
							'<tr><td >'+list[i].product.spMc+'</td>'+
							'<td >'+list[i].product.ggSm+'</td>'+
							'<td >'+list[i].product.lsj+'</td>'+
							'<td >'+list[i].product.jxj+'</td>'+
							'<td >'+list[i].productCount+'</td>'+
							'<td >'+list[i].product.dw+'</td>'+
							'<td >'+list[i].productPrices+'</td>'					
						);
						$("#goodslist2").append(
						'<a href="javascript:" onclick="move(this)">'+list[i].product.spMc+'<span class="badge badge-light">'+list[i].productCount+'</span></a>')
						$($("#goodslist2").children()[i]).attr("data-num", list[i].product.kcSl)
						.attr("data-totalM",list[i].productPrices)
						.attr("id",list[i].product.productId)
						.attr("class","btn btn-secondary goodslist_a");
						goods.list.push({
						"name":list[i].product.spMc
						,"num":list[i].productCount
						,"id":list[i].productId
						,"money":list[i].productPrices
						})
					};
					
				}
			</script>
			<p>商品列表：</p>
			<table id="sal_details_table" class="table table-bordered table-hover table-striped" style="width:100%;text-align: center">
				<thead>
					<tr>
						<th style="font-size:12px;width:8%;text-align:center">产品名</th>
						<th style="font-size:12px;width:8%;text-align:center">规格</th>
						<th style="font-size:12px;width:8%;text-align:center">零售价</th>
						<th style="font-size:12px;width:8%;text-align:center">经销价</th>
						<th style="font-size:12px;width:8%;text-align:center">数量</th>
						<th style="font-size:12px;width:8%;text-align:center">单位</th>
						<th style="font-size:12px;width:8%;text-align:center">总价</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td >产品名</td>
						<td >规格</td>
						<td >零售价</td>
						<td >经销价</td>
						<td >数量</td>
						<td >单位</td>
						<td >总价</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="8" ><a href="javascript:" id="administrator_update">修改产品列表</a></td>
					</tr>
				</tfoot>
			</table>
		</div>
</body>
</html>

<script type="text/javascript">
	jQuery(function($) {
		var oTable1 = $('#sample_table').dataTable({
			"ordering" : false,
			"bStateSave" : true, //状态保存
			"bInfo" : false, //去掉显示数据条数
			"searching" : false, //去掉搜索框
			"paging" : false,
		});
		

		$('[data-rel="tooltip"]').tooltip({
			placement : tooltip_placement
		});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $source.offset();
			var w2 = $source.width();

			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
			return 'left';
		}
	});
</script>
<script type="text/javascript"> 
	var goods = {			//全局变量 用于存放添加订单的信息
			"customId":0
			,"remark":""
			,"totalM":0
			,"list":[]
			,"orderId":0
		};
	var checked = new Array();
	$(function() {
		var ischange = false;//用于商品信息搜索
		$("#administrator").fix({
			float : 'left',
			//minStatue : true,
			skin : 'green',	
			durationTime :false,
			spacingw:50,//设置隐藏时的距离
			spacingh:270,//设置显示时间距
		});
		/* 批量删除 */
		$("#administrator_dele").click(function(){
			layer.confirm('确认删除?', {icon: 3, title:'提示'}, function(index){
				$("#testIframe tbody tr").each(function(i, element) {
					if($(this).find("input:checkbox").get(0).checked){
						//console.log($(this).find("input:checkbox").get(0));
						//console.log($(this).find("td:nth-child(2)").html());
						checked.push($(this).find("td:nth-child(2)").html());
					}
				});
				if(checked.length > 0){
					//console.log(checked);
					$.ajax({
						type:"post"
						,url:"salCtl/salOrderdelets"
						,data:JSON.stringify(checked)
						,contentType:"application/json;charset=utf-8"
						,success:function(m){
							layer.msg('已成功删除', {
							  icon: 1,
							  time: 2000 
							  ,end:function(){location.reload();}
							})
						}
					})	
				}else{
					layer.msg('请勾选数据', {
					  icon: 5,
					  time: 1000 
					})
				};
			 	layer.close(index);
			});
		})
		
		
		/*数量减少*/
		$('.fa-minus').click(function() {
			var num = parseInt($("#num").html());
			if(num > 1)$("#num").html(num-1);
		});
		
		/*数量加*/
		$('.fa-plus').click(function() {
			var num = parseInt($("#num").html());
			var max = parseInt($("#kcSl").html());
			if(num < max)$("#num").html(num+1);
		});
		/*规范数量与金额*/
		$('#addgoods_num').click(function() {
			var num = parseInt($("#num").html());
			var max = parseInt($("#kcSl").html());
			var jxj = parseInt($("#jxj").html());
			if(num > max){
				$("#num").html(max);
			}
			if(num < 0){
				$("#num").html(1);
			}
			$("#totalM").html(parseInt($("#num").html())*jxj);
		})
		
		/*添加商品*/
		$('#administrator_add').on('click', function(event){
				var x = positionBody(event).x;
				var y = positionBody(event).y;
				y = y > 100 ? y-100:y;
				var that = this;
				var Interval = null;
				layer.open({
					type: 1
					,title:'添加商品'
					,area: ['700px','']
					,offset:[y,x]
					,shadeClose: true //是否点击遮罩关闭
					,content: $('#add_goods')
					,btn:['退出','下一步']
					,btn1:function(){
						if(Interval != null)clearTimeout(Interval);
					}
					,btn2:function(){
						//将总金额存到json
						goods.totalM = parseInt($("#totalMoney").html());
						//console.log(goods);
						layer.open({
							type:1
							,title:'订单详情'
							,content:$('#add_details')
							,offset:[y,x]
							,area: ['700px','']
							,shadeClose: true //是否点击遮罩关闭
							,btn:['返回','生成订单']
							,btn1:function(){
								that.click();
							}
							,btn2:function(){
								//将信息存到json custom remark
								goods.customId = $("#custom").val();
								goods.remark = $("#remark").val();
								$.ajax({
									type:"post"
									,url:"<%=basePath%>salCtl/salCreateOrder"
									,data:JSON.stringify(goods)
									,contentType:"application/json;charset=utf-8"
									,success:function(m){
										//清空json
										goods = {			
											"customId":0
											,"remark":""
											,"totalM":0
											,"list":[]
											,"orderId":0
										};
										$("#totalMoney").html("0");
										$("#goodslist2").html("");
										orderDetails(m);
										layer.open({
											type:1
											,title:'订单详情'
											,content:$('#order_details')
											,area:["500",""]
											,shadeClose:true
											,btn:['确定']
											,btn1:function(){
												//清空json
												goods = {			
													"customId":0
													,"remark":""
													,"totalM":0
													,"list":[]
													,"orderId":0
												};
												$("#totalMoney").html("0");
												$("#goodslist2").html("");
											}
											,cancel:function(){
												//清空json
												goods = {			
													"customId":0
													,"remark":""
													,"totalM":0
													,"list":[]
													,"orderId":0
												};
												$("#totalMoney").html("0");
												$("#goodslist2").html("");
											}
										});
									}
								}) 								
							}
							,cancel:function(){}
							,success:function(){
								$.ajax({
									type:"post"
									,url:"salCtl/selCustom"
									,success:function(m){
										$("#custom").html("");
										for(var i in m){
											$("#custom").append(
												'<option value="'+m[i].customId+'">'+m[i].customName+'</option>'
											);	
										}
									}
								})
							}
						})
					}
					,cancel:function(){
						if(Interval != null)clearTimeout(Interval);
					}
					,success:function(){
						//获取商品种类信息 
                		$.ajax({
                			type:"post"
                			,url:'salCtl/selSPLB'
                			,success:function(m){
                				//console.log(m);
                				$("#CcSPLB").children().each(function(i, element) {
                					if(i > 0)$(this).remove();//删除之前的种类信息
                				})
                				for(var i in m){
  									$("#CcSPLB").append('<option value="'+m[i]+'">'+m[i]+'</option>');
                				}
                				ischange = true;//更新商品列表
                			}
                		});
                		//给select绑定change事件
						$("#CcSPLB").change(function(e) {
							//console.log($("#CcSPLB").val());
							ischange = true;
						})
                		//循环获取输入框的值
                		Interval = setInterval(function() {
                			var newval = $("#serch_goods_text").val();
                			//如果输入框的值发生了改变，则把值绑定到元素上
                			if(newval != $("#serch_goods_text").attr("data-val")){
                				$("#serch_goods_text").attr("data-val",newval);
                				//console.log($("#serch_goods_text").val());
                				ischange = true;
                			};
                			if(ischange){
                				//console.log("ischange");
                				ischange = false;
                				var type = $("#CcSPLB").val();
                				var message = $("#serch_goods_text").val();
                				$.ajax({
                					type:"post"
                					,url:"salCtl/selSPXX"
                					,data:"type="+type+"&message="+message
                					,success:function(m){
                						if(m != ""){
                							$("#goodslist1").children().each(function(i, element) {
                								$(this).remove();
                							});
			                				for(var i in m){
												$("#goodslist1").append(
												'<a href="javascript:" class="btn btn-secondary goodslist_a" id="'+m[i].productId+'"'+
												'onclick="move(this)">'+m[i].spMc+'<span class="badge badge-light">'+m[i].kcSl+'</span></a>')
			                				}
                						}
                					}
                				})
                			}
                		}, 500);
					}
				});
		})
			
		/* 修改商品列表*/
		$('#administrator_update').on('click', function(event){
				var x = positionBody(event).x;
				var y = positionBody(event).y;
				y = y > 100 ? y-100:y;
				var that = this;
				var Interval = null;
				layer.open({
					type: 1
					,title:'添加商品'
					,area: ['700px','']
					,offset:[y,x]
					,shadeClose: true //是否点击遮罩关闭
					,content: $('#add_goods')
					,btn:['退出','确认']
					,btn1:function(){
						if(Interval != null)clearTimeout(Interval);
					}
					,btn2:function(){
						//将总金额存到json
						goods.totalM = parseInt($("#totalMoney").html());
						console.log(goods);
						$.ajax({
							type:"post"
							,url:"<%=basePath%>salCtl/salOrderUpdate"
							,data:JSON.stringify(goods)
							,contentType:"application/json;charset=utf-8"
							,success:function(m){
								//console.log(m);
								orderDetails(m);
							}
						})
					}
					,cancel:function(){
						if(Interval != null)clearTimeout(Interval);
					}
					,success:function(){
						//获取商品种类信息 
                		$.ajax({
                			type:"post"
                			,url:'salCtl/selSPLB'
                			,success:function(m){
                				//console.log(m);
                				$("#CcSPLB").children().each(function(i, element) {
                					if(i > 0)$(this).remove();//删除之前的种类信息
                				})
                				for(var i in m){
  									$("#CcSPLB").append('<option value="'+m[i]+'">'+m[i]+'</option>');
                				}
                				ischange = true;//更新商品列表
                			}
                		});
                		//给select绑定change事件
						$("#CcSPLB").change(function(e) {
							//console.log($("#CcSPLB").val());
							ischange = true;
						})
                		//循环获取输入框的值
                		Interval = setInterval(function() {
                			var newval = $("#serch_goods_text").val();
                			//如果输入框的值发生了改变，则把值绑定到元素上
                			if(newval != $("#serch_goods_text").attr("data-val")){
                				$("#serch_goods_text").attr("data-val",newval);
                				//console.log($("#serch_goods_text").val());
                				ischange = true;
                			};
                			if(ischange){
                				//console.log("ischange");
                				ischange = false;
                				var type = $("#CcSPLB").val();
                				var message = $("#serch_goods_text").val();
                				$.ajax({
                					type:"post"
                					,url:"salCtl/selSPXX"
                					,data:"type="+type+"&message="+message
                					,success:function(m){
                						if(m != ""){
                							$("#goodslist1").children().each(function(i, element) {
                								$(this).remove();
                							});
			                				for(var i in m){
												$("#goodslist1").append(
												'<a href="javascript:" class="btn btn-secondary goodslist_a" id="'+m[i].productId+'"'+
												'onclick="move(this)">'+m[i].spMc+'<span class="badge badge-light">'+m[i].kcSl+'</span></a>')
			                				}
                						}
                					}
                				})
                			}
                		}, 500);
					}
				});
		})
		
		
	
		/* 复选框 */
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
				.each(function(){
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});
		});
		
		//初始化宽度、高度   这个要放在所有jQuery语句后面
		//$(".widget-box").height($(window).height()-215); 
		$(".table_menu_list").width($(window).width()-30);
		//当文档窗口发生改变时 触发  
			$(window).resize(function(){
			//$(".widget-box").height($(window).height()-215);
			$(".table_menu_list").width($(window).width()-30);
			$(".table_menu_list").height($(window).height()-215);
			})
		laydate({
			elem: '#start',
			event: 'focus' 
		});
	});
	
	
	
	/* 移动商品 */	
	function move(obj,event){
		var x = positionBody(event).x;
		var y = positionBody(event).y;
		var id = $(obj).parent().attr("id");
		var num = $(obj).children("span").html();
		var goodsid = $(obj).attr("id");
		if(id == "goodslist1"){
			layer.open({
				type:1
				,title:'请选择添加商品的数量'
				,content:$('#addgoods_num')
				,area:["400",""]
				,offset:[y-200,x-200]
				,shadeClose:true
				,btn:['确定','取消']
				,btn1:function(){
					$('#addgoods_num').click();//避免未规范数量
					//先检查有没有重复添加
					if($("#goodslist2").children("#"+goodsid).size() > 0){
						layer.open({
						  offset:[y,x]
						  ,content:"是否继续添加?<br>(继续添加将覆盖原有商品)"
						  ,title:"重复的添加操作"
						  ,btn:["继续","取消"]
						  ,icon:3
						  ,btn1:function(){//移除掉重复的dom
							$("#goodslist2").children("#"+goodsid).remove();
							//移除数据
							var list = goods.list;
							for(var i in list){
								if(list[i].id == goodsid){
									$("#totalMoney").html($("#totalMoney").html()-list[i].money);
									goods.list.splice(i, 1);
								}
							}
							addgoodstoright(obj,goodsid);
						  }
						  ,btn2:function(){
						  }
						});
					}else{addgoodstoright(obj,goodsid);};
					
				}
				,btn2:function(){}
				,success:function(){
					$.ajax({
						type:"post"
						,url:"salCtl/selSPXXOne"
						,data:"id="+goodsid
						,success:function(m){
							$("#spMc").html(m.spMc);
							$("#spLb").html(m.spLb);
							$("#ggSm").html(m.ggSm);
							$("#dw").html(m.dw);
							$("#lsj").html(m.lsj);
							$("#jxj").html(m.jxj);
							$("#bzxx").html(m.bzxx);
							$("#kcSl").html(m.kcSl);
							$("#totalM").html(m.jxj);
							$("#num").html("1");
						}
					})
				}
			})
		}else{
			//先从总价中移除并更新总价
			var total = parseInt($(obj).attr("data-totalM"));
			var totalMoney = parseInt($("#totalMoney").html())
			totalMoney = totalMoney - total;
			$("#totalMoney").html(totalMoney);
			//改变样式，设置库存量
			$(obj).clone().attr("class", "btn btn-secondary goodslist_a")
			.appendTo("#goodslist1").children("span").html($(obj).attr("data-num"));
			$(obj).remove();//移除原先的
			//从json中移除商品
			var list = goods.list;
			for(var i in list){
				if(list[i].id == goodsid)list.splice(i,1);
			}
		}
	}
	
	function positionBody(event) {
	    var x, y;
	    var e = event || window.event;
	    x = e.clientX;
	    y = e.clientY;
	    return {
	        x: x,
	        y: y
	    }
	}
	
	//字数限制
	function checkLength(which) {
		var maxChars = 100; //
		if(which.value.length > maxChars){
		layer.open({
		icon:2,
		title:'提示框',
		content:'您输入的字数超过限制!',	
		});
			// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
			which.value = which.value.substring(0,maxChars);
			return false;
		}else{
			var curr = maxChars - which.value.length; //250 减去 当前输入的
			document.getElementById("sy").innerHTML = curr.toString();
			return true;
		}
	};
	
	
	


	//设置审核指针样式
	function setsend(){
		$("tbody").children().each(function(i, element) {
			var that = $(this);
			var outsta = $(that.children(".td-status")[0]).children("span").html();
			var ordersta = $(that.children(".td-status")[1]).children("span").html();
			if(outsta == "未出库" && ordersta == "支付完成"){
				$(that.children(".td-manage").children()[0]).attr("style", "");
			}
		})
	};
		
	function addgoodstoright(obj1,goodsid){
		var num = parseInt($("#num").html());
		var max = parseInt($("#kcSl").html());
		var totalM = parseInt($("#totalM").html());
		var totalMoney = parseInt($("#totalMoney").html())
		//将单商品总价计入总价
		totalMoney += totalM;
		//将库存数量放到data-value里，改变样式,添加到已选择的框中，将选中的数量加到html
		$(obj1).clone().attr("data-num",max).attr("data-totalM",totalM)
		.attr("class", "btn btn-success goodslist_a")
		.appendTo("#goodslist2").children("span").html(num);
		//移除原先的
		$(obj1).remove();
		//更新总价
		$("#totalMoney").html(totalMoney);
		//把添加的商品加入到json中
		goods.list.push({
		"name":$("#spMc").html()
		,"num":num
		,"id":goodsid
		,"money":totalM
		})
	};
	
	/*审核*/
	function member_send(obj,id){
		var ordernum = $($(obj).parents("tr").children()[3]).html();
		if($(obj).attr("style") == ""){
			layer.confirm('请确认要审核的订单编号:\n'+ordernum,function(index){
				$.ajax({
					type:"post",
					url:"salCtl/send",
					data:"orderid="+id,	
					success:function(){
						$($(obj).parents("tr").find(".td-status")[1]).html('<span class="label label-success radius">通过审核</span>');
						$(obj).attr("style", "cursor:not-allowed");
						layer.msg('已审核!',{icon: 1,time:1000});
					},
					error:function(){
						layer.msg('审核失败！请联系管理员!',{icon: 5,time:1000});
					}
				})
				
			});
		}
	}
	
	/*产品-编辑*/
	function member_edit(obj,id){
		$.ajax({
			type:"post"
			,url:"salCtl/salOrderDetails"
			,data:"id="+id
			,success:function(m){
				console.log(m);
				orderDetails(m);
				console.log(m);
				layer.open({
					type:1
					,title:'订单详情'
					,content:$('#order_details')
					,area:["500",""]
					,shadeClose:true
					,btn:['确定']
					,btn1:function(){
						//清空json
						goods = {			
							"customId":0
							,"remark":""
							,"totalM":0
							,"list":[]
							,"orderId":0
						};
						$("#totalMoney").html("0");
						$("#goodslist2").html("");
					}
					,cancel:function(){
						//清空json
						goods = {			
							"customId":0
							,"remark":""
							,"totalM":0
							,"list":[]
							,"orderId":0
						};
						$("#totalMoney").html("0");
						$("#goodslist2").html("");
					}
				});
			}
		})
		
		
	}

	/*产品-删除*******************************************************/
	function member_del(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type:"post",
				url:"salCtl/dele",
				data:"pageNum=${data.pageNum }&type=${type}&message=${message}&salid="+id,
				dateType:"json",
				success:function(m){
					$(obj).parents("tr").remove();
					//console.log(m);
					layer.msg('已删除!',{icon:1,time:1000});
					if($("tbody").children("tr").length < 1){
						$("#prePage").get(0).click();
					}
					else{
						//如果返回有5条数据则新增一条	
						if(m.list.length == 5){
							var bean = m.list[4];
							var orderOutState = {val:function(){
								if(bean.orderOutState == 1)return '<span class="label label-success radius">已出库</span>';
								return '<span class="label label-danger radius">未出库</span>';
							}};
							var rebate ={val:function(){
								if(bean.rebate == 1)return '是';
								return '否';
							}};
							var orderState = {val:function(){
								switch(bean.orderState){
									case 0 :return '<span class="label label-secondary radius">等待支付</span>';break;
									case 1 :return '<span class="label label-warning radius">支付完成</span>';break;
									case 2 :return '<span class="label label-success radius">交易成功</span>';break;
									case 3 :return '<span class="label label-danger radius">交易失败</span>';break;
									case 4 :return '<span class="label label-success radius">通过审核</span>';break;
								}
							}};
							var createTime = {val:function(){
								return '<span>'+bean.createTime.substr(0,10)+'</span><br>'+
								'<span>'+bean.createTime.substr(11,8)+'</span>';
								
								//bean.createTime.substr(0,19).replace("T"," ");
							}};
							$("tbody").append(
								'<tr class="pageinfo">'+
									'<td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>'+
									'<td>'+bean.orderId +'</td>'+
									'<td>'+createTime.val()+'</td>'+
									'<td>'+bean.invoiceNumber +'</td>'+
									'<td>'+bean.user.userName +'</td>'+
									'<td>'+bean.custom.customName +'</td>'+
									'<td>'+bean.salMoney +'</td>'+
									'<td class="td-status">'+orderOutState.val()+'</td>'+
									'<td>'+rebate.val()+'</td>'+
									'<td class="td-status">'+orderState.val()+'</td>'+
									'<td>'+bean.remark +'</td>'+
									'<td>'+bean.company.comName +'</td>'+
									'<td class="td-manage">'+
										'<a href="javascript:;" member_send(this,'+bean.orderId +','+bean.orderOutState+') style="cursor:not-allowed" title="审核"  class="btn btn-xs btn-success"><i class="fa fa-thumb-tack bigger-120"></i></a>'+
										'<div style="height:3px;"></div>  '+
										'<a title="编辑"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-list bigger-120"></i></a>'+       
										'<div style="height:3px;"></div>  '+
										'<a title="删除" href="javascript:;"  onclick="member_del(this,'+bean.orderId +')" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>'+
									'</td></tr>'
							);
						};
						//改变page
						$("#pages").html(m.pages);
						$("#total").html(m.total);
					}
				},
				error:function(){
					layer.msg('未成功删除!\n请联系管理员',{icon:1,time:1000});
				}
			});
			
		});
	}	
</script>