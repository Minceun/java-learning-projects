<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Lab/layui-v2.5.6/layui/css/layui.css"  media="all">
<script src="/Lab/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
 <style type="text/css">
 	.content{
 		width: 100%;
		height: 100%;
 		text-align: center;
 	}
 	</style>
<title>equipments</title>
</head>
<body class="layui-bg-gray">
<%@ include file="/labs/headAndTail/head.jsp" %>
<div class="content">
<h1 style="padding:30px;color:black;">实验设备</h1>
	
<div class="layui-container">  
<div class="layui-row layui-col-space30">

		<div class="layui-col-md4 layui-col-md-offset2">
		<div class="layui-card">
		<div class="layui-card-body">  
			      <img style="width:320px;height:200px" src="/Lab/labs/equipments/img/1.png">
			      <br><h3 style="padding:15px;">Myo—交互式腕带</h3>
		</div>
		</div>
		</div>
		
		<div class="layui-col-md4">
		<div class="layui-card">
		<div class="layui-card-body">  
			      <img style="width:320px;height:200px" src="/Lab/labs/equipments/img/2.png">
			      <br><h3 style="padding:15px;">Kinect</h3>
		</div>
		</div>
		</div>
		
		<div class="layui-col-md4 layui-col-md-offset2">
		<div class="layui-card">
		<div class="layui-card-body">  
			      <img style="width:320px;height:200px" src="/Lab/labs/equipments/img/3.png">
			      <br><h3 style="padding:15px;">Geomagic Touch</h3>
		</div>
		</div>
		</div>
		
		<div class="layui-col-md4">
		<div class="layui-card">
		<div class="layui-card-body">  
			      <img style="width:320px;height:200px" src="/Lab/labs/equipments/img/4.png">
			      <br><h3 style="padding:15px;">wacom数位板</h3>
		</div>
		</div>
		</div>
		
		<div class="layui-col-md4 layui-col-md-offset2">
		<div class="layui-card">
		<div class="layui-card-body">  
			      <img style="width:320px;height:200px" src="/Lab/labs/equipments/img/5.png">
			      <br><h3 style="padding:15px;">PixelSense</h3>
		</div>
		</div>
		</div>
		
		</div>
		</div>
			
			
<br><br><br><br><br>
</div>

<%@ include file="/labs/headAndTail/tail.jsp" %>
</body>
</html>