<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
  <meta charset="utf-8">
  <title>index</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/Lab/layui-v2.5.6/layui/css/layui.css"  media="all">
  <script src="/Lab/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
</head>
<body>
	<div class="layui-nav" style="background-color:white;">
     <a class="fly-logo layui-col-md-offset1" href="/Lab/index.jsp" >
      <img src="/Lab/labs/headAndTail/img/123.png" style="width:100px;height:100px;" alt="layui">
      <img src="/Lab/labs/headAndTail/img/sut.jpeg" style="width:200px;height:70px;" alt="layui">
      <img src="/Lab/labs/headAndTail/img/lab.jpeg" style="width:300px;height:110px;" alt="layui">
   </a> 
    </div>
    
    
    
<div class="layui-nav" >
<ul class="layui-nav" style="text-align:center;">
	
  <li class="layui-nav-item"><a href="/Lab/index.jsp">首页</a></li>
  <li class="layui-nav-item"><a href="/Lab/labs/team/team1.jsp">科研队伍</a></li>
  <li class="layui-nav-item"><a href="/Lab/getNews">实验室动态</a></li>
  
  <li class="layui-nav-item">
    <a href="javascript:;">实验室展示</a>
    <dl class="layui-nav-child">
      <dd><a href="/Lab/getAchievements">实验室成果</a></dd>
      <dd><a href="/Lab/labs/equipments/equipment.jsp">实验设备</a></dd>
    </dl>
  </li>

    <li class="layui-nav-item"><a href="/Lab/downloadFILE">资料下载</a></li>
  <li class="layui-nav-item"><a href="/Lab/showAllGraud">历届毕业生</a></li>
  
  <li class="layui-nav-item">
    <a href="javascript:;">联系我们</a>
    <dl class="layui-nav-child">
      <dd><a href="participant.jsp">招贤纳士</a></dd>
      <dd><a href="CORIDEA.jsp">欢迎合作</a></dd>
      <!-- <dd class="layui-this"><a href="">选中项</a></dd> -->
    </dl>
  </li>
  
  <li class="layui-nav-item"><a href="/Lab/login.jsp">管理员登陆</a></li>
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