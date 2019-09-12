<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link type="text/css" rel="stylesheet" href="assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<link type="text/css" rel="stylesheet" href="assets/css/ace.min.css" />
		<link type="text/css" rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link type="text/css" rel="stylesheet" href="assets/css/ace-skins.min.css" />
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script type="text/javascript" src="assets/js/ace-extra.min.js"></script>
		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
		<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>        
        <script type="text/javascript" src="assets/layer/layer.js"></script>
<title>登陆</title>

<script>
	
</script>

</head>

<%
			String uname = "";
			String upass = "";
			Cookie[] cs = request.getCookies();
			if (cs != null && cs.length > 0) 
			{
				for (int i = 0; i < cs.length; i++)
				 {
					Cookie c = cs[i];
					if (c.getName().equals("uname"))
					 {//取出用户名
						uname = c.getValue();
					 }
					if (c.getName().equals("upass")) 
					 {//取出密码
						upass = c.getValue();
					 }
				}
			}
		%>

<body class="login-layout" onload="t()">
<div class="logintop">    
    <span>欢迎来到后台管理界面平台</span>    
    <ul>
    <li><a href="#">返回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    <div class="loginbody">
<div class="login-container">
	<div class="center">
	<h1>
									<i class="icon-leaf green"></i>
									<span class="orange">DB1901CRM</span>
									<span class="white">后台管理系统</span>
								</h1>
								<h4 class="white">Background Management System</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box widget-box no-border visible" style="height: 312px;">
									<div class="widget-body" style="height: 301px;">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												管理员登陆
											</h4>

											<div class="login_icon"><img src="images/login.png" /></div>

											<form action="loginctlr/login.do" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="登录名"  name="uname" value="<%=uname%>">
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码" name="upass" value="<%=upass%>">
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" name="rememberme" value="1" class="ace">
															<span class="lbl">保存密码(保存三天)</span>
														</label>

														<button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="login_btn">
															<i class="icon-key"></i>
															登陆
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											<div class="social-or-login center">
												<span class="bigger-110">通知</span>
											</div>

											<div class="social-login center">
											本网站系统不再对IE8以下浏览器支持，请见谅。
											</div>
										</div><!-- /widget-main -->

										<div class="toolbar clearfix">
											

											
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
                        </div>
                        <div class="loginbm"><a href="">思创DB1901组</a> <!-- 版权所有  2016  <a href="">南京思美软件系统有限公司</a>  --></div><strong></strong>
</body>
</html>
<script>
        window.onload=function(){
        
            document.onkeydown=function(ev){
                var event=ev ||event
                if(event.keyCode==13){
                    $("#login_btn").trigger("click");
                }
            }
        }
        
        
    </script>

<script  type="text/javascript">
$('#login_btn').on('click',function(){
         var num=0;
		 var str="";
	     $(".form-control").each(function(n){
	        if($(this).val()==""){
				layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
		                title: '提示框',				
						icon:0,								
		          }); 
		        num++;
	            return false;            
	        }
		});
		if(num == 0){
	        $.ajax({
				type:"post",
				url:"loginctlr/islogin.do",
				dateType:"json",
				success:function(m){
					if(m.code == "200"){
						layer.confirm('检测到已有登录用户', {
					     btn: ['继续登录','取消登录'] ,//按钮
						 icon:2,
					    }, 
						function(){
						  $.ajax({
							type:"post",
							url:"loginctlr/ajaxlogout.do",
							success:function(){
								$("form").submit();
							}
						  });
					 	},
					 	function(){
					 		location.href="index.jsp";
					 	}
					 );
					}else{
						$("form").submit();
					};
				}
			});
		};
	});
	
		
		var isfail ='${param.fail=="state" ? "用户已停用！":"" }${param.fail=="nouser" ? "用户名不存在！":"" }${param.fail=="error" ? "用户名或密码错误！":"" }${param.fail=="codeerror" ? "验证码错误！":"" }${param.fail=="unknown" ? "用户名不存在！":""}';
		function result(){
			if(isfail != ""){
				layer.alert(isfail,{
		                title: '提示框',				
						icon:0,								
		          });
			}			
		};
		result();

</script>