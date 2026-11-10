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
  </style>
<title></title>
</head>
<body class="layui-bg-gray">
<%@ include file="/admin/headAndTail/head.jsp" %>

<div class="content">
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;text-align:center">
  <legend>合作意向详情</legend>
</fieldset>
 <div class="layui-container">  
  <div class="layui-row layui-col-space30">
  <c:forEach var="c" items="${corlist}">
  <div class="layui-col-md8 layui-col-md-offset2">
        <div class="layui-card">
        <div class="layui-card-body">
   <div class="layui-row" style="text-align:left;">
       <h3 style="padding-top:15px;color:black;">合作人姓名：${c.CORname}</h3>
              <br/><p>​合作详情：${c.CORidea}</p >
    <p style="text-align:right;">合作人联系方式：${c.CORtele }</p >
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