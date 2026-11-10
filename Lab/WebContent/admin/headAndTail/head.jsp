<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8">
  <title>index</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" type="text/css" href="/Lab/css/bootstrap.min.css" />
  <script src="/Lab/js/bootstrap.js"></script>
  <script src="/Lab/js/bootstrap.min.js"></script>
  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<link rel="stylesheet" href="/Lab/layui-v2.5.6/layui/css/layui.css"  media="all">
  <script src="/Lab/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>  
</head>
<body>
	<div class="layui-nav" style="background-color:white;">
    <a class="fly-logo layui-col-md-offset1" href="/Lab/index.jsp">
      <img src="/Lab/labs/headAndTail/img/123.png" style="width:100px;height:100px;" alt="layui">
      <img src="/Lab/labs/headAndTail/img/sut.jpeg" style="width:200px;height:70px;" alt="layui">
      <img src="/Lab/labs/headAndTail/img/lab.jpeg" style="width:300px;height:110px;" alt="layui">
    </a>
    </div>
    
    
    
<div class="layui-nav" >
<ul class="layui-nav" style="text-align:center;">
	
  <li class="layui-nav-item"><a href="/Lab/admin_select">用户管理</a></li>
  <li class="layui-nav-item"><a href="/Lab/admin/admin_teams/team.jsp">科研队伍管理</a></li>
  
  <li class="layui-nav-item">
    <a href="javascript:;">发布信息</a>
    <dl class="layui-nav-child">
      <dd><a href="/Lab/admin/admin_news/new.jsp">发布实验室动态</a></dd>
      <dd><a href="/Lab/admin/admin_achievements/achievement.jsp">发布实验室成果</a></dd>
<!--       <dd><a href="/Lab/labs/equipments/equipment.jsp">修改实验设备</a></dd>
 -->    </dl>
  </li>

  <li class="layui-nav-item"><a href="/Lab/upload.jsp">资料管理</a></li>
  <li class="layui-nav-item"><a href="/Lab/managerGrau">毕业生管理</a></li>
  
  <li class="layui-nav-item">
    <a href="javascript:;">查看新联系</a>
    <dl class="layui-nav-child">
      <dd><a href="/Lab/ManaParticipant">新申请加入</a></dd>
      <dd><a href="/Lab/CORMessage">新合作</a></dd>
      <!-- <dd class="layui-this"><a href="">选中项</a></dd> -->
    </dl>
  </li>
  
  <li class="layui-nav-item"><a href="/Lab/tuichu">注销登陆</a></li>
  
  <c:if test="${isLogin ==1 }">
         		<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎你！</b>${name.admin_num }
            </c:if>
</ul>
	

</div>


<script>
layui.use('element', function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
  //监听导航点击
  element.on('nav(demo)', function(elem){
    layer.msg(elem.text());
  });
});
</script>
</body>
</html>