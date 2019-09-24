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
	<script src="<%=basePath%>assets/js/jquery.min.js"></script>
	<link href="<%=basePath%>assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="<%=basePath%>css/style.css"/>       
        <link href="<%=basePath%>assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=basePath%>assets/css/ace.min.css" />
        <link rel="stylesheet" href="<%=basePath%>assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
			<script src="<%=basePath%>assets/js/jquery.min.js"></script>

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
		<script src="<%=basePath%>assets/js/bootstrap.min.js"></script>
		<script src="<%=basePath%>assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="<%=basePath%>assets/js/jquery.dataTables.min.js"></script>
		<script src="<%=basePath%>assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="<%=basePath%>js/H-ui.js"></script> 
        <script type="text/javascript" src="<%=basePath%>js/H-ui.admin.js"></script> 
        <script src="<%=basePath%>assets/layer/layer.js" type="text/javascript" ></script>
        <script src="<%=basePath%>assets/laydate/laydate.js" type="text/javascript"></script>

	

  </head>
  
  <body>
  
   	<div class="page-content clearfix">
    <div id="Member_Ratings">
      <div class="d_Confirm_Order_style">
    <form action="conctlr/back.do" method="post">
    <div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">记录优先级</label><input name="pri" type="text"  class="text_add" placeholder="请输入记录优先级"  style="width:400px"/></li>
       <li style="width:90px;"><input type="submit"  class="btn_search" value="查询"></li>
      </ul>
    </div>
   </form>
     <!---->
     
       <script type="text/javascript">
       function dell(){
       if(document.getElementById("myform").checked==true){
       document.getElementById("myform").submit();
       }else{
       	confirm("请勾选！");
       }
       }
       </script>
     <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加反馈记录</a>
        <a href="conctlr/custom.do"  class="btn btn-danger"><i class="icon-plus"></i>返回上一级</a>
       </span>
     
     </div>
     <form action="conctlr/delAll.do" id="myform" method="post">
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25"><label><input type="checkbox"  class="ace"><span class="lbl"></span></label></th>
				<th style="width:100px;font-size:12px;">记录优先级</th>
				<th style="width:30px;font-size:12px;">反馈类型</th>
				<th style="width:60px;font-size:12px;">反馈时间</th>
				<th style="width:100px;font-size:12px;">分析</th>
				<th style="width:90px;font-size:12px;">反馈主题</th>
                <th style="width:50px;font-size:12px;">反馈描述</th> 
                 <th style="width:50px;font-size:12px;">反馈来源</th>             
				<th style="width:120px;font-size:12px;">操作</th>
			</tr>
		</thead>
	<tbody>
		
		<c:forEach items="${pi.list }" var="feedback">
			<tr>
				<td><label><input type="checkbox" name="box"  class="ace"><span class="lbl"></span></label></td>
				<td style="font-size:11px;">${feedback.pri }</td>
				<td style="font-size:11px;">${feedback.feedbackType}</td>
				<td style="font-size:11px;"><fmt:formatDate value="${feedback.feedbackTime}"
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td style="font-size:11px;">${feedback.anaiusis}</td>
				<td style="font-size:11px;">${feedback.feedbackTopic}</td>
				<td style="font-size:11px;">${feedback.feedbackDesc}</td>
				<td style="font-size:11px;">${feedback.feedbackResource}</td>				
				<td class="td-manage">
		          <a title="删除" href="javascript:;"  onclick="member_del(this,'1');del(${feedback.feedbackId })" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
		        </td>
			</tr>
			</c:forEach>
			
			<tr>
	           			<td colspan="12" style="text-align: center">
	           			<a href="conctlr/feedback.do?pageNum=${pi.firstPage }">首页</a>
	           			<a href="conctlr/feedback.do?pageNum=${pi.prePage }">上一页</a>
	           			<a href="conctlr/feedback.do?pageNum=${pi.nextPage }">下一页</a>
	           			<a href="conctlr/feedback.do?pageNum=${pi.lastPage }">尾页</a>
	           			当前${pi.pageNum}/${pi.pages}页,共${pi.total}条
	           		</td>
	           </tr>
      </tbody>
	</table>
   </div>
   </form>
  </div>
 </div>
</div>
<!--添加用户图层-->
<form action="conctlr/addSalFeedback.do" method="post">
<div class="add_menber" id="add_menber_style" style="display:none;overfiow:scroll">
   
    <ul class=" page-content">
    <input type="hidden" name="customId" value="${customId}" /> 
 	<input type="hidden" name="empId" value="${nowuser.empId}" /> 
  	<input type="hidden" name="states"  id="states" />
     <!-- <li style="display:hidden"><label class="label_name">客户编号：</label><span class="add_name"><input  type="text" id="customId" class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">优&nbsp;&nbsp;先&nbsp;&nbsp;级：</label><span class="add_name">
     <select style="margin-left:10px;" name="pri">
     	<option value="" selected>请选择</option>
     	<option value="高" >高</option>
     	<option value="中">中</option>
     	<option value="低">低</option>
     </select></span></li>
     <li><label class="label_name">反馈类型：</label><span class="add_name">
      <select style="margin-left:10px;" name="feedbackType"> 
     	<option value="请选择" selected>请&nbsp;选&nbsp;择</option>
     	<option value="线上调查">线上调查</option>
     	<option value="电话回访">电话回访</option>
     	<option value="线下走访">线下走访</option>
     </select></span></li>    
     <li><label class="label_name">反馈主题：</label><span class="add_name"><input  type="text" name="feedbackTopic"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">反馈时间：</label><span class="add_name"><input  type="DATE" name="feedbackTime" dateFmt="yyyy-MM-dd"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;析：</label><span class="add_name"><textarea rows="4" cols="20" name="anaiusis" style="resize:none;" class="text_add"></textarea></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="margin-top:20px;">反馈描述：</label><span class="add_name"><textarea rows="4" cols="20" name="feedbackDesc"  class="text_add" style="resize:none;"></textarea></span><div class="prompt r_f"></div></li> 
      <li><label class="label_name" style="margin-top:20px;">反馈来源：</label><span class="add_name"><textarea rows="4" cols="20" name="feedbackResource"  class="text_add" style="margin-top:30px;resize:none;"></textarea></span><div class="prompt r_f"></div></li>    
    </ul><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="提交"></div><br><br>
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

/*用户-删除ajax*/

 function del(feedbackId)
    {
        var url="conctlr/delSalFeedback.do?feedbackId="+feedbackId;
        
	   //ajax异步请求
	   $.ajax
	   ({
	      type:"post",
	      url:url,
	      dataType:"json",
	      success:function(data)
	      {//从前台回调回来的数组，处理后的数据 
	      }
	    });
       
    }


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
