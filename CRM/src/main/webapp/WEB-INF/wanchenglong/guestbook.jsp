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
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
 		<link href="<%=basePath%>assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="<%=basePath%>css/style.css"/>       
        <link href="<%=basePath%>assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=basePath%>assets/css/ace.min.css" />
        <link rel="stylesheet" href="<%=basePath%>font/css/font-awesome.min.css" />
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
        <script src="<%=basePath%>assets/js/bootstrap.min.js"></script>
		<script src="<%=basePath%>assets/js/typeahead-bs2.min.js"></script>           	
		<script src="<%=basePath%>assets/js/jquery.dataTables.min.js"></script>
		<script src="<%=basePath%>assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="<%=basePath%>assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="<%=basePath%>assets/laydate/laydate.js" type="text/javascript"></script>
<title>留言</title>

<!--引入bootstrap的css文件-->
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
    <!--先引入jquery的js文件（bootstrap本身未自带，需拷贝）-->
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <!--再引入bootstrap的js文件-->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
</head>

<body onload="load()">
<div class="margin clearfix">
 <div class="Guestbook_style">
 <div class="search_style">
 	<form action="Office/selectinfo.do" method="post">
 	
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">请输入</label><input name="smsHeadline" type="text"  class="text_add" placeholder="输入消息标题"  style=" width:400px"/></li>
       <!-- <li><label class="l_f">请输入</label><input name="" type="text" class="text_add" placeholder="输入留言信息" style=" width:250px"></li> -->
       <!-- <li><label class="l_f">时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li> -->
       <li style="width:90px;"><button type="submit" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
      </form>
    </div>
    <div class="border clearfix">
       <span class="l_f">
       	<a href="javascript:shanchu()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a>
        <!-- <a href="javascript:ovid()" class="btn btn-danger"><i class="fa fa-trash"></i>&nbsp;批量删除</a> -->
        <a href="Office/selectreaded.do?read=1" class="btn btn-sm btn-primary"><i class="fa fa-check"></i>&nbsp;已浏览</a>
        <a href="Office/selectreaded.do?read=0" class="btn btn-yellow"><i class="fa fa-times"></i>&nbsp;未浏览</a>
       
       <script type="text/javascript">
						function shanchu() {
						//alert("進入刪除！！")
						document.getElementById("delmany1").submit();
						var a=document.getElementsByName("test111");
						
						}
							
					</script>
       </span>
       
     </div>
    <!--留言列表-->
    <div class="Guestbook_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr class="warning">
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
		
		<form action="Office/delmyallaa.do" id="delmany1" method="post">
		
		<c:forEach items="${smsinfo.list}" var="i">
		<tr>
		  <td class="danger"><label><input type="checkbox" name="test111" value="${i.detailId }" class="ace"><span class="lbl"></span></label></td>
          <%-- <td><label><input type="checkbox" value="${i.detailId }" class="ace"><span class="lbl"></span></label></td> --%>
          <td style="font-size:11px;">${i.detailId }</td>
         <td  style="font-size:11px;"><a title="详情" onclick="jia(${i.detailId  });Guestbook_iew('12')" href="javascript:;"   >${i.officeSms.smsHeadline}</a> </td>
         
        
         
          <%-- <td> <a href="javascript:;" onclick="Guestbook_iew('12')">${i.smsHeadline}</a></td> --%>
          <td style="font-size:11px;">${i.sysUsers.userName}</td>
				
		  <td style="font-size:11px;">${i.syscompany.comName}</td>
          <td style="font-size:11px;"><fmt:formatDate value="${i.lastTime}"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
           
         
         
          

					<c:if test="${i.smsState==1}">
						<td class="td-status"><span class="label label-danger radius">已阅读</span></td>
					</c:if>
					<c:if test="${i.smsState==0}">
						<td class="td-status"><span class="label label-warning radius">未阅读</span></td>
					</c:if>
					
         
          <td class="td-manage">
         
           <!-- <a onclick="changenum()" href="javascript:;">点我</a> -->
         <%--  <a title="设为未读"  class="btn btn-xs btn-success" href='Office/selectmysmsById.do?id=${i.detailId }'>改变状态</a> --%>
           <a onclick="jiaaa(${i.detailId });member_add('550')" href="javascript:ovid()" id="member_add" class="btn btn-xs btn-warning">回复信息</a>
        	<!-- <a  href="javascript:;"  onclick="member_del(this,'1')" title="删除" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a> -->
          	<a title="删除"  onclick="delet(${i.detailId });member_del(this,'1')" href="javascript:;"   class="btn btn-xs btn-warning" >删除<i class="icon-trash  bigger-120"></i></a>
          </td>
		</tr>
       </c:forEach>
		</form>
		<tr>
	           			<td colspan="12" style="text-align: center">
	           			<a href="Office/selectinfo.do?pageNum=${smsinfo.firstPage }&smsHeadline=${smsHeadline}">首页</a>
	           			<a href="Office/selectinfo.do?pageNum=${smsinfo.prePage }&smsHeadline=${smsHeadline}">上一页</a>
	           			<a href="Office/selectinfo.do?pageNum=${smsinfo.nextPage }&smsHeadline=${smsHeadline}">下一页</a>
	           			<a href="Office/selectinfo.do?pageNum=${smsinfo.lastPage }&smsHeadline=${smsHeadline}">尾页</a>
	           			当前${smsinfo.pageNum}/${smsinfo.pages}页,共${smsinfo.total}条
	           			</td>
	           </tr>
		
		
		
     <%--  <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
          <td>1</td>
          <td><u style="cursor:pointer"  class="text-primary" onclick="member_show('张小泉','member-show.html','1031','500','400')">张小泉</u></td>
          <td class="text-l">
          <a href="javascript:;" onclick="Guestbook_iew('12')">${i.smsHeadline}</a>
          <td>2016-6-11 11:11:42</td>
          <td class="td-status"><span class="label label-success radius">已浏览</span></td>
          <td class="td-manage">
           <a onClick="member_stop(this,'10001')"  href="javascript:;" title="已浏览"  class="btn btn-xs btn-success"><i class="fa fa-check  bigger-120"></i></a>   
        <a  onclick="member_edit('回复','member-add.html','4','','510')" title="回复"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>      
        <a  href="javascript:;"  onclick="member_del(this,'1')" title="删除" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
          </td>  --%>
        </tr>
        </tbody>
      </table>
    </div>
 </div>
</div>

<!--添加用户图层-->
<form action="Office/setstate11.do" id="changenum1" method="post" onsubmit="return yan(this)">
<div class="add_menber" id="add_menber_style" style="display:none">
  
    <ul class=" page-content">
     <li><label class="label_name">信息标题：</label><span class="add_name"><input readonly="true" id="sms1" value="" name="用户名" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name"></label><span class="add_name"></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">信息内容：</label><span class="add_name"><textarea style="resize: none;" readonly="true" id="sms2"  type="text"  class="text_add"></textarea></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">发送人：</label><span class="add_name"><input readonly="true" id="sms3"  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">发送公司：</label><span class="add_name"><input readonly="true" id="sms4"  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">发送时间：</label><span class="add_name"><input readonly="true" id="sms5"  type="text"  dateFmt="yyyy-MM-dd HH:mm:ss"  class="text_add"/></span><div class="prompt r_f"></div></li>
    
    </ul><br><br><br><br><br><br><br><br><br><br><br><br>
    <!-- <a onclick="changenum()" href="javascript:;">确定并关闭</a>  -->
    <div class="center"> <a onclick="submitnum()" href="javascript:;">确定并关闭</a> </div><br><br><br><br><br><br>
   <!--  <div class="center"> <input  class="btn btn-primary" type="submit" id="submit" value="确定并关闭"></div><br><br><br><br><br><br> -->
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
<form action="Office/replacesmsInfo.do" method="post" onsubmit="return yan(this)">
<div class="add_menber" id="add_sms_style" style="display:none">
  
    <ul class=" page-content">
     <!-- <li style="display:hidden"><label class="label_name">客户编号：</label><span class="add_name"><input  type="text" id="customId" class="text_add"/></span><div class="prompt r_f"></div></li> -->
     
   	<li></li>
     <li><label class="label_name"></label><div class="prompt r_f"><input style="display: none"  type="text" name="detail11" id="detail11" class="text_add" /></div></li>
     <li><label class="label_name">信息标题：</label><span class="add_name"><input  type="text" name="smshidle" id="detail2" class="text_add"/></span><div class="prompt r_f"></div></li>
	<li><label class="label_name"></label><div class="prompt r_f"></div></li>
	<li><label class="label_name"></label><div class="prompt r_f"></div></li>
     <!-- <li><label class="label_name">接收人公司：</label><span class="add_name"><input  type="text" name="companyid" id="owner" class="text_add"/></span><div class="prompt r_f"></div></li> -->
	<li><label class="label_name"></label><div class="prompt r_f"></div></li>
     <li><label class="label_name">信息内容：</label><textarea style="width: 100%;height:100px; "   name="smsdetail1" id="detail3" ></textarea></li>


		<%-- <select id="rolesx" name="roleId"  data-selector data-selector-checks="true">
                <c:forEach items="${roles}" var="r" >
                <option value="${r.roleId }">${r.roleName }</option>
                </c:forEach>
            </select></span><div class="prompt r_f"></div></li> --%>
            
    </ul><br><br><br><br><br><br><br><br><br><br><br><br>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="发送"></div><br><br><br><br><br><br>
 </div>
 </form>
 
 


<!--留言详细-->
<div id="Guestbook" style="display:none">
 <div class="content_style">
    <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">是否回复 </label>
       <div class="col-sm-9">
       
       <label><input name="checkbox" type="checkbox" class="ace" id="checkbox"><span class="lbl"> 回复</span></label>
       <div class="Reply_style">
          <textarea name="权限描述" class="form-control" id="form_textarea" placeholder="" onkeyup="checkLength(this);"></textarea>
          <span class="wordage">剩余字数：<span id="sy" style="color:Red;">200</span>字</span>
       </div>
       </div>
	</div>
 </div>
</div>
</body>
</html>
<script type="text/javascript">
 /*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url+'#?='+id,w,h);
}
/*留言-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}

/*checkbox激发事件*/
$('#checkbox').on('click',function(){
	if($('input[name="checkbox"]').prop("checked")){
		 $('.Reply_style').css('display','block');
		}
	else{
		
		 $('.Reply_style').css('display','none');
		}	
	})
	
	
	
	
	/* load */
	/* function load(){
		alert("load");
		//发送ajax请求
			var url = "Office";//请求地址
			console.log(url);
			
			new Ajax.Request(
			 url,
			 {method: "post",onComplete: success}//请求方法	//回调函数
			 )
	}
	
	function success(resp){ //响应对象
		var result = resp.responseText; //获取响应文本内容
		console.log(result);
		var j = JSON.parse(result);//字符串转JSON
		if(j.msg=="yes")
		{
			document.getElementById("sp").innerHTML = "用户名已存在";
			
		}else
		{
			document.getElementById("sp").innerHTML = "用户名可使用";
		}
		
		}
		 */
		
		
		
/*留言查看*/
function Guestbook_iew(id){
	var index = layer.open({
        type: 1,
        title: '留言信息',
		maxmin: true, 
		shadeClose:false,
        area : ['800px' , ''],
        content:$('#add_menber_style'),
		
				
	      
	   
	})	
};
	/*字数限制*/
function checkLength(which) {
	var maxChars = 200; //
	if(which.value.length > maxChars){
	   layer.open({
	   icon:2,
	   title:'提示框',
	   content:'您输入的字数超过限制!',	
    });
		// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
		which.value = which.value.substring(0,maxChars);
		return false;
	}else{
		var curr = maxChars - which.value.length; //250 减去 当前输入的
		document.getElementById("sy").innerHTML = curr.toString();
		return true;
	}
};
</script>
<script type="text/javascript">
jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable( {
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,2,3,5,6]}// 制定列不参与排序
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
			
			
			
			
			
			
	/* 发送信息的ajax */
function jiaaa(detailId)
    {
        var url="detail/selectsmsbyid.do?detailId="+detailId;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {
     	 $("#detail11").val(data.smsSender);
        // $("#sms2").val(data.smsContent);//将取出的值覆盖原来的值 （val对值进行操作)
        // $("#sms3").val(data.sysUsers.userName);
         //$("#sms4").val(data.syscompany.comName);
        // $("#sms5").val(data.lastTime);

      }
    });
       
    }
    

			
			
			
			
			
			
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
    


/*用户-编辑*/
 function member_add(id){
	  layer.open({
        type: 1,
        title: '--回复短信--',
		maxmin: true, 
		shadeClose:false, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_sms_style'),

    });
} 



/*用户-添加*/
/* function member_add(id){
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
}); */


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

		function submitnum(){
		document.getElementById("changenum1").submit();
		var nums=window.top.document.getElementsByName('num');
		for(var i=0;i<nums.length;i++){nums[i].innerHTML="${num}"-1;}		
		
		}


		function changenum1(){
		var nums=window.top.document.getElementsByName('num');
		for(var i=0;i<nums.length;i++){nums[i].innerHTML="${num}"+1;}
		}
		
		function changenum2(){
		var nums=window.top.document.getElementsByName('num');
		for(var i=0;i<nums.length;i++){nums[i].innerHTML="${num}"-1;}
		}
					
</script>
