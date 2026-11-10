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

<div class="layui-container" >
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;text-align:center">
  <legend>发布实验室成果</legend>
</fieldset>
 
<form class="layui-form" action="/Lab/addAchievement" method="post" style="margin-top: 20px;">
  <div class="layui-form-item">
    <label class="layui-form-label">成果</label>
    <div class="layui-input-block">
      <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">日期</label>
      <div class="layui-input-block">
        <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">详情</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" name="detail" id="detail" lay-verify="detail" class="layui-textarea"></textarea>
    </div>
  </div>

  <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即发布</button>
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
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });

 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 5){
        return '标题至少得5个字符啊';
      }
    }
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
  
  
  //监听提交
  form.on('submit(demo1)', function(data){
    layer.alert(JSON.stringify(data.field), {
      title: '提交成功！'
    })
  /*   return false; */
  })
  
});
</script>


</body>
<%@ include file="/admin/headAndTail/tail.jsp" %>
</html>