
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
        <a href="sysEmpuser/sysEmpuserexcle.do" class="btn btn-warning"> <i class="layui-icon layui-icon-download-circle">&nbsp;导出Excel</i> </a>
       
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
				<th width="5%">审核状态</th>
				<th width="5%">公司编号</th>
				<th width="5%">修改时间</th>
				<th width="5%">详细信息</th>  
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
        <td width="8%">
        ${t.empEduca=='1' ? "小学":"" }
         ${t.empEduca=='2' ? "中学":"" }
          ${t.empEduca=='3' ? "大专":"" }
          ${t.empEduca=='4' ? "本科":"" }
          ${t.empEduca=='5' ? "硕士/博士":"" }
        </td> 
        <td width="8%">${t.empSchool }</td> 
        <td width="5%">${t.empPhone }</td> 
         <td width="5%">
           ${t.dutId=='1' ? "员工":"" }
         ${t.dutId=='2' ? "主管":"" }
          ${t.dutId=='3' ? "副主管":"" }
          ${t.dutId=='4' ? "经理":"" }
          ${t.dutId=='5' ? "总经理":"" }
          ${t.dutId=='6' ? "总监":"" }
          ${t.dutId=='7' ? "副总监":"" }
          ${t.dutId=='8' ? "董事长":"" }
         </td> 
         <td width="8%">
         ${t.empSysstate=='1' ? "审核通过":"" }
         ${t.empSysstate=='2' ? "审核失败":"" }
         </td> 
         <td width="5%">
       
         ${t.comId=='1' ? "小管有限公司":"" }
         ${t.comId=='2' ? "小唐有限公司":"" }
         ${t.comId=='3' ? "小余有限公司":"" }
         ${t.comId=='11' ? "小陈有限公司":"" }
         ${t.comId=='12' ? "小钟有限公司":"" }
         ${t.comId=='13' ? "小樊有限公司":"" }
         ${t.comId=='14' ? "小刘有限公司":"" }
         ${t.comId=='15' ? "小万有限公司":"" }
         </td> 
        <td width="6%"><fmt:formatDate value="${t.lastTime}" pattern="yyyy-MM-dd" /></td>
        <td width="5%"><a href="javascript:" class="member_show"  onclick="look(${t.empId });">查看详情</a></td>
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
 <!--添加用户图层--> 
 <div class="add_menber" id="add_menber_style" style="display:none">
 <form action="sysEmpuser/add.do" method="post" enctype="multipart/form-data" onsubmit="return t()">
    <ul class=" page-content">
     <li><label class="label_name">员工姓名：</label><span class="add_name"><input  type="hidden" name="empId" ><input id="empName1" name="empName" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">员工性别：</label><span class="add_name">
     <select  name="empSix" id="empSix1" style="width: 170px;color:green;">
                  <option value="0">请选择--</option>
    			<option value="1">男</option>
    			  <option value="2">女</option>
 				 </select>
     </span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">员工照片：</label><span class="add_name"><input id="files1" name="files" type="file"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">身份证号：</label><span class="add_name"><input id="empNumber1" name="empNumber" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">家乡地址：</label><span class="add_name"><input id="empAddress1"  name="empAddress" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">现在地址：</label><span class="add_name"><input   name="empTadayadd" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">员工学历：</label><span class="add_name">
  	  <select   name="empEduca"  style="width: 170px;color:green;">
      <option value="0">请选择--</option>
      <option value="1">小学</option>
      <option value="2">中学</option>
      <option value="3">大专</option>
      <option value="4">本科</option>
      <option value="5">硕士/博士</option>
      </select>
  	 </span><div class="prompt r_f"></div></li>
     <li><label class="label_name">政治面貌：</label><span class="add_name"><input id="empFace1"   name="empFace" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">毕业学校：</label><span class="add_name"><input id="empSchool1"  name="empSchool" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">联系电话：</label><span class="add_name"><input   id="empPhone1" name="empPhone" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">网上联系方式：</label><span class="add_name"><input name="empMeshphone" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">网上联系详情：</label><span class="add_name"><input  name="empContact" type="text"  class="text_add" placeholder="必填"/></span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">审核状态：</label><span class="add_name">
  	  <select   name="empState"  style="width: 170px;color:green;">
      <option value="0">请选择--</option>
      <option value="1">审核通过</option>
      <option value="2">审核失败</option>
      </select>
  	 </span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">职务编号：</label><span class="add_name">
  	<select name="dutId" style="width: 170px;color:green;">
                  <option value="0">选择职务</option>
                  <c:forEach items="${coom }" var="s">
    			<option value="${s.dutId}">${s.dutName}</option>
    			  </c:forEach>
 				 </select>
  	 </span><div class="prompt r_f"></div></li>
  	 <li><label class="label_name">员工状态：</label><span class="add_name">
  	 <select   name="empSysstate"  style="width: 170px;color:green;">
      <option value="0">请选择--</option>
      <option value="1">在职</option>
      <option value="2">离职</option>
      </select>
  	 </span><div class="prompt r_f"></div></li>
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
    <div class="center"><input class="btn btn-primary" type="submit" id="submit" value="添加"><br/><br/><br/><br/> </div>
 </form>
 </div>
     <!-- 查看详情 -->
 <div class="add_menber" id="show_menber_style" style="display:none"> 
    <ul class=" page-content">
     <li><label class="label_name">员工姓名：</label><span class="add_name"><input  type="text" readonly="readonly" id="empName" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">员工性别：</label><span class="add_name"><input  type="text" readonly="readonly" id="empSix"  class="text_add"/></span><div class="prompt r_f"></div></li>
      <li><label class="label_name">员工照片：</label><span class="add_name"><input readonly="readonly" type="text" id="empPrice" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">身份证号：</label><span class="add_name"><input readonly="readonly" type="text" id="empNumber" class="text_add"/></span><div class="prompt r_f"></div></li>
        <li><label class="label_name">家庭住址：</label><span class="add_name"><input  type="text" readonly="readonly" id="empAddress" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">现在地址：</label><span class="add_name"><input  type="text" readonly="readonly" id="empTadayadd" class="text_add"/></span><div class="prompt r_f"></div></li>
      <li><label class="label_name">员工学历：</label><span class="add_name"><input readonly="readonly" type="text" id="empEduca" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">政治面貌：</label><span class="add_name"><input readonly="readonly" type="text"  id="empFace" class="text_add"/></span><div class="prompt r_f"></div></li>
        <li><label class="label_name">毕业学校：</label><span class="add_name"><input  type="text" readonly="readonly" id="empSchool" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">联系电话：</label><span class="add_name"><input  type="text" readonly="readonly" id="empPhone" class="text_add"/></span><div class="prompt r_f"></div></li>
      <li><label class="label_name">网上联系方式：</label><span class="add_name"><input readonly="readonly" type="text" id="empMeshphone" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">网上联系详情：</label><span class="add_name"><input readonly="readonly" type="text" id="empContact" class="text_add"/></span><div class="prompt r_f"></div></li>
      <li><label class="label_name">审核状态：</label><span class="add_name"><input readonly="readonly" type="text" id="empState" class="text_add"/></span><div class="prompt r_f"></div></li>
        <li><label class="label_name">职务编号：</label><span class="add_name"><input  type="text" readonly="readonly" id="dutId" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">员工状态：</label><span class="add_name"><input  type="text" readonly="readonly" id="empSysstate" class="text_add"/></span><div class="prompt r_f"></div></li>
      <li><label class="label_name">备注信息：</label><span class="add_name"><input readonly="readonly" type="text" id="empRemark" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">公司编号：</label><span class="add_name"><input readonly="readonly" type="text" id="comId" class="text_add"/></span><div class="prompt r_f"></div></li>
      <li><label class="label_name">修改时间：</label><span class="add_name"><input readonly="readonly" type="text" id="lastTime" class="text_add"/></span><div class="prompt r_f"></div></li>
   
   </ul>
   </div>
</body>
</html>
<script>
	function t(){
		var empName = document.getElementById("empName1").value;
		var empSix = document.getElementById("empSix1").value;
		var files = document.getElementById("files1").value;
		var empNumber = document.getElementById("empNumber1").value;
		var empAddress = document.getElementById("empAddress1").value;
		var empFace = document.getElementById("empFace1").value;
		var empSchool = document.getElementById("empSchool1").value;
		var empPhone = document.getElementById("empPhone1").value;
		var regTel = /0?(13|14|15|18|17)[0-9]{9}/;
		if (empName==""){
			  layer.alert('员工姓名不能为空!',{
              title: '提示框',				
				icon:0, 
			 });
			return false;
          } 
         if (empSix=="0"){
			  layer.alert('员工性别不能为空!',{
              title: '提示框',				
				icon:0, 
			 });
			return false;
          } 
          if (files==""){
			  layer.alert('员工照片不能为空!',{
              title: '提示框',				
				icon:0, 
			 });
			return false;
          } 
           if (empNumber==""){
			  layer.alert('身份证号不能为空!',{
              title: '提示框',				
				icon:0, 
			 });
			return false;
          } 
            if (empAddress==""){
			  layer.alert('家庭地址不能为空!',{
              title: '提示框',				
				icon:0, 
			 });
			return false;
          } 
             if (empFace==""){
			  layer.alert('政治面貌不能为空!',{
              title: '提示框',				
				icon:0, 
			 });
			return false;
          } 
             if (empSchool==""){
			  layer.alert('毕业院校不能为空!',{
              title: '提示框',				
				icon:0, 
			 });
			return false;
          } 
             if (!regTel.test(empPhone) ){
			  layer.alert('电话格式不正确!',{
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
        title: '添加公司',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber_style'),
		
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
 
function look(empId)
    {
    var url='sysEmpuser/detail.do?empId='+empId;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {
       	 $("#empName").val(data.empName);
         $("#empSix").val(data.empSix);//将取出的值覆盖原来的值 （val对值进行操作)
         $("#empPrice").val(data.empPrice);
         $("#empNumber").val(data.empNumber); 
          $("#empAddress").val(data.empAddress);
         $("#empTadayadd").val(data.empTadayadd);//将取出的值覆盖原来的值 （val对值进行操作)
         $("#empEduca").val(data.empEduca);
         $("#empContact").val(data.empContact);
         $("#empFace").val(data.empFace); 
          $("#empSchool").val(data.empSchool);
         $("#empPhone").val(data.empPhone);//将取出的值覆盖原来的值 （val对值进行操作)
         $("#empMeshphone").val(data.empMeshphone);
         $("#empState").val(data.empState);
         $("#dutId").val(data.dutId);
         $("#empSysstate").val(data.empSysstate);//将取出的值覆盖原来的值 （val对值进行操作)
         $("#empRemark").val(data.empRemark);
         $("#comId").val(data.comId);
          $("#lastTime").val(data.lastTime);   
           
      }
    });   
    } 

</script>
<script type="text/javascript">
jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable( {
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,2,3,4,5,6,7,8,9]}// 制定列不参与排序
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