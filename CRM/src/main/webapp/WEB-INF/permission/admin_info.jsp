<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
 <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css" rel="stylesheet" href="../css/style.css"/>       
        <link href="../assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="../assets/css/ace.min.css" />
        <link rel="stylesheet" href="../font/css/font-awesome.min.css" />
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script type="text/javascript" src="assets/js/ace-extra.min.js"></script>
		<script src="../js/jquery-1.9.1.min.js"></script>
		<script src="../assets/layer/layer.js" type="text/javascript" ></script>
        <script src="../assets/laydate/laydate.js" type="text/javascript"></script>  
        <script src="../assets/js/bootstrap.min.js"></script>
		<script src="../assets/js/typeahead-bs2.min.js"></script>           	
		<script src="../assets/js/jquery.dataTables.min.js"></script>
		<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
                      
<title>个人信息管理</title>
</head>

<body>
<script>
function(){

	var success = "${success}";
	if(success=="success"){
			layer.alert('修改密码成功，点击确定返回登录页面！',{
               title: '提示框',				
			   icon:1,			   		
			  });
	}
}
</script>

<div class="clearfix">
 <div class="admin_info_style">
   <div class="admin_modify_style" id="Personal">
     <div class="type_title">个人账户信息 </div>
      <div class="xinxi">
        <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">用&nbsp;户&nbsp;名： </label>
          <div class="col-sm-9"><input type="text" name="用户名" id="website-title" value="${nowuser.userName }" class="col-xs-7 text_info" disabled="disabled">
          &nbsp;&nbsp;&nbsp;<a href="javascript:ovid()" onclick="change_Password()" class="btn btn-warning btn-xs">修改密码</a></div>
          
          </div>
  			<form action="updatePassword.do" method="get" >
          	</form>
          <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">账户角色： </label>
          <div class="col-sm-9" > <span>${role.roleName == null ? "无":role.roleName }</span></div>
          </div>
          
          <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">员工编号： </label>
          <div class="col-sm-9" > <span>${nowuser.empId }</span></div>
          </div>
          <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">公司编号： </label>
          <div class="col-sm-9" > <span>${nowuser.comId }</span></div>
          </div>
           <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">账户状态： </label>
          <div class="col-sm-9" > <span>${nowuser.userState == '0' ? "可用":"不可用" }</span></div>
          </div>
           <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">注册时间： </label>
          <div class="col-sm-9" > <span><fmt:formatDate value="${nowuser.lastTime }" pattern="yyyy-MM-dd"/></span></div>
          </div>
           <div class="Button_operation clearfix"> 
								
				<button onclick="save_info();" class="btn btn-success radius" type="button">保存修改</button>              
			</div>
            </div>
    </div>
    <div class="recording_style">
    <div class="type_title">角色及相应权限说明 </div>
    <div class="recording_list">
     <table class="table table-border table-bordered table-bg table-hover table-sort" id="sample-table">
    <thead>
      <tr class="text-c">
        
        <th width="80">角色编号</th>
        <th width="100">角色名称</th>
        <th>角色描述</th>
        <th width="25%">拥有权限</th>
        <th width="80">上级角色编号</th>
        <th width="120">创建时间</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${roles }" var="r">
      <tr>
        
        <td>${r.roleId }</td>
        <td>${r.roleName }</td>
        <td>${r.roleDescribe }</td>
        <td><c:forEach items="${r.perms }" var="p"><p>${p.permissionName}</p></c:forEach></td>
        <td>${r.higherRoleId }</td>
        <td><fmt:formatDate value="${r.lastTime }" pattern="yyyy-MM-dd"/></td>      
      </tr>
   	</c:forEach>           
    
    </tbody>
  </table>
    </div>
    </div>
 </div>
</div>
 <!--修改密码样式-->
 		<form action="updatePassword.do" method="post" onsubmit="return t()">
         <div class="change_Pass_style" id="change_Pass">
            <ul class="xg_style">
             <li><label class="label_name">原&nbsp;&nbsp;密&nbsp;码</label><input name="oldpass" type="password" class="" id="password" ></li>
             <li><label class="label_name">新&nbsp;&nbsp;密&nbsp;码</label><input name="password" type="password" class="" id="Nes_pas"></li>
             <li><label class="label_name">确认密码</label><input name="再次确认密码" type="password" class="" id="c_mew_pas"></li>
              
            </ul>
           <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="确认修改">
         </div>
         </form>
</body>
</html>

<script>
	function t(){
		var pass1 = document.getElementById("password").value;
		var pass2 = document.getElementById("Nes_pas").value;
		var pass3 = document.getElementById("c_mew_pas").value;
		if (pass1==""){
			  layer.alert('原密码不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          } 
		  if (pass2==""){
			  layer.alert('新密码不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          } 
		   
		  if (pass3==""){
			  layer.alert('确认新密码不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          }
		    if(pass2 != pass3 )
        {
            layer.alert('密码不一致!',{
              title: '提示框',				
				icon:0,
			    
			 });
			 return false;
        }
	}	
</script>


<script>

 //按钮点击事件
function modify(){
	 $('.text_info').attr("disabled", false);
	 $('.text_info').addClass("add");
	  $('#Personal').find('.xinxi').addClass("hover");
	  $('#Personal').find('.btn-success').css({'display':'block'});
	};
function save_info(){
	    var num=0;
		 var str="";
     $(".xinxi input[type$='text']").each(function(n){
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
			  
			   layer.alert('修改成功！',{
               title: '提示框',				
			   icon:1,			   		
			  });
			  $('#Personal').find('.xinxi').removeClass("hover");
			  $('#Personal').find('.text_info').removeClass("add").attr("disabled", true);
			  $('#Personal').find('.btn-success').css({'display':'none'});
			   layer.close(index);
			
		  }		  		
	};	
 //初始化宽度、高度    
    $(".admin_modify_style").height($(window).height()); 
	$(".recording_style").width($(window).width()-400); 
    //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".admin_modify_style").height($(window).height()); 
	$(".recording_style").width($(window).width()-400); 
  });
  //修改密码
  function change_Password(){
	   layer.open({
    type: 1,
	title:'修改密码',
	area: ['300px','300px'],
	shadeClose: true,
	content: $('#change_Pass'),
	
	yes:function(index, layero){		
		   if ($("#password").val()==""){
			  layer.alert('原密码不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          } 
		  if ($("#Nes_pas").val()==""){
			  layer.alert('新密码不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          } 
		   
		  if ($("#c_mew_pas").val()==""){
			  layer.alert('确认新密码不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          }
		    if(!$("#c_mew_pas").val || $("#c_mew_pas").val() != $("#Nes_pas").val() )
        {
            layer.alert('密码不一致!',{
              title: '提示框',				
				icon:0,
			    
			 });
			 return false;
        }   
		 else{
		 var params = {};
	
			params.password = $("#c_mew_pas").val();		
		 
		  /* $.ajax({
				type:"post",
				url:"userinfoctlr/updatePassword.do",
				date:params,
				dataType:"json",
				success:function(m){
					if(m.code == "200"){
						layer.alert('修改成功！',{
		               	title: '提示框',				
						icon:1,		
			  					}); 
			 			 layer.close(index);
						}	
				}
			}); */
			      
		  }	 
	}
    });
	}
</script>
<script>
jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable( {
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,2,3,4,5,6]}// 制定列不参与排序
		] } );
				
				
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
});</script>

