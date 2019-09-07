<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">会员名称</label><input name="" type="text"  class="text_add" placeholder="输入会员名称、电话、邮箱"  style=" width:400px"/></li>
       <li><label class="l_f">添加时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
       <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>
     <!---->
     <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加用户</a>
        <a href="javascript:ovid()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a>
       </span>
       <span class="r_f">共：<b>2345</b>条</span>
     </div>
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="80">ID</th>
				<th width="100">信息标题</th>
				<th width="80">接受者</th>
				
				<th width="120">公司名称</th>
				<th width="150">最后时间</th>
				<th width="70">信息状态</th> 
				
                
				               
				<th width="250">操作</th>
			</tr>
		</thead>
	<tbody>
			<!-- <tr>
          <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
          <td>1</td>
          <td><u style="cursor:pointer" class="text-primary" onclick="member_show('张三','member-show.html','10001','500','400')">张三</u></td>
          <td>男</td>
          <td>13000000000</td>
          <td>admin@mail.com</td>
          <td class="text-l">北京市 海淀区</td>
          <td>2014-6-11 11:11:42</td>
          <td>普通用户</td>
          <td class="td-status"><span class="label label-success radius">已启用</span></td>
          <td class="td-manage">
          <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
          <a title="编辑" onclick="member_edit('550')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
          <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
          </td>
		</tr> -->
		
		
		
		
		<c:forEach items="${smsdetailinfo }" var="per">
			<tr>
				<td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
				<td style="font-size:11px;">${per.detailId }</td>
				<%-- <td style="font-size:11px;">${per.officeSms.smsHeadline}</td> --%>
				<td style="font-size:11px;"><a title="编辑" onclick="jia(${per.smsId });member_edit('550')" href="javascript:;"   >${per.officeSms.smsHeadline}</a> </td>
				
				<td style="font-size:11px;">${per.sysUsers.userName}</td>
				
				<td style="font-size:11px;">${per.syscompany.comName}</td>
				<td style="font-size:11px;"><fmt:formatDate value="${per.lastTime}"
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
				
				
				
				<td class="td-status"><span class="label label-success radius">

				<c:if test="${per.smsState==1}">
					已阅读
				</c:if>
				<c:if test="${per.smsState==0}">
					未阅读
				</c:if>
				</span></td>
				
				<td class="td-manage">
					<%-- <a href='Office/Officestate.do?sta="+${per.smsState}+"&&id="+${per.detailId }+"'>确认设为未读</a> --%>
          			<a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
          			<a title="编辑"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
          			<a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
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
<div class="add_menber" id="add_menber_style" style="display:none">
  
    <ul class=" page-content">
     <li><label class="label_name">信息标题：</label><span class="add_name"><input readonly="true" id="sms1" value="" name="用户名" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">信息内容：</label><span class="add_name"><input readonly="true" id="sms2"  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">发送人：</label><span class="add_name"><input readonly="true" id="sms3"  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">公司名字：</label><span class="add_name"><input readonly="true" id="sms4"  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">发送时间：</label><span class="add_name"><input readonly="true" id="sms5"  type="text"  dateFmt="yyyy-MM-dd HH:mm:ss"  class="text_add"/></span><div class="prompt r_f"></div></li>
     
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
 $('#member_add').on('click', function(){
    layer.open({
        type: 1,
        title: '添加用户',
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
        title: '信息详细内容',
		maxmin: true, 
		shadeClose:false, //点击遮罩关闭层
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



/* 查看详情的ajax */
function jia(smsId)
    {
        var url="detail/selectsmsById.do?smsId="+smsId;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {//从前台回调回来的数组，处理后的数据
       //alert(JSON.stringify(data));
       	 $("#sms1").val(data.smsHeadline);
         $("#sms2").val(data.smsContent);//将取出的值覆盖原来的值 （val对值进行操作)
         $("#sms3").val(data.sysUsers.userName);
         $("#sms4").val(data.syscompany.comName);
         $("#sms5").val(data.lastTime);
         
         /* $("#superiorUnitsx").val(data.superiorUnits);
         $("#ownerx").val(data.owner);
         $("#staffx").val(data.staff);
         $("#tradeNumberx").val(data.tradeNumber);
         $("#customTypex").val(data.customType);
         $("#customStatex").val(data.customState);
         $("#customSourcex").val(data.customSource);
         $("#fixedPhonex").val(data.fixedPhone);
         $("#cellPhonex").val(data.cellPhone);
         $("#customFaxx").val(data.customFax);
         $("#depositBankx").val(data.depositBank);
         $("#bankAccoutx").val(data.bankAccout);
         $("#nextcontactTimex").val(data.nextcontactTime.substr(0, 10));
         $("#emailx").val(data.email);
         $("#sicCodex").val(data.sicCode);
         $("#payWayx").val(data.payWay);
         $("#effectivityx").val(data.effectivity);
         $("#detailAddressx").val(data.detailAddress);
         $("#remarkx").val(data.remark);
         $("#comIdx").val(data.comId);
         var customState = data.customState;
         if(customState == "正在合作"){
         	$(".ace[name=form-field-radio1]").get(2).checked = "true";
         }else{
         	$(".ace[name=form-field-radio1]").get(3).checked = "true";
         }	; */	   
      }
    });
       
    }
    





</script>