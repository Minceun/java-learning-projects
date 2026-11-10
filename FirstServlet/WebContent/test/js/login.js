window.onload=function(){
    var name = document.getElementById("username");
    var pwd = document.getElementById("password");
    var error = document.getElementById("error");
    name.onblur = function(){
    		error.innerHTML="请输入密码！"
    }
    pwd.onblur = function(){
    		if((name.value!="admin")||(pwd.value!="124121")){
    			error.innerHTML="用户名或密码错误，请重新输入！";
    		}
    		else{
    			error.innerHTML="";
    		}
		}
}

function jump(){
	window.location.href="/FirstServlet/test/register.jsp";
}