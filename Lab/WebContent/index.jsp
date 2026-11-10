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
<%@ include file="/labs/headAndTail/head.jsp" %>
<div class="layui-container">  
	<div class="layui-row"><div class="layui-col-md12"></div></div>
	<div class="layui-row layui-col-space30">
		<div class="layui-col-md6">
			<div class="layui-carousel" id="test1" lay-filter="test1">
			  <div carousel-item="">
				<div><img style="width:600px;height:280px" src="/Lab/labs/img/1.jpeg"></div>
			    <div><img style="width:600px;height:280px" src="/Lab/labs/img/2.jpeg"></div>
			    <div><img style="width:600px;height:280px" src="/Lab/labs/img/3.jpeg"></div>
			    <div><img style="width:600px;height:280px" src="/Lab/labs/img/4.jpeg"></div>
			    <div><img style="width:600px;height:280px" src="/Lab/labs/img/5.jpeg"></div>
			  </div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-card">
		        <div class="layui-card-header" style="font-size: 19px;">实验室动态&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		        <a href="/Lab/getNews" style="font-size:10px;">查看更多-></a></div>
		        <div class="layui-card-body">
		        		<a href="/Lab/getNews">·&nbsp;<span>观看“人机共协，科技向善”云论坛第四期</span><span style="float:right;">2020-07-05</span></a><br>
		          	<a href="/Lab/getNews">·&nbsp;<span>实验室召开全体讨论会</span><span style="float:right;">2020-07-03</span></a><br>
		          	<a href="/Lab/getNews">·&nbsp;<span>人机交互实验室硕士研究生课题讨论</span><span style="float:right;">2020-06-20</span></a><br>
		          	<a href="/Lab/getNews">·&nbsp;<span>人机交互实验室召开毕业生欢送会</span><span style="float:right;">2020-06-20</span></a><br>
		          	<a href="/Lab/getNews">·&nbsp;<span>2017级本科生综合程序设计课题确定</span><span style="float:right;">2020-06-20</span></a><br>
		          	<a href="/Lab/getNews">·&nbsp;<span>2020届本科毕业生答辩</span><span style="float:right;">2020-06-11</span></a><br>
		          	<a href="/Lab/getNews">·&nbsp;<span>2020届硕士生毕业答辩</span><span style="float:right;">2020-06-02</span></a><br>
		          	<a href="/Lab/getNews">·&nbsp;<span>实验室召开全体讨论会</span><span style="float:right;">2020-05-31</span></a><br>
		          	<a href="/Lab/getNews">&nbsp;<span></span><span></span style="float:right;"></a><br>
		        </div>
	      	</div>
		</div>
	</div>
	
	<div class="layui-row layui-col-space30">
		<div class="layui-col-md6">
			<div class="layui-card">
		        <div class="layui-card-header" style="font-size: 19px;">简介</div>
		        <div class="layui-card-body">
		          	沈阳工业大学人机交互实验室成立于2006年07月。实验室致力于人机交互领域研究，
		          	主要从事的研究方向有：多通道笔式交互技术研究、多点触摸技术研究、生物特征识别、
		          	及面向弱势群体的交互研究等，并有基于Android的移动式计算开发、基于java、web
		          	的网站开发等横向研究课题。实验室以认真、细节为特点，以培养人才、储备知识、
		          	创新与突破技术应用为长期目标，以努力营造一个宽松的学术环境为宗旨，广泛开展
		          	多学科交叉研究，特别是在人机交互领域中的用户模型、人机界面、多通道人机交互
		          	等多个方向上进行了深入的研究。
		          	<br><br><br><br><br>
		        </div>
	      	</div>
	      	<div class="layui-card">
		        <div class="layui-card-header" style="font-size: 19px;">队伍规模&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		        <a href="/Lab/labs/team/team1.jsp" style="font-size:10px;">查看详情-></a></div>
		        <div class="layui-card-body">
		          	教授：1人<br>
		          	博士研究生：2人<br>
		          	硕士研究生：7人<br>
		          	本科生：6人<br>
		          	<br><br>
		        </div>
	      	</div>
		</div>
	<div class="layui-col-md6">
		<div class="layui-card">
	        <div class="layui-card-header" style="font-size: 19px;">科研项目</div>
	        <div class="layui-card-body">
	        <div class="layui-row">
			    <div class="layui-col-xs6">
			      <div class="grid-demo grid-demo-bg1"><img style="width:220px;height:200px" src="/Lab/labs/achievements/img/1.jpg"><p style="text-align:center;padding:10px;">人机自然交互及用户体验</p></div>
			    </div>
			    <div class="layui-col-xs6">
			      <div class="grid-demo grid-demo-bg1"><img style="width:220px;height:200px" src="/Lab/labs/achievements/img/2.png"><p style="text-align:center;padding:10px;">交互式数字孪生空间</p></div>
			    </div>
			</div>
			<div class="layui-row">
			    <div class="layui-col-xs6">
			      <div class="grid-demo grid-demo-bg1"><img style="width:220px;height:200px" src="/Lab/labs/achievements/img/3.jpg"><p style="text-align:center;padding:10px;">沉浸式交互学习及其体验设计</p></div>
			    </div>
			    <div class="layui-col-xs6">
			      <div class="grid-demo grid-demo-bg1"><img style="width:220px;height:200px" src="/Lab/labs/achievements/img/4.jpg"><p style="text-align:center;padding:10px;">新型材料的镜像计算与交互设计</p></div>
			    </div>
			</div>
	        </div>
      	</div>
	</div>
	</div>
	<br>
</div>
 
<script>
layui.use(['carousel', 'form'], function(){
  var carousel = layui.carousel
  ,form = layui.form;
  
  //常规轮播
  carousel.render({
    elem: '#test1'
    ,arrow: 'always'
    	,interval: 1800
    ,width: '555px'
     		/*   	,height: '440px' */
  });
 
  //监听开关
  form.on('switch(autoplay)', function(){
    ins3.reload({
      autoplay: this.checked
    });
  });
  
});
</script>

<script>
layui.use('flow', function(){
  var flow = layui.flow;
  //按屏加载图片
  flow.lazyimg({
    elem: '#LAY_demo3 img'
    ,scrollElem: '#LAY_demo3' //一般不用设置，此处只是演示需要。
  });
  
});
</script>



<%@ include file="/labs/headAndTail/tail.jsp" %>
</body>
</html>