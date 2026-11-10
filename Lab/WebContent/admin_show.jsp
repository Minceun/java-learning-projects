<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/admin/headAndTail/head.jsp" %>

<html>
<head>
<meta charset="UTF-8">
<title>查看所有用户信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/Lab/layui-v2.5.6/layui/css/layui.css"  media="all">
  <script src="/Lab/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
<style type="text/css">
.result-content{
		width:1100px;
		height:100%;
		margin-left: auto;
				margin-right: auto;
}
	.table{
				margin-left: auto;
				margin-right: auto;
				text-align: left;
				width:500px;
				height:100%;
	}
	.search-tab{
	margin-left: auto;
				margin-right: auto;
	}
	.result-title{
	margin-left: auto;
				margin-right: auto;
				text-align: center;
	}
</style>
</head>
<body>
<br/>
	<form action="/Lab/admin_select" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="70">姓名:</th>
                            <td><input class="common-text form-control" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                        
                    </table>
                </form>
                <br/>
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                   
                    <c:if test="${isHigher ==1 }">
         						<a href="admin_add.jsp"><button type="button" class="btn btn-primary btn2">
					新增管理员	
					</button></a>
            				</c:if>
            				 	
					<br/>
                        <br/><br/>
                    </div>
                </div>
                <div class="result-content">
                    <table class="table table-striped table-bordered table-hover table-condensed" width="100%">
                        <tr class="success">
                            <th class="col-md-1">ID</th>
                            <th class="col-md-1">管理员账号</th>
                            <th class="col-md-1">管理员姓名</th>
                            <th class="col-md-2">管理员密码</th>
         						<th class="col-md-1">操作</th>
            				
                            
                        </tr>
                        <c:forEach var="u" items="${userlist}">
                        <tr>
                            <td>
                                ${u.id }
                           </td>
                           <td>
                                ${u.admin_num }
                           </td>
                           <td>
                                ${u.admin_name }
                           </td>
                           <td>
                                ${u.admin_password }
                           </td>
                          
         						<td>
                                
                       <c:if test="${isHigher !=1 }">	
                       <c:if test="${u.admin_num ==name.admin_num }">
                       <a class="link-update" href="adminupdate?id=${u.id }">
                  			     修改
                       </a>
                       </c:if>
                       </c:if>
							<c:if test="${isHigher ==1 }">	<a class="link-update" href="adminupdate?id=${u.id }">修改</a></c:if>
							
                               <c:if test="${isHigher ==1 }">  <a class="link-del" href="admindelete?id=${u.id }">删除</a></c:if>
                            </td>
                        </tr>
                         </c:forEach>
                    </table>
                    </div>
            </form>
		<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jq uery.min.js"></script>
</body>
</html>