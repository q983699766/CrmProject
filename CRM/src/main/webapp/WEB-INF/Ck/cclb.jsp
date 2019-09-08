<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<title>用户列表</title>
</head>

<body>
<div class="page-content clearfix">
    <div id="Member_Ratings">
      <div class="d_Confirm_Order_style">
    <div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">仓库编号</label><input name="" type="text"  class="text_add" placeholder="输入会员名称、电话、邮箱"  style=" width:400px"/></li>
       <li><label class="l_f">添加时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
       <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>
     <!---->
     <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加仓库</a>
        <a href="javascript:ovid()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a>
       </span>
       <span class="r_f">共：<b>${pi.total }</b>条</span>
     </div>
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 
		 <tr>
				<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="80px">仓库编号</th>
				<th width="250px">仓库名</th>
				<th width="100px">备注信息</th>
				<th width="100px">公司编号</th>
                <th width="100px">最后修改时间</th>				            
				<th width="200px">操作</th>
			</tr>
		</thead>
	<tbody>
	
    <c:forEach items="${pi.list }" var="u">
		<tr>
          <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
          <td>${u.ckBh }</td>
          <td><a href="ccckxxctlr/select1.do?ckBh=${u.ckBh}">${u.ckM }</a></td>       
          <td>${u.bzxx }</td>
          <td>${u.comId }</td>
          <td><fmt:formatDate value="${u.lastTime}" pattern="yyyy-MM-dd" /></td>         
         
          <td class="td-manage">          
          <a title="编辑"  onclick="jia(${u.ckBh});member_edit('550')" href="javascript:"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
          <a title="删除" href="javascript:;"  onclick="member_del(this,'${u.ckBh }')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a> 
          
          </td>
		</tr>
       </c:forEach>
      
      
       
	 <tr>
              <td colspan="15" style="text-align: center;">
                  <a href="ccckxxctlr/ck.do?pageNum=${pi.firstPage }">首页</a>
                  <a href="ccckxxctlr/ck.do?pageNum=${pi.prePage }">上一页</a>
                  <a href="ccckxxctlr/ck.do?pageNum=${pi.nextPage }">下一页</a>
                  <a href="ccckxxctlr/ck.do?pageNum=${pi.lastPage }">尾页</a>
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
<form action="ccckxxctlr/add.do" method="post">
<div class="add_menber" id="add_menber_style" style="display:none">
  
    <ul class=" page-content">     
     <li><label class="label_name">仓库名</label><span class="add_name"><input name="ckM" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息</label><span class="add_name"><input name="bzxx" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">公司编号</label><span class="add_name"><input name="comId" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <div class="prompt r_f"></div>
     </li>    
    <center>
    <label><input name="form-field-radio1"type="submit"  value="提交" class="btn btn-prompt r_f"><span class="lbl"></span></label></span><div class="prompt r_f"></div></li>   
 	</center>
 </div>
 </form>
 
 <!--修改用户图层  -->
 <form action="ccckxxctlr/updatecckcxx.do" method="post">
<div class="update_menber" id="update_menber_style" style="display:none">
  
    <ul class=" page-content">
     <input  type="hidden" id="ckBh2" name="ckBh" class="text_add"/> 
     <li><label class="label_name">仓库名</label><span class="add_name"><input id="ckM2" name="ckM" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息</label><span class="add_name"><input id="bzxx2" name="bzxx" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">公司编号</label><span class="add_name"><input id="comId2" name="comId" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <div class="prompt r_f"></div>
     </li> 
    
    <center>
    <label><input name="form-field-radio1"type="submit"  value="修改" class="btn btn-prompt r_f"><span class="lbl"></span></label></span><div class="prompt r_f"></div></li>   
 	</center>
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
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
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
        title: '添加用户',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber_style'),
		/* btn:['提交','取消'], */
		yes:function(index,layero){	
		 var num=0;
		 var str="";
     $(".add_menber input[type$='text']").each(function(n){
          if($(this).val()=="")
          {
               
			   layer.alert(str+=""+$(this).attr("#name")+"不能为空！\r\n",{
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
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
		$(obj).remove();
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		layer.msg('已启用!',{icon: 6,time:1000});
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
		//btn:['提交','取消'],
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
        $("#supInfoNum1").text(data.supInfoNum);
        $("#supName1").text(data.supName);
        $("#supUname1").text(data.supUname);
        $("#contacts1").text(data.contacts);
        $("#fixedTel1").text(data.fixedTel);
        $("#telphone1").text(data.telphone);
        $("#fax1").text(data.fax);
        $("#email1").text(data.email);
        $("#openBank1").text(data.openBank);
        $("#bankNumber1").text(data.bankNumber);
        $("#comIndex1").text(data.comIndex);
        $("#remarksInfo1").text(data.remarksInfo);
        $("#effectiveOrnot1").text(data.effectiveOrnot);bankNature1
            $("#bankNature1").text(data.bankNature);
             $("#comId1").text(data.comId);
        //将取出的值覆盖原来的值 （val对值进行操作)			   
  }
    });
       
    } 
//编辑函数
 function jia(ckBh)
    {
        var url="ccckxxctlr/select.do?ckBh="+ckBh;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {//从前台回调回来的数组，处理后的数据
 
      	$("#ckBh2").val(data.ckBh);
        $("#ckM2").val(data.ckM);//仓库名
        $("#bzxx2").val(data.bzxx);//备注信息
        $("#comId2").val(data.comId);//公司编号  
        $("#lastDate").val(data.lastDate);
      //将取出的值覆盖原来的值 （val对值进行操作)	
        
      }
    });
       
    } 




/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		//$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
		document.location.href="ccckxxctlr/del.do?uid="+id
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





