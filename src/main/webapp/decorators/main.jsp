<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dp" uri="/dp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="${ctx}/static/adminlte/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${ctx}/static/plugins/font-awesome-4.7.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${ctx}/static/plugins/ionicons-2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${ctx}/static/adminlte/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
      folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${ctx}/static/adminlte/dist/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="${ctx}/static/css/myAdminLteCss.css">
<title>自主测试系统</title>
<!-- 引入被装饰页面的head标签内的内容 如css等 -->
<sitemesh:write property='head'></sitemesh:write>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">
		<!-- 顶栏信息 -->
		<header class="main-header">
			<!-- Logo -->
			<a href="#" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>A</b>TS</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b><spring:message code="system.title"></spring:message></b></span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="${ctx}/static/adminlte/dist/img/user2-160x160.jpg"
								class="user-image" alt="User Image"> <span
								class="hidden-xs">【${sessionScope.userContext.account}】</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="${ctx}/static/adminlte/dist/img/user2-160x160.jpg"
									class="img-circle" alt="User Image">

									<p>当前登入用户</p></li>
								<!-- Menu Body -->
								<li class="user-body">
									<div class="row">
										<div class="col-xs-6 text-center">
											<a href="#">上次登录时间：</a>
										</div>
										<div class="col-xs-6 text-center">
											<a href="#">2017-09-13 18:00</a>
										</div>
									</div> <!-- /.row -->
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">修改密码</a>
									</div>
									<div class="pull-right">
										<a href="${ctx}/logout" class="btn btn-default btn-flat">注销</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</header>

		<!-- 菜单列表 -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<c:forEach items="${sessionScope.userContext.userMenus}" var="menu">
						<li class="treeview" id="menu-${menu.id}" parentIds="${menu.parentIds}">
							<a href="#"> <i class="${menu.icon}"></i>
								<span>${menu.name}</span> 
								<span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
							</a> 
							<dp:drawMenu userMenus="${menu.subUserMenus}" />
						</li>
					</c:forEach>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>
		<!-- 内容主页，被装饰页 -->
		<div class="content-wrapper">
			<sitemesh:write property='body'></sitemesh:write>
		</div>
		<!-- 底栏信息 -->
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 2.3.11
			</div>
			<strong>Copyright &copy; 2017 <a href="#">自主测试系统</a>.
			</strong> All rights reserved.
		</footer>
	</div>

	<!-- jQuery 2.2.3 -->
	<script src="${ctx}/static/adminlte/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="${ctx}/static/adminlte/bootstrap/js/bootstrap.min.js"></script>
	<!-- SlimScroll -->
	<script
		src="${ctx}/static/adminlte/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="${ctx}/static/adminlte/plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="${ctx}/static/adminlte/dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="${ctx}/static/adminlte/dist/js/demo.js"></script>
	<!-- 自定义js -->
	<script src="${ctx}/static/js/menuInit.js"></script>
</body>
</html>