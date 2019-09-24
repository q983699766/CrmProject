<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="stylesheet" href="css/style.css" />
<link href="assets/css/codemirror.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
<script src="<%=basePath%>My97DatePicker/WdatePicker.js"
	type="text/javascript" defer="defer" charset="UTF-8"></script>
<script src="assets/js/jquery.min.js"></script>
<script src="vue/vue.min.js"></script>
<!-- 引入JS文件 -->
<script src="vue.min.js"></script>



<script type="text/javascript">
	window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>



<script type="text/javascript">
	if ("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>
<!-- page specific plugin scripts -->
<script src="assets/js/jquery.dataTables.min.js"></script>
<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script src="assets/layer/layer.js" type="text/javascript"></script>
<script src="assets/laydate/laydate.js" type="text/javascript"></script>

<script type="text/javascript">
function gb(){
var danjia=document.getElementById("danjia").value;
var sl=document.getElementById("aa").value;
$("#bb").val(danjia*sl);
}

function hhh(e){
document.getElementById("xx").value=e;
     var url = "purorder/goadd.do" 
		//ajax异步请求
		$.ajax({
			type : "post",
			url : url,
			dataType : "json",
			success : function(data) { //从前台回调回来的数组，处理后的数据
				 var a="";
				       a="<option value='0'>请选择</option>";
				       
			          $.each(data,function(i,d)//两个参数，第一个参数表示遍历的数组的下标，第二个参数表示下标对应的值
			          {  
			              
			              a+="<option value='"+d.productId+"'>"+d.productId+"</option>" 
			          });
			         
			          $("#searchs").html(a);
				
			}
		});
  
}

</script>

</head>

<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<div class="search_style">
					<form action="purorder/selectinfo.do" method="post">
						<div class="title_names">搜索查询</div>
						<ul class="search_content clearfix">
							<li><label class="l_f">采购单主题</label><input name="purTitle"
								type="text" class="text_add" placeholder="输入采购单主题"
								style=" width:400px" /></li>
	              <li style="width:90px;"><input type="submit" value="查询" class="btn_search"></li>
						</ul>
				</div>
				</form>
	
			
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th style="width:80px;font-size:12px;">采购单编号</th>
								<th style="width:100px;font-size:12px;">采购主题</th>
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
								<th style="width:80px;font-size:12px;">备注信息</th>
								<th style="width:50px;font-size:12px;">公司编号</th>
								<th style="width:100px;font-size:12px;">最后修改时间</th>
								<th style="width:100px;font-size:12px;">操作</th>
								<th style="width:90px;font-size:12px;">查看</th>

							</tr>
						</thead>
						<tbody>
							<form action="pursupinfo/delall.do" id="cc" method="post">
								<c:forEach items="${pi.list}" var="i">
									<tr>
										
										<td>${i.purNumber}</td>
										<td>${i.purTitle}</td>
										<td><fmt:formatDate value="${i.purDate}"
												pattern="yyyy-MM-dd " /></td>
										<td>${i.supInfoNum}</td>
										<td>${i.payAmount}</td>
										<td class="text-l" style="width: 120px">${i.invoiceNumber}</td>
										<c:if test="${i.payStatus=='2'}">
										<td style="color: red">已付款</td>
										</c:if>
										<c:if test="${i.payStatus=='1'}">
										<td>未付款</td>
										</c:if>
										<td>${i.purProgrees=="2" ? "待采购":"已入库"}</td>
										<td><fmt:formatDate value="${i.deliveryTime}"
												pattern="yyyy-MM-dd" /></td>
										<td>${i.deliveryAddress}</td>
										<td>${i.deliveryMode}</td>
										<td>${i.operatorId}</td>
										<td>${i.remarksInfo}</td>
										<td>${i.comId}</td>
										<td><fmt:formatDate value="${i.lastDate}"
												pattern="yyyy-MM-dd " /></td>
									<c:if test="${i.payStatus=='2'}">			
										<td style="color: red">已付款</td>
										<td><a href="purorder/oderinfo.do?purNumber=${i.purNumber}">查看详单</a></td>
                                       </tr>
							    	</c:if>	
									<c:if test="${i.payStatus=='1'}">			
									   <td style="font-size:15px;width: 200px">
									   
									   <c:if test="${i.purProgrees=='2'}">
										<a title="添加" href="javascript:ovid()" name="pursupinfo/goaddinfo.do" onclick="hhh(${i.purNumber});dd()"
											class="btn btn-xs btn-warning"><i
												class="icon-plus bigger-120"></i></a>
										</c:if>
										 <c:if test="${i.purProgrees=='1'}">
										<a title="添加" href="javascript:return false;" onclick="return false;" style='opacity: 0.4'"
											class="btn btn-xs btn-warning"><i
												class="icon-plus bigger-120"></i></a>
										</c:if>
											 <a title="删除"
											href="purorder/delinfo.do?purNumber=${i.purNumber}"
											onclick="return window.confirm('是否确定删除此订单?')"
											class="btn btn-xs btn-warning">
											<i class="icon-trash  bigger-120"></i></a>
											 <a href="javascript:" onclick="jia1(${i.purNumber})" class="member_show"></a>
                                     <c:if test="${i.purProgrees!='2'}">
									  <a title="付款" href="purorder/fukuan.do?purNumber=${i.purNumber}"
											class="btn btn-xs btn-primary"><i
												class="icon-ok bigger-100"></i></a>
									</c:if>
										</td>
										<td><a href="purorder/oderinfo.do?purNumber=${i.purNumber}">查看详单</a></td>

									</tr>
								</c:if>	
								</c:forEach>
							</form>
							<tr>
								<td colspan="18" style="text-align: center"><a
									href="purorder/selectinfo.do?pageNum=${pi.navigateFirstPage}">首页</a>
									<a href="purorder/selectinfo.do?pageNum=${pi.prePage }">上一页</a>
									<a href="purorder/selectinfo.do?pageNum=${pi.nextPage }">下一页</a>
									<a
									href="purorder/selectinfo.do?pageNum=${pi.navigateLastPage }">尾页</a>
									当前${pi.pageNum}/${pi.pages}页,共${pi.total}条</td>
							</tr>
                         </tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</script>
	


	<form action="purorder/addpro2.do" method="post" >
      <div class="add_menber" id="add_menber_style" style="display:none">
             <table class="table table-striped table-bordered table-hover">
     <tr>
		<!-- <th style="width:60px;font-size:12px;">编号</th> -->
		<th style="width:10%;font-size:12px; text-align: center ">产品编号</th>
		<th style="width:10%;font-size:12px;text-align: center">产品名称</th>
		<th style="width:5%;font-size:12px;text-align: center">单价</th>
		<th style="width:5%;font-size:12px;text-align: center">数量</th>
		<th style="width:8%;font-size:12px;text-align: center">总价</th>
		<th style="width:18%;font-size:12px;text-align: center">备注信息</th>
		<!-- <th style="width:18%;font-size:12px;text-align: center">交货时间</th> -->
	 </tr>
	 <tr>
	    <td> <select style="width:80px;" name="productId" id="searchs"  onchange="cz()">
	        </select>
	    </td> 
	    
	    
		<td><input type="text"  style="width:80px;font-size:12px;"  id="mingcheng" name="spMc"readonly="readonly"></td> 
		<td ><input type="text" style="width:50px;font-size:12px;"  id="danjia" name="cbj" readonly="readonly"></td> 
		<td ><input type="text"style="width:50px;font-size:12px;"   id="aa" name="productCount" oninput="gb()"></td>  <!--  //数量 -->
		<td ><input type="text" style="width:80px;font-size:12px;"  id="bb" name="payAmount" readonly="readonly"> </td> <!--  //总价 -->
		<td ><input type="text" style="width:80px;font-size:12px;"   id="" name="remarksInfom" ></td> 
		<td ><%-- <fmt:formatDate value="${i.lastDate}"pattern="yyyy-MM-dd " />
			<input type="date" style="width:150px;font-size:12px;"  id="" name="lastDate" > --%>
		<input type="hidden" style="width:150px;font-size:12px;"  id="xx" name="vvv">
		</td>
	</tr>
	  <tr> <td colspan="10">
	   <input type="submit" value="提交" class="btn btn-primary" >
	</td></tr>	
	</form>

</body>
<script type="text/javascript">
 function cz(){
   var id=document.getElementById("searchs").value;
     var url="purorder/quzhi.do?productId="+id;
     document.getElementById("aa").value="";
     document.getElementById("bb").value="";
   //ajax异步请求
   $.ajax ({
      type:"post",
      url:url,
      dataType:"json",
      success:function(data)
      {//从前台回调回来的数组，处理后的数据
      	$("#mingcheng").val(data.spMc);
        $("#danjia").val(data.cbj);
       }
        });
        }
</script>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="asset/js/select.js"></script>
<script src="verSelector/verSelect.js"></script>
<script>
    new verSelector();
</script>
</html>
<script>
	jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ], //默认第几个排序
			"bStateSave" : true, //状态保存
			"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0, 8, 9 ]
				} // 制定列不参与排序
			]
		});


		$('table th input:checkbox').on('click', function() {
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
				.each(function() {
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});

		});


		$('[data-rel="tooltip"]').tooltip({
			placement : tooltip_placement
		});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $source.offset();
			var w2 = $source.width();

			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 5)) return 'right';
			return 'left';
		}
	})
	/*用户-添加*/

	function dd() {
		layer.open({
			type : 1,
			title : '添加采购单信息',
			maxmin : true,
			shadeClose : true, //点击遮罩关闭层
			area : [ '600px', '' ],
			content : $('#add_menber_style'),
			yes : function(index, layero) {
				var num = 0;
				var str = "";
				$(".add_menber input[type$='text']").each(function(n) {
					if ($(this).val() == "") {

						layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
							title : '提示框',
							icon : 0,
						});
						num++;
						return false;
					}
				});
				if (num > 0) {
					return false;
				} else {
					layer.alert('添加成功！', {
						title : '提示框',
						icon : 1,
					});
					layer.close(index);
				}
			}
		});
	};
	/*用户-查看*/
	function member_show(title, url, id, w, h) {
		layer_show(title, url + '#?=' + id, w, h);
	}
	/*用户-查看*/
	$('.member_show').on('click', function() {
		layer.open({
			type : 1,
			title : '详细信息',
			maxmin : true,
			shadeClose : true, //点击遮罩关闭层
			area : [ '800px', '' ],
			content : $('#show_menber_style'),

			yes : function(index, layero) {
				var num = 0;
				var str = "";
				$(".show_menber input[type$='text']").each(function(n) {
					if ($(this).val() == "") {

						layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
							title : '提示框',
							icon : 0,
						});
						num++;
						return false;
					}
				});
				if (num > 0) {
					return false;
				} else {
					layer.alert('添加成功！', {
						title : '提示框',
						icon : 1,
					});
					layer.close(index);
				}
			}
		});
	});
	/*用户-停用*/
	function member_stop(obj, id) {
		layer.confirm('确认要停用吗？', function(index) {
			$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">禁止</span>');
			$(obj).remove();
			layer.msg('已停用!', {
				icon : 5,
				time : 1000
			});
		});
	}

	/*用户-启用*/
	function member_start(obj, id) {
		layer.confirm('确认要启用吗？', function(index) {
			$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">有效</span>');
			$(obj).remove();
			layer.msg('启用成功!', {
				icon : 6,
				time : 1000
			});
		});
	}
	/*用户-编辑*/

	function member_edit(id) {
		layer.open({
			type : 1,
			title : '修改采购单详情',
			maxmin : true,
			shadeClose : false, //点击遮罩关闭层
			area : [ '800px', '' ],
			content : $('#update_menber_style'),

			yes : function(index, layero) {
				var num = 0;
				var str = "";
				$(".update_menber input[type$='text']").each(function(n) {
					if ($(this).val() == "") {

						layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
							title : '提示框',
							icon : 0,
						});
						num++;
						return false;
					}
				});
				if (num > 0) {
					return false;
				} else {
					layer.alert('添加成功！', {
						title : '提示框',
						icon : 1,
					});
					layer.close(index);
				}
			}
		});
	}
	
	
	//点击添加详情单的函数
	
	
	
	
	//编辑函数
	function jia(supInfoNum) {
		var url = "pursupinfo/select.do?supInfoNum=" + supInfoNum;
		//ajax异步请求
		$.ajax({
			type : "post",
			url : url,
			dataType : "json",
			success : function(data) { //从前台回调回来的数组，处理后的数据
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
				$("#comId2").val(data.comId); //将取出的值覆盖原来的值 （val对值进行操作)	
				var r = data.effectiveOrnot;
				if (r == "启用") {
					$(".ace[name='form-field-radio1']").get(0).checked = "true";
				} else {
					$(".ace[name='form-field-radio1']").get(1).checked = "true";
				}
			}
		});

	}

	/*用户-删除*/
	function member_del(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			$(obj).parents("tr").remove();
			layer.msg('已删除!', {
				icon : 1,
				time : 1000
			});
		});
	}
	laydate({
		elem : '#start',
		event : 'focus'
	});
</script>


<style>
.update_menber {
	
}

.update_menber li {
	margin: 10px 0px;
	height: 40px;
	line-height: 40px;
	float: left;
	width: 50%
}

.update_menber li.adderss {
	width: 100%
}

.update_menber li .label_name, .member_content li .label_name {
	width: 80px;
	text-align: right;
	float: left;
	line-height: 30px;
}

.update_menber li .add_name {
	float: left;
	margin-left: 10px;
	line-height: 30px;
}

.update_menber li .add_name .lbl {
	top: -5px;
	left: 10px;
}

.show_menber {
	
}

.show_menber li {
	margin: 10px 0px;
	height: 40px;
	line-height: 40px;
	float: left;
	width: 50%
}

.show_menber li.adderss {
	width: 100%
}

.show_menber li .label_name, .member_content li .label_name {
	width: 80px;
	text-align: right;
	float: left;
	line-height: 30px;
}

.show_menber li .add_name {
	float: left;
	margin-left: 10px;
	line-height: 30px;
}

.show_menber li .add_name .lbl {
	top: -5px;
	left: 10px;
}
</style>
