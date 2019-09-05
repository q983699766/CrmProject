
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basepath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/style.css"/>       
        <link rel="stylesheet" href="assets/css/ace.min.css" />
        <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
        <link rel="stylesheet" href="Widget/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
        <link href="Widget/icheck/icheck.css" rel="stylesheet" type="text/css" />   
		
	    <script src="js/jquery-1.9.1.min.js"></script>   
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/typeahead-bs2.min.js"></script>
		
		<script src="assets/js/jquery.dataTables.min.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="js/H-ui.js"></script> 
        <script type="text/javascript" src="js/H-ui.admin.js"></script> 
        <script src="assets/layer/layer.js" type="text/javascript" ></script>
        <script src="assets/laydate/laydate.js" type="text/javascript"></script>
        <script type="text/javascript" src="Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script> 
        <script src="js/lrtk.js" type="text/javascript" ></script>
	<title>产品列表</title>
	<style type="text/css">
	.page{
		margin-left: 1166px;
		color: red;
	}
	.table table-striped table-bordered table-hover{
	width: 1400px;
	}
	</style>
</head>
<body>
		
<div class=" page-content clearfix">
 <div id="products_style">
     <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="member_add" class="btn btn-warning" title="添加员工信息"><i class="fa fa-plus"></i>&nbsp;添加员工信息</a>
       </span>
     </div>
     <!--产品列表展示-->
     <div class="h_products_list clearfix" id="products_list">
       <div id="scrollsidebar" class="left_Treeview">
      </div>  
     </div>
       
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="5%">员工编号</th>
				<th width="8%">员工姓名</th> 
				<th width="5%">性别</th> 
				<th width="5%">照片</th>
				<th width="8%">家庭地址</th>
				<th width="5%">学历</th>
				<th width="8%">毕业院校</th>
				<th width="8%">联系方式</th>
				<th width="8%">职务编号</th>
				<th width="5%">状态</th>
				<th width="8%">备注信息</th>
				<th width="5%">公司编号</th>
				<th width="5%">修改时间</th> 
				<th width="8%">操作</th>
			</tr>
		</thead>
	<tbody>
	<c:forEach items="${Empuser }" var="t" >
     <tr>
        <td width="8%">${t.empId }</td>               
        <td width="8%">${t.empName}</td>
        <td width="5%">${t.empSix}</td>
        <td width="8%"><a href="sysEmpuser/xz.do?empPrice=${t.empPrice}"><img src="upload/${t.empPrice}" width="60px" height="50px"></a> </td> 
        <td width="8%">${t.empAddress}</td>
        <td width="8%">${t.empEduca }</td> 
        <td width="8%">${t.empSchool }</td> 
        <td width="5%">${t.empPhone }</td> 
         <td width="5%">${t.dutId }</td> 
         <td width="8%">${t.empSysstate }</td> 
         <td width="5%">${t.empRemark }</td> 
         <td width="5%">${t.comId }</td> 
        <td width="8%"><fmt:formatDate value="${t.lastTime}" pattern="yyyy-MM-dd" /></td>
        </td>
        <td class="td-manage">
        <a title="编辑"  href='sysEmpuser/selectEmpuser.do?empId=${ t.empId}'  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
        <a title="删除" href='sysEmpuser/delEmpuser.do?empId=${t.empId}' class="btn btn-xs btn-warning" onclick="return window.confirm('是否确定删除此用户?')"><i class="icon-trash  bigger-120"></i></a>
       </td>
	  </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>     
  </div>
 </div>
 <!--添加用户图层--> 
 <form action="sysEmpuser/add.do" method="post" enctype="multipart/form-data">
<div class="add_menber" id="add_menber_style" style="display:none">
  
    <ul class=" page-content">
     <li><label class="label_name">员工姓名：</label><span class="add_name"><input  type="hidden" name="empId" ><input value="" name="empName" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">员工性别：</label><span class="add_name"><input name="empSix" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">员工照片：</label><span class="add_name"><input value="" name="files" type="file"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">身份证号：</label><span class="add_name"><input value="" name="empNumber" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">家乡地址：</label><span class="add_name"><input value="" name="empAddress" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">现在地址：</label><span class="add_name"><input value="" name="empTadayadd" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">员工学历：</label><span class="add_name"><input value="" name="empEduca" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">政治面貌：</label><span class="add_name"><input value="" name="empFace" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">毕业学校：</label><span class="add_name"><input value="" name="empSchool" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">联系电话：</label><span class="add_name"><input value="" name="empPhone" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">网上联系方式：</label><span class="add_name"><input value="" name="empMeshphone" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">网上联系详情：</label><span class="add_name"><input value="" name="empContact" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">审核状态：</label><span class="add_name"><input value="" name="empState" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">职务编号：</label><span class="add_name">
  	<select name="dutId" style="width: 170px;color:green;">
                  <option value="0">选择公司</option>
                  <c:forEach items="${coom }" var="s">
    			<option value="${s.dutId}">${s.dutName}</option>
    			  </c:forEach>
 				 </select>
  	 </span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">员工状态：</label><span class="add_name"><input value="" name="empSysstate" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">备注信息：</label><span class="add_name"><input value="" name="empRemark" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">公司编号：</label><span class="add_name">
  	 <select name="comId" style="width: 170px;color:green;">
                  <option value="0">选择公司</option>
                  <c:forEach items="${com }" var="k">
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
jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable( {
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,2,3,4,5,8,9]}// 制定列不参与排序
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
			});
 laydate({
    elem: '#start',
    event: 'focus' 
});
$(function() { 
	$("#products_style").fix({
		float : 'left',
		//minStatue : true,
		skin : 'green',	
		durationTime :false,
		spacingw:30,//设置隐藏时的距离
	    spacingh:260,//设置显示时间距
	});
});
</script>
<script type="text/javascript">
//初始化宽度、高度  
 $(".widget-box").height($(window).height()-215); 
$(".table_menu_list").width($(window).width()-260);
 $(".table_menu_list").height($(window).height()-215);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".widget-box").height($(window).height()-215);
	 $(".table_menu_list").width($(window).width()-260);
	  $(".table_menu_list").height($(window).height()-215);
	})
 
/*******树状图*******/
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				demoIframe.attr("src",treeNode.file + ".html");
				return true;
			}
		}
	}
};	
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}
		
$(document).ready(function(){
	var t = $("#treeDemo");
	t = $.fn.zTree.init(t, setting, zNodes);
	demoIframe = $("#testIframe");
	demoIframe.bind("load", loadReady);
	var zTree = $.fn.zTree.getZTreeObj("tree");
	zTree.selectNode(zTree.getNodeByParam("id",'11'));
});	

/*产品-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}

//面包屑返回值
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
$('.Order_form').on('click', function(){
	var cname = $(this).attr("title");
	var chref = $(this).attr("href");
	var cnames = parent.$('.Current_page').html();
	var herf = parent.$("#iframe").attr("src");
    parent.$('#parentIframe').html(cname);
    parent.$('#iframe').attr("src",chref).ready();;
	parent.$('#parentIframe').css("display","inline-block");
	parent.$('.Current_page').attr({"name":herf,"href":"javascript:void(0)"}).css({"color":"#4c8fbd","cursor":"pointer"});
	//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
    parent.layer.close(index);
	
});
</script>
<script type="text/javascript">
/*用户-添加*/
 $('#member_add').on('click', function(){
    layer.open({
        type: 1,
        title: '添加员工信息',
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