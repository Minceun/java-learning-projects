<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<link rel="stylesheet" href="/Lab/layui-v2.5.6/layui/css/layui.css"  media="all">
		<script src="/Lab/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
 <style type="text/css">
 	.content{
 		width: 100%;
		height: 100%;
 		text-align: center;
 	}
 	</style>
 <title>研究生</title>
	</head>
	<body class="layui-bg-gray">
	<%@ include file="/labs/headAndTail/head.jsp" %>
	
	<div class="content">
    		<div class="se-nav">
        		<h1 style="padding:30px;color:black;">研究队伍</h1>
	        <div class="se-secondnav">
	          	<span class="layui-breadcrumb" lay-separator="|" >
				  <a href="/Lab/labs/team/team1.jsp" style="font-size:17px;">教授</a>
				  <a href="/Lab/getTeam" style="font-size:17px;">博士</a>
				  <a href="/Lab/getTeam2" style="font-size:17px;">硕士</a>
				  <a href="/Lab/getTeam3" style="font-size:17px;">本科生</a>
				</span>
	        </div><br>
        </div>
        
        <div class="layui-container">  
		<div class="layui-row layui-col-space30">
		
		<c:forEach var="u" items="${MASed }">
		
		<div class="layui-col-md5 layui-col-md-offset1">
        <div class="layui-card">
        <div class="layui-card-body">
			<div class="layui-row">
			    <div class="layui-col-xs4">
			      <div class="grid-demo grid-demo-bg1" style="text-align:left;">
			      <img style="width:130px;height:200px" src="/Lab/labs/team/img/${ u.MASname }.png"></div>
			    </div>
			    <div class="layui-col-xs6" style="vertical-align:middle;">
			      <br><h2 style="padding:15px;">${ u.MASname }</h2>
			      <span style="color:#9d8a0e">研究生</span>
	              <!-- <p class="p2 mail" style="padding:15px;"><strong>邮箱：</strong><span class="p2 mail mleft">yqxu@tsinghua.edu.cn</span></p> -->
			    </div>
			</div>
		</div>
		</div>
		</div>
	
		</c:forEach>
		
		
		
		
		</div>
		</div>
        
        
        <br>
        </div>
        
        
	</body>
</html>
