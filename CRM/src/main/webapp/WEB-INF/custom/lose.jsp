<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.sc.bean.SysUsers"%>
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
        <link rel="stylesheet" href="<%=basePath%>font/css/font-awesome.min.css" />
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
    <form action="conctlr/lose.do" method="post">
    <div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">客户名称</label><input name="message" type="text"  class="text_add" placeholder="输入客户名称"  style="width:400px"/></li>
       <li style="width:90px;"><input type="submit"  class="btn_search" value="查询"></li>
      </ul>
    </div>
   </form>
     <!---->
     
       <script type="text/javascript">
       function dell(){
       if(document.getElementById("box").checked == true){
       document.getElementById("myform").submit();
       }else{
       	confirm("请勾选！");
       }
       }
       </script>
       <br><br>
     <form action="conctlr/delAll.do" id="myform" method="post">
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25"><label><input type="checkbox"  class="ace"><span class="lbl"></span></label></th>
				<th style="width:100px;font-size:12px;">客户编号</th>
				<th style="width:60px;font-size:12px;">客户名</th>		
				<th style="width:60px;font-size:12px;">客户类型</th>
				<th style="width:80px;font-size:12px;">移动电话</th>
				<th style="width:90px;font-size:12px;">最后下单时间</th>
                <th style="width:50px;font-size:12px;">详细信息</th>
				<th style="width:50px;font-size:12px;">状态</th>                
				<th style="width:120px;font-size:12px;">操作</th>
			</tr>
		</thead>
	<tbody>
		
		<c:forEach items="${pi.list }" var="per">
			<tr>
				<td><label><input type="checkbox" id="box" name="box" value="${per.customId }" class="ace"><span class="lbl"></span></label></td>
				<td style="font-size:11px;">${per.customId }</td>
				<td style="font-size:11px;">${per.customName}</td>
				<td style="font-size:11px;">${per.customType}</td>
				<td style="font-size:11px;">${per.cellPhone}</td>
				<td style="font-size:11px;"><fmt:formatDate value="${per.salorder.createTime}"
				pattern="yyyy-MM-dd" /></td>
				<td style="font-size:11px;"><a href="javascript:" class="member_show" onclick="jia1(${per.customId })">查看客户</a></td>
				<td class="td-status"><span  class=" ${per.customState=='暂缓流失' ? 'label label-warning radius' : 'label label-active radius'}">${per.customState}</span></td>
	
				<c:if test="${per.customState=='暂缓流失'}">
				<td class="td-manage" style="font-size:11px;">
		          <a title="添加措施" href="javascript:ovid()" onclick="ajax(${per.customId },this);tc()" class="btn btn-xs btn-info ${empty per.salbleed ? '' : 'disabled'}" ><i class="icon-plus"></i></a>
		          <a title="修改措施" href="javascript:;" onclick="tc1(${per.customId});" class="btn btn-xs btn-success"><i class="icon-edit bigger-120"></i></a> 
		          <a title="流失审核" href="javascript:;" onclick="member_edit(id);ajax1(${per.customId});" class="btn btn-xs btn-danger"><i class="fa fa-thumb-tack bigger-120"></i></a> 
		        </td>
		        </c:if>
		        <c:if test="${per.customState=='已经流失'}">
		        <td class="td-manage" style="font-size:11px;">
		        	<center><span style="color:red;font-size:15px">已审核</span> &nbsp;&nbsp;
		        	<a title="客户恢复" onclick="return twice();" href="javascript:;"  class="btn btn-xs btn-primary"><i class="icon-undo bigger-120"></i></a> 
		        	<script type="text/javascript">
		        		function twice(){
		        			var customId=${per.customId};
		        			layer.confirm('是否恢复？',{
		        			btn:['是','否'],
		        			icon:0,
		        			},
		        			function(){
		        				location.href="conctlr/updateCustom.do?customId=${per.customId}";
		        				return true;
		        			},
		        			function(){
		        			
		        			
		        			}
		        			
		        			)
		        		};
		        	
		        	
		        	</script>
				</center>
				</td>   
		        </c:if>
		        
			</tr>
			</c:forEach>
			
			<tr>
	           			<td colspan="12" style="text-align: center">
	           			<a href="conctlr/lose.do?pageNum=${pi.firstPage }&message=${message}">首页</a>
	           			<a href="conctlr/lose.do?pageNum=${pi.prePage }&message=${message}">上一页</a>
	           			<a href="conctlr/lose.do?pageNum=${pi.nextPage }&message=${message}">下一页</a>
	           			<a href="conctlr/lose.do?pageNum=${pi.lastPage }&message=${message}">尾页</a>
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
<!--添加用户流失信息图层-->
<form action="conctlr/addSalBleed.do" method="post">
<div class="add_menber" id="add_menber_style" style="display:none;overfiow:scroll" >
  
    <ul class=" page-content">
    <%
     SysUsers users = (SysUsers) session.getAttribute("nowuser");
					Long userId = users.getUserId();
     %>
    
    <input type="hidden" name="customId" id="customId" value="${bleed.customId}" />
    <input type="hidden" name="operatorId" id="operatorId" value="<%=userId %>" />
     <!-- <li style="display:hidden"><label class="label_name">客户编号：</label><span class="add_name"><input  type="text" id="customId" class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">处理方式：</label><span class="add_name"><input  type="text" name="processingMode"  class="text_add"/></span><div class="prompt r_f"></div></li>     
     <li><label class="label_name">是否流失：</label><span class="add_name">
      <select style="margin-left:10px;" name="bleed"> 
     	<option  selected>请选择</option>
     	<option value="是">是</option>
     	<option value="否">否</option>
     </select></span></li>	 
     <li><label class="label_name">处理措施：</label><span class="add_name"><textarea rows="11%" cols="22%" type="text"  name="treatmentMeasures" style="resize:none;" class="text_add"></textarea></span><div class="prompt r_f"></div></li>
    </ul><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="提交"></div><br><br>
 </div>
 </form>
 
 <!--修改 用户流失信息图层 -->
 <form action="conctlr/updateSalBleed.do" method="post">
<div class="add_menber" id="update1_menber_style" style="display:none;overfiow:scroll" >
  
    <ul class=" page-content">
    <%
     SysUsers user1 = (SysUsers) session.getAttribute("nowuser");
					Long user1Id = user1.getUserId();
     %>
    
    <input type="hidden" name="churnId" id="churnId1" value="${bleed.churnId}" />
    <input type="hidden" name="customId" id="customId1" value="${bleed.customId}" />
    <input type="hidden" name="operatorId" id="operatorId1" value="<%=user1Id %>" />
     <!-- <li style="display:hidden"><label class="label_name">客户编号：</label><span class="add_name"><input  type="text" id="customId" class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">处理方式：</label><span class="add_name"><input  type="text" name="processingMode" id="processingMode1"  class="text_add"/></span><div class="prompt r_f"></div></li>     
     <li><label class="label_name">是否流失：</label><span class="add_name">
      <select style="margin-left:10px;" name="bleed" id="bleed1"> 
     	<option  selected>请选择</option>
     	<option value="是">是</option>
     	<option value="否">否</option>
     </select></span></li>	 
     <li><label class="label_name">处理措施：</label><span class="add_name"><textarea rows="11%" cols="22%" type="text" id="treatmentMeasures1"  name="treatmentMeasures" style="resize:none;" class="text_add"></textarea></span><div class="prompt r_f"></div></li>
    </ul><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="提交"></div><br><br>
 </div>
 </form>
 
 
 <!--审核流失操作图层-->
 <form action="conctlr/updateSalCustom.do" method="post">
<div class="add_menber" id="update_menber_styles" style="display:none;overfiow:scroll" >
  
    <ul class=" page-content">
    <%
     SysUsers user = (SysUsers) session.getAttribute("nowuser");
					Long usersId = users.getUserId();
     %>
    
    <input type="hidden" name="customId" id="customId2" value="${bleed.customId}" />
    <input type="hidden" name="operatorId" id="operatorId" value="<%=usersId %>" />
     <!-- <li style="display:hidden"><label class="label_name">客户编号：</label><span class="add_name"><input  type="text" id="customId" class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">处理方式：</label><span class="add_name"><input  type="text" name="processingMode" id="processingMode" readonly="readonly" class="text_add"/></span><div class="prompt r_f"></div></li>     
     <li><label class="label_name">是否流失：</label><span class="add_name"><input  type="text" name="bleed" id="bleed" readonly="readonly" class="text_add"/></span><div class="prompt r_f"></div></li>	 
     <li><label class="label_name">处理措施：</label><span class="add_name"><textarea rows="11%" cols="22%" type="text" id="treatmentMeasures" readonly="readonly"  name="treatmentMeasures" style="resize:none;" class="text_add"></textarea></span><div class="prompt r_f"></div></li>
    </ul><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <div class="center"> <input class="btn btn-primary"  type="submit" id="submit" value="确认审核"></div><br><br>
 </div>
 </form>
 
  <!--查看用户图层-->
  
<div class="show_menber" id="show_menber_style" style="display:none"> 
    <ul class=" page-content">
     <!-- <li><label class="label_name">客户编号：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">客户名称：</label><span class="add_name"><input  type="text" readonly="true" id="customNamex1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户属性：</label><span class="add_name"><input  type="text" readonly="true" id="customPropertiesx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;站：</label><span class="add_name"><input readonly="true" type="text" id="websitex1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">股票代码：</label><span class="add_name"><input readonly="true" type="text" id="ticketCodex1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">上级单位：</label><span class="add_name"><input readonly="true" type="text" id="superiorUnitsx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">所&nbsp;&nbsp;有&nbsp;&nbsp;者：</label><span class="add_name"><input readonly="true" type="text" id="ownerx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">员&nbsp;&nbsp;工&nbsp;&nbsp;数：</label><span class="add_name"><input readonly="true" type="text" id="staffx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">行业编号：</label><span class="add_name"><input readonly="true" type="text" id="tradeNumberx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户类型：</label><span class="add_name"><input readonly="true" type="text" id="customTypex1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户来源：</label><span class="add_name"><input readonly="true" type="text" id="customSourcex1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">固定电话：</label><span class="add_name"><input readonly="true" type="text" id="fixedPhonex1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">移动电话：</label><span class="add_name"><input readonly="true" type="text" id="cellPhonex1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">客户传真：</label><span class="add_name"><input readonly="true" type="text" id="customFaxx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">开户银行：</label><span class="add_name"><input readonly="true" type="text" id="depositBankx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">银行账户：</label><span class="add_name"><input readonly="true" type="text" id="bankAccoutx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">下次联系：</label><span class="add_name"><input readonly="true" type="DATE"  id="nextcontactTimex1"   dateFmt="yyyy-MM-dd HH:mm:ss" class="text_add" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">电子邮件：</label><span class="add_name"><input readonly="true" type="text" id="emailx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">S&nbsp;I&nbsp;C编码：</label><span class="add_name"><input readonly="true" type="text" id="sicCodex1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">支付方式：</label><span class="add_name"><input readonly="true" type="text" id="payWayx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">是否有效：</label><span class="add_name"><input readonly="true" type="text" id="effectivityx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">详细地址：</label><span class="add_name"><input readonly="true" type="text" id="detailAddressx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息：</label><span class="add_name"><input readonly="true" type="text" id="remarkx1" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">公司编号：</label><span class="add_name"><input readonly="true" type="text" id="comIdx1" class="text_add"/></span><div class="prompt r_f"></div></li>
    </ul>
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
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			})
/*用户-添加*/



function  tc(){
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
}


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
  $('.member_show').on('click', function(){
    layer.open({
        type: 1,
        title: '用户信息',
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

/*用户-编辑*/
function member_edit(id){
	  layer.open({
        type: 1,
        title: '流失信息审核',
		maxmin: true, 
		shadeClose:false, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#update_menber_styles'),
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


function tc1(customId){
	  layer.open({
        type: 1,
        title: '流失信息审核',
		maxmin: true, 
		shadeClose:false, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#update1_menber_style'),
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
		,success:function(){
			var url="conctlr/selectByCustomId.do?customId="+customId;
		   //ajax异步请求
		   $.ajax
		   ({
		      type:"post",
		      url:url,
		      dataType:"json",
		      success:function(data)
		      {//从前台回调回来的数组，处理后的数据 
		      $("#churnId1").val(data.churnId);
		      $("#customId1").val(data.customId);
		      $("#operatorId1").val(data.operatorId);
		      $("#processingMode1").val(data.processingMode);
		      $("#treatmentMeasures1").val(data.treatmentMeasures);
		      $("#bleed1").val(data.bleed);
		      }
		    });
		}
    });
}


/* 查看详情的ajax */
function jia1(customId)
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
       	 $("#customIdx1").val(data.customId);
         $("#customNamex1").val(data.customName);//将取出的值覆盖原来的值 （val对值进行操作)
         $("#customPropertiesx1").val(data.customProperties);
         $("#websitex1").val(data.website);
         $("#ticketCodex1").val(data.ticketCode);
         $("#superiorUnitsx1").val(data.superiorUnits);
         $("#ownerx1").val(data.owner);
         $("#staffx1").val(data.staff);
         $("#tradeNumberx1").val(data.tradeNumber);
         $("#customTypex1").val(data.customType);
         $("#customStatex1").val(data.customState);
         $("#customSourcex1").val(data.customSource);
         $("#fixedPhonex1").val(data.fixedPhone);
         $("#cellPhonex1").val(data.cellPhone);
         $("#customFaxx1").val(data.customFax);
         $("#depositBankx1").val(data.depositBank);
         $("#bankAccoutx1").val(data.bankAccout);
         $("#nextcontactTimex1").val(data.nextcontactTime.substr(0, 10));
         $("#emailx1").val(data.email);
         $("#sicCodex1").val(data.sicCode);
         $("#payWayx1").val(data.payWay);
         $("#effectivityx1").val(data.effectivity);
         $("#detailAddressx1").val(data.detailAddress);
         $("#remarkx1").val(data.remark);
         $("#comIdx1").val(data.comId);
         var customState = data.customState;
         if(customState == "正在合作"){
         	$(".ace[name=form-field-radio1]").get(2).checked = "true";
         }else{
         	$(".ace[name=form-field-radio1]").get(3).checked = "true";
         }	;	   
      }
    });
       
    }
    
    function ajax(customId,obj){
     var url="conctlr/goaddSalBleed.do?customId="+customId;
    
	   //ajax异步请求
	   $.ajax
	   ({
	      type:"post",
	      url:url,
	      dataType:"json",
	      success:function(data)
	      {//从前台回调回来的数组，处理后的数据 
	      $("#customId").val(data);    
	      //$($(obj).parent().children().get(0)).addClass("disabled");
	      }
	    });      	 
    }
    
      function ajax1(customId){
    	 var url="conctlr/selectByCustomId.do?customId="+customId;
    
	   //ajax异步请求
	   $.ajax
	   ({
	      type:"post",
	      url:url,
	      dataType:"json",
	      success:function(data)
	      {//从前台回调回来的数组，处理后的数据 
	      $("#churnId").val(data.churnId);
	      $("#customId2").val(data.customId);
	      $("#operatorId").val(data.operatorId);
	      $("#processingMode").val(data.processingMode);
	      $("#treatmentMeasures").val(data.treatmentMeasures);
	      $("#bleed").val(data.bleed);
	      $("#comId").val(data.comId);
	      $("#lastTime").val(data.lastTime);
	      }
	    });      	 
    }
    
    
    
    
    
   
/*用户-删除*/
function member_del(customId){
	layer.confirm('确认要删除吗？',function(index){
	     
		//$(obj).parents("tr").remove();
		document.location.href="conctlr/delSalCustomInfo.do?customId="+customId;
		layer.msg('已删除!',{icon:1,time:1000});
	});
}


/*用户-删除ajax*/

//   function del(customId)
//     {
//         var url="conctlr/delSalCustomInfo.do?customId="+customId;
        
// 	   //ajax异步请求
// 	   $.ajax
// 	   ({
// 	      type:"post",
// 	      url:url,
// 	      dataType:"json",
// 	      success:function(data)
// 	      {//从前台回调回来的数组，处理后的数据 
// 	      }
// 	    });
       
//     } 


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

