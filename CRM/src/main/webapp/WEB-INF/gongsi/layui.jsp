<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
       	<link  rel="stylesheet" href="<%=basePath%>layui/css/layui.css" media="all"/>
		<script src="<%=basePath%>layui/layui.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <table class="layui-hide" id="test" lay-filter="test" lay-data="{id: 'idTest'}"></table>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">添加职位信息</button>
  </div>
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit" href='upadte.do'>编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
   <!--添加用户图层--> 
 <div  id="cs" style="display:none">
 <input type="text">
 <input type="text">
 <input type="text">
 <input type="text">
 </div> 
</html>
 </body>
<script>
layui.use('table', function(){
  var table = layui.table;
  table.render({
    elem: '#test'
    ,url:'sysdutyctlr/listui.do'
    ,toolbar: '#toolbarDemo'
    ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
    	title: '职位信息'
     ,layEvent: 'LAYTABLE_TIPS'
     ,icon: 'layui-icon-tips'
    }]
    ,title: '职位信息表'
    ,totalRow: true
    ,cols: [[
    	{type: 'checkbox', fixed: 'left'}
      ,{field:'dutId', title:'ID', width:80, fixed: 'left', unresize: true, sort: true, totalRowText: '合计行'}
      ,{field:'dutName', title:'职位名称', width:120, edit: 'text'}
      ,{field:'secId', title:'部门编号', width:150, edit: 'text'}
      ,{field:'dutRemark', title:'备注信息', width:130, edit: 'text', sort: true}
      ,{field:'comId', title:'公司编号', width:100, sort: true}
     ,{field:'lastTime', title:'修改时间',totalRow: true}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
    ]]  
    ,page: true
    ,id: 'idTest'
    
    ,response: {
      statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
    }
    ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
      return {
        "code": res.status, //解析接口状态
        "msg": res.message, //解析提示文本
        "count": res.total, //解析数据长度
        "data": res.rows //解析数据列表
      };
    }
  });
    table.on('toolbar(test)', function(obj){
  layer.open({
        type: 1,
        title: '添加职务',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , '600px'],
        content:$('#cs')
    });
  });
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.prompt({
        formType: 2
        ,value: data.email
      }, function(value, index){
        obj.update({
          email: value
        });
        layer.close(index);
      });
    }
  });
});
</script>