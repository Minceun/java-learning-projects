<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
 		<link rel="stylesheet" href="layui-v2.5.6/layui/css/layui.css"  media="all">
		<script src="layui-v2.5.6/layui/layui.js" charset="utf-8"></script>	
		 <style type="text/css">
		 	.content{
		 		width: 100%;
				height: 100%;
		 		text-align: center;
		 	}
		 	.layui-col-md5{
		 		position:relative;
		 		left:-50px;
		 	}
		 	.spant{
		 	position:relative;
		 		left:20px;
		 		text-align:left;
		 		float:left;
		 		width:300px;
		 	}
		 </style>
 		<title>科研团队</title>
	</head>
	
	<body class="layui-bg-gray">
	<%@ include file="/labs/headAndTail/head.jsp" %>
	
	<div class="content">
    		<div class="se-nav">
        		<h1 style="padding:30px;color:black;">历届毕业生</h1>
	        <div class="se-secondnav">
	          	<!-- <span class="layui-breadcrumb" lay-separator="|" >
				  <a href="/Lab/labs/team/team1.jsp" style="font-size:17px;">科研团队</a>
				  <a href="/Lab/labs/team/team2.jsp" style="font-size:17px;">博士</a>
				  <a href="/Lab/labs/team/team3.jsp" style="font-size:17px;">研究生</a>
				</span> -->
	        </div><br>
        </div>
        
        <div class="layui-container">  
		<div class="layui-row layui-col-space30">
		  <c:forEach var="d" items="${LISTDOC}">
		<div class="layui-col-md5 layui-col-md-offset1">
        <div class="layui-card">
        <div class="layui-card-body">
			<div class="layui-row">
			    <div class="layui-col-xs4">
			      <div class="grid-demo grid-demo-bg1" style="text-align:left;">
			      <img style="width:150px;height:200px" src="Graudimg/${d.DOCname }.png">
			      </div>
			    </div>
			    <div class="layui-col-xs7" style="vertical-align:middle;">
			      <br><h2 style="padding:15px;"><a href="showAllMes?docname=${d.DOCname }">${d.DOCname }</a></h2>
			      <span class="spant" style="color:#9d8a0e;width:250px;">研究方向：<br/>${d.DOCfield }</span>
			    </div>
			</div>
		</div>
		</div>
		</div>
		 </c:forEach>
		
		
		 <c:forEach var="m" items="${LISTMAS}">
		<div class="layui-col-md5 layui-col-md-offset1">
        <div class="layui-card">
        <div class="layui-card-body">
			<div class="layui-row">
			    <div class="layui-col-xs4">
			      <div class="grid-demo grid-demo-bg1" style="text-align:left;">
			      <img style="width:150px;height:200px" src="Graudimg/${m.MASname }.png"></div>
			    </div>
			    <div class="layui-col-xs7" style="vertical-align:middle;">
			      <br><h2 style="padding:15px;"><a href="showAllMes?masname=${m.MASname }">${m.MASname }</a></h2>
			      <span class="spant" style="color:#9d8a0e;width:250px;">研究方向：<br/>${m.MASfield }</span>
			    </div>
			</div>
		</div>
		</div>
		</div>
		 </c:forEach>
		<c:forEach var="b" items="${LISTBAC}">
		<div class="layui-col-md5 layui-col-md-offset1">
        <div class="layui-card">
        <div class="layui-card-body">
			<div class="layui-row">
			    <div class="layui-col-xs4">
			      <div class="grid-demo grid-demo-bg1" style="text-align:left;">
			      <img style="width:150px;height:200px" src="Graudimg/${b.BACname }.png"></div>
			    </div>
			    <div class="layui-col-xs7" style="vertical-align:middle;">
			      <br><h2 style="padding:15px;">${b.BACname }</h2>
			    <p>简介：${b.BACMes }</p>
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
       <%@ include file="/labs/headAndTail/tail.jsp" %>
	</body>
</html>
