<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
  <link rel="stylesheet" href="/Lab/layui-v2.5.6/layui/css/layui.css"  media="all">
  <script src="/Lab/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>

 <style type="text/css">
  .content{
   width: 100%;
  height: 100%;
   text-align: center;
  }
  </style>
<title>实验室动态</title>
</head>
<body class="layui-bg-gray">
<%@ include file="/labs/headAndTail/head.jsp" %>

<div class="content">
 <h1 style="padding:30px;color:black;">学习资料展示</h1>
 <div class="layui-container">  
  <div class="layui-row layui-col-space30">
  <c:forEach var="f" items="${filelist}">
  <div class="layui-col-md8 layui-col-md-offset2">
        <div class="layui-card">
        <div class="layui-card-body">
   <div class="layui-row" style="text-align:left;">
       <h3 style="padding-top:15px;color:black;">${f.fileCon}</h3>
              <p>​<a href=${f.filePath }>点击此处下载  <span class="glyphicon glyphicon-download-alt"></span></a></p >
    <p style="text-align:right;">上传者：${f.fileOwner }</p >
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