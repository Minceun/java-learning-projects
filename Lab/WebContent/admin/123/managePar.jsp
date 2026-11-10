<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/admin/headAndTail/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看招贤纳士详情</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script src="js/bootstrap.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/ProClassset/layui-v2.5.6/layui/css/layui.css"  media="all">
  <script src="/ProClassset/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="contain">
			<table border="1px" cellspacing="0" cellpadding="0">
			<c:forEach var="u" items="${PARlist}">
				<tr>
					<td>
						<li style="list-style-type: none;">
							<div class="row">
								<div class="col-md-10 col-md-offset-1">
									${u.parName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${u.parGender }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${u.parAge }
									<br /> 联系电话：${u.parTele }
									<br /> ${u.parDegree }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${u.parWork }
									<br /> 个人信息:<br />${u.parPerMes }
									<br /> 获奖经历:<br />${u.parPrize }
									<br /> 加入原因:<br />${u.parReason }
									<br />
								</div>
							</div>
						</li>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
			<script src="js/bootstrap.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	
</body>
</html>