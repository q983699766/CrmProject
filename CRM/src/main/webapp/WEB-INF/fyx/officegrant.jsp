<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
 <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/style.css"/>       
        <link href="assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/ace.min.css" />
        <link rel="stylesheet" href="font/css/font-awesome.min.css" />
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="js/jquery-1.9.1.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script>           	
		<script src="assets/js/jquery.dataTables.min.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="assets/laydate/laydate.js" type="text/javascript"></script>
<title>留言</title>
</head>
<script type="text/javascript">
	function sccc() {
			var b = document.getElementsByName("bb000");
			alert(b.length); 
			for(var b0=0;b0<b.length;b0++){
				if(b[b0].checked){
					document.getElementById('cc000').submit();
					return;
				}
			} 
		}   
	/*发布*/
  function open(){
  	  $.ajax({
		type:"post",
    	url:"officeg.do/pretargetId.do",
    	success:function(data){
     	   	var select = document.getElementById("selecttargetId");
     	   	$.each(data, function(i, elt) {
     	   		select.options.add(new Option(elt.checkTarget, elt.targetId));
     	   	})
     	}
	  }); 
	  $.ajax({
		type:"post",
    	url:"officeg.do/prereceiver.do",
    	success:function(data){
     	   	var spanreceiver = document.getElementById("spanreceiver");
     	   	var checkbox;
     	   	var text;
     	   	$.each(data, function(i, elt) {
     	   		checkbox = document.createElement("input");
     	   		checkbox.setAttribute("type", "checkbox");
     	   		checkbox.setAttribute("name", "receiverId");
     	   		checkbox.setAttribute("value", elt.userId);
     	   		text = document.createTextNode(elt.userName);
     	   		spanreceiver.appendChild(checkbox);
     	   		spanreceiver.appendChild(text);
     	   	})
     	}
	  });
   	layer.open({
        type: 1,
        title: '发布',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber_style'),
		yes:function(index,layero){	
		 	/* layer.closeAll(); */
		}
    });
}; 
/* 获取发布表单，并提交 */
function fabuform(){
	// 设置targetId的input的值
	$("#targetId").val($("#selecttargetId").find("option:selected").val());
	// 任务指标不能为空
	if($("#selecttargetId").val()==-1){
		layer.alert('任务指标不能为空!',{
              title: '提示框',				
				icon:0,
			 });
		return false;
	}
	// 接收人不能为空
	var receiverIdList = $("input[name='receiverId']").val();
	if(receiverIdList==0){
		layer.alert('接收人不能为空!',{
              title: '提示框',				
				icon:0,
			 });
		return false;
	}
	/* 终止日期验证 */
	var endtime = $("#taskEndtime").val();
	var starttime = $("#taskStarttime").val();
	if(endtime<=starttime){
		layer.alert('终止日期不能小于等于生效日期!',{
              title: '提示框',				
				icon:0,
			 });
		return false;
	}
	layer.closeAll();
	
	document.forms.fabuformv.action="officeg.do/fabu.do";
	return true;
	/* document.getElementById("fabuformv").submit(); */
	
}
	</script>
<body>
<div class="margin clearfix">
 <div class="Guestbook_style">
	<!--<div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">考核指标集名称</label><input name="" type="text" class="text_add" placeholder="输入查询的指标名称" style=" width:250px"></li>
       <li><label class="l_f">时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
       <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>-->
	 <!-- <div class="search_style">
      <div class="title_names">发布考核任务</div>
      <form action="officecc.do/addofficechecktarget.do" method="post">
      <ul class="search_content clearfix">
       <li><label class="l_f">任务标题</label><input name="taskTitle" type="text" class="text_add" placeholder="添加一个名称" style=" width:250px"></li>
       <li><label class="l_f">任务具体内容</label><textarea name="taskContent" class="textarea" style=" margin-left:10px;" cols="100"></textarea></li>
       <li><label class="l_f">考核指标集</label>
           <button type="button" onclick="addtargetId()" class="btn_search"><i class="icon-search"></i>选择</button>
       </li>
       <li><label class="l_f">有效期</label>生效日期<input name="taskStarttime" type="date" class="text_add" style=" width:250px">终止日期<input name="taskEndtime" type="date" class="text_add" style=" width:250px"></li>
       <li><label class="l_f">被考核人</label><button type="button" onclick="addreceiver()" class="btn_search"><i class="icon-search"></i>添加</button></li>
       <li style="width:90px;"><button type="submit" class="btn_search"><i class="icon-search"></i>发布</button></li>
       <li style="width:90px;"><button type="reset" class="btn_search"><i class="icon-search"></i>重置</button></li>
      </ul>
      </form>
    </div> -->
    <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:open();" id="open" class="btn btn-yellow"><i class="icon-plus"></i>&nbsp;新增发布</a>
        
        <!--<a href="javascript:ovid()" class="btn btn-sm btn-primary"><i class="fa fa-check"></i>&nbsp;已浏览</a>
        <a href="javascript:ovid()" class="btn btn-yellow"><i class="fa fa-times"></i>&nbsp;未浏览</a>-->
        
       </span>
       
       <span class="r_f"></span>
     </div>
     
     
     
    <!--列表-->
    <div class="Guestbook_list">
    <form action="officecc.do/delallofficechecktarget.do" method="post" id="cc000" >
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
          <th width="80">任务编号ID</th>
          <th width="150px">任务标题</th>
          <th width="160">任务具体内容</th>
          <th width="80">考核指标</th>
          <th width="80">开始时间</th>
          <th width="80">结束时间</th>
          <th width="80">发布人</th>
          <th width="80">公司ID</th>
          <th width="200px">最后修改时间</th>
           <th width="70">查看详情</th>            
           <th width="250">删除</th> 
          </tr>
      </thead>
	<tbody>
	
	<c:forEach items="${list }" var="u" varStatus="x">
		<tr>
     <td><label name="lll"><input type="checkbox" class="ace" name="bb000" id="inputt${x.index }" value="${u.taskId }"><span class="lbl" name="mmm"></span></label></td>
          <td>${u.taskId }</td>
          <td>${u.taskTitle }</td>
          <td>${u.taskContent }</td>
          <td>${u.officeChecktarget.checkTarget }</td>
          <td><fmt:formatDate value="${u.taskStarttime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
          <td><fmt:formatDate value="${u.taskEndtime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
          <td>${u.sysUsers.userName }
          <!-- <a onclick="Guestbook_iewre('${u.taskPublisher }')" title="此人接收"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a> -->
          </td>
          <td>${u.comId }</td>
          <td><fmt:formatDate value="${u.lastTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
          <td class="td-status">
          <a href="officeg.do/listdetail.do?taskId=${u.taskId }&taskPublisher=${u.taskPublisher }">查看详情</a>
          <!-- <a onclick="Guestbook_iew('${u.taskId }')" title="修改"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a> -->
          </td>
          <td class="td-manage">
          <!-- <a onclick="Guestbook_iewrethisline('${u.taskId }')" title="此条接收详情"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a> -->
        <a  href="javascript:;"  onclick="member_del(this,'${u.taskId }','${u.comId }')" title="删除" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
          </td>
        </tr>
        </c:forEach>
        
        </tbody>
      </table>
      </form>
    </div>
 </div>
</div>
<!--添加用户图层-->
<form action="" method="post" id="fabuformv" onsubmit="return fabuform()">
<div class="add_menber" id="add_menber_style" style="display:none">
    <ul class=" page-content">
     <!-- <li style="display:hidden"><label class="label_name">客户编号：</label><span class="add_name"><input  type="text" id="customId" class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">任务标题：</label><span class="add_name"><input required type="text" name="taskTitle" id="taskTitle" class="text_add"/></span><div class="prompt r_f" ></div></li>
     <li><label class="label_name">具体内容：</label><span class="add_name"><input required type="text" name="taskContent" id="taskContent" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">考核指标：</label><span class="add_name"><input  type="hidden" name="targetId" id="targetId" class="text_add"/>&nbsp;&nbsp;
     	<select id="selecttargetId" class="text_add">
     		<option value="-1">请选择</option>
     	</select>
     </span><div class="prompt r_f"></div></li>
     <li><label class="label_name">公司编号：</label><span class="add_name"><input required type="text" name="comId" id="comId" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">生效日期：</label><span class="add_name"><input required type="date"  name="taskStarttime" id="taskStarttime" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">终止日期：</label><span class="add_name"><input required  name="taskEndtime" id="taskEndtime" type="date" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">被考核人：</label><span class="add_name" id="spanreceiver"></span><div class="prompt r_f"></div></li>
     

    </ul><br><br><br><br><br><br><br><br><br><br><br><br>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="发布">&nbsp;&nbsp;<input class="btn btn-primary" type="reset" id="submit" value="重置"></div><br><br><br><br><br><br>
 </div>
 </form>
<!--此人接收-->
<div id="Guestbookre" style="display:none">
 <!--此条接收列表-->
    <div class="Guestbook_list">
    <form action="" method="post" id="ccre" >
      <table class="table table-striped table-bordered table-hover" id="tablere">
      <thead>
		 <tr>
          <th width="80">编号ID</th>
          <th width="150px">任务编号ID</th>
          <th width="">接收用户编号</th>
          <th width="80">是否完成</th>
          <th width="80">状态</th>
          <th width="80">公司ID</th>
          <th width="200px">最后修改时间</th>
           <th width="70">修改</th>            
           <th width="250">删除</th> 
          </tr>
      </thead>
	<c:forEach items="${getre }" var="u" varStatus="x">
		<tr>
          <td>${u.idd }</td>
          <td>${u.taskId }</td>
          <td>${u.receiverId }</td>
          <td>${u.isFinish==0? "未完成":"已完成" }</td>
          <td>${u.statue }
          	<c:if test="${u.statue==0 }">未开始</c:if>
          	<c:if test="${u.statue==1 }">已生效</c:if>
          	<c:if test="${u.statue==2 }">已逾期</c:if>
          </td>
          <td>${u.comId }</td>
          <td><fmt:formatDate value="${u.lastTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
          <td class="td-status"><a onclick="Guestbook_iewre('${u.taskId }')" title="修改"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a></td>
          <td class="td-manage">
          <a  href="javascript:;"  onclick="member_delre(this,'${u.taskId }')" title="删除" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
          </td>
        </tr>
        </c:forEach>
        
      </table>
      </form>
    </div>
</div>

<!--此条接收-->
<div id="Guestbookthisline" style="display:none">
	<!--此条接收列表-->
    <div class="Guestbook_list">
    <form action="" method="post" id="ccthisline" >
      <table class="table table-striped table-bordered table-hover" id="tablethisline">
      <thead>
		 <tr>
          <th width="80">编号ID</th>
          <th width="150px">任务编号ID</th>
          <th width="">接收用户编号</th>
          <th width="80">是否完成</th>
          <th width="80">状态</th>
          <th width="80">公司ID</th>
          <th width="200px">最后修改时间</th>
           <th width="70">修改</th>            
           <th width="250">删除</th> 
          </tr>
      </thead>
	<c:forEach items="${getthisline }" var="u" varStatus="x">
		<tr>
          <td>${u.idd }</td>
          <td>${u.taskId }</td>
          <td>${u.receiverId }</td>
          <td>${u.isFinish==0? "未完成":"已完成" }</td>
          <td>${u.statue }
          	<c:if test="${u.statue==0 }">未开始</c:if>
          	<c:if test="${u.statue==1 }">已生效</c:if>
          	<c:if test="${u.statue==2 }">已逾期</c:if>
          </td>
          <td>${u.comId }</td>
          <td><fmt:formatDate value="${u.lastTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
          <td class="td-status"><a onclick="Guestbook_iewthisline('${u.taskId }')" title="修改"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a></td>
          <td class="td-manage">
          <a  href="javascript:;"  onclick="member_delthisline(this,'${u.taskId }')" title="删除" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
          </td>
        </tr>
        </c:forEach>
        
      </table>
      </form>
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
function member_del(obj,id,comId){
	layer.confirm('确认要删除吗？',function(index){
		/*$(obj).parents("tr").remove();*/
		/*alert(id);
		$.ajax({
			type:"post",
			url:"officecc.do/delofficechecktarget.do",
			data:{"targetId":id}
			
		});*/
		layer.msg('已删除!',{icon:1,time:1000});
		document.location.href="officeg.do/del.do?taskId="+id+"&comId="+comId;
		
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
/*留言查看*/
function Guestbook_iew(id){
	var url="officecc.do/goupdateofficechecktarget.do?targetId="+id;
	$.ajax({
		type:"post",
      	url:url,
      	dataType:"json",
      	success:function(data)
	      {//从前台回调回来的数组，处理后的数据
	       //alert(JSON.stringify(data));
	         $("#checkTarget").val(data.checkTarget);//将取出的值覆盖原来的值 （val对值进行操作)	
	         $("#remark").val(data.remark);
	      }
	});
	var index = layer.open({
        type: 1,
        title: '修改界面',
		maxmin: true, 
		shadeClose:false,
        area : ['600px' , ''],
        content:$('#Guestbook'),
		btn:['修改','取消'],
		yes: function(index, layero){		 
		  /* if($('input[name="checkbox"]').prop("checked")){			 
			 if($('.form-control').val()==""){
				layer.alert('回复内容不能为空！',{
               title: '提示框',				
			  icon:0,		
			  }) 
			 }else{			
			      layer.alert('确定回复该内容？',{
				   title: '提示框',				
				   icon:0,	
				   btn:['确定','取消'],	
				   yes: function(index){					   
					     layer.closeAll();
					   }
				  }); 		  
		   }			
	      }else{			
			 layer.alert('是否要取消回复！',{
               title: '提示框',				
			icon:0,		
			  }); 
			  layer.close(index);      		  
		  } */
		  if($('#checkTarget').val()=="" || $('#remark').val()==""){
				layer.alert('修改名称或内容不能为空！',{
               title: '提示框',				
			  icon:0,		
			  }) 
			 }else{			
			      layer.alert('确定该修改？',{
				   title: '提示框',				
				   icon:0,	
				   btn:['确定','取消'],	
				   yes: function(index){					   
					     
					     $.ajax({
					     	type:"post",
					     	url:"officecc.do/updateofficechecktarget.do",
					     	data:{"targetId":id,"checkTarget":$('#checkTarget').val(),"remark":$('#remark').val()},
					     	success:function(data){
					     		document.location.reload();
					     	}
					     });
					     layer.closeAll();
					     /*document.location.href="officecc.do/updateofficechecktarget.do?targetId="+id+"&checkTarget="+$('#checkTarget').val()+"&remark="+$('#remark').val();
					     layer.closeAll();*/
					   }
				  }); 		  
		   }
	   }
	})	
};

/*此人接收*/
function Guestbook_iewre(id){
	var url="officeg.do/listre.do?id="+id;
	$.ajax({
		type:"post",
      	url:url,
      	dataType:"json",
      	success:function(data)
	      {
	      
	      }
	});
	var index = layer.open({
        type: 1,
        title: '修改界面',
		maxmin: true, 
		shadeClose:false,
        area : ['600px' , ''],
        content:$('#Guestbookre'),
		btn:['关闭','取消'],
		yes: function(index, layero){		 
		   layer.closeAll();
	   }
	})	
};

/*此条接收*/
function Guestbook_iewrethisline(id){
	var url="officeg.do/listthisline.do?taskId="+id;
	$.ajax({
		type:"post",
      	url:url,
      	dataType:"json",
      	
      	success:function(data)
	      {
	        
	      }
	});
	
	var index = layer.open({
        type: 1,
        title: '接收详情',
		maxmin: true, 
		shadeClose:false,
        area : ['600px' , ''],
        content:$('#Guestbookthisline'),
		btn:['关闭','取消'],
		yes: function(index, layero){		 
		   layer.closeAll();
	   }
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
</script>
