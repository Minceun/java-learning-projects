$(function ()
{
            //鼠标点击输入框外时触发
            $("#username").blur(function ()
            {
                //获取输入内容
                var username = $(this).val();
 
                //发送ajax，请求servlet 返回数据data
                $.get("findUserServlet",{username:username},function (data)
                {
                    //"userExist": true, "msg": "此用户名太受欢迎，请换一个"
                    //"userExist": false, "msg": "此用户可用"
                    var span = $("#usernameError");
                    span.html(data.msg);
 
                    //如果用户名存在
                    if (data.userExist)
                        span.css("color","red");
                    else
                        span.css("color","green");
 
                },"json");
            });
 
        });
window.onload = function(){
    //获取用户名文本框
    var usernameElt = document.getElementById("username");
    //获取username的span标签
    var usernameSpan = document.getElementById("usernameError");
    //给用户名绑定blur事件，
    usernameElt.onblur = function(){
        //获得用户名
        var username = usernameElt.value;
        //去除前后空白
        username = username.trim();
//					alert(username);
        //判断用户名是否为空
        //if(username.length == 0)
        //if(username === "")
        if(Boolean(username)){
            //用户名不空，继续判断长度6-14
            if(username.length >= 3 && username.length <= 14){
                //用户名长度合法
                //继续判断用户名只能由数字和字母组成，不能含有其他符号（正则表达式）
                var regExp = /^[A-Za-z0-9]+$/;
                var ok = regExp.test(username);
                if(ok){
                    if(username=="admin"||username=="aaa"||username=="bbb"||username=="ccc"||username=="test"||username=="121212"){
                    	 usernameSpan.innerText = "用户名已存在";
                    }
                }else{
                    usernameSpan.innerText = "用户名只能由数字和字母组成";
                }
            }else{
                //用户名长度不合法
                usernameSpan.innerText = "用户名必须在6-14位之间";
            }
            
        }else{
            usernameSpan.innerText = "用户名不能为空";
        }
    }
    //给username文本框绑定获得焦点事件
    usernameElt.onfocus = function(){
        //输入不合法，文本框中内容清空
        if(usernameSpan.innerText.length != 0){
            usernameElt.value = "";
        }
        //清空span
        usernameSpan.innerText = "";
    }
    
    //获取用户密码及确认密码文本框
    var userpwdElt = document.getElementById("userpwd");
    var userpwdElt2 = document.getElementById("userpwd2");
    //获取userpwd的span标签
    var userpwdSpan = document.getElementById("userpwdError");
    //给密码绑定blur事件，
    userpwdElt2.onblur = function(){
        var pwd = userpwdElt.value;
        var pwd2 = userpwdElt2.value;
        if(pwd != pwd2){
            userpwdSpan.innerText = "两次密码不一致";
        }else{
            
        }
    }
    //给userpwd2文本框绑定获得焦点事件
    userpwdElt2.onfocus = function(){
        //输入不合法，文本框中内容清空
        if(userpwdSpan.innerText.length != 0){
            userpwdElt2.value = "";
        }
        //清空span
        userpwdSpan.innerText = "";
    }
    
    //获取邮箱文本框
    var emailElt = document.getElementById("email");
    //获取email的span标签
    var emailSpan = document.getElementById("emailError");
    //给邮箱绑定blur事件
    emailElt.onblur = function(){
        var email = emailElt.value;
        var regExp = /^\w+([-+.]\w+)*@\w+([-+.]\w+)*\.\w+([-+.]\w+)*$/;
        var ok = regExp.test(email);
        if(ok){
            
        }else{
            emailSpan.innerText = "邮箱格式不合法";
        }
    }
    //给email文本框绑定获得焦点事件
    emailElt.onfocus = function(){
        //输入不合法，文本框中内容清空
        if(emailSpan.innerText.length != 0){
            emailElt.value = "";
        }
        //清空span
        emailSpan.innerText = "";
    }
    
    //给提交按钮绑定鼠标单击事件
    var submitBtnElt = document.getElementById("submitBtn");
    submitBtnElt.onclick = function(){
        //触发username的blur userpwd2的blur email的blur
        usernameElt.focus();
        usernameElt.blur();
        
        userpwdElt2.focus();
        userpwdElt2.blur();
        
        emailElt.focus();
        emailElt.blur();
        //当所有的表单项都合法，提交数据
        if(usernameSpan.innerText == "" && userpwdSpan.innerText == "" && emailSpan.innerText== ""){
            var userformElt = document.getElementById("userform");
            userformElt.submit();
        }
    }
}
