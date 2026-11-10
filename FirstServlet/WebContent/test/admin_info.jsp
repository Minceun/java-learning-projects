<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="infor" content="width=device-width,initial-scale=1.0">
		<link rel="stylesheet" href="/FirstServlet/test/css/menu.css">
		<link rel="stylesheet" href="/FirstServlet/test/css/infocss.css">
		<title>完善信息</title>
	</head>
	<body>
		<%@ include file="head_admin.jsp" %>
	
		<div id="top"></div>
		<div id="all">
		<h2>完善信息</h2>
		<form action="/FirstServlet/test/welcome.jsp" method="get">
			<label>上传头像</label>
			<input type="file" name="photo" id="photo" value="" /><br/>
			<hr />
			<label>姓名</label>
			<input type="text" id="name" placeholder="请输入您的姓名"/><br/>
			<hr />
			<label>性别</label>
			<input type="radio" name="sex" />男<input type="radio" name="sex" />女<br/>
			<hr />
			<label>年龄</label>
			<input type="number" id="age" value="18" placeholder="请输入您的年龄"/><br/>
			<hr />
			<label>E-mail</label>
			<input type="email" id="email" placeholder="请输入您的email"/><br/>
			<hr />
			<label>Phone</label>
			<input type="text" id="phone" placeholder="请输入您的电话"/><br/>
			<hr />
			<label>QQ</label>
			<input type="text" id="QQ" placeholder="请输入您的QQ号码"/><br/>
			<hr />
			<label>地区</label>
			<select name="province">
				<option value="">辽宁省</option>
			</select>
			<select name="city">
				<option value="">大连市</option>
				<option value="">沈阳市</option>
				<option value="">辽阳市</option>
				<option value="">鞍山市</option>
				<option value="">阜新市</option>
			</select><br />
			<hr />
			<label>选择你感兴趣的内容（可多选）</label><br />
			<div id="intersting">
				<input type="checkbox" name="interst" value="" />摄影
				<input type="checkbox" name="interst" value="" />音乐
				<input type="checkbox" name="interst" value="" />电影<br />
				<input type="checkbox" name="interst" value="" />阅读
				<input type="checkbox" name="interst" value="" />运动
				<input type="checkbox" name="interst" value="" />计算机
			</div>
			<hr />
			<label>个人简介</label><br />
			<textarea name="person" rows="5" cols="60"></textarea>
			<br />
			<hr />
			<input type="submit" id="butt"  value="提交"/>
			<div id="top"></div>
		</form>
		<a href="#top" style="float: right;color: #00FFFF;">点击返回顶部</a>
		</div>
	</body>
</html>
