<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/admin/headAndTail/head.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>查看招贤纳士详情</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		
		<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/ProClassset/layui-v2.5.6/layui/css/layui.css"  media="all">
  <script src="/ProClassset/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
  <style type="text/css">
			body {
				width: 100%;
				height: 100%;
			}
			.contain{
			}
			.row{
				display:inline-block;
			}
		</style>
</head>
<body class="layui-bg-gray">


<div class="content">
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;text-align:center">
  <legend>查看报名详情</legend>
</fieldset>
 <div class="layui-container">  
  <div class="layui-row layui-col-space30">
 <c:forEach var="u" items="${PARlist}">
  <div class="layui-col-md8 layui-col-md-offset2">
        <div class="layui-card">
        <div class="layui-card-body">
   <div class="layui-row" style="text-align:left;">
       <h3 style="padding-top:15px;color:black;">${u.parName }</h3>
              <br/><p>​性别：${u.parGender }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年龄：${u.parAge }</p >
                  <br/><p>​联系电话：${u.parTele }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p >
                  <br/><p>​学历：${u.parDegree }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工作/学习单位：${u.parWork }</p >
                  <br/><p>​个人信息：${u.parPerMes }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p >
                  <br/><p>​获奖经历：${u.parPrize }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p >
                  <br/>
    <p>加入原因：${u.parReason }</p >
   </div>
  </div>
  </div>
  </div>
  </c:forEach>
  
  </div>
  </div>
<br>  
</div>


			<script src="js/bootstrap.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	
</body>
</html>