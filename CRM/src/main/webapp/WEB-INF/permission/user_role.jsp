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
<title>管理权限</title>
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
			layer.alert('操作失败,权限名已存在！',{
               title: '提示框',				
			   icon:2,		   		
			  });
	}
	if(ok=="3"){
			layer.alert('操作失败,权限分栏名已存在！',{
               title: '提示框',				
			   icon:2,		   		
			  });
	}
	if(ok=="4"){
			layer.alert('操作失败,无法删除全部分栏！',{
               title: '提示框',				
			   icon:2,		   		
			  });
	}
	if(ok=="5"){
			layer.alert('操作失败,分栏内必须为空！',{
               title: '提示框',				
			   icon:2,		   		
			  });
	}
</script>


 <div class="margin clearfix">
 
 	<%-- <div class="search_style">
    	<font size="80">${aa.ckM }</font> 
    <form action="#" method="post">
      <div class="title_names">权限名关键字查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">模糊查询</label><input name="ccspxx" type="text"  class="text_add" placeholder="请输入关键字:"  style=" width:400px"/></li>
       <li style="width:90px;"><button type="submit" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
      </form>
    </div> --%>
 
 <form action="getPermByCol.do" method="post">
   <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:;" id="member_add" class="btn btn-warning" title="普通管理员及以上可用"><i class="fa fa-plus"></i>&nbsp;给角色配置权限</a>
        <a href="javascript:;" id="member_addperm" class="btn btn-warning" title="超级管理员可用"><i class="fa fa-plus"></i> 添加权限</a>
        <a href="javascript:;" id="member_addpermcol" class="btn btn-warning" title="超级管理员可用"><i class="fa fa-plus"></i> 添加权限分栏</a>
        
       	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选择分栏查看管理权限
       	<select name="columnName">
       		<option value="all">查看全部</option>
       		<c:forEach items="${col }" var="c"><option value="${c.columnName}" ${c.columnName ==colName ? 'selected="selected"':'false' }>${c.columnName}</option></c:forEach>
       	</select>
       	
       </span>
       <input type="submit" class="btn btn-warning" value="查看"/>
       <a href="javascript:;"  onclick="delpermcol()" class="btn btn-danger" title="超级管理员可用"><i class="fa fa-trash"></i> 删除当前的分栏</a>
       <a href="javascript:;"  onclick="delallperm()" class="btn btn-danger" title="超级管理员可用"><i class="fa fa-trash"></i> 一键取消除超管外所有角色权限</a>
     </div>
     </form>
     <div class="compete_list">
       <table id="sample-table-1" class="table table-striped table-bordered table-hover">
		 <thead>
			<tr>
			  <!-- <th class="center"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th> -->
			  <th>权限名称</th>
              <th>权限所在分栏</th>
			  <th class="hidden-480">权限别名</th>             
			  <th class="hidden-480">操作</th>
             </tr>
		    </thead>
             <tbody>
             
             <c:forEach items="${list.list }" var="p">
             		
			  <tr>
				<!-- <td class="center"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td> -->
				<td>${p.permissionName }</td>
				
				<td class="hidden-480">${p.permissionColumn }</td>
				<td>${p.remark }</td>
				<td>
                 <a title="编辑" onclick="jia(${p.permissionId });member_edit('550');" href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>        
          			<a title="删除" href="javascript:;"  onclick="del_perm(${p.permissionId })" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
				</td>
			   </tr>
			   </c:forEach>	
			   <tr style="text-align: center;">
    				<td colspan="7">
    			<a href="getPermByCol.do?pageNum=${list.navigateFirstPage }&columnName=${colName}">首页</a>
    			<a href="getPermByCol.do?pageNum=${list.prePage}&columnName=${colName}">上一页</a>
    			<a href="getPermByCol.do?pageNum=${list.nextPage }&columnName=${colName}">下一页</a>
    			<a href="getPermByCol.do?pageNum=${list.navigateLastPage }&columnName=${colName}">尾页</a>
    			当前第${list.pageNum }/${list.pages }页，共${list. total}条，每页10条
    				</td>
    		</tr>			
		      </tbody>
	        </table>
     </div>
 </div>
 
 <!-- 添加权限分栏 -->
 <form action="addpermcol.do" method="post" onsubmit="return addpermcol()">
<div class="add_menber" id="add_menber2_style" style="display:none">
  <br/>
    <ul class=" page-content">
     <li><label class="label_name">分栏名称：</label><span class="add_name"><input  type="text" name="columnName" id="columnName" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">分栏描述：</label><span class="add_name"><input  type="text" name="remark" id="remark111" class="text_add"/></span><div class="prompt r_f"></div></li>
    </ul>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="提交"><br/><br/>
 </div>
 </div>
  </form>
 
 
 
 <!--修改权限-->
 <form action="update.do" method="post" onsubmit="return updateperm()">
 <input type="hidden" name="permissionId" id="permissionId"/>
 <input type="hidden" name="permissionColumn" id="permissionColumn"/>
<div class="add_menber" id="update_menber_style" style="display:none"> 
    <ul class=" page-content">
     <!-- <li><label class="label_name">客户编号：</label><span class="add_name"><input  type="text"  class="text_add"/></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">权限名称：</label><span class="add_name"><input  type="text" name="permissionName" id="permissionNamex" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">权限描述：</label><span class="add_name"><input  type="text" name="remark" id="remarkx" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">权限方法：</label><span class="add_name"><input  type="text" name="permission" id="permission" class="text_add"/></span><div class="prompt r_f"></div></li>
     <%-- <li><label class="label_name">下列角色拥有该权限：按住ctrl，点击多选</label><span class="add_name">
     		&nbsp;&nbsp;&nbsp;&nbsp;<select id="roles" name="roleId" multiple="multiple">
                <c:forEach items="${roles}" var="r" ><option value="${r.roleId }">${r.roleName }</option></c:forEach>
            </select></span><div class="prompt r_f"></div></li> --%>
            <li><label class="label_name">所在分栏：</label><span class="add_name"><select id="permissionColumnx" name="colId" data-selector>
                <c:forEach items="${col}" var="c" ><option value="${c.columnId }">${c.columnName }</option></c:forEach>
            </select></span><div class="prompt r_f"></div></li>
            <li><label class="label_name"></label><span class="add_name"></span><div class="prompt r_f"></div></li>
    <li><label class="label_name">操&nbsp;作&nbsp;人：</label><span class="add_name">&nbsp;&nbsp;${nowuser.userName }</span><div class="prompt r_f"></div></li>
    </ul><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="提交"></div><br/><br/><br/><br/><br/><br/><br/><br/>
 </div>
</form>
 
 <!-- 添加权限 -->
 <form action="addperm.do" method="post" onsubmit="return addperm()">
<div class="add_menber" id="add_menber1_style" style="display:none">
  <br/>
    <ul class=" page-content">
     <li><label class="label_name">权限名称：</label><span class="add_name"><input  type="text" name="permissionName" id="permissionName111" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">权限方法：</label><span class="add_name"><input  type="text" name="permission" id="permission111" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">权限别名：</label><span class="add_name"><input placeholder="必须型如：user：add" type="text" name="remark" id="remark1" class="text_add" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">所在分栏：</label><span class="add_name"><select id="columnName111" name="columnName" data-selector>
                <c:forEach items="${col}" var="c" ><option value="${c.columnName }">${c.columnName }</option></c:forEach>
            </select></span><div class="prompt r_f"></div></li>
    </ul>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="提交"><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
 </div>
 </div>
  </form>
 
 
 <!--给角色配置权限图层--> 
 <form action="add.do" method="post" onsubmit="return addroleperm(this)">
<div class="add_menber" id="add_menber_style" style="display:none">
  <br/>
    <ul class=" page-content">
     <li><label class="label_name">角色名称：</label><span class="add_name">&nbsp;&nbsp;&nbsp;&nbsp;<select id="role111" name="role" data-selector>
                <c:forEach items="${roles}" var="r" ><c:if test="${r.roleId != 1}"><option value="${r.roleId }">${r.roleName }</option></c:if></c:forEach>
            </select></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">权限名称：</label><span class="add_name">&nbsp;&nbsp;&nbsp;&nbsp;<select id="perm111" name="perm" data-selector data-selector-checks="true">
                <c:forEach items="${permList}" var="p" ><option value="${p.permissionId }">${p.permissionName }</option></c:forEach>
            </select></span><div class="prompt r_f"></div></li>
    </ul><br/><br/><br/><br/><br/>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="提交"><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
 </div>
  </form>
 
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
</body>
</html>
<script>
new verSelector();

/* 添加权限 */
function addperm(){
		var pass1 = document.getElementById("permissionName111").value;
		var pass2 = document.getElementById("permission111").value;
		var pass3 = document.getElementById("remark1").value;
		var pass4 = document.getElementById("columnName111").value;
		
		if (pass1==""){
			  layer.alert('权限分不能为空!',{
              title: '提示框',				
				icon:0,
			 });
			return false;
          } 
		  if (pass2==""){
			  layer.alert('权限方法不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          }   
          if (pass3==""){
			  layer.alert('权限描述不能为空!',{
              title: '提示框',				
				icon:0,
			 });
			return false;
          } 
		  if (pass4==""){
			  layer.alert('权限分栏不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          }  
            
	}	



/* 权限分栏添加 */
function addpermcol(){
		var pass1 = document.getElementById("columnName").value;
		var pass2 = document.getElementById("remark111").value;
		
		if (pass1==""){
			  layer.alert('权限分栏名不能为空!',{
              title: '提示框',				
				icon:0,
			 });
			return false;
          } 
		  if (pass2==""){
			  layer.alert('权限分栏描述不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          }   
            
	}	


/* 权限修改 */
function updateperm(){
		var pass1 = document.getElementById("permissionNamex").value;
		var pass2 = document.getElementById("remarkx").value;
		var pass3 = document.getElementById("permission").value;
		var pass4 = document.getElementById("permissionColumnx").value;
		/* var pass5 = document.getElementById("roles").value; */
		if (pass1==""){
			  layer.alert('权限名不能为空!',{
              title: '提示框',				
				icon:0,
			 });
			return false;
          } 
		  if (pass2==""){
			  layer.alert('权限描述不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          }   
          if (pass3==""){
			  layer.alert('权限方法不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          }   if (pass4==""){
			  layer.alert('权限分栏不能为空!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          }   
	}	


/* 给角色配置权限 */
	function addroleperm(obj){
		var pass1 = document.getElementById("role111").value;
		var pass2 = document.getElementById("perm111").value;
		
		var perm="";
		$(".actives").each(function(i,e){
			if(i!=0)perm+="perm="+$(this).attr("data-value")+"&";
		});
		obj.action=obj.action+"?"+perm;
	
		
		if (pass1==""){
			  layer.alert('角色不能为空!',{
              title: '提示框',				
				icon:0,
			 });
			return false;
          } 
		  if (pass2==""){
			  layer.alert('必须选择至少一个权限!',{
              title: '提示框',				
				icon:0,
			    
			 });
			return false;
          }  
	}	
</script>



<script type="text/javascript">
/* 删除当前分栏 */
function delpermcol(){
		var colname = "${colName}";
 		layer.confirm('是否确定删除？',{
                btn: ['是','否'] ,				
				icon:0,
				},
				function(){
						  location.href="delpermcol.do?colname="+colname;
						  return true;
					 	},
				function(){
					 	
					 	}	
 		)
 };



/* 一键取消 */
function delallperm(){
 		layer.confirm('是否确定全部取消？',{
                btn: ['是','否'] ,				
				icon:0,
				},
				function(){
						  location.href="reset.do";
						  return true;
					 	},
				function(){
					 	
					 	}	
 		)
 };



/* 删除 */
function del_perm(permId){
 		layer.confirm('是否确定删除？',{
                btn: ['是','否'] ,				
				icon:0,
				},
				function(){
						  location.href="del.do?permId="+permId;
						  return true;
					 	},
				function(){
					 	
					 	}	
 		)
 };



/* 权限分栏-添加 */
$('#member_addpermcol').on('click', function(){
    layer.open({
        type: 1,
        title: '添加权限分栏',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber2_style'),
		
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



/* 权限-添加 */
$('#member_addperm').on('click', function(){
    layer.open({
        type: 1,
        title: '添加权限',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber1_style'),
		
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


/*权限-编辑*/
function member_edit(id){
	  layer.open({
        type: 1,
        title: '修改权限',
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

function jia(permId)
    {
        var url="selectById.do?permId="+permId;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {//从前台回调回来的数组，处理后的数据
       //alert(JSON.stringify(data));
         $("#permissionId").val(data.permissionId);//将取出的值覆盖原来的值 （val对值进行操作)	
         $("#permissionNamex").val(data.permissionName);
         $("#permission").val(data.permission);
         $("#remarkx").val(data.remark);
         $("#permissionColumnx").val(data.permissionColumn);
          $("#lastTime").val(data.lastTime);
          var highRoleName = data.permissionColumn;
          $("#permissionColumnx").children().each(function(i, element){
          		if(element.innerHTML == highRoleName)element.selected = "true";
          });
         /* var highRoleName = data.highRoleName;	
         $("#roles").children().each(function(i, element) {
         	if(element.innerHTML == highRoleName)element.selected = "true";
         }); */	 
         
         /*  $(data).each(function(i, role) {
         	alert(role.roleName);
         });  */ 
      }
    });
}



/*权限-角色-添加*/
 $('#member_add').on('click', function(){
    layer.open({
        type: 1,
        title: '给角色配置权限,已有权限会被删除！',
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
 }); */
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
