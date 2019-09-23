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
        <link rel="stylesheet" href="../css/style.css"/>       
        <link href="../assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="../assets/css/ace.min.css" />
        <link rel="stylesheet" href="../font/css/font-awesome.min.css" />
        <link rel="stylesheet" href="../css/style.css"/>
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		
		<script src="../verSelector/asset/js/select.js"></script>
		<script src="../verSelector/verSelect.js"></script>
		
		<script src="../js/jquery-1.9.1.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
		<script src="../assets/js/typeahead-bs2.min.js"></script>           	
		<script src="../assets/js/jquery.dataTables.min.js"></script>
		<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="../assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="../assets/laydate/laydate.js" type="text/javascript"></script>
<title>管理用户</title>
</head>

<body>
<script type="text/javascript">


	var ok = "${ok}";
	if(ok=="1"){
			layer.alert('操作成功',{
               title: '提示框',				
			   icon:1,			   		
			  });
	}
	if(ok=="2"){
			layer.alert('用户名已存在，请重新操作！',{
               title: '提示框',				
			   icon:2,		   		
			  });
	}
	if(ok=="3"){
			layer.alert('只有超级管理员可对超级管理员进行操作',{
               title: '提示框',				
			   icon:2,		   		
			  });
	}
</script>

	

 <div class="margin clearfix">
 
 	<div class="search_style">
    	<font size="80">${aa.ckM }</font> 
    <form action="#" method="post">
      <div class="title_names">账户、用户名关键字查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">模糊查询</label><input name="ccspxx" type="text"  class="text_add" placeholder="请输入关键字:"  style=" width:400px"/></li>
       <li style="width:90px;"><button type="submit" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
      </form>
    </div>
    
   <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="member_add" class="btn btn-warning" title="添加用户账号"><i class="fa fa-plus"></i>&nbsp;添加用户</a>
        
       </span>
       
     </div>
     <div class="compete_list">
     <div class="Guestbook_list">
       <table id="sample-table-1" class="table table-striped table-bordered table-hover">
		 <thead>
			<tr>
			  <th>用户账号</th>
              <th>用户密码</th>
              <th>用户姓名</th>
              <th>用户所拥有角色</th>
              <th>上次操作时间</th>
			  <th class="hidden-480">用户状态</th>             
			  <th class="hidden-480">操作</th>
             </tr>
		    </thead>
             <tbody>
             <c:forEach items="${users.list }" var="u">
			  <tr>
				
				<td>${u.userName }</td>
				
				<td>******</td>
				<td>${u.empName }</td>
				<td><c:forEach items="${u.roles }" var="rol"><p>${rol.roleName }</p></c:forEach></td>
				<td><fmt:formatDate value="${u.lastTime }" pattern="yyyy-MM-dd HH:mm"/></td>
				<td>${u.userState=='0' ? "可用":"不可用"}</td>
				<td>
                 <a title="编辑" onclick="jia(${u.userId });member_edit('550');" href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>        
                 <a title="删除" href="javascript:;"  onclick="del_user(${u.userId})" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
                  <a title="切换状态" href="updatesta.do?userId=${u.userId }"  onclick="Competence_del(this,'1')" class="btn btn-xs btn-info" ><i class="fa fa-exchange  bigger-120"></i></a>
				</td>
			   </tr>
			   </c:forEach>
			   
			   <tr style="text-align: center;">
    				<td colspan="7">
    			<a href="getlist1.do?pageNum=${users.navigateFirstPage }">首页</a>
    			<a href="getlist1.do?pageNum=${users.prePage}">上一页</a>
    			<a href="getlist1.do?pageNum=${users.nextPage }">下一页</a>
    			<a href="getlist1.do?pageNum=${users.navigateLastPage }">尾页</a>
    			当前第${users.pageNum }/${users.pages }页，共${users. total}条,每页10条
    				</td>
    		</tr>												
		      </tbody>
	        </table>
	        </div>
     </div>
 </div>
 <!--添加权限样式-->
 <!-- <div id="Competence_add_style" style="display:none">
   <div class="Competence_add_style">
     <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1"> 权限名称 </label>
       <div class="col-sm-9"><input type="text" id="form-field-1" placeholder=""  name="权限名称" class="col-xs-10 col-sm-5"></div>
	</div>
     <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1"> 权限说明 </label>
       <div class="col-sm-9"><textarea name="权限说明" class="form-control" id="form_textarea" placeholder="" onkeyup="checkLength(this);"></textarea><span class="wordage">剩余字数：<span id="sy" style="color:Red;">200</span>字</span></div>
	</div>
   </div> 
  </div>-->


<!--修改用户图层-->
 <form action="update.do" method="post" onsubmit="return update(this)">
 <input type="hidden" name="userId" id="userId"/>
 <input type="hidden" name="userPassword" id="userPassword"/>
 
 <input type="hidden" name="userState" id="userState"/>
<div class="add_menber" id="update_menber_style" style="display:none"> 
    <ul class=" page-content">
     <!-- <li><label class="label_name">客户编号：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">用户账号：</label><span class="add_name"><input  type="text" readonly="readonly" name="userName" id="userName" class="text_add"/></span><div class="prompt r_f"></div></li>
     
     <li><label class="label_name">用户密码：</label><span class="add_name">&nbsp;&nbsp;&nbsp;●●●●●●<!-- <input  type="password" name="userPassword" id="userPassword" class="text_add"/> --></span><div class="prompt r_f"></div></li>
     
     <li><label class="label_name">员工编号：</label><span class="add_name"><input  type="text" name="empId" id="empIdx" class="text_add"/></span><div class="prompt r_f"></div></li>
     <!-- <li><label class="label_name">公司编号：</label><span class="add_name"><input  type="text" name="comId" id="comIdx" class="text_add"/></span><div class="prompt r_f"></div></li> --><li><label class="label_name">用户角色：</label><span class="add_name">
     		&nbsp;&nbsp;&nbsp;&nbsp;<select id="rolesx" name="roleId"  data-selector data-selector-checks="true">
                <c:forEach items="${roles}" var="r" ><option value="${r.roleId }" >${r.roleName }</option></c:forEach>
            </select></span><div class="prompt r_f"></div></li>
    </ul><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="提交"></div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
 </div>
</form>




 <!--添加用户图层--> 
 <form action="add.do" method="post" onsubmit="return add(this)">
<div class="add_menber" id="add_menber_style" style="display:none">
  
    <ul class=" page-content">
     <li><label class="label_name">用户账号：</label><span class="add_name"><input value="" name="userName" id="uname" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">用户密码：</label><span class="add_name"><input name="userPassword" id="upass" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
     
     <div class="prompt r_f"></div>
     </li>
     <li><label class="label_name">员工编号：</label><span class="add_name"><input name="empId" id="empId" type="text"  class="text_add" placeholder="必填" /></span><div class="prompt r_f"></div></li>
     <!-- <li><label class="label_name">公司编号：</label><span class="add_name"><input name="comId" id="comId" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">添加角色：</label><span class="add_name">&nbsp;&nbsp;&nbsp;&nbsp;
             <select id="roles" name="roleId" data-selector data-selector-checks="true">
                <c:forEach items="${roles}" var="r" ><option value="${r.roleId }">${r.roleName }</option></c:forEach>
            </select></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span class="add_name">
     <label><input name="userState" value="0" type="radio" checked="checked" class="ace"><span class="lbl">启用</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="userState" value="1" type="radio" class="ace"><span class="lbl">不启用</span></label></span><div class="prompt r_f"></div></li><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    	<!-- <input name="roleId" type="hidden" id="myroleid" > -->
    </ul>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="提交"><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
 </div>
  </form>
  
</body>
</html>
<script>

new verSelector();

/* 添加用户判断 */
function add(obj){
		var pass4 = document.getElementById("uname").value;
		var pass5 = document.getElementById("upass").value;
		var pass1 = document.getElementById("empId").value;
		var pass2 = document.getElementById("comId").value;
		var pass3 = document.getElementById("roles").value;
		
		var roleId="";
		$(".actives").each(function(i,e){
		    /* alert($(this).attr("data-value")); */
		    roleId+="roleId="+$(this).attr("data-value")+"&";
		});
		
		obj.action=obj.action+"?"+roleId;
		/* alert(obj.action); */
		if (pass4==""){
			  layer.alert('用户名不能为空!',{
              title: '提示框',				
				icon:0,
			 });
			return false;
          } if (pass5==""){
			  layer.alert('密码不能为空!',{
              title: '提示框',				
				icon:0,
			 });
			return false;
          } 
		if (pass1==""){
			  layer.alert('员工编号不能为空!',{
              title: '提示框',				
				icon:0,
			 });
			return false;
          } 
		  if (pass2==""){
			  layer.alert('公司编号不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          } 
		   
		  if (pass3==""){
			  layer.alert('角色不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          }
		    
	}


/* 修改判断 */
	function update(obj){
		var pass1 = document.getElementById("empIdx").value;
		var pass2 = document.getElementById("comIdx").value;
		//var pass3 = document.getElementById("rolesx");
		
		var roleId="";
		$(".actives").each(function(i,e){
		    /* alert($(this).attr("data-value")); */
		    roleId+="roleId="+$(this).attr("data-value")+"&";
		});
		obj.action=obj.action+"?"+roleId;
		/* alert(obj.action);
		alert(roleId); */
		if (pass1==""){
			  layer.alert('员工编号不能为空!',{
              title: '提示框',				
				icon:0,
			 });
			return false;
          } 
		  if (pass2==""){
			  layer.alert('公司编号不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          } 
		   
		  if (pass3==""){
			  layer.alert('角色不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          }
		    
	}	
</script>


<script type="text/javascript">
/* 删除 */
function del_user(uId){
 		layer.confirm('是否确定删除？',{
                btn: ['是','否'] ,				
				icon:2,
				},
				function(){
						  location.href="del.do?userId="+uId;
						  return true;
					 	},
				function(){
					 	
					 	}	
 		)
 };


/*用户-编辑*/
function member_edit(id){
	  layer.open({
        type: 1,
        title: '修改用户信息',
		maxmin: true, 
		shadeClose:false, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#update_menber_style'),
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

function jia(userId)
    {  $("#roles").change();
        var url="selectById.do?userId="+userId;
     
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {//从前台回调回来的数组，处理后的数据
       //alert(JSON.stringify(data));
       
         $("#userName").val(data.userName);//将取出的值覆盖原来的值 （val对值进行操作)	
         $("#userPassword").val(data.userPassword);
         $("#empName").val(data.empName);
         $("#rolesx").val(data.roleName);
         $("#userId").val(data.userId);
         $("#userPassword").val(data.userPassword);
         $("#empIdx").val(data.empId);
         $("#comIdx").val(data.comId);
         $("#userState").val(data.userState);
         var roles = data.roles;
         for(var i in roles){
         
         	var rid = roles[i].roleId;
         	
         	 $("p[data-value]").each(function(i, element) {
         	  
         	 /*verSelector-option-value verSelector-two actives*/
         	//alert($(element).attr("data-value"));
         	if($(element).attr("data-value") == rid){
         	//class="verSelector-option-value verSelector-two actives"
         	  // $(element).addClass("verSelector-option-value verSelector-two actives");
         	  // alert(element.className);
         	   $(element).click();
         	}
         }); 
         }   
      }
    });
}


/*用户-添加*/
 $('#member_add').on('click', function(){
    layer.open({
        type: 1,
        title: '添加用户',
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



/*添加权限*/
/* $('#Competence_add').on('click', function(){	 
	 layer.open({
        type: 1,
        title: '添加权限',
		maxmin: true, 
		shadeClose: false,
        area : ['800px' , ''],
        content:$('#Competence_add_style'),
		btn:['提交','取消'],
		yes:function(index,layero){	
		 var num=0;
		 var str="";
     $(".col-sm-9 input[type$='text'],#form_textarea").each(function(n){
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
 });*/
 /*权限-删除*/
function Competence_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
/*修改权限*/
function Competence_del(id){
		window.location.href ="Competence.html?="+id;
};	
/*字数限制*/
function checkLength(which) {
	var maxChars = 200; //
	if(which.value.length > maxChars){
	   layer.open({
	   icon:2,
	   title:'提示框',
	   content:'您出入的字数超多限制!',	
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
//面包屑返回值
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
$('.Order_form ,#Competence_add').on('click', function(){
	var cname = $(this).attr("title");
	var cnames = parent.$('.Current_page').html();
	var herf = parent.$("#iframe").attr("src");
    parent.$('#parentIframe span').html(cname);
	parent.$('#parentIframe').css("display","inline-block");
    parent.$('.Current_page').attr("name",herf).css({"color":"#4c8fbd","cursor":"pointer"});
	//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+">" + cnames + "</a>");
    parent.layer.close(index);
	
});
</script>
