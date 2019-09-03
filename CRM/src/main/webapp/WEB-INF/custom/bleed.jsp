<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
   
     <!---->
     <div class="border clearfix">
       <span class="l_f">
      	<p class="btn btn-danger">客户：张三</p>
        <a href="#"  class="btn btn-warning"><i class="icon-plus"></i>添加联系人</a>
        <a href="javascript:ovid()" class="btn btn-danger">查看联系记录</a>
       </span>
       <span class="r_f">共：<b>2345</b>条</span>
     </div>
     <!---->
     <div class="table_menu_list">
       <table style="1100px" class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th style="font-size:12px;width:10%;">联系人名</th>
				<th style="font-size:12px;width:8%;">英文名</th>
				<th style="font-size:12px;width:10%;">职务</th>
				<th style="font-size:12px;width:10%;">部门</th>
				<th style="font-size:12px;width:12%;">手机</th>
				<th style="font-size:12px;width:12%;">办公电话</th>
                <th style="font-size:12px;width:12%;">电子邮件</th>
				<th style="font-size:12px;width:15%;">地址</th>
				<th style="font-size:12px;width:12%">备注信息</th>                 
				<th style="font-size:12px;width:40px;">操作</th>
			</tr>
		</thead>
	<tbody>
		<tr>
          <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
          <td style="font-size:13px;">张三</td>
          <td style="font-size:13px;">SanZhang</td>
          <td style="font-size:13px;">客户经理</td>
          <td style="font-size:13px;w">销售部</td>
          <td style="font-size:13px;">13871753294</td>
          <td style="font-size:13px;">0710-3445921</td>
          <td style="font-size:13px;">123@163.com</td>
          <td style="font-size:13px;">隆中路206号六零九15栋</td>
          <td style="font-size:13px;">销售冠军</td>
          <td class="td-manage">
          <a title="编辑" onclick="member_edit('550')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
          <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
          </td>
		</tr>
      </tbody>
	</table>
   </div>
  </div>
 </div>
</div>

 
 <!--修改用户图层-->
 <form action="#" method="post">
<div class="update_menber" id="update_menber_style" style="display:none"> 
    <ul class=" page-content">
     <!-- <li><label class="label_name">客户编号：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">联系姓名：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">英&nbsp;&nbsp;文&nbsp;&nbsp;名：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">办公电话：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">电子邮件：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
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


/*用户-编辑*/
function member_edit(id){
	  layer.open({
        type: 1,
        title: '修改用户信息',
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
