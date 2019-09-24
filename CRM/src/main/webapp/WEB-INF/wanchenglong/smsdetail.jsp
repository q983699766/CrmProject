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

	<!--引入bootstrap的css文件-->
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
    <!--先引入jquery的js文件（bootstrap本身未自带，需拷贝）-->
    <%-- <script src="<%=basePath%>js/jquery.min.js"></script> --%>
    <!--再引入bootstrap的js文件-->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    
</head>

<body>
<div class="page-content clearfix">
    <div id="Member_Ratings">
      <div class="d_Confirm_Order_style">
    <div class="search_style">
      <form action="Office/selectdetailinfo.do" method="post">
      
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">请输入</label><input name="smsHeadline" type="text"  class="text_add" placeholder="输入消息标题"  style=" width:400px"/></li>
      <!--  <li><label class="l_f">添加时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li> -->
       <li style="width:90px;"><input type="submit" value="查询" class="btn_search"></i></li>
      </ul>
      </form>
    </div>
    
     <!---->
     <div class="border clearfix">
       <span class="l_f">
        <a onclick="jiaaa()" href="javascript:ovid()" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>发送信息</a>
        <%-- <a title="编辑" onclick="jia(${per.smsId });member_edit('550')" href="javascript:;"   >${per.officeSms.smsHeadline}</a> --%>
         <a href="detail/countunread.do"  class="btn btn-warning"></i>我的未读信息个数:${num} </a> 
        <a href="javascript:shanchu()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a>
       
       <script type="text/javascript">
						function shanchu() {
						//alert("進入刪除！！")
						document.getElementById("delmany").submit();
						var a=document.getElementsByName("test11");
						
						}
							
					</script>
       
       </span>
       
       
      
     </div>
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr class="success">
				<th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="80">ID</th>
				<th width="100">信息标题</th>
				<th width="80">接受人</th>
				
				<th width="120">接受人公司</th>
				<th width="150">接收时间</th>
				<th width="70">信息状态</th> 
				
                
				               
				<th width="250">操作</th>
			</tr>
		</thead>
	<tbody>
		<form action="Office/delallaa.do" id="delmany" method="post">
		
			<c:forEach items="${smsdetailinfo.list }" var="per">
				<tr>
					<td class="danger"><label><input type="checkbox" name="test11" value="${per.detailId }" class="ace"><span class="lbl"></span></label></td>
					<td style="font-size:11px;">${per.detailId }</td>
					<%-- <td style="font-size:11px;">${per.officeSms.smsHeadline}</td> --%>
					<td style="font-size:11px;"><a title="详情" onclick="jia(${per.detailId });member_edit('550')" href="javascript:;"   >${per.officeSms.smsHeadline}</a> </td>
				
					<td style="font-size:11px;">${per.sysUsers.userName}</td>
				
					<td style="font-size:11px;">${per.syscompany.comName}</td>
					<td style="font-size:11px;"><fmt:formatDate value="${per.lastTime}"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
				
				
				
					

					<c:if test="${per.smsState==1}">
						<td class="td-status"><span class="label label-danger radius">已阅读</span></td>
					</c:if>
					<c:if test="${per.smsState==0}">
						<td class="td-status"><span class="label label-warning radius">未阅读</span></td>
					</c:if>
					
				
					<td class="td-manage">
						<a title="设为未读"  class="btn btn-xs btn-success" href='Office/Officestate.do?id=${per.detailId }'><i class="icon-ok bigger-120"></i></a>
          				
          				<!-- <a title="编辑"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a>  -->
          			
          			 	<a title="删除"  onclick="delet(${per.detailId });member_del(this,'1')" href="javascript:;"   class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
          				
          			</td>
				
				
				</tr>
			</c:forEach>
		</form>
			
			<tr>
	           			<td colspan="12" style="text-align: center">
	           			<ul class="pagination"> 
	           			<li><a href="Office/selectdetailinfo.do?pageNum=${smsdetailinfo.firstPage }&smsHeadline=${smsHeadline}">首页</a></li>
	           			<li><a href="Office/selectdetailinfo.do?pageNum=${smsdetailinfo.prePage }&smsHeadline=${smsHeadline}">&laquo;上一页</a></li>
	           			<li><a href="Office/selectdetailinfo.do?pageNum=${smsdetailinfo.nextPage }&smsHeadline=${smsHeadline}">下一页&raquo;</a></li>
	           			<li><a href="Office/selectdetailinfo.do?pageNum=${smsdetailinfo.lastPage }&smsHeadline=${smsHeadline}">尾页</a></li>
	           			<!-- <li><a href="#">&raquo;</a></li> -->
	           			<li><a href="#">当前${smsdetailinfo.pageNum}/${smsdetailinfo.pages}页,共${smsdetailinfo.total}条</a></li>
	           			</ul>
	           			</td>
	           </tr>
	           
      </tbody>
	</table>
   </div>
  </div>
 </div>
</div>
<!--添加用户图层-->
<form action="Office/setstate.do" method="post" onsubmit="return yan(this)">
<div class="add_menber" id="add_menber_style" style="display:none">
  
    <ul class=" page-content">
     <li><label class="label_name">信息标题：</label><span class="add_name"><input style="border:none;" readonly="true" id="sms1" value="" name="用户名" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name"></label><span class="add_name"></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">信息内容：</label><span class="add_name"><textarea  style="resize: none;border:none;" readonly="true" id="sms2"  type="text"  class="text_add"></textarea></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">发送人：</label><span class="add_name"><input style="border:none;" readonly="true" id="sms3"  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">发送公司：</label><span class="add_name"><input style="border:none;" readonly="true" id="sms4"  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">发送时间：</label><span class="add_name"><input style="border:none;" readonly="true" id="sms5"  type="text"  dateFmt="yyyy-MM-dd HH:mm:ss"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <!-- <li><label class="label_name">发送时间：</label><span class="add_name"><input readonly="true" id="sms5"  type="text"  dateFmt="yyyy-MM-dd HH:mm:ss"  class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <%-- <fmt:formatDate value="${per.lastTime}" pattern="yyyy-MM-dd HH:mm:ss" /> --%>
    </ul><br>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="确定并关闭"></div><br><br><br><br><br><br>
 </div>
 </form>
 <script>
 function yan(c){
 //alert("进入js了");
		var id="";
		$(".actives").each(function(i,e) {		
			id += "id=" + $(this).attr("data-value")+"&";
		});
		c.action=c.action+"?"+id;
		//alert(c.action);
 
 }
 </script>
 
 <!--添加用户图层-->
<form action="Office/addsmsInfo.do" method="post" onsubmit="return yan(this)">
<div class="add_menber" id="add_sms_style" style="display:none">
  
    <ul class=" page-content">
     <!-- <li style="display:hidden"><label class="label_name">客户编号：</label><span class="add_name"><input  type="text" id="customId" class="text_add"/></span><div class="prompt r_f"></div></li> -->
     
   	<li><label class="label_name">接&nbsp;&nbsp;收&nbsp;&nbsp;人：：</label><select name="searchs" id="searchs" data-selector data-selector-checks="true"><option>接收人</option></select></li>
     <li><label class="label_name"></label><div class="prompt r_f"></div></li>
     <li><label class="label_name">信息标题：</label><span class="add_name"><input    type="text" name="smshidle" id="detail2" class="text_add"/></span><div class="prompt r_f"></div></li>
	<li><label class="label_name"></label><div class="prompt r_f"></div></li>
	<li><label class="label_name"></label><div class="prompt r_f"></div></li>
     <!-- <li><label class="label_name">接收人公司：</label><span class="add_name"><input  type="text" name="companyid" id="owner" class="text_add"/></span><div class="prompt r_f"></div></li> -->
	<li><label class="label_name"></label><div class="prompt r_f"></div></li>
     <li><label class="label_name">信息内容：</label><textarea style="resize: none;" style="width: 100%;height:100px; "   name="smsdetail1" id="detail3" ></textarea></li>


		<%-- <select id="rolesx" name="roleId"  data-selector data-selector-checks="true">
                <c:forEach items="${roles}" var="r" >
                <option value="${r.roleId }">${r.roleName }</option>
                </c:forEach>
            </select></span><div class="prompt r_f"></div></li> --%>
            
    </ul><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br>
    <div class="center" > <input onclick="changenum1()" class="btn btn-primary" type="submit" id="submit" value="发送"></div><br><br><br><br><br><br>
 </div>
 </form>
</body>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="asset/js/select.js"></script>
<script src="verSelector/verSelect.js"></script>
<script>
    new verSelector();
</script>
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
        title: '发送信息',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_sms_style'),
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

    });
}
/*用户-删除*/
/* function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
laydate({
    elem: '#start',
    event: 'focus' 
});

 */

/* 查看详情的ajax */
function jia(detail)
    {
        var url="detail/selectsmsById.do?detail="+detail;
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
    








/* 发送信息的ajax */
function jiaaa(smsId)
    {
        var url="detail/selectsmsuser.do";
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {
     /*  var roleName = data.roleName;	
         $("#roles").children().each(function(i, element) {
         	if(element.innerHTML == roleName)element.selected = "true";
         }); */
      
      
      
      
      var h="";
			          $.each(data,function(i,d)//两个参数，第一个参数表示遍历的数组的下标，第二个参数表示下标对应的值
			          {  
			              h+="<option value='"+d.userId+"'>"+d.userName+"</option>" 
			          });
			          $("#searchs").html(h); 
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

/*用户-删除ajax*/

 function delet(detailId)
    {
        var url="Office/delsmsInfo.do?detailId="+detailId;
        
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


	function changenum1(){
		var nums=window.top.document.getElementsByName('num');
		for(var i=0;i<nums.length;i++){nums[i].innerHTML="${num}+1";}
		}


</script>