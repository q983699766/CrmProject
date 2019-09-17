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
				<th width="10%">查看详情</th> 
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
        <td width="10%"><a href="javascript:"  class="member_show"  onclick="jia(${t.dutId})">查看详情</a></td>
        <td>
               <a title="编辑" onclick="Competence_modify('560')" href='upadte.do?dutId=${ t.dutId}'  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>        
               <a title="删除" href='del.do?dutId=${t.dutId}'   class="btn btn-xs btn-warning" onclick="return window.confirm('是否确定删除此用户?')"><i class="fa fa-trash  bigger-120"></i></a>
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

<div class="add_menber" id="add_menber_style" style="display:none">
     <form action="updataduty.do" method="post" onsubmit=" return t()">
    <ul class=" page-content">
     <li><label class="label_name">职位名称：</label><span class="add_name">
     	<input name="dutName" type="text"  class="text_add" placeholder="必填"/>
     <input type="hidden" name="dutId" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">所属部门：</label><span class="add_name">
      <select name="secId" style="width: 170px;color:green;">
                  <option value="0">部门类型</option>
                  <c:forEach items="${ls }" var="u">
    			<option value="${u.secId}">${u.secName}</option>
    			  </c:forEach>
 				 </select>
     </span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息：</label><span class="add_name"><input id="dutRemark1" name="dutRemark" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
	 <li><label class="label_name">所属公司：</label><span class="add_name"><select name="comId" style="width: 170px;color:green;">
                  <option value="0">选择公司</option>
                  <c:forEach items="${cs }" var="k">
    			<option value="${k.comId}">${k.comName}</option>
    			  </c:forEach>
 				 </select>
     </span><div class="prompt r_f"></div></li>
    </ul>
    <div class="center"> <input class="btn btn-primary" type="submit" id="submit" value="添加"/><br/><br/><br/><br/></div>
  </form>
 </div>
  
  <!-- 查看详情 -->
<div class="add_menber" id="show_menber_style" style="display:none"> 
    <ul class=" page-content">
     <li><label class="label_name">职位名称：</label><span class="add_name"><input  type="text" readonly="readonly" id="dutName" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">所属部门：</label><span class="add_name"><input  type="text" readonly="readonly" id="secId" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注说明：</label><span class="add_name"><input readonly="readonly" type="text" id="dutRemark" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">所属公司：</label><span class="add_name"><input readonly="readonly" type="text" id="comId" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">修改时间：</label><span class="add_name"><input readonly="readonly" type="text" id="lastTime" class="text_add"/></span><div class="prompt r_f"></div></li>
   </ul>
 </div>
 <div class="add_menber" id="show_menber_style" style="display:none"> 
    <ul class=" page-content">
     <li><label class="label_name">职位名称：</label><span class="add_name"><input  type="text" readonly="readonly" id="dutName" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">所属部门：</label><span class="add_name"><input  type="text" readonly="readonly" id="secId" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注说明：</label><span class="add_name"><input readonly="readonly" type="text" id="dutRemark" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">所属公司：</label><span class="add_name"><input readonly="readonly" type="text" id="comId" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">修改时间：</label><span class="add_name"><input readonly="readonly" type="text" id="lastTime" class="text_add"/></span><div class="prompt r_f"></div></li>
   </ul>
 </div>
</body>
</html>
<script>
	function t(){
		var dutRemark = document.getElementById("dutRemark1").value;
		if (dutRemark==""){
			  layer.alert('职位信息不能为空!',{
              title: '提示框',				
				icon:0, 
			 });
			return false;
          } 
          }
</script>
<script>
/*用户-添加*/
 $('#member_add').on('click', function(){
    layer.open({
        type: 1,
        title: '添加职位',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber_style')
		})
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
       	 $("#dutName").val(data.dutName);
         $("#secId").val(data.secId);//将取出的值覆盖原来的值 （val对值进行操作)
         $("#dutRemark").val(data.dutRemark);
          $("#comId").val(data.comId);
         $("#lastTime").val(data.lastTime);   
      }
    });   
    } 
</script>
