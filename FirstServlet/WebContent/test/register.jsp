<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <title></title>
        <link rel="stylesheet" href="/FirstServlet/test/css/register.css">
		<style type="text/css">
        </style>
        <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
        <script type="text/javascript" src="/FirstServlet/test/js/register.js"></script>
	</head>
	<body>
		<!--
		1.用户名不能为空
		2.用户名必须在6-14位之间
		3.用户名只能由数字和字母组成，不能含有其他符号（正则表达式）
		4.密码和确认密码一致，邮箱地址合法
		5.统一失去焦点验证
		6.错误提示信息统一在span标签中提示，字体12号，红色
		7.文本框再次获得焦点后，清空错误提示信息，如果文本框中数据不合法要求清空文本框的value
		8.最终表单中所有项均合法方可提交
		-->
        <!--这个表单提交应该使用post，这里为了检测使用get-->
        <div class ="content"><br />
            <div class="head">
                <h1>注册</h1>
            </div>
            <div class="form">
                <form id="userform" action="/FirstServlet/registerServlet" method="post" name="login">
                    <div class="in">
                        <input type="text" name="username" id="username" placeholder="请输入用户名"/><span id="usernameError"></span><br>
                        <input type="text" name="userpwd" id="userpwd" placeholder="请输入密码"/><br>
                        <input type="text" name="userpwd2" id="userpwd2" placeholder="请再次输入密码"/><span id="userpwdError"></span><br>
                        <input type="text" name="email" id="email" placeholder="请输入邮箱"/><span id="emailError"></span><br>
                        <br>
                    </div>
                    <!--<input type="submit" value="注册"/>-->
                    <div class="butt">
                        <input type="button" value="注册" id="submitBtn" name="submitBtn"/>
                        <input type="reset" value="重置" />
                    </div>
                    <br />
                </form>
            </div>
            
        </div>
	</body>
</html>
