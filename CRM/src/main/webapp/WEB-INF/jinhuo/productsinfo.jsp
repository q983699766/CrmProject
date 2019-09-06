<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
       <li><label class="l_f">产品信息</label><input name="" type="text"  class="text_add" placeholder="输入产品编号、名称"  style=" width:400px"/></li>
       <!-- <li><label class="l_f">添加时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li> -->
       <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>
     <!---->
     <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>生成送货单</a>
        <a href="javascript:ovid()" class="btn btn-danger"><i class="icon-trash"></i>批量生成送货单</a>
       </span>
    
     </div>
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th style="width:100px;font-size:12px;">编号</th>
				<th style="width:60px;font-size:12px;">产品编号</th>
				<th style="width:60px;font-size:12px;">产品名称</th>
                <th style="width:60px;font-size:12px;">单价</th>
				<th style="width:60px;font-size:12px;">数量</th>
				<th style="width:30px;font-size:12px;">交货时间</th>
				<th style="width:60px;font-size:12px;">备注信息</th>
				<th style="width:60px;font-size:12px;">状态</th>
				<th style="width:60px;font-size:12px;">总价</th>
				<th style="width:60px;font-size:12px;">操作人</th>
				<th style="width:120px;font-size:12px;">操作</th>
           </tr>
		</thead>
	<tbody>
	 <c:forEach items="${pi.list}" var="i">
		<tr>
          <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
          <td>${i.productId}</td>
          <td>${i.productId}</td>
          <td>${i.spMc}</td>
          <td>${i.cbj}</td>
          <%-- <td>${i.active}</td> --%>
           <td>${i.kcSl}</td>
          <td class="text-l">${i.bzxx}</td> 

         <%--  <td>${i.deliveryTime}</td> --%>
         <%--  <td>${i.active}</td> --%>
         <%--  <td>${i.price}</td> --%>
         <%--   <td class="text-l">${i.remarksInfo}</td>
          <td>${i.comId}</td> --%>

<%-- 
           <td>${i.lastDate}</td> 
          <td><a href="#">产品详情</a></td>--%>
         <td class="td-manage">
         <a title="生成送货单" href="pursupinfo/delinfo.do?supInfoNum=${i.productId}" class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
           <a title="删除" href="pursupinfo/delinfo.do?supInfoNum=${i.productId}"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
        

          </td> 
		</tr>
       </c:forEach>
          <tr >
              <td colspan="10" style="text-align: center;">
                  <a href="products/selectproducts.do?pageNum=${pi.firstPage }">首页</a>
                  <a href="products/selectproducts.do?pageNum=${pi.prePage }">上一页</a>
                  <a href="products/selectproducts.do?pageNum=${pi.nextPage }">下一页</a>
                  <a href="products/selectproducts.do?pageNum=${pi.lastPage }">尾页</a>
                                       当前${pi.pageNum }/${pi.pages }页，共${pi.total }条
              </td>
           </tr>
      </tbody>
	</table>
   </div>
  </div>
 </div>
</div>
<!--添加用户图层-->
<div class="add_menber" id="add_menber_style" style="display:none">
   <ul class=" page-content">
     <!-- <li ><label class="label_name" style="width: 100px;">供应商编号：</label><span class="add_name"><input  type="text" name="供应商编号" id="SUP_INFO_NUM" class="text_add"/></span><div class="prompt r_f"></div></li>
      --><li><label class="label_name" style="width: 100px;" >供应商名称：</label><span class="add_name"><input  type="text" name="供应商名称" id="supname"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">供应商简称：</label><span class="add_name"><input  type="text" name="供应商简称" id="SUP_UNAME"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联系人：</label><span class="add_name"><input  type="text"  name="联系人" id="CONTACTS"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">固定电话：</label><span class="add_name"><input  type="text"  name="固定电话" id="FIXED_TEL"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">移动电话：</label><span class="add_name"><input  type="text"  name="移动电话"id="TELPHONE"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联系传真：</label><span class="add_name"><input  type="text" name="联系传真" id="FAX"class="text_add"/></span><div class="prompt r_f"></div></li>
     <!-- <li><label class="label_name" style="width: 100px;">联系地址：</label><span class="add_name"><input  type="text" name="联系地址" id="SUP_INFO_NUM"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联系邮编：</label><span class="add_name"><input  type="text" name="联系邮编" id="SUP_INFO_NUM"class="text_add"/></span><div class="prompt r_f"></div></li>
      --><li><label class="label_name" style="width: 100px;">邮箱：</label><span class="add_name"><input  type="text"  name="邮箱" id="EMAIL"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">开户银行：</label><span class="add_name"><input  type="text"  name="开户银行" id="OPEN_BANK"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">银行账号：</label><span class="add_name"><input  type="text" name="银行账号" id="BANK_NUMBER"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">公司主页：</label><span class="add_name"><input  type="text"  name="公司主页" id="COM_INDEX"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">备注信息：</label><span class="add_name"><input  type="text" name="备注信息" id="REMARKS_INFO"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">公司编号：</label><span class="add_name"><input  type="text"  name="公司编号" id="COM_ID"class="text_add"/></span><div class="prompt r_f"></div></li>
  <li><label class="label_name" style="width: 100px;">状态：</label><span class="add_name"> 
    <label><input name="form-field-radio1" type="radio" checked="checked" class="ace"><span class="lbl">启用</span></label>&nbsp;&nbsp;&nbsp;
      <label><input name="form-field-radio1"type="radio" class="ace"><span class="lbl">禁用</span></label></span><div class="prompt r_f"></div></li>
     </ul>
 </div>
 
 <!--修改用户图层-->
<form action="">
<div class="update_menber" id="update_menber_style" style="display:none">
  
    <ul class=" page-content">
     <li><label class="label_name"  style="width: 100px;">供应商编号：</label><span class="add_name"><input  type="text" name="供应商编号" class="text_add" value="${goupdateinfo.pursupnumber}"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name"  style="width: 100px;">供应商名称：</label><span class="add_name"><input  type="text" name="供应商名称" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">供应商简称：</label><span class="add_name"><input  type="text" name="供应商简称" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联系人：</label><span class="add_name"><input  type="text"  name="联系人"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">固定电话：</label><span class="add_name"><input  type="text"  name="固定电话"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">移动电话：</label><span class="add_name"><input  type="text" name="移动电话" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联系传真：</label><span class="add_name"><input  type="text"  name="联系传真" class="text_add"/></span><div class="prompt r_f"></div></li>
     <!-- <li><label class="label_name" style="width: 100px;">联系地址：</label><span class="add_name"><input  type="text" name="联系地址" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联系邮编：</label><span class="add_name"><input  type="text"  name="联系邮编"class="text_add"/></span><div class="prompt r_f"></div></li>
     --> <li><label class="label_name" style="width: 100px;">邮箱：</label><span class="add_name"><input  type="text"  name="邮箱"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">开户银行：</label><span class="add_name"><input  type="text"  name="开户银行"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">银行账号：</label><span class="add_name"><input  type="text" name="银行账号" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">公司主页：</label><span class="add_name"><input  type="text"   name="公司主页"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">备注信息：</label><span class="add_name"><input  type="text" name="备注信息" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">公司编号：</label><span class="add_name"><input  type="text"  name="公司编号"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">状态：</label><span class="add_name">
     <label><input name="form-field-radio1" type="radio" checked="checked" class="ace"><span class="lbl">启用</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio1"type="radio" class="ace"><span class="lbl">禁止</span></label></span><div class="prompt r_f"></div></li>
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
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 5) ) return 'right';
					return 'left';
				}
			})
/*用户-添加*/

 $('#member_add').on('click', function(){
    layer.open({
        type: 1,
        title: '添加供应商信息',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber_style'),
		btn:['提交','取消'],
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
function member_show(title,url,id,w,h){
	layer_show(title,url+'#?='+id,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">禁止</span>');
		$(obj).remove();
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">有效</span>');
		$(obj).remove();
		layer.msg('启用成功!',{icon: 6,time:1000});
	});
}
/*用户-编辑*/

function member_edit(id){
	  layer.open({
        type: 1,
        title: '修改供应商信息',
		maxmin: true, 
		shadeClose:false, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#update_menber_style'),
		btn:['提交','取消'],
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
</style>
