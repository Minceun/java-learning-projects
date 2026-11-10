<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/labs/headAndTail/head.jsp" %>
<html>

	<head>
		<meta charset="UTF-8">
		<title>合作意向</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script src="js/bootstrap.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<style type="text/css">
			body {
				width: 100%;
				height: 100%;
			}
			
			.row {
				margin-bottom: 20px;
				width: 1000px;
			}
			
			.row .row {
				margin-top: 10px;
				margin-bottom: 0;
			}
			
			[class*="col-md-5"] {
				padding-top: 15px;
				padding-bottom: 15px;
				background-color: #eee;
				background-color: white;
				border: 1px solid #ddd;
				border: 1px solid rgba(86, 61, 124, .2);
			}
			
			[class*="col-lg-9"] {
				padding-top: 15px;
				padding-bottom: 15px;
				background-color: #eee;
				background-color: darkgray;
				border: 1px solid #ddd;
				border: 1px solid rgba(86, 61, 124, .2);
				border-radius: 10px;
			}
			
			[class*="col-md-10"] {
				padding-top: 15px;
				padding-bottom: 15px;
				background-color: #eee;
				background-color: white;
				border: 1px solid #ddd;
				border: 1px solid rgba(86, 61, 124, .2);
				position: relative;
				left: 100px;
			}
			.contain{
				width: 1000px;
				height: 1400px;
				margin-left: auto;
				margin-right: auto;
				text-align: left;
				margin-top: 50px;
			}
			.nav{
				margin-left: auto;
				margin-right: auto;
				position: relative;
				right: 0px;
				width: 600px;
				height: 100%;
			}
			#submit{
			margin-left: auto;
				margin-right: auto;
				position: relative;
				left:220px;
			}
		</style>
	</head>

	<body class="layui-bg-gray">
		<div class="contain">
		<form action="/Lab/coridea" method="post" id="myform" name="myform">
			<ul class="nav">
				<li>
					<div class="row">
						<div class="col-md-5 col-md-offset-1">
							<label>姓名<span style="color: red;">*</span></label>
							&nbsp;
							<input type="text" name="name" placeholder="请输入您的名字" value="" />
						</div>
					</div>
				</li>
				<li>
					<div class="row">
						<div class="col-md-5 col-md-offset-1">
							<label>性别<span style="color: red;">*</span></label>
							&nbsp;
							<input type="radio" name="gender" value="male" />&nbsp;男&nbsp;
							<input type="radio" name="gender" value="female" />&nbsp;女&nbsp;
						</div>
					</div>
				</li>
				<li>
					<div class="row">
						<div class="col-md-5 col-md-offset-1">
							<label>年龄<span style="color: red;">*</span></label>
							&nbsp;
							<input type="text" name="age" placeholder="请输入您的年龄" value="" />
						</div>
					</div>
				</li>
				<li>
					<div class="row">
						<div class="col-md-5 col-md-offset-1">
							<label>联系方式<span style="color: red;">*</span></label>
							&nbsp;
							<input type="text" name="tele" placeholder="请输入联系方式" value="" />
						</div>
					</div>
				</li>
				<li>
					<div class="row">
						<div class="col-md-5 col-md-offset-1">
							<label>简述合作意向<span style="color: red;">*</span></label>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
							<textarea cols="52" rows="10" name="idea"></textarea>
						</div>
					</div>
				</li>
				<br />
				<input type="submit" name="submit" id="submit" value="确定" class="btn btn-info"/>
			</ul>
			</form>
			
		</div>
		<script src="js/bootstrap.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

	</body>

</html>