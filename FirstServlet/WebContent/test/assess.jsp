<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="utf-8" />
	<meta name="infor" content="width=device-width,initial-scale=1.0">
	<link rel="stylesheet" href="/FirstServlet/test/css/assess.css">
	<link rel="stylesheet" href="/FirstServlet/test/css/menu.css">
	<title>评价</title>
</head>
<body>
	<%@ include file="head_user.jsp" %>

    <div class ="content">
        <h2>您对本站的服务还满意吗？点击下方做出评价吧</h2>
        <div id="all">
	        <input type="radio" name="assess" /><i style="color:white;">A.非常满意</i>
	        <br><input type="radio" name="assess" /><i style="color:white;">B.很满意</i>
	        <br><input type="radio" name="assess" /><i style="color:white;">C.基本满意</i>
	        <br><input type="radio" name="assess" /><i style="color:white;">D.不满意</i>
        </div>
        <div class="butt">
	        		<br><input type="button" value="提交" onclick="window.location.href='/FirstServlet/test/assess_success.jsp';"><br><br>
	    </div>
    </div>
</body>
</html>