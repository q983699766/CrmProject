<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="assets/js/jquery.min.js"></script>
	<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/style.css"/>       
        <link href="assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/ace.min.css" />
        <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
			<script src="assets/js/jquery.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="assets/js/jquery.dataTables.min.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="js/H-ui.js"></script> 
        <script type="text/javascript" src="js/H-ui.admin.js"></script> 
        <script src="assets/layer/layer.js" type="text/javascript" ></script>
        <script src="assets/laydate/laydate.js" type="text/javascript"></script>

	

  </head>
  
  <body>
   	<div class="page-content clearfix">
    <div id="Member_Ratings">
      <div class="d_Confirm_Order_style">
    <div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">客户名称</label><input name="" type="text"  class="text_add" placeholder="输入客户名称、电话、邮箱"  style=" width:400px"/></li>
       <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>
     <!---->
     <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加客户</a>
        <a href="javascript:ovid()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a>
       </span>
     </div>
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th style="width:100px;font-size:12px;">客户编号</th>
				<th style="width:60px;font-size:12px;">客户名</th>
				<th style="width:30px;font-size:12px;">客户属性</th>
				<th style="width:60px;font-size:12px;">客户类型</th>
				<th style="width:80px;font-size:12px;">移动电话</th>
				<th style="width:100px;font-size:12px;">公司编号</th>
				<th style="width:90px;font-size:12px;">下次联系时间</th>
                <th style="width:50px;font-size:12px;">详细信息</th>
				<th style="width:50px;font-size:12px;">状态</th>                
				<th style="width:120px;font-size:12px;">操作</th>
			</tr>
		</thead>
	<tbody>
		<!-- <tr>
          <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
          <td>1</td>
          <td>张三</td>
          <td>政府人员</td>
          <td>VIP客户</td>
          <td>13478965432</td>
          <td class="text-l">2</td>
          <td>2014-6-11 11:11:42</td>
          <td><a href="javascript:ovid()" id="member_show" >查看客户</a></td>
          <td class="td-status"><span class="label label-success radius">正在合作</span></td>
          <td class="td-manage">
          <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
          <a title="编辑" onclick="member_edit('550')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
          <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
          <a href="javascript:;">联系人</a>
          </td>
		</tr> -->
		
		<c:forEach items="${pi.list }" var="per">
			<tr>
				<td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
				<td style="font-size:11px;">${per.customId }</td>
				<td style="font-size:11px;">${per.customName}</td>
				<td style="font-size:11px;">${per.customProperties}</td>
				<td style="font-size:11px;">${per.customType}</td>
				<td style="font-size:11px;">${per.cellPhone}</td>
				<td style="font-size:11px;">${per.comId}</td>
				<td style="font-size:11px;"><fmt:formatDate value="${per.nextcontactTime}"
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td style="font-size:11px;"><a href="javascript:ovid()" id="member_show" >查看客户</a></td>
				<td class="td-status"><span class="label label-success radius">${per.customState}</span></td>
				<td class="td-manage">
		          <a title="编辑" onclick="jia(${per.customId });member_edit('550');" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
		          <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
		          <a href="javascript:;">联系人</a>
		        </td>
			</tr>
			</c:forEach>
			<tr>
	           			<td colspan="12" style="text-align: center">
	           			<a href="conctrl/custom.do?pageNum=${pi.firstPage }">首页</a>
	           			<a href="conctrl/custom.do?pageNum=${pi.prePage }">上一页</a>
	           			<a href="conctrl/custom.do?pageNum=${pi.nextPage }">下一页</a>
	           			<a href="conctrl/custom.do?pageNum=${pi.lastPage }">尾页</a>
	           			当前${pi.pageNum}/${pi.pages}页,共${pi.total}条
	           		</td>
	           </tr>
      </tbody>
	</table>
   </div>
  </div>
 </div>
</div>
<!--添加用户图层-->
<form action="#" method="post">
<div class="add_menber" id="add_menber_style" style="display:none">
  
    <ul class=" page-content">
     <!-- <li style="display:hidden"><label class="label_name">客户编号：</label><span class="add_name"><input  type="text" id="customId" class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">客户名称：</label><span class="add_name"><input  type="text" name="客户名称" id="customName" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户属性：</label><span class="add_name"><input  type="text" name="客户属性" id="customProperties" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;站：</label><span class="add_name"><input  type="text" name="网站" id="website" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">股票代码：</label><span class="add_name"><input  type="text" name="股票代码" id="ticketCode" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">上级单位：</label><span class="add_name"><input name="上级单位" id="superiorUnits" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">所&nbsp;&nbsp;有&nbsp;&nbsp;者：</label><span class="add_name"><input  type="text" name="所有者" id="owner" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">员&nbsp;&nbsp;工&nbsp;&nbsp;数：</label><span class="add_name"><input  type="text" name="员工数" id="staff" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">行业编号：</label><span class="add_name"><input  type="text" name="行业编号" id="tradeNumber" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户类型：</label><span class="add_name"><input  type="text" name="客户类型" id="customType" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户来源：</label><span class="add_name"><input  type="text" name="客户来源" id="customSource" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">固定电话：</label><span class="add_name"><input  type="text" name="固定电话" id="fixedPhone" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">移动电话：</label><span class="add_name"><input  type="text" name="移动电话" id="cellPhone" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户传真：</label><span class="add_name"><input  type="text" name="客户传真" id="customFax" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">开户银行：</label><span class="add_name"><input  type="text" name="开户银行" id="depositBank" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">银行账户：</label><span class="add_name"><input  type="text" name="银行帐户" id="bankAccout" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">下次联系：</label><span class="add_name"><input  type="DATE" name="下次联系" id="nextcontactTime" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">电子邮件：</label><span class="add_name"><input  type="text" name="电子邮件" id="email" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">S&nbsp;I&nbsp;C编码：</label><span class="add_name"><input  type="text" name="SIC编码" id="sicCode" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">支付方式：</label><span class="add_name"><input  type="text" name="支付方式" id="payWay" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">是否有效：</label><span class="add_name"><input  type="text" name="是否有效" id="effectivity" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">详细地址：</label><span class="add_name"><input  type="text" name="详细地址" id="detailAddress" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息：</label><span class="add_name"><input  type="text" name="备注信息" id="remark" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">公司编号：</label><span class="add_name"><input  type="text" name="公司编号" id="comId" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户状态：</label><span class="add_name">
     <label><input name="form-field-radio1" type="radio" checked="checked" class="ace"><span class="lbl">正在合作</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio1"type="radio" class="ace"><span class="lbl">暂缓流失</span></label></span><div class="prompt r_f"></div></li>
    </ul>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="提交"></div>
 </div>
 </form>
 
 <!--修改用户图层-->
 <form action="#" method="post">
<div class="update_menber" id="update_menber_style" style="display:none"> 
    <ul class=" page-content">
     <!-- <li><label class="label_name">客户编号：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">客户名称：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户属性：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;站：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">股票代码：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">上机单位：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">所&nbsp;&nbsp;有&nbsp;&nbsp;者：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">员&nbsp;&nbsp;工&nbsp;&nbsp;数：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">行业编号：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户类型：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户来源：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">固定电话：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">移动电话：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户传真：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">开户银行：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">银行账户：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">下次联系：</label><span class="add_name"><input  type="DATE"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">电子邮件：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">S&nbsp;I&nbsp;C编码：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">支付方式：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">是否有效：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">详细地址：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">公司编号：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户状态：</label><span class="add_name">
     <label><input name="form-field-radio1" type="radio" checked="checked" class="ace"><span class="lbl">正在合作</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio1"type="radio" class="ace"><span class="lbl">暂缓流失</span></label></span><div class="prompt r_f"></div></li>
    </ul>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="提交"></div>
 </div>
 </form>
 
  <!--查看用户图层-->
  <form action="#" method="post"></form>
<div class="show_menber" id="show_menber_style" style="display:none">
  
    <ul class=" page-content">
     <li><label class="label_name">客户编号：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户名称：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户属性：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;站：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">股票代码：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">上机单位：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">所&nbsp;&nbsp;有&nbsp;&nbsp;者：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">员&nbsp;&nbsp;工&nbsp;&nbsp;数：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">行业编号：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户类型：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户来源：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">固定电话：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">移动电话：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户传真：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">开户银行：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">银行账户：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">下次联系：</label><span class="add_name"><input  type="DATE"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">电子邮件：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">S&nbsp;I&nbsp;C编码：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">支付方式：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">是否有效：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">详细地址：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">公司编号：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户状态：</label><span class="add_name">
     <label><input name="form-field-radio1" type="radio" checked="checked" class="ace"><span class="lbl">正在合作</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio1"type="radio" class="ace"><span class="lbl">暂缓流失</span></label></span><div class="prompt r_f"></div></li>
    </ul>
 </div>
 </form>
   	
  </body>
</html>
<script>
jQuery(function($) {
				var oTable1 = $('#sample-table').dataTable( {
				"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		] } );
				
				
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
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
			})
/*用户-添加*/
  $('#member_add').on('click', function(){
    layer.open({
        type: 1,
        title: '添加客户',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber_style'),
		yes:function(index,layero){	
		 var num=0;
		 var str="";
     $(".add_menber input[type$='text']").each(function(n){
          if($(this).val()=="")
          {
               
			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                title: '提示框',				
				icon:0,								
          }); 
		    num++;
            return false;            
          } 
		 });
		  if(num>0){  return false;}	 	
          else{
			  layer.alert('添加成功！',{
               title: '提示框',				
			icon:1,		
			  });
			   layer.close(index);	
		  }		  		     				
		}
    });
}); 
/*用户-查看*/
  $('#member_show').on('click', function(){
    layer.open({
        type: 1,
        title: '添加客户',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#show_menber_style'),
		
		yes:function(index,layero){	
		 var num=0;
		 var str="";
     $(".show_menber input[type$='text']").each(function(n){
          if($(this).val()=="")
          {
               
			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                title: '提示框',				
				icon:0,								
          }); 
		    num++;
            return false;            
          } 
		 });
		  if(num>0){  return false;}	 	
          else{
			  layer.alert('添加成功！',{
               title: '提示框',				
			icon:1,		
			  });
			   layer.close(index);	
		  }		  		     				
		}
    });
}); 
/*用户-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">暂缓流失</span>');
		$(obj).remove();
		layer.msg('暂缓流失!',{icon: 5,time:1000});
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">正在合作</span>');
		$(obj).remove();
		layer.msg('正在合作!',{icon: 6,time:1000});
	});
}
/*用户-编辑*/
function member_edit(id){
	  layer.open({
        type: 1,
        title: '修改用户信息',
		maxmin: true, 
		shadeClose:false, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#update_menber_style'),
		yes:function(index,layero){	
		 var num=0;
		 var str="";
     $(".update_menber input[type$='text']").each(function(n){
          if($(this).val()=="")
          {
               
			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                title: '提示框',				
				icon:0,								
          }); 
		    num++;
            return false;            
          } 
		 });
		  if(num>0){  return false;}	 	
          else{
			  layer.alert('添加成功！',{
               title: '提示框',				
			icon:1,		
			  });
			   layer.close(index);	
		  }		  		     				
		}
    });
}

function jia(customId)
    {
        var url="conctlr/selectById.do?customId="+customId;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {//从前台回调回来的数组，处理后的数据
       //alert(JSON.stringify(data));
         $("#customNamex").val(data.customName);//将取出的值覆盖原来的值 （val对值进行操作)			   
      }
    });
       
    }
/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
laydate({
    elem: '#start',
    event: 'focus' 
});

</script>


<style>
.update_menber{}
.update_menber li{ margin:10px 0px; height:40px; line-height:40px; float:left; width:50%}
.update_menber li.adderss{ width:100%}
.update_menber li .label_name,
.member_content li .label_name { width:80px; text-align:right; float:left; line-height:30px;}
.update_menber li .add_name{ float:left; margin-left:10px; line-height:30px;}
.update_menber li .add_name .lbl{ top:-5px; left:10px;}


.show_menber{}
.show_menber li{ margin:10px 0px; height:40px; line-height:40px; float:left; width:50%}
.show_menber li.adderss{ width:100%}
.show_menber li .label_name,
.member_content li .label_name { width:80px; text-align:right; float:left; line-height:30px;}
.show_menber li .add_name{ float:left; margin-left:10px; line-height:30px;}
.show_menber li .add_name .lbl{ top:-5px; left:10px;}
</style>
