<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <link rel="stylesheet" href="css/style.css"/>       
    <link href="assets/css/codemirror.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/ace.min.css" />
    <link rel="stylesheet" href="font/css/font-awesome.min.css" />
    <!--[if lte IE 8]>
  	<link rel="stylesheet" href="assets/css/ace-ie.min.css" />
	<![endif]-->
	<script src="js/jquery-1.9.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="Widget/Validform/5.3.2/Validform.min.js"></script>
	<script src="assets/js/typeahead-bs2.min.js"></script>           	
	<script src="assets/js/jquery.dataTables.min.js"></script>
	<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
    <script src="assets/layer/layer.js" type="text/javascript" ></script>          
	<script src="js/lrtk.js" type="text/javascript" ></script>
    <script src="assets/layer/layer.js" type="text/javascript"></script>	
    <script src="assets/laydate/laydate.js" type="text/javascript"></script>
	<style type="text/css">
		td{
			font-size:12px;
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
    	
    	<li>
    	<select name="type">
    		<option value="0">订单号</option>
    		<option value="1">关键字</option>
    	</select>
    	<input name="message" type="text"  class="text_add" placeholder=""  style=" width:400px"/>
    	</li>
	  		<li style="width:90px;"><button type="submit" class="btn_search"><i class="fa fa-search"></i>查询</button>
	    </li> 
    </ul>
    </form>
    </div>
    <!--操作-->
     <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:" id="administrator_add" class="btn btn-warning"><i class="fa fa-plus"></i> 添加新订单</a>
		<a href="javascript:" class="btn btn-danger"><i class="fa fa-trash"></i> 批量删除订单</a>
		<a href="javascript:" class="btn btn-danger"><i class="fa fa-send-o bigger-120"></i> 批量发货</a>
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
     <div class="table_menu_list"  id="testIframe">
			<table class="table table-striped table-bordered table-hover" id="sample_table">
				<thead>
					<tr>
						<th width="25px">
						<label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
						<th style="font-size:12px;width:8%;">编号</th>
						<th style="font-size:12px;width:8%;">创建日期</th>
						<th style="font-size:12px;width:10%;">发票编号</th>
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
							<td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
							<td>${bean.orderId }</td>
							<td>
								<span><fmt:formatDate value="${bean.createTime }" pattern="yyyy-MM-dd"/></span>
								<span><fmt:formatDate value="${bean.createTime }" pattern="hh:mm:ss"/></span>
							</td>
							<td>${bean.invoiceNumber }</td>
							<td>${bean.user.userName }</td>
							<td>${bean.custom.customName }</td>
							<td>${bean.salMoney }</td>
							<td class="td-status"><span class="label ${bean.orderOutState eq 1 ? 'label-success' : 'label-danger'} radius">${bean.orderOutState eq 1 ? "已出库" : "未出库"}</span></td>
							<td>${bean.rebate eq 1 ? '是' : '否' }</td>
							<td class="td-status">
								<c:choose>
									<c:when test="${bean.orderState eq 0}"><span class="label label-secondary radius">等待支付</span></c:when>
									<c:when test="${bean.orderState eq 1}"><span class="label label-warning radius">支付完成</span></c:when>
									<c:when test="${bean.orderState eq 2}"><span class="label label-success radius">交易成功</span></c:when>
									<c:when test="${bean.orderState eq 3}"><span class="label label-danger radius">交易失败</span></c:when>
								</c:choose>
							</td>
							<td>${bean.remark }</td>
							<td>${bean.company.comName }</td>
							<td class="td-manage">
								<a onClick="member_send(this,${bean.orderId },${bean.orderOutState})" style="cursor:not-allowed" href="javascript:;" title="发货"  class="btn btn-xs btn-success" ><i class="fa fa-send-o bigger-120"></i></a>
								<div style="height:3px;"></div>  
								<a title="编辑" onclick="member_edit('编辑','transaction.jsp','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>       
								<div style="height:3px;"></div>  
								<a title="删除" href="javascript:;"  onclick="member_del(this,${bean.orderId })" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
							</td>
						</tr> 
					</c:forEach> 
				</tbody>
				<tfoot>
					<tr class="pagebotton">
	           			<td colspan="13" style="text-align: center">
		           			<a href="salCtl/salMessCtl?pageNum=${data.firstPage }&type=${type}&message=${message}">首页</a>
		           			<a id="prePage" href="salCtl/salMessCtl?pageNum=${data.prePage }&type=${type}&message=${message}">上一页</a>
		           			<a href="salCtl/salMessCtl?pageNum=${data.nextPage }&type=${type}&message=${message}">下一页</a>
		           			<a href="salCtl/salMessCtl?pageNum=${data.lastPage }&type=${type}&message=${message}">尾页</a>
		           			当前<span id="pageNum">${data.pageNum}</span>/<span id="pages">${data.pages}</span>页,共<span id="total">${data.total}</span>条
            			</td>
	           		</tr>
				</tfoot>
    		</table>
      </div>
     
  </div>
</div>
 <!--添加管理员-->
 <div id="add_administrator_style" class="add_menber" style="display:none">
    <form action="" method="post" id="form-admin-add">
		<div class="form-group">
			<label class="form-label"><span class="c-red">*</span>管理员：</label>
			<div class="formControls">
				<input type="text" class="input-text" value="" placeholder="" id="user-name" name="user-name" datatype="*2-16" nullmsg="用户名不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label"><span class="c-red">*</span>初始密码：</label>
			<div class="formControls">
			<input type="password" placeholder="密码" name="userpassword" autocomplete="off" value="" class="input-text" datatype="*6-20" nullmsg="密码不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label "><span class="c-red">*</span>确认密码：</label>
			<div class="formControls ">
		<input type="password" placeholder="确认新密码" autocomplete="off" class="input-text Validform_error" errormsg="您两次输入的新密码不一致！" datatype="*" nullmsg="请再输入一次新密码！" recheck="userpassword" id="newpassword2" name="newpassword2">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label "><span class="c-red">*</span>性别：</label>
			<div class="formControls  skin-minimal">
		      <label><input name="form-field-radio" type="radio" class="ace" checked="checked"><span class="lbl">保密</span></label>&nbsp;&nbsp;
            <label><input name="form-field-radio" type="radio" class="ace"><span class="lbl">男</span></label>&nbsp;&nbsp;
            <label><input name="form-field-radio" type="radio" class="ace"><span class="lbl">女</span></label>
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label "><span class="c-red">*</span>手机：</label>
			<div class="formControls ">
				<input type="text" class="input-text" value="" placeholder="" id="user-tel" name="user-tel" datatype="m" nullmsg="手机不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls ">
				<input type="text" class="input-text" placeholder="@" name="email" id="email" datatype="e" nullmsg="请输入邮箱！">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label">角色：</label>
			<div class="formControls "> <span class="select-box" style="width:150px;">
				<select class="select" name="admin-role" size="1">
					<option value="0">超级管理员</option>
					<option value="1">管理员</option>
					<option value="2">栏目主辑</option>
					<option value="3">栏目编辑</option>
				</select>
				</span> </div>
		</div>
		<div class="form-group">
			<label class="form-label">备注：</label>
			<div class="formControls">
				<textarea name="" cols="" rows="" class="textarea" placeholder="说点什么...100个字符以内" dragonfly="true" onkeyup="checkLength(this);"></textarea>
				<span class="wordage">剩余字数：<span id="sy" style="color:Red;">100</span>字</span>
			</div>
			<div class="col-4"> </div>
		</div>
		<div> 
        <input class="btn btn-primary radius" type="submit" id="Add_Administrator" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
	</form>
   </div>
 </div>
</body>
</html>
<script type="text/javascript">
		jQuery(function($) {
			var oTable1 = $('#sample_table').dataTable( {
				"aaSorting": [[ 1, "asc" ]],//默认第几个排序
				"bStateSave": true,//状态保存
				"bInfo":false, 		//去掉显示数据条数
				"searching":false,  //去掉搜索框
				"paging":false,
				"aoColumnDefs": [
				//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
				{"orderable":false,"aTargets":[0,3,4,5,7,8,9,10,11,12]}// 制定列不参与排序
				]
			});
		
			$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('table')
				var off1 = $parent.offset();
				var w1 = $parent.width();
		
				var off2 = $source.offset();
				var w2 = $source.width();
		
				if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
				return 'left';
			}
		});

	</script>
	<script type="text/javascript">
	$(function() { 
		$("#administrator").fix({
					float : 'left',
					//minStatue : true,
					skin : 'green',	
					durationTime :false,
					spacingw:50,//设置隐藏时的距离
					spacingh:270,//设置显示时间距
		});
		
		/*添加管理员*/
		$('#administrator_add').on('click', function(){
			layer.open({
			type: 1,
			title:'添加管理员',
			area: ['700px',''],
			shadeClose: false,
			content: $('#add_administrator_style'),
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
		$(".table_menu_list").height($(window).height()-215);
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
	
	
	


	//设置发货指针样式
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
		
	
	/*发货*/
	function member_send(obj,id){
		var ordernum = $($(obj).parents("tr").children()[3]).html();
		if($(obj).attr("style") == ""){
			layer.confirm('请确认要发货的订单编号:\n'+ordernum,function(index){
				$.ajax({
					type:"post",
					url:"salCtl/send",
					data:"orderid="+id,	
					success:function(){
						$($(obj).parents("tr").find(".td-status")[0]).html('<span class="label label-success radius">已出库</span>');
						$(obj).attr("style", "cursor:not-allowed");
						layer.msg('已发货!',{icon: 1,time:1000});
					},
					error:function(){
						layer.msg('发货失败！请联系管理员!',{icon: 5,time:1000});
					}
				})
				
			});
		}
	}
	
	/*产品-编辑*/
	function member_edit(title,url,id,w,h){
		layer_show(title,url,w,h);
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
								}
							}};
							var createTime = {val:function(){
								return bean.createTime.substr(0,19).replace("T"," ");
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
										'<a href="javascript:;" member_send(this,'+bean.orderId +','+bean.orderOutState+') style="cursor:not-allowed" title="发货"  class="btn btn-xs btn-success"><i class="fa fa-send-o bigger-120"></i></a>'+
										'<div style="height:3px;"></div>  '+
										'<a title="编辑"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>'+       
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