<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action='./sayHi?msg=Please'>
	<label>UserName: 
	<input type="text" name="username" id="username1" value=''/>
	</label>
	<input type="submit" value="Say Hi to Servlet by GET"/>
</form>
<hr />
<form action='./sayHi?msg=Please' method="POST">
	<label>UserName:
	<input type="text" name="username" id="username2" value=''/>
	</label> <input type="submit" value="Say Hi to Servlet by POST"/>
</form>

</body>
</html>