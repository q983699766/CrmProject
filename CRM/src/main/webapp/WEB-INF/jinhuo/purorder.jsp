<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="assets/js/jquery.min.js"></script>
	<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/style.css"/>       
        <link href="assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/ace.min.css" />
        <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="<%=basePath%>My97DatePicker/WdatePicker.js" type="text/javascript" defer="defer"  charset="UTF-8"></script>
			<script src="assets/js/jquery.min.js"></script>
			<script src="vue/vue.min.js"></script>
  <!-- 引入JS文件 -->
    <script src="vue.min.js"></script>  
		<!-- <![endif]-->

		<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="assets/js/jquery.dataTables.min.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="js/H-ui.js"></script> 
        <script type="text/javascript" src="js/H-ui.admin.js"></script> 
        <script src="assets/layer/layer.js" type="text/javascript" ></script>
        <script src="assets/laydate/laydate.js" type="text/javascript"></script>

	

  </head>
  
  <body>
   	<div class="page-content clearfix">
    <div id="Member_Ratings">
      <div class="d_Confirm_Order_style">
    <div class="search_style">
    <form action="pursupinfo/selectinfo.do" method="post">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">供应商编号</label><input name="supName" type="text"  class="text_add" placeholder="输入供应商名称、电话、联系人"  style=" width:400px"/></li>
       <!-- <li><label class="l_f">添加时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li> -->
       <li style="width:90px;"><input type="submit" value="查询" class="btn_search"> </li>
      </ul>
    </div>
    </form>
     <!---->
     <!-- <button type="button" class="btn_search"><i class="icon-search"></i>查询</button> -->
    <!--  <div class="border clearfix">
       <span class="l_f">
         <a href="javascript:ovid()" name="pursupinfo/goaddinfo.do" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加采购单</a>
        <a href="javascript:ovid()"  class="btn btn-danger"><i class="icon-trash"></i>批量删除采购单</a>
       </span>
     
     </div> -->
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<!-- <th width="25"><label><input type="checkbox"  class="ace"><span class="lbl"></span></label></th> -->
				<th style="width:80px;font-size:12px;">采购单编号</th>
				<th style="width:80px;font-size:12px;">采购主题</th>
				<th style="width:100px;font-size:12px;">采购日期</th>
				<th style="width:80px;font-size:12px;">供应商编号</th>
				<th style="width:80px;font-size:12px;">货款金额</th>
				<th style="width:80px;font-size:12px;">发票号码</th>
				<th style="width:80px;font-size:12px;">付款情况</th>
                 <th style="width:80px;font-size:12px;">采购进展</th>
                <th style="width:100px;font-size:12px;">交货时间</th>
                <th style="width:50px;font-size:12px;">交货地点</th>
                <th style="width:50px;font-size:12px;">交货方式</th>
                <th style="width:50px;font-size:12px;">操作人员</th>
                <th style="width:50px;font-size:12px;">备注信息</th>
                <th style="width:50px;font-size:12px;">公司编号</th>
                <th style="width:100px;font-size:12px;">最后修改时间</th>
                <th style="width:130px;font-size:12px;">操作</th>
                <th style="width:130px;font-size:12px;">查看</th>
				
			</tr>
		</thead>
	<tbody>
	 <c:forEach items="${pi.list}" var="i">
		<tr>
          <!-- <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td> -->
          <td>${i.purNumber}</td>
           <td>${i.purTitle}</td>
          <td><fmt:formatDate value="${i.purDate}"
				pattern="yyyy-MM-dd " /></td>
          <td>${i.supInfoNum}</td>
          <td>${i.payAmount} </td>
          <td class="text-l">${i.invoiceNumber}</td>
          <td>${i.payStatus=="1"?"待付款":"已付款"} </td>
         <td>${i.purProgrees=="2" ? "采购中":"已入库"} </td>
          <td><fmt:formatDate value="${i.deliveryTime}"
				pattern="yyyy-MM-dd" /></td>
          <td>${i.deliveryAddress}</td>
          <td>${i.deliveryMode}</td>
          <td>${i.operatorId}</td>
          <td>${i.remarksInfo}</td>
          <td>${i.comId}</td>
          <td><fmt:formatDate value="${i.lastDate}"
				pattern="yyyy-MM-dd " /></td>
		  <td style="font-size:15px;width: 200px"><!-- <a onClick="member_stop(this,'10001')"  href="javascript:;"  title="查看详情"  class="btn btn-xs btn-success"><i class="icon-plus"></i></a>  -->
          <a href="javascript:ovid()" name="pursupinfo/goaddinfo.do" id="member_add" class="btn btn-warning"><i class="icon-plus" style="font-size: 5px;"></i>添加</a>
          <a title="编辑" onclick="jia(${i.purNumber });member_edit('550');" href="javascript:"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
          <a title="删除"  href="purorder/delinfo.do?purNumber=${i.purNumber}"  onclick="return window.confirm('是否确定删除此订单?')"class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
          <a href="javascript:" onclick="jia1(${i.purNumber})" class="member_show" ></a>
            
          </td>
          <td><a href="pur/ck.do?purNumber=${i.purNumber}" >查看详单</a></td>
          
		</tr>
       </c:forEach>
        
          <tr>
             <td colspan="17" style="text-align: center">
                  <a href="pursupinfo/selectinfo.do?pageNum=${pi.navigateFirstPage}">首页</a>   
                  <a href="pursupinfo/selectinfo.do?pageNum=${pi.prePage }">上一页</a>  
                  <a href="pursupinfo/selectinfo.do?pageNum=${pi.nextPage }">下一页</a>  
                  <a href="pursupinfo/selectinfo.do?pageNum=${pi.navigateLastPage }">尾页</a>  
                                     当前${pi.pageNum}/${pi.pages}页,共${pi.total}条
             </td>
          </tr>
       
       
      </tbody>
	</table>
   </div>
  </div>
 </div>
</div>
<!--添加用户图层-->
<script type="text/javascript">
function yz(){
var a = document.getElementById("a").value;
if(a==""){
alert("供应商名称不能为空");
return false;
}
var b = document.getElementById("b").value;
if(b==""){
alert("供应商简称不能为空");
return false;
}
var c= document.getElementById("c").value;
if(c==""){
alert("联系人不能为空");
return false;
}
var d = document.getElementById("d").value;
if(d==""){
alert("固定电话不能为空");
return false;
}
var e = document.getElementById("e").value;
if(e==""){
alert("移动电话不能为空");
return false;
}
var f = document.getElementById("f").value;
if(f==""){
alert("联系传真不能为空");
return false;
}
var g = document.getElementById("g").value;
if(g==""){
alert("邮编不能为空");
return false;
}
var h = document.getElementById("h").value;
if(h==""){
alert("开户银行不能为空");
return false;
}
var i = document.getElementById("i").value;
if(i==""){
alert("银行账号不能为空");
return false;
}
var j = document.getElementById("j").value;
if(j==""){
alert("公司主页不能为空");
return false;
}
var k = document.getElementById("k").value;
if(k==""){
alert("备注信息不能为空");
return false;
}
var l = document.getElementById("l").value;
if(l==""){
alert("必选项");
return false;
}

}
</script>


 <form action="purorder/addpro.do" method="post" >
<div class="add_menber" id="add_menber_style" style="display:none">
 <table class="table table-striped table-bordered table-hover"   id="table">
       <thead>
             <tr>
				<!-- <th style="width:60px;font-size:12px;">编号</th> -->
				<th style="width:80px;font-size:12px;">产品编号</th>
				<th style="width:80px;font-size:12px;">产品名称</th>
                <th style="width:60px;font-size:12px;">单价</th>
				<th style="width:80px;font-size:12px;">数量</th>
				<th style="width:80px;font-size:12px;">总价</th>
			    <th style="width:80px;font-size:12px;">备注信息</th>
			    <th style="width:20%;font-size:12px;">交货时间</th>
				<th style="width:60px;font-size:12px;">状态</th>
				<th style="width:80px;font-size:12px;">公司编号</th>
				<th style="width:80px;font-size:12px;">操作</th>
				
				
       </tr>
      </thead>
        <tbody>
               <tr v-for="(user,index) in stu">
               
                      <td><input id="productId" v-model="user.productId" name="productId"></td>
                      <td><input id="age" v-model="user.age" name=""></td>
                      <td><input id="proPrice" v-model="user.proPrice" name="proPrice"></td>
                      <td><input id="productCount" v-model="user.productCount" name="productCount"></td>
                      <td><input id="name" v-model="user.name" name=""></td>
                      <td><input id="remarksInfom" v-model="user.remarksInfom" name="remarksInfom"></td>
                      <td><input id="warehouseOrnot" v-model="user.warehouseOrnot" name="warehouseOrnot"></td>
                      <td><input id="comId" v-model="user.comId" name="comId"></td>
                      <td><input id="name" v-model="user.name" name=""></td>
                      <td><button @click="insert" style="width: 10px;font-size: 3px;">添加</button><button @click="remove(index)">移除</button></td>
                    </tr>
          <tbody>      
      
 </table>
<div> 
  <center><div> <input type="submit" value="提交" class="btn btn-primary"></div></center>
    <br>
 </div> 
   
    <script type="text/javascript">
        new Vue({
          el:'#table',
          data:{
             user:{productId:'',age:'',proPrice:'',productCount:'',remarksInfom:'',comId:'',name:'',age:''},
             stu:[
                {productId:'',age:'',proPrice:'',productCount:'',remarksInfom:'',comId:'',name:'',age:''}
               
             ]
          },
         methods:{
         
           insert:function(){
              this.stu.push(this.user)
           },
           remove:function(index){
             this.stu.splice(index,1)
           }
           
         }
        })
     </script>
 </form>
  
    

  
 
<!--   <!--  //添加采购单详情单 -->
   <div class="update_menber" id="show_menber_style" style="display:none">
    <ul class=" page-content">
     <li><label class="label_name"  style="width: 130px;">采购详情单编号：</label><span class="add_name" id="supInfoNum1" name="supInfoNum">  </span><div class="prompt r_f"></div></li>
     <li><label class="label_name"  style="width: 100px;">采购单编号：</label><span class="add_name"id="supName1" name="supName" ></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">产&nbsp;品&nbsp;编&nbsp;号：</label><span class="add_name" id="supUname1" name="supUname"></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">产&nbsp;品&nbsp;数&nbsp;量：</label><span class="add_name" id="contacts1" name="contacts"></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">产&nbsp;品&nbsp;价&nbsp;格：</label><span class="add_name" id="fixedTel1" name="fixedTel"></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">是&nbsp;否&nbsp;入&nbsp;库：</label><span class="add_name" id="telphone1" name="telphone"></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">操&nbsp;作&nbsp;人&nbsp;员：</label><span class="add_name" id="fax1" name="fax"></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">备&nbsp;注&nbsp;信&nbsp;息：</label><span class="add_name" id="email1" name="email"></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">公&nbsp;司&nbsp;编&nbsp;号：</label><span class="add_name" id="openBank1" name="openBank" ></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">修&nbsp;改&nbsp;时&nbsp;间：</label><span class="add_name" id="bankNumber1" name="bankNumber"></span><div class="prompt r_f"></div></li>
     
    </ul>
 </div>	 

 <%-- <!-- //添加页面 -->
<form action="purorderinfo/addinfo.do" method="post" onsubmit="return yz()">
<div class="add_menber" id="add_menber_style" style="display:none">
   <ul class=" page-content">
    <!--  <li><label class="label_name" style="width: 100px;">采购详情编号：</label><span class="add_name"><input id="b"name="purInfoNumber" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     --> <!-- <li><label class="label_name" style="width: 100px;">采购单编号：</label><span class="add_name"><input id="d"name="purNumber" type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
   <li> -->
      <li><label class="label_name" style="width: 100px;">产品编号：</label><span class="add_name"><input  id="f"name="productId"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">产品数量：</label><span class="add_name">&nbsp;&nbsp;<input id="i" name="productCount"   style="width:170px;height: 27px;background-color: gray;" class=" Wdate"readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
     </span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">产品价格：</label><span class="add_name"><input  id="j" name="proPrice"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
    <!--  <li><label class="label_name" style="width: 100px;">是否入库：</label><span class="add_name"><input id="k" name="warehouseOrnot"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
      <li><label class="label_name" style="width: 100px;">操作人员：</label><span class="add_name"><input id="k" name="operatorId"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
     --><li><label class="label_name" style="width: 100px;">备注信息：</label><span class="add_name"><input id="k" name="remarksInfom"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
    <!-- <li><label class="label_name" style="width: 100px;">公司编号：</label><span class="add_name"><input id="k" name="comId"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">修改时间：</label><span class="add_name"><input id="k" name="lastDate"type="date" class="text_add"/></span><div class="prompt r_f"></div></li>
  --></ul>
<li><label class="label_name" style="width: 100px;">产品价格：</label><span class="add_name"><input  id="j" name="proPrice"type="text" class="text_add"/></span><div class="prompt r_f"></div></li>
    
    <center><div> <input type="submit" value="提交" class="btn btn-primary"></div></center>
    <br>
 </div> 
 
 </form> --%>
 <!--修改用户图层-->
<form action="pursupinfo/updateinfo.do">
<div class="update_menber" id="update_menber_style" style="display:none"> 

     <table class="table table-striped table-bordered table-hover" id="sample-table">
   <tr> 
				<th style="width:160px;font-size:12px;">采购详情编号</th>
				<th style="width:100px;font-size:12px;">采购单编号</th>
				<th style="width:80px;font-size:12px;">产品名称</th>
                <th style="width:60px;font-size:12px;">产品单价</th>
				<th style="width:80px;font-size:12px;">产品数量</th>
				<th style="width:80px;font-size:12px;">是否入库</th>
			    <th style="width:80px;font-size:12px;">操作人员</th>
			    <th style="width:80px;font-size:12px;">备注信息</th>
				<th style="width:60px;font-size:12px;">公司编号</th>
				<th style="width:160px;font-size:12px;">最后修改时间</th>
		 </tr>
      
 </table>
 <!-- 
    <ul class=" page-content">
     <input  type="hidden" id="supInfoNum2" name="supInfoNum" class="text_add"/>
     <li><label class="label_name"  style="width: 100px;">供应商名称：</label><span class="add_name"><input  type="text"id="supName2" name="supName" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">供应商简称：</label><span class="add_name"><input  type="text" id="supUname2" name="supUname" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联&nbsp;&nbsp;&nbsp;&nbsp;系人：</label><span class="add_name"><input  type="text" id="contacts2" name="contacts"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">固&nbsp;定&nbsp;电&nbsp;话：</label><span class="add_name"><input  type="text" id="fixedTel2" name="fixedTel"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">移&nbsp;动&nbsp;电&nbsp;话：</label><span class="add_name"><input  type="text" id="telphone2"name="telphone" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联&nbsp;系&nbsp;传&nbsp;真：</label><span class="add_name"><input  type="text"  id="fax2"name="fax" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">联系地址：</label><span class="add_name"><input  type="text" name="联系地址" class="text_add"/></span><div class="prompt r_f"></div></li>
      <li><label class="label_name" style="width: 100px;">联系邮编：</label><span class="add_name"><input  type="text"  name="联系邮编"class="text_add"/></span><div class="prompt r_f"></div></li>
    <li><label class="label_name" style="width: 100px;">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</label><span class="add_name"><input  type="text" id="email2" name="email"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">开&nbsp;户&nbsp;银&nbsp;行：</label><span class="add_name"><input  type="text" id="openBank2" name="openBank"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">银&nbsp;行&nbsp;账&nbsp;号：</label><span class="add_name"><input  type="text" id="bankNumber2" name="bankNumber" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">账&nbsp;户&nbsp;类&nbsp;型：</label><span class="add_name"><input  type="text" id="bankNature2" name="bankNature"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">公&nbsp;司&nbsp;主&nbsp;页：</label><span class="add_name"><input  type="text"  id="comIndex2" name="comIndex"class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">备&nbsp;注&nbsp;信&nbsp;息：</label><span class="add_name"><input  type="text" id="remarksInfo2" name="remarksInfo" class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name" style="width: 100px;">公&nbsp;司&nbsp;编&nbsp;号：</label><span class="add_name"><input readonly="readonly" type="text" id="comId2" name="comId"class="text_add"/></span><div class="prompt r_f"></div></li>
        <li><label class="label_name" style="width: 100px;">最后修改时间：</label><span class="add_name"><input  type="text" id="lastDate" name="lastDate"class="text_add"/></span><div class="prompt r_f"></div></li>
      <li><label class="label_name" style="width: 100px;">状态：</label><span class="add_name">
     <label><input name="form-field-radio1" type="radio" class="ace"><span class="lbl">启用</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio1"type="radio" class="ace"><span class="lbl">禁止</span></label></span><div class="prompt r_f"></div></li>
    </ul>
     -->
   <center> <div> <input type="submit" value="提交" class="btn btn-primary"></div><br><br><br></center>
   
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
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
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
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 5) ) return 'right';
					return 'left';
				}
			})
/*用户-添加*/

 $('#member_add').on('click', function(){
    layer.open({
        type: 1,
        title: '添加采购单信息',
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
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url+'#?='+id,w,h);
}
/*用户-查看*/
  $('.member_show').on('click', function(){
    layer.open({
        type: 1,
        title: '详细信息',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#show_menber_style'),
		
		yes:function(index,layero){	
		 var num=0;
		 var str="";
     $(".show_menber input[type$='text']").each(function(n){
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
/*用户-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">禁止</span>');
		$(obj).remove();
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">有效</span>');
		$(obj).remove();
		layer.msg('启用成功!',{icon: 6,time:1000});
	});
}
/*用户-编辑*/

function member_edit(id){
	  layer.open({
        type: 1,
        title: '修改采购单详情',
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
//编辑函数
 function jia(supInfoNum)
    {
        var url="pursupinfo/select.do?supInfoNum="+supInfoNum;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {//从前台回调回来的数组，处理后的数据
        $("#supInfoNum2").val(data.supInfoNum);
        $("#supName2").val(data.supName);
        $("#supUname2").val(data.supUname);
        $("#contacts2").val(data.contacts);
        $("#fixedTel2").val(data.fixedTel);
        $("#telphone2").val(data.telphone);
        $("#fax2").val(data.fax);
        $("#email2").val(data.email);
        $("#openBank2").val(data.openBank);
        $("#bankNumber2").val(data.bankNumber);
        $("#comIndex2").val(data.comIndex);
        $("#remarksInfo2").val(data.remarksInfo); 
        $("#bankNature2").val(data.bankNature);
        $("#lastDate").val(data.lastDate);
        $("#comId2").val(data.comId);//将取出的值覆盖原来的值 （val对值进行操作)	
        var r=data.effectiveOrnot;
        if(r=="启用"){
           $(".ace[name='form-field-radio1']").get(0).checked="true";
        }else
        {
         $(".ace[name='form-field-radio1']").get(1).checked="true";
        }		   
      }
    });
       
    } 
    //查看函数
 /* function jia1(supInfoNum)
    {
        var url="pursupinfo/select.do?supInfoNum="+supInfoNum;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      
      {//从前台回调回来的数组，处理后的数据
       //alert(JSON.stringify(data));
        $("#supInfoNum1").text(data.supInfoNum);
        $("#supName1").text(data.supName);
        $("#supUname1").text(data.supUname);
        $("#contacts1").text(data.contacts);
        $("#fixedTel1").text(data.fixedTel);
        $("#telphone1").text(data.telphone);
        $("#fax1").text(data.fax);
        $("#email1").text(data.email);
        $("#openBank1").text(data.openBank);
        $("#bankNumber1").text(data.bankNumber);
        $("#comIndex1").text(data.comIndex);
        $("#remarksInfo1").text(data.remarksInfo);
        $("#effectiveOrnot1").text(data.effectiveOrnot);bankNature1
            $("#bankNature1").text(data.bankNature);
             $("#comId1").text(data.comId);
        //将取出的值覆盖原来的值 （val对值进行操作)			   
  }
    });
       
    }  */
/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
laydate({
    elem: '#start',
    event: 'focus' 
});

</script>


<style>
.update_menber{}
.update_menber li{ margin:10px 0px; height:40px; line-height:40px; float:left; width:50%}
.update_menber li.adderss{ width:100%}
.update_menber li .label_name,
.member_content li .label_name { width:80px; text-align:right; float:left; line-height:30px;}
.update_menber li .add_name{ float:left; margin-left:10px; line-height:30px;}
.update_menber li .add_name .lbl{ top:-5px; left:10px;}

.show_menber{}
.show_menber li{ margin:10px 0px; height:40px; line-height:40px; float:left; width:50%}
.show_menber li.adderss{ width:100%}
.show_menber li .label_name,
.member_content li .label_name { width:80px; text-align:right; float:left; line-height:30px;}
.show_menber li .add_name{ float:left; margin-left:10px; line-height:30px;}
.show_menber li .add_name .lbl{ top:-5px; left:10px;}
</style>
