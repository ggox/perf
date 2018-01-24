<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
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
	href="${ctx}/static/plugins/Font-Awesome-4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${ctx}/static/plugins/ionicons-2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${ctx}/static/adminlte/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${ctx}/static/adminlte/plugins/iCheck/square/blue.css">
<title>登录</title>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<b>自主测试系统</b>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<%-- <c:if test="${msg==null || msg==''}">
				<p class="login-box-msg">账号登录</p>
			</c:if>
			<c:if test="${msg!=null && msg!=''}"> --%>
				<p class="login-box-msg" style="color: red;">${msg}</p>
			<%-- </c:if> --%>

			<form action="loginSubmit" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" placeholder="账号"
						name="username"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="密码"
						name="password"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input style="width: 100px;display: inline-block;" type="text" class="form-control" placeholder="验证码" name="captcha"> 
					<label style="display: inline-block;vertical-align: middle;margin-left: 5px;">
						<img id="captchaPic" title="点击更换" src="${ctx}/captchaCode" onclick="refreshCaptchaCode();">
						看不清<a href="#" onclick="refreshCaptchaCode();">换一张</a>
					</label>
				</div>
				<mvc:errors path="userToken.captcha"></mvc:errors>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck" style="margin-left: 2px;">
							<label> 
								<!-- <input type="checkbox" name="rememberMe">
								记住我 -->
								<a href="register" class="text-center">注册</a>&nbsp; <a
									href="forgotpassword">忘记密码</a>
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<!-- <div class="social-auth-links text-center">
				<p>- OR -</p>
				<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i
					class="fa fa-facebook"></i> Sign in using Facebook</a> <a href="#"
					class="btn btn-block btn-social btn-google btn-flat"><i
					class="fa fa-google-plus"></i> Sign in using Google+</a>
			</div> -->
			<!-- /.social-auth-links -->

		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.2.3 -->
	<script src="${ctx}/static/adminlte/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="${ctx}/static/adminlte/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="${ctx}/static/adminlte/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
		function refreshCaptchaCode(){
			$("#captchaPic").attr("src","${ctx}/captchaCode?"+Math.random());
		}
	</script>
</body>
</html>