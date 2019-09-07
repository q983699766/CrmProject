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
	 <div class="search_style">
      <div class="title_names">新建考核指标集</div>
      <form action="officecc.do/addofficechecktarget.do" method="post">
      <ul class="search_content clearfix">
       <li><label class="l_f">考核指标集名称</label><input name="checkTarget" type="text" class="text_add" placeholder="添加一个名称" style=" width:250px"></li>
       <li><label class="l_f">考核指标集描述</label><textarea name="remark" class="textarea" style=" margin-left:10px;" cols="100"></textarea><!--<input class="inline laydate-icon" id="start" style=" margin-left:10px;">--></li>
       <li style="width:90px;"><button type="submit" class="btn_search"><i class="icon-search"></i>添加</button></li>
       
      </ul>
      </form>
    </div>
    <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" class="btn btn-danger"><i class="fa fa-trash"></i>&nbsp;批量删除</a>
        <!--<a href="javascript:ovid()" class="btn btn-sm btn-primary"><i class="fa fa-check"></i>&nbsp;已浏览</a>
        <a href="javascript:ovid()" class="btn btn-yellow"><i class="fa fa-times"></i>&nbsp;未浏览</a>-->
       </span>
       <!-- <span class="r_f">共：<b>2334</b>条</span> -->
     </div>
    <!--留言列表-->
    <div class="Guestbook_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
          <th width="80">ID</th>
          <th width="150px">考核指标集名称</th>
          <th width="">考核指标集描述</th>
          <th width="200px">最后修改时间</th>
          <th width="70">修改</th>                
          <th width="250">删除</th>
          </tr>
      </thead>
	<tbody>
	<c:forEach items="${list }" var="u" >
		<tr>
     <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
          <td>${u.targetId }</td>
          <td><!-- <u style="cursor:pointer"  class="text-primary" onclick="member_show('张小泉','member-show.html','1031','500','400')"> -->${u.checkTarget }<!-- </u> --></td>
          <td class="text-l">
          ${u.remark }
          </td>
          <td><fmt:formatDate value="${u.lastTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
          <td class="td-status"><a onclick="Guestbook_iew('${u.targetId }')" title="修改"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a></td>
          <td class="td-manage">
           <!--<a onClick="member_stop(this,'10001')"  href="javascript:;" title="已浏览"  class="btn btn-xs btn-success"><i class="fa fa-check  bigger-120"></i></a>   
        <a  onclick="member_edit('回复','member-add.html','4','','510')" title="回复"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>   -->   
        <a  href="javascript:;"  onclick="member_del(this,'${u.targetId }')" title="删除" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
          </td>
        </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
 </div>
</div>
<!--留言详细-->
<div id="Guestbook" style="display:none">
 <div class="content_style">
  <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">考核指标集名称</label>
       <div class="col-sm-9"><input id="checkTarget" name="checkTarget" type="text" class="text_add" style=" width:250px"></div>
	</div>
   <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">考核指标集描述</label>
       <div class="col-sm-9"><textarea id="remark" name="remark" class="textarea" style=" margin-left:10px;" cols="50"></textarea></div>
	</div>
    <!-- <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">是否回复 </label>
       <div class="col-sm-9">
       <label><input name="checkbox" type="checkbox" class="ace" id="checkbox"><span class="lbl"> 回复</span></label>
       <div class="Reply_style">
          <textarea name="权限描述" class="form-control" id="form_textarea" placeholder="" onkeyup="checkLength(this);"></textarea>
          <span class="wordage">剩余字数：<span id="sy" style="color:Red;">200</span>字</span>
       </div>
       </div>
	</div>-->
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
		/*$(obj).parents("tr").remove();*/
		/*alert(id);
		$.ajax({
			type:"post",
			url:"officecc.do/delofficechecktarget.do",
			data:{"targetId":id}
			
		});*/
		document.location.href="officecc.do/delofficechecktarget.do?targetId="+id;
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
