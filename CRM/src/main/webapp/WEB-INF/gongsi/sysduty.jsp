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
          <link  rel="stylesheet" href="../layui/css/layui.css" />
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
				<script src="../layui/layui.js"></script>
		
		<script src="../js/jquery-1.9.1.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
		<script src="../assets/js/typeahead-bs2.min.js"></script>           	
		<script src="../assets/js/jquery.dataTables.min.js"></script>
		<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="../assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="../assets/laydate/laydate.js" type="text/javascript"></script>
<title>管理用户</title>
<style type="">
.page{
		margin-left: 1400px;
		color: red;
	}
</style>
</head>

<body>
 <div class="margin clearfix">
   <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="member_add" class="btn btn-warning" title="添加用户"><i class="fa fa-plus"></i>&nbsp;添加职位信息</a>
        
       </span>
       
     </div>
     <div class="compete_list">
       <table id="sample-table-1" class="table table-striped table-bordered table-hover">
		 <thead>
			<tr>
			  
				<th width="10%">职位编号</th>
				<th width="10%">职位名称</th> 
				<th width="10%">所属部门</th> 
				<th width="20%">备注说明</th>
				<th width="10%">所属公司</th>
				<th width="10%">修改时间</th> 
				<th width="60%">操作</th>
             </tr>
		    </thead>
             <tbody>
           <c:forEach items="${pi.list }" var="t" >
     	<tr>
        <td width="10%">${t.dutId }</td>               
        <td width="10%">${t.dutName}</td>
        <td width="10%">
        <c:if test="${t.secId==1 }">物流部</c:if>
        <c:if test="${t.secId==2 }">客服部</c:if>
        <c:if test="${t.secId==7 }">人事部</c:if>
        <c:if test="${t.secId==8 }">决策部</c:if>
        </td>
        <td width="10%">${t.dutRemark }</td> 
        <td width="10%">
         <c:if test="${t.comId==1}">小管有限公司</c:if>
       	 <c:if test="${t.comId==2}">小唐有限公司</c:if>
       	 <c:if test="${t.comId==3}">小余有限公司</c:if>
       	 <c:if test="${t.comId==10}">小万有限公司</c:if>
       	 <c:if test="${t.comId==11}">小陈有限公司</c:if>
       	 <c:if test="${t.comId==12}">小钟有限公司</c:if>
       	 <c:if test="${t.comId==13}">小樊有限公司</c:if>
       	 <c:if test="${t.comId==14}">小刘有限公司</c:if>
        </td>         
        <td width="10%"><fmt:formatDate value="${t.lastTime}" pattern="yyyy-MM-dd" /></td>
        <td>
               <a title="编辑" onclick="Competence_modify('560')" href='upadte.do?dutId=${ t.dutId}'  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>        
                <a title="删除" href='del.do?dutId=${t.dutId}'  onclick="Competence_del(this,'1')" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
				</td>
			   </tr>
			   </c:forEach>												
		      </tbody>
	        </table>
	        <div class="page">
    	<a href="listpage.do?pageNum=${pi.firstPage }">首页</a>
           <a href="listpage.do?pageNum=${pi.prePage }">上页</a>
           <a href="listpage.do?pageNum=${pi.nextPage }">下页</a>
           <a href="listpage.do?pageNum=${pi.lastPage }">尾页</a>
           	当前第${pi.pageNum }/ ${pi.pages }页，共${pi.total } 条数据。
          </div>
     </div>
 </div>

  
 <!--添加用户图层--> 
 <form action="updataduty.do" method="post" onsubmit=" return t()">
<div class="add_menber" id="add_menber_style" style="display:none">
    <ul class=" page-content">
     <li><label class="label_name">职位名称：</label><span class="add_name">
     	<input name="dutName" type="text"  class="text_add" placeholder="必填"/>
     <input type="hidden" name="dutId" ></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">所属部门：</label><span class="add_name">
      <select name="secId" style="width: 170px;color:green;">
                  <option value="0">部门类型</option>
                  <c:forEach items="${ls }" var="u">
    			<option value="${u.secId}">${u.secName}</option>
    			  </c:forEach>
 				 </select>
     </span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息：</label><span class="add_name"><input id="dutRemark" name="dutRemark" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
	 <li><label class="label_name">所属公司：</label><span class="add_name"><select name="comId" style="width: 170px;color:green;">
                  <option value="0">选择公司</option>
                  <c:forEach items="${cs }" var="k">
    			<option value="${k.comId}">${k.comName}</option>
    			  </c:forEach>
 				 </select>
     </span><div class="prompt r_f"></div></li>
    </ul>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="添加"><br/><br/><br/><br/>
 </div>
  </form>
  
</body>
</html>
<script>
	function t(){
		var dutRemark = document.getElementById("dutRemark").value;
		if (dutRemark==""){
			  layer.alert('用户名不能为空!',{
              title: '提示框',				
				icon:0, 
			 });
			return false;
          } 
          }
</script>
<script type="text/javascript">
/*用户-添加*/
 $('#member_add').on('click', function(){
    layer.open({
        type: 1,
        title: '添加职位',
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
