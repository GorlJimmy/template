<%@page import="org.linuxkernel.template.cv.config.Config"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><%=Config.PROJECT_NAME%></title>
<link href="./media/css/bootstrap.css" rel="stylesheet">
<link href="./media/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./media/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="./media/css/style-metro.css" rel="stylesheet" type="text/css" />
<link href="./media/css/style.css" rel="stylesheet" type="text/css" />
<link href="./media/css/uniform.default.css" rel="stylesheet" 	type="text/css" />
<link href="./media/css/jquery.gritter.css" rel="stylesheet"	type="text/css" />
<link rel="shortcut icon" href="./media/image/favicon.ico" />


<script src="./media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="./media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="./media/js/jquery-ui-1.10.1.custom.min.js" 	type="text/javascript"></script>
<script src="./media/js/bootstrap.min.js" type="text/javascript"></script>
<script src="./media/js/excanvas.min.js"></script>
<script src="./media/js/respond.min.js"></script>
<script src="./media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="./media/js/jquery.blockui.min.js" type="text/javascript"></script>
<script src="./media/js/jquery.cookie.min.js" type="text/javascript"></script>
<script src="./media/js/jquery.uniform.min.js" type="text/javascript"></script>
<script type="text/javascript" src="./media/js/jquery.gritter.js"></script>
<script type="text/javascript" src="./media/js/jquery.pulsate.min.js"></script>
<script type="text/javascript" src="./media/js/jquery.bootpag.min.js"></script>
<script src="./media/js/app.js"></script>
<script src="./media/js/libs/init-config.js"></script>
<script>
	$(function() {
		App.init();
	});
</script>

</head>
<body class="page-header-fixed">
<div id="template_header">
<div class="navbar header navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="index"><%=Config.APPLICATION%></a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li><a href="index"><b class="icon-home"></b>首页</a></li>
					<li><a href="index"><b
							class="icon-comment"></b>课程简介</a></li>
					<li><a href="index"><b
							class="icon-envelope"></b>项目信息</a></li>
					<li><a href="index"><b
							class="icon-bell"></b>课程通知</a></li>
					<li><a href="index"><b
							class="icon-book"></b>相关文章</a></li>
					<li><a href="index"><b
							class="icon-download"></b>资源下载</a></li>
				</ul>
				<ul class="nav pull-right">
					<li class="divider-vertical"></li>

					<li><a href="system?requestType=about"><b
							class="icon-bell"></b>关于我们</a></li>
					<li><a href="system?requestType=contact"><b
							class="icon-pencil"></b>联系我们</a></li>
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"
						href="system?requestType=profile"><i
							class="icon-cog"></i></a>
						<ul class="dropdown-menu">
							<li><a href="index"><i
									class="icon-user"></i> 个人信息</a></li>
							<li><a href="index"><i
									class="icon-calendar"></i> 我的日历</a></li>
							<li><a href="index"><i
									class="icon-envelope"></i> 新消息(3)</a></li>
							<li><a href="#"><i class="icon-tasks"></i>我的任务</a></li>
							<li class="divider"></li>
							<li><a href="index"><i
									class="icon-lock"></i> 锁屏</a></li>
							<li><a href="index"><i
									class="icon-remove-circle"></i> 注销登录</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
</div>
</div>
<div id="template_content" class="page-container row-fluid">
<jsp:include page="${view}"></jsp:include>
</div>
<div class="footer"><%=Config.COPY_RIGHT%></div>
</body>
</html>
