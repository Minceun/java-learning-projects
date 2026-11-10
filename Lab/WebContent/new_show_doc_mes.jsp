<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/ProClassset/layui-v2.5.6/layui/css/layui.css"  media="all">
  <script src="/ProClassset/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>

 <style type="text/css">
  .content{
   width: 100%;
  height: 100%;
   text-align: center;
  }
  .img-thumbnail{
  width:400px;
  height:500px;
  }
  </style>
<title>信息详情</title>
</head>
<body class="layui-bg-gray">
<%@ include file="/labs/headAndTail/head.jsp" %>

<div class="content">
 <h1 style="padding:30px;color:black;">研究生资料详情</h1>
 <div class="layui-container">  
  <div class="layui-row layui-col-space30">
  <c:forEach var="l" items="${list}">
  <div class="layui-col-md8 layui-col-md-offset2">
        <div class="layui-card">
        <div class="layui-card-body">
        <img src="Graudimg/${l.DOCname }.png" alt="" class="img-thumbnail"/>
   <div class="layui-row" style="text-align:left;">
       <h3 style="padding-top:15px;color:black;">${l.DOCname }</h3>
              <p>研究成果：${l.DOCfield }</p >
    <p style="text-align:left;">个人信息：${l.DOCMes }</p >
   </div>
  </div>
  </div>
  </div>
  <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
  </c:forEach>
  
  </div>
  </div>
<br>  
</div>

<%@ include file="/labs/headAndTail/tail.jsp" %>
</body>
</html>