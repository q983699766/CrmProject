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
	
		<script src="../layui/layui.js"></script>
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
 <div class="margin clearfix">
   <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="member_add" class="btn btn-warning" title="添加用户"><i class="fa fa-plus"></i>&nbsp;添加部门</a>
       </span>
       
     </div>
     <div class="compete_list">
       <table id="sample-table-1" class="table table-striped table-bordered table-hover">
		 <thead>
			<tr>
			  
			  <th>部门编号</th>
              <th>部门名称</th>
              <th>备注信息</th>
               <th>所属公司</th>
              <th>最后操作时间</th>
              <th>詳細信息</th>            
			  <th class="hidden-480">操作</th>
             </tr>
		    </thead>
             <tbody>
             <c:forEach items="${branch }" var="u">
			  <tr>
				<td>${u.secId }</td>
				<td>${u.secName }</td>
				<td>${u.secComment }</td>
				<td>${u.comId }</td>
				<td><fmt:formatDate value="${u.lastTime }" pattern="yyyy-MM-dd HH:mm"/></td>
				<td width="10%"><a href="javascript:"  class="member_show"  onclick="jia(${u.secId})">查看详情</a></td>
				<td>
                 <a title="编辑" onclick="Competence_modify('560')" href='selectBranch.do?secId=${u.secId}'  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>        
                 <a title="删除" href='delBranch.do?secId=${u.secId}'  class="btn btn-xs btn-warning"  onclick="return window.confirm('是否确定删除此用户?')"><i class="fa fa-trash  bigger-120"></i></a>
				</td>
			   </tr>
			   </c:forEach>												
		      </tbody>
	        </table>
     </div>
 </div> 
  
 <!--添加用户图层--> 
 <div class="add_menber" id="add_menber_style" style="display:none">
 <form action="addBranch.do" method="post" onsubmit=" return t()" >
    <ul class=" page-content">
     <li><label class="label_name">部门名称：</label><span class="add_name"><input  name="secName" type="text"  class="text_add" placeholder="必填" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息：</label><span class="add_name"><input name="secComment" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">公司编号：</label><span class="add_name"><select name="comId" style="width: 170px;color:green;">
                  <option value="0">选择公司</option>
                  <c:forEach items="${as }" var="k">
    			<option value="${k.comId}">${k.comName}</option>
    			  </c:forEach>
 				 </select>
     </span><div class="prompt r_f"></div></li>
    </ul>
    <div class="center">
    <input class="btn btn-primary" type="submit" id="submit" value="添加"/><br/><br/><br/><br/> </div>
  </form>
 </div> 
 <!-- 查看详情 -->
 <div class="add_menber" id="show_menber_style" style="display:none"> 
    <ul class=" page-content">
     <li><label class="label_name">部门名称：</label><span class="add_name"><input  type="text" readonly="readonly" id="secName" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息：</label><span class="add_name"><input  type="text" readonly="readonly" id="secComment" class="text_add"/></span><div class="prompt r_f"></div></li>
      <li><label class="label_name">所属公司：</label><span class="add_name"><input readonly="readonly" type="text" id="comId" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">修改时间：</label><span class="add_name"><input readonly="readonly" type="text" id="lastTime" class="text_add"/></span><div class="prompt r_f"></div></li>
   </ul>
 </div>   
</body>
</html>
<script>
function t(){
		var secName = document.getElementById("secName").value;
		if (secName==""){
			  layer.alert('部门名称不能为空!',{
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
        title: '添加职务',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber_style')
    });
});

$('.member_show').on('click', function(){
    layer.open({
      type: 1,
      title: '详细信息',
      area: ['800px', ''],
      shadeClose: true, //点击遮罩关闭
      maxmin: true, 
      content:$('#show_menber_style')
     })
});
 
function jia(dutId)
    {
        var url='detail.do?dutId='+dutId;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {
       	 $("#secName").val(data.secName);
         $("#secComment").val(data.secComment);//将取出的值覆盖原来的值 （val对值进行操作)
         $("#comId").val(data.comId);
         $("#lastTime").val(data.lastTime);   
      }
    });   
    } 

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
