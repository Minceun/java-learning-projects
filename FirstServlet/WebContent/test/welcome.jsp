<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
        <meta name="infor" content="width=device-width,initial-scale=1.0">
        <link rel="stylesheet" href="/FirstServlet/test/css/welcome.css">

        <script type="text/javascript" src="/FirstServlet/test/js/welcome.js"></script>
        <link href="/FirstServlet/test/css/bootstrap.css" rel="stylesheet"/>
        <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.js"></script>
        <link rel="stylesheet" href="/FirstServlet/test/css/menu.css">
        <title>welcome!</title>
    </head>
    <style type="text/css">
            .modal.fade.in{
                top:90px;
            }
    </style>
	<body>
		<%@ include file="head_user.jsp" %>
<%
		String s1 = (String)session.getAttribute("username");
		if(s1 != null){
			out.println("欢迎用户: " + s1 + "<br>");
		}else{
			out.println("您还没有进行登陆<br>");
		}
	%>
        <div class ="content"><br />
            <h1 id="hh" class="text-muted">开始记账吧！</h1><br>
            <div class ="add">
                <p style="color: white; font-size: 18px;">类型：&nbsp;&nbsp;&nbsp;<select class="add2" id="inout">
                    <option value="1">收入</option>
                    <option value="2">支出</option>
                    </select></p>
                <p style="color: white; font-size: 18px;">	类别：&nbsp;&nbsp;
                    <select class="add2" id="way">
                    <option value="">服饰</option>
                    <option value="">交通</option>
                    <option value="">教育</option>
                    <option value="">工资</option>
                    <option value="">兼职</option>
                    </select></p>
                <p style="color: white; font-size: 18px;">金额：&nbsp;&nbsp;<input type="text" class="add2" id="number" /></p>
                <input type="button" value="添加" id="but" onclick="add();" />

            </div>
                <table style="border=1px;" id="tb">
                    <tr>
                        <td class="bigclassname">&nbsp;&nbsp;&nbsp;&nbsp;类型&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td class="bigclassname">&nbsp;&nbsp;&nbsp;&nbsp;类别&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td class="bigclassname">&nbsp;&nbsp;&nbsp;&nbsp;金额&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td class="bigclassname">&nbsp;&nbsp;&nbsp;&nbsp;修改&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td class="bigclassname">&nbsp;&nbsp;&nbsp;&nbsp;删除&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    </tr>
                </table>
        </div>

	</body>
</html>
