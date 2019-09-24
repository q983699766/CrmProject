<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="<%=basePath%>assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="<%=basePath%>css/style.css"/>       
        <link href="<%=basePath%>assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=basePath%>assets/css/ace.min.css" />
        <link rel="stylesheet" href="<%=basePath%>assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
			<script src="<%=basePath%>assets/js/jquery.min.js"></script>

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
		<script src="<%=basePath%>assets/js/bootstrap.min.js"></script>
		<script src="<%=basePath%>assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="<%=basePath%>assets/js/jquery.dataTables.min.js"></script>
		<script src="<%=basePath%>assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="<%=basePath%>js/H-ui.js"></script> 
        <script type="text/javascript" src="<%=basePath%>js/H-ui.admin.js"></script> 
        <script src="<%=basePath%>assets/layer/layer.js" type="text/javascript" ></script>
        <script src="<%=basePath%>assets/laydate/laydate.js" type="text/javascript"></script>
<title>用户列表</title>
</head>

<body>
<div class="page-content clearfix">
    <div id="Member_Ratings">
      <div class="d_Confirm_Order_style">
    <div class="search_style">
     <div class="title_names">采购单详情</div>
    
    </div>
  <%--   <form action="ccspxxctlr/mh.do" method="post">
     
    </form>
     <!---->
     <div class="border clearfix">
       <span class="l_f">
       
        
       </span>
    
       <span class="r_f">共：<b>${pi.total }</b>条</span>
     </div>
     <!----> --%>
     
        <script type="text/javascript">
			function sc() {
			document.getElementById("cc").submit();
			var a=document.getElementsByName("bb");
			}
							
	  </script>
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="80px">采购详情编号</th>
				<th width="250px">采购编号</th>
				<th width="100px">产品编号</th>
			    <th width="100px">产品价格</th>
				<th width="100px">采购数量</th>
            	<th width="180px">是否入库</th>
                <th width="80px">操作人员</th>
				<th width="250px">备注信息</th>
				<th width="70px">公司编号</th> 
				<th width="100px">最后修改时间</th>                 
				<th width="200px">操作</th>
			</tr>
		</thead>
	<tbody>
	<c:forEach items="${u}" var="u"> 
		<tr>
		
		 <c:if test="${u.warehouseOrnot =='已入库' }">        
          <td><label><input type="checkbox" disabled="disabled" class="ace"><span class="lbl"></span></label></td>
          </c:if>  <!--是否入库  -->  
          <c:if test="${u.warehouseOrnot !='已入库' }">        
          <td><label><input type="checkbox"  class="ace"><span class="lbl"></span></label></td>
          </c:if>  <!--是否入库  -->  
          
          <td>${u.purInfoNumber }</td> <!-- 采购详情编号 -->
          <td>${u.purNumber }</td>     <!-- 采购单编号 -->
          <td>${u.productId }</td>		<!-- 产品编号 -->
          <td>${u.proPrice }</td>		<!--产品价格  -->
          <td>${u.productCount }</td> <!--产品数量  -->
           
          <c:if test="${u.warehouseOrnot =='已入库' }">        
          <td style="color: red">${u.warehouseOrnot }</td> 
          </c:if>  <!--是否入库  -->  
           
          <c:if test="${u.warehouseOrnot !='已入库' }">        
          <td >${u.warehouseOrnot }</td> 
          </c:if>  <!--是否入库  --> 
              
          <td>${u.operatorId }</td>			<!--操作人员  -->
          <td>${u.remarksInfom }</td>	<!--备注信息  -->
          <td>${u.comId }</td>         <!-- 公司编号 -->
          
          <td><fmt:formatDate value="${u.lastDate}" pattern="yyyy-MM-dd" /></td>   <!--最后修改时间  -->      
           
           <c:if test="${u.warehouseOrnot !='已入库' }">
          <td class="td-manage">         
          <a title="入库" onclick="jia(${u.purInfoNumber});member_edit(this)"  href="javascript:"  class="btn btn-warning"><i class="icon-plus"></i></a> 
        </td>
        </c:if>
         <c:if test="${u.warehouseOrnot =='已入库' }">
            <td class="td-manage" style="color: red">         
                   入库成功 
        </td>
        </c:if>
		</tr>
       </c:forEach> 
       		              
          <%--  <tr>
              <td colspan="15" style="text-align: center;">
                  <a href="purorder/oderinfo.do?pageNum=${pi.firstPage }">首页</a>
                  <a href="purorder/oderinfo.do?pageNum=${pi.prePage }">上一页</a>
                  <a href="purorder/oderinfo.do?pageNum=${pi.nextPage }">下一页</a>
                  <a href="purorder/oderinfo.do?pageNum=${pi.lastPage }">尾页</a>
                                       当前${pi.pageNum }/${pi.pages }页
              </td>
           </tr> --%>
       
       
      </tbody>
	</table>
   </div>
  </div>
 </div>
</div>

 <!--修改用户图层  -->
 <%-- <form action="purorder/add.do" method="post">
<div class="update_menber" id="update_menber_style" style="display:none">
  
    <ul class=" page-content">
     <input  type="hidden" id="purInfoNumber2" name="purInfoNumber" class="text_add"/> 
     <input  type="hidden" id="purNumber2" name="purNumber" class="text_add"/> 
    <!--  <li><label class="label_name">商品详情编号：</label><span class="add_name"><input id="purInfoNumber2"  name="purInfoNumber" type="text" class="text_add"  required /></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">采购单编号</label><span class="add_name"><input id="purNumber2" name="purNumber" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">产品编号</label><span class="add_name"><input id="productId2" name="productId" type="text"  class="text_add" readonly="readonly" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">产品数量</label><span class="add_name"><input id="productCount2" name="productCount" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">产品价格</label><span class="add_name"><input id="proPrice2" name="proPrice" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>
     <li style="display: none"><label class="label_name">是否入库</label><span class="add_name"><input type="hidden" id="warehouseOrnot2" name="warehouseOrnot" type="text"  class="text_add" required readonly="readonly" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">操作人员</label><span class="add_name"><input id="operatorId2" name="operatorId" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息</label><span class="add_name"><input id="remarksInfom2" name="remarksInfom" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>     
     <li><label class="label_name">公司编号</label><span class="add_name"><input id="comId2" name="comId" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">入库时间</label><span class="add_name"><input id="lastDate2" name="lastDate" type="text"  class="text_add" required/ readonly="readonly"></span><div class="prompt r_f"></div></li>
     <div class="prompt r_f"></div>
    
    <center>
    <label><input name="form-field-radio1" type="submit"   value="入库" class="btn btn-prompt r_f"><span class="lbl"></span></label></span><div class="prompt r_f"></div></li>   
 	</center>
 	<br/>
 </div>

 </form> --%>
 <div class="update_menber" id="update_menber_style" style="display:none">
  
    <ul class=" page-content">
     <input  type="hidden" id="purInfoNumber2" name="purInfoNumber" class="text_add"/> 

    <!--  <li><label class="label_name">商品详情编号：</label><span class="add_name"><input id="purInfoNumber2"  name="purInfoNumber" type="text" class="text_add"  required /></span><div class="prompt r_f"></div></li> -->
     <li><label class="label_name">采购单编号</label><span class="add_name"><input id="purNumber2" name="purNumber" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">产品编号</label><span class="add_name"><input id="productId2" name="productId" type="text"  class="text_add" readonly="readonly" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">产品数量</label><span class="add_name"><input id="productCount2" name="productCount" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">产品价格</label><span class="add_name"><input id="proPrice2" name="proPrice" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>
     <li style="display: none"><label class="label_name">是否入库</label><span class="add_name"><input type="hidden" id="warehouseOrnot2" name="warehouseOrnot" type="text"  class="text_add" required readonly="readonly" /></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">操作人员</label><span class="add_name"><input id="operatorId2" name="operatorId" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">备注信息</label><span class="add_name"><input id="remarksInfom2" name="remarksInfom" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>     
     <li><label class="label_name">公司编号</label><span class="add_name"><input id="comId2" name="comId" type="text"  class="text_add" required readonly="readonly"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">入库时间</label><span class="add_name"><input id="lastDate2" name="lastDate" type="text"  class="text_add" required/ readonly="readonly"></span><div class="prompt r_f"></div></li>
     <div class="prompt r_f"></div>
 	<br/>
 </div>
</body>
</html>
<script>
jQuery(function($) {
				var oTable1 = $('#sample-table').dataTable( {
				"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
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
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			})


/*入库*/
function member_edit(obj){
		console.log(obj);
	  layer.open({
        type: 1,
        title: '入库',
		maxmin: true, 
		shadeClose:false, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#update_menber_style'),
        btn:["入库"],
	      btn1:function(){
	      	puroderinfo.purInfoNumber = $("#purInfoNumber2").val();
	        puroderinfo.purNumber = $("#purNumber2").val();
	        puroderinfo.productId = $("#productId2").val();//商品类型
	        puroderinfo.productCount = $("#productCount2").val();//规格说明
	        puroderinfo.proPrice = $("#proPrice2").val();//单位
	        puroderinfo.warehouseOrnot = $("#warehouseOrnot2").val();//库存数量 
	        puroderinfo.operatorId = $("#operatorId2").val();
	        puroderinfo.remarksInfom = $("#remarksInfom2").val();//零售价       
	        puroderinfo.comId = $("#comId2").val();//公司编号
	      	$.ajax({
	      		type:"post"
	      		,url:"purorder/add.do"
	      		,data:JSON.stringify(puroderinfo)
	      		,contentType:"application/json;charset=utf-8"
	      		,success:function(m){
	      			layer.msg("入库成功",{icon:1,time:1000,end:function(){
	      				$(obj).parents("tr").children("td:nth-child(7)").html("已入库").css("color", "red");
						$(obj).parent().html("入库成功").css("color", "red");
	      			}});
	      		}
	      	})
	      },
    });
}
 var puroderinfo = {
   		purInfoNumber : 0
   		,purNumber : 0
   		,productId : 0
   		,proPrice : 0
   		,warehouseOrnot : ""
   		,operatorId : 0
   		,remarksInfom : ""
   		,comId : 0
   		,productCount : 0
   }
//编辑函数
 function jia(purInfoNumber)
    {
        var url="purorder/select1.do?purInfoNumber="+purInfoNumber;
   //ajax异步请求
   $.ajax
   ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {//从前台回调回来的数组，处理后的数据
      	$("#purInfoNumber2").val(data.purInfoNumber);
        $("#purNumber2").val(data.purNumber);
        $("#productId2").val(data.productId);//商品类型
        $("#productCount2").val(data.productCount);//规格说明
        $("#proPrice2").val(data.proPrice);//单位
        $("#proPrice2").val(data.proPrice);//仓库编号
        $("#warehouseOrnot2").val("已入库");//库存数量
        $("#operatorId2").val(data.operatorId);//成本价
        $("#remarksInfom2").val(data.remarksInfom);//零售价       
        $("#comId2").val(data.comId);//公司编号
        $("#lastDate2").val(data.lastDate);
      //将取出的值覆盖原来的值 （val对值进行操作)	
        
      }
    });
       
    } 




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
