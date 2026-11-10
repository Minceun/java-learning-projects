<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="infor" content="width=device-width,initial-scale=1.0">
 		<link rel="stylesheet" href="/FirstServlet/test/css/log.css">
		<link rel="stylesheet" href="/FirstServlet/test/css/menu.css">
		<title>评价统计</title>
	</head>
	<body>
		<%@ include file="head_admin.jsp" %>

        <div class ="content"><br />
            <h1>用户评价统计</h1>   
            <table>
            <tr>
                <th>选项</th>
                <th>百分比</th>
            </tr>
            <tr>
                <td>A 非常满意</td>
                <td>50%</td>
            </tr>
            <tr>
                <td>B 佷满意</td>
                <td>50%</td>
            </tr>
            <tr>
                <td>C 比较满意</td>
                <td>0%</td>
            </tr>
            <tr>
                <td>D 不满意</td>
                <td>0%</td>
            </tr>
        </table>
        </div>
        
	</body>
</html>
