<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Lab/layui-v2.5.6/layui/css/layui.css"  media="all">
<script src="/Lab/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
<title>Insert title here</title>
</head>
<body class="layui-bg-gray">
<%@ include file="/admin/headAndTail/head.jsp" %>

<br>

<div class="layui-container" style="vertical-align:middle;">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;text-align:center">
  <legend>添加团队人员</legend>
</fieldset>

<form class="layui-form" action="/Lab/addTeam" method="post" style="margin-top: 20px;">
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name" lay-verify="required" lay-reqtext="姓名是必填项，岂能为空？" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">学号</label>
    <div class="layui-input-block">
      <input type="text" name="id" lay-verify="required" lay-reqtext="学号是必填项，岂能为空？" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">学位</label>
    <div class="layui-input-block">
      <select name="degree" lay-filter="aihao">
        <option value=""></option>
        <option value="0">本科生</option>
        <option value="1" selected="">硕士</option>
        <option value="2">博士</option>
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <input type="radio" name="sex" value="男" title="男" checked="">
      <input type="radio" name="sex" value="女" title="女">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">是否在读</label>
    <div class="layui-input-block">
      <input type="checkbox" checked="" name="status" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
</div><br><br><br><br>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  //监听提交
  form.on('submit(demo1)', function(data){
    layer.alert(JSON.stringify(data.field), {
      title: '提交成功！'
    })
	 /* return false; */
  })
  
});
</script>
</body>
<%@ include file="/admin/headAndTail/tail.jsp" %>
</html>