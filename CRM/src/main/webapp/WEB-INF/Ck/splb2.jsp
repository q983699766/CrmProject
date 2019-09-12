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
<title>用户列表</title>
</head>

<body>
<div class="page-content clearfix">
    <div id="Member_Ratings">
      <div class="d_Confirm_Order_style">
    <div class="search_style">
    	
    	<font size="80">${aa.ckM }</font> 
    <form action="ccspxxctlr/mh.do" method="post">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">产品查询</label><input name="ccspxx" type="text"  class="text_add" placeholder="请输入产品名称:"  style=" width:400px"/></li>
       <li style="width:90px;"><button type="submit" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>
    </form>
     <!---->
     <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加用户</a>
        <a href="javascript:sc()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a>
       </span>
       <script type="text/javascript">
			function sc() 
			  {		
				var a=document.getElementsByName("bb");			
				for(var a0=0;a0<a.length;a0++)
				  {
					if(a[a0].checked)
					{								
						document.getElementById("cc").submit();
						return;
					}
				  }
				  
				  	alert("请选择你要删除的商品！");
			 
			   }
							
	  </script>
       
       <span class="r_f">共：<b>${pi.total }</b>条</span>
     </div>
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="80px">产品编号</th>
				<th width="250px">产品名称</th>
				<th width="100px">商品类型</th>
				<th width="100px">规格说明</th>
                <th width="100px">单位</th>				
				<th width="180px">仓库编号</th>
                <th width="80px">库存数量</th>
				<th width="70px">成本价</th>
				<th width="70px">零售价</th>  
				<th width="70px">经销价</th>
				<th width="250px">备注信息</th>
				<th width="70px">公司编号</th> 
				<th width="100px">最后修改时间</th>                 
				<th width="200px">操作</th>
			</tr>
		</thead>
	<tbody>
	<form action="ccspxxctlr/sc.do" id="cc" method="post">
	<c:forEach items="${aa.ccspxxb }" var="u" >
		<tr>
          <td><label><input type="checkbox" class="ace" name="bb" value="${u.productId}"><span class="lbl"></span></label></td>
          <td>${u.productId }</td>
          <td>${u.spMc }</td>
          <td>${u.spLb }</td>
          <td>${u.ggSm }</td>
          <td>${u.dw }</td>
          <td>${u.ckBh }</td>
          <td>${u.kcSl }</td>
          <td>${u.cbj }</td>
          <td>${u.lsj }</td>
          <td>${u.jxj }</td>
          <td>${u.bzxx }</td>
          <td>${u.comId }</td>
          <td><fmt:formatDate value="${u.lastTime}" pattern="yyyy-MM-dd" /></td>         
          <td class="td-manage">
          <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
          <a title="编辑" onclick="jia(${u.productId});member_edit('550')" href="javascript:"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
          <a title="删除" href="ccspxxctlr/del.do?productId=${u.productId }"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
          </td>
		</tr>
       </c:forEach>
       	</form>              
          <%-- <tr>
              <td colspan="15" style="text-align: center;">
                  <a href="ccckxxctlr/select1.do?pageNum=${aaaf.firstPage }">首页</a>
                  <a href="ccckxxctlr/select1.do?pageNum=${aaap.prePage }">上一页</a>
                  <a href="ccckxxctlr/select1.do?pageNum=${aaan.nextPage }">下一页</a>
                  <a href="ccckxxctlr/select1.do?pageNum=${aaal.lastPage }">尾页</a>
                                       当前${aaapn.pageNum }/${aaaps.pages }页
              </td>
           </tr> --%>
       
       
      </tbody>
	</table>
   </div>
  </div>
 </div>
</div>
<!--添加用户图层-->
<form action="ccspxxctlr/add.do" method="post">
<div class="add_menber" id="add_menber_style" style="display:none">
  
    <ul class=" page-content">
     <li><label class="label_name">商&nbsp;&nbsp;品 &nbsp;名：</label><span class="add_name"><input  name="spMc" type="text" class="text_add"  required /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">商品类型</label><span class="add_name"><input name="spLb" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">规格说明</label><span class="add_name"><input name="ggSm" type="text"  class="text_add" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">单位</label><span class="add_name"><input name="dw" type="text"  class="text_add" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">仓库编号</label><span class="add_name"><input name="ckBh" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">库存数量</label><span class="add_name"><input name="kcSl" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">成本价</label><span class="add_name"><input name="cbj" type="text"  class="text_add" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">零售价</label><span class="add_name"><input name="lsj" type="text"  class="text_add" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">经销价</label><span class="add_name"><input name="jxj" type="text"  class="text_add" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息</label><span class="add_name"><input name="bzxx" type="text"  class="text_add" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">公司编号</label><span class="add_name"><input name="comId" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <div class="prompt r_f"></div>
     </li> 
    
    <center>
    <label><input name="form-field-radio1"type="submit"  value="提交" class="btn btn-prompt r_f"><span class="lbl"></span></label></span><div class="prompt r_f"></div></li>   
 	</center>
 </div>

 </form>
 <!--修改用户图层  -->
 <form action="ccspxxctlr/updateccspxx.do" method="post">
<div class="update_menber" id="update_menber_style" style="display:none">
  
    <ul class=" page-content">
     <input  type="hidden" id="productId2" name="productId" class="text_add"/> 
     <li><label class="label_name">商&nbsp;&nbsp;品 &nbsp;名：</label><span class="add_name"><input id="spMc11"  name="spMc" type="text" class="text_add"  required /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">商品类别</label><span class="add_name"><input id="spLb2" name="spLb" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">规格说明</label><span class="add_name"><input id="ggSm2" name="ggSm" type="text"  class="text_add" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">单位</label><span class="add_name"><input id="dw2" name="dw" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">仓库编号</label><span class="add_name"><input id="ckBh2" name="ckBh" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">库存数量</label><span class="add_name"><input id="kcSl2" name="kcSl" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">成本价</label><span class="add_name"><input id="cbj2" name="cbj" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">零售价</label><span class="add_name"><input id="lsj2" name="lsj" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">经销价</label><span class="add_name"><input id="jxj2" name="jxj" type="text"  class="text_add" required/></span><div class="prompt r_f"></div></li>
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

//编辑函数
 function jia(productId)
    {
        var url="ccspxxctlr/select.do?productId="+productId;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {//从前台回调回来的数组，处理后的数据
      	$("#productId2").val(data.productId);
        $("#spMc11").val(data.spMc);//商品名
        $("#spLb2").val(data.spLb);//商品类型
        $("#ggSm2").val(data.ggSm);//规格说明
        $("#dw2").val(data.dw);//单位
        $("#ckBh2").val(data.ckBh);//仓库编号
        $("#kcSl2").val(data.kcSl);//库存数量
        $("#cbj2").val(data.cbj);//成本价
        $("#lsj2").val(data.lsj);//零售价
        $("#jxj2").val(data.jxj);//经销价
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
