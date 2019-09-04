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
       <li><label class="l_f">供应商编号</label><input name="" type="text"  class="text_add" placeholder="输入供应商名称、电话、联系人"  style=" width:400px"/></li>
       <!-- <li><label class="l_f">添加时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li> -->
       <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>
     <!---->
     <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" name="pursupinfo/goaddinfo.do" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加供应商信息</a>
        <a href="javascript:ovid()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a>
       </span>
     
     </div>
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th style="width:100px;font-size:12px;">供应商编号</th>
				<th style="width:60px;font-size:12px;">供应商名称</th>
				<th style="width:30px;font-size:12px;">联系人</th>
				<th style="width:60px;font-size:12px;">联系电话</th>
				<th style="width:80px;font-size:12px;">开户银行</th>
				<th style="width:100px;font-size:12px;">银行账号</th>
				<th style="width:90px;font-size:12px;">备注信息</th>
                <th style="width:50px;font-size:12px;">详细信息</th>
				<th style="width:50px;font-size:12px;">状态</th>                
				<th style="width:120px;font-size:12px;">操作</th>
			</tr>
		</thead>
	<tbody>
	 <c:forEach items="${pi.list}" var="i">
		<tr>
          <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
          <td>${i.supInfoNum}</td>
          <td>${i.supName}</td>
          <td>${i.contacts}</td>
          <td>${i.telphone}</td>
          <td>${i.openBank}</td>
          <td class="text-l">${i.bankNumber}</td>
          <td>${i.remarksInfo}</td>
          <td style="font-size:15px;"><a onclick="jia1(${i.supInfoNum }); href="javascript:ovid()" id="member_show" >查看详情</a></td>
          <td class="td-status"><span class="label label-success radius">${i.effectiveOrnot}</span></td>
          <td class="td-manage">
          <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
          <a title="编辑" onclick="jia(${i.supInfoNum });member_edit('550');" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
          <a title="删除" href="pursupinfo/delinfo.do?supInfoNum=${i.supInfoNum}"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
         
          </td>
		</tr>
       </c:forEach>
        
          <tr>
             <td colspan="11" style="text-align: center">
                  <a href="pursupinfo/selectinfo.do?pageNum=${pi.navigateFirstPage}">首页</a>   
                  <a href="pursupinfo/selectinfo.do?pageNum=${pi.prePage }">上一页</a>  
                  <a href="pursupinfo/selectinfo.do?pageNum=${pi.nextPage }">下一页</a>  
                  <a href="pursupinfo/selectinfo.do?pageNum=${pi.navigateLastPage }">尾页</a>  
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
<script type="text/javascript">
function yz(){
var a = document.getElementById("a").value;
if(a==""){
alert("供应商名称不能为空");
return false;
}
var b = document.getElementById("b").value;
if(b==""){
alert("供应商简称不能为空");
return false;
}
var c= document.getElementById("c").value;
if(c==""){
alert("联系人不能为空");
return false;
}
var d = document.getElementById("d").value;
if(d==""){
alert("固定电话不能为空");
return false;
}
var e = document.getElementById("e").value;
if(e==""){
alert("移动电话不能为空");
return false;
}
var f = document.getElementById("f").value;
if(f==""){
alert("联系传真不能为空");
return false;
}
var g = document.getElementById("g").value;
if(g==""){
alert("邮编不能为空");
return false;
}
var h = document.getElementById("h").value;
if(h==""){
alert("开户银行不能为空");
return false;
}
var i = document.getElementById("i").value;
if(i==""){
alert("银行账号不能为空");
return false;
}
var j = document.getElementById("j").value;
if(j==""){
alert("公司主页不能为空");
return false;
}
var k = document.getElementById("k").value;
if(k==""){
alert("备注信息不能为空");
return false;
}
var l = document.getElementById("l").value;
if(l==""){
alert("必选项");
return false;
}

}
</script>
<!-- //添加页面 -->
<form action="pursupinfo/addinfo.do" method="post" onsubmit="return yz()">
<div class="add_menber" id="add_menber_style" style="display:none">
   <ul class=" page-content">
     <!--  <li ><label class="label_name" style="width: 100px;">供应商编号：</label><span class="add_name"><input  type="text"  name="supInfoNum" class="text_add"/></span><div class="prompt r_f"></div></li>
      --> <li><label class="label_name" style="width: 100px;" >供应商名称：</label><span class="add_name"><input id="a" name="supName" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">供应商简称：</label><span class="add_name"><input id="b"name="supUname" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联系人：</label><span class="add_name"><input  id="c"name="contacts"type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">固定电话：</label><span class="add_name"><input id="d"name="fixedTel" type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">移动电话：</label><span class="add_name"><input id="e"name="telphone" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联系传真：</label><span class="add_name"><input  id="f"name="fax"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
     <!-- <li><label class="label_name" style="width: 100px;">联系地址：</label><span class="add_name"><input  type="text" name="联系地址" id="SUP_INFO_NUM"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联系邮编：</label><span class="add_name"><input  type="text" name="联系邮编" id="SUP_INFO_NUM"class="text_add"/></span><div class="prompt r_f"></div></li>
      --><li><label class="label_name" style="width: 100px;">邮箱：</label><span class="add_name"><input  id="g"name="email"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">开户银行：</label><span class="add_name"><input  id="h"name="openBank"type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">银行账号：</label><span class="add_name"><input  id="i"name="bankNumber"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">公司主页：</label><span class="add_name"><input  id="j" name="comIndex"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">备注信息：</label><span class="add_name"><input id="k" name="remarksInfo"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
    <!--  <li><label class="label_name" style="width: 100px;">公司编号：</label><span class="add_name"><input  type="text"  name="公司编号" id="COM_ID"class="text_add"/></span><div class="prompt r_f"></div></li>
  --> <li>
<!--       <label class="label_name" style="width: 100px;">状态：</label><span class="add_name">  -->
<!--       <input type="radio" checked="checked" name="effectiveOrnot">启用 -->
<!--       <input type="radio" name="effectiveOrnot">禁用 -->
 状态：<select name="effectiveOrnot" id="l"> 
     <option value="启用">启用</option>
      <option value="禁用">禁用</option>
    </select>
      
      </li>
<!--       <label><input name="form-field-radio1" type="radio" checked="checked" class="ace"><span class="lbl" name="">启用</span></label>&nbsp;&nbsp;&nbsp; -->
<!--       <label><input name="form-field-radio1"type="radio" class="ace"><span class="lbl">禁用</span></label></span><div class="prompt r_f"></div></li> -->
     </ul>
    <center><div> <input type="submit" value="提交" class="btn btn-primary"></div></center>
 </div>
 
 </form>
 <!--修改用户图层-->
<form action="pursupinfo/updateinfo.do">
<div class="update_menber" id="update_menber_style" style="display:none">
  
    <ul class=" page-content">
    <!--  <li><label class="label_name"  style="width: 100px;">供应商编号：</label><span class="add_name"><input  type="text" name="供应商编号" class="text_add"/></span><div class="prompt r_f"></div></li>
      --><li><label class="label_name"  style="width: 100px;">供应商名称：</label><span class="add_name"><input  type="text" name="供应商名称" class="text_add"/></span><div class="prompt r_f"></div></li>
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
    <center><div> <input type="submit" value="提交" class="btn btn-primary"></div></center>
    
 </div>
  
</form>
   
  <!--  //查看详情 -->
   <div class="update_menber" id="show_menber_style" style="display:none">
  
    <ul class=" page-content">
     <li><label class="label_name"  style="width: 100px;">供应商编号：</label><span class="add_name" id="pursupinfonum1"> $("#pursupinfonum1") </span><div class="prompt r_f"></div></li>
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
    <center><div> <input type="submit" value="提交" class="btn btn-primary"></div></center>
    
 </div>	
   	
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
/*用户-查看*/
  $('#member_show').on('click', function(){
    layer.open({
        type: 1,
        title: '详细信息',
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
//编辑函数
 function jia(supInfoNum)
    {
        var url="pursupinfo/updeinfo.do?supInfoNum="+supInfoNum;
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
    //查看函数
 function jia1(supInfoNum)
    {
        var url="pursupinfo/select.do?supInfoNum="+supInfoNum;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {//从前台回调回来的数组，处理后的数据
       //alert(JSON.stringify(data));
         $("#pursupinfonum1").val(data.pursupinfonum1);//将取出的值覆盖原来的值 （val对值进行操作)			   
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
