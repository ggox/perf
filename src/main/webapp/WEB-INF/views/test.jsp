<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> 功能模块</a></li>
			<li><a href="#">商品管理</a></li>
			<li class="active">${flag}</li>
		</ol>
	</section>
	<section class="content">
		<h1 align="center">${flag}</h1>
		<div>
			<spring:message code="system.title"></spring:message>
		</div>
	</section>
</body>
</html>