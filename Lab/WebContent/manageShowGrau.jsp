<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/Lab/layui-v2.5.6/layui/css/layui.css"  media="all">
  <script src="/Lab/layui-v2.5.6/layui/layui.js" charset="utf-8"></script>

 <style type="text/css">
  .content{
   width: 100%;
  height: 100%;
   text-align: center;
  }
  .result-content{
  	width:1100px;
  	height:100%;
  	margin-left:auto;
  	margin-right:auto;
  }
  </style>
<title>实验室动态</title>
</head>
<body class="layui-bg-gray">
<%@ include file="/admin/headAndTail/head.jsp" %>
			<form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                    <a href="admin_addDOC.jsp">
                    <button type="button" class="btn btn-info">
							新增人员信息
							</button>
                    
                    </a>
                    </div>
                    
                </div>
                <div class="result-content">
                    <table class="table table-striped table-bordered table-hover table-condensed" width="100%">
                        <tr class="success">
						<th class="col-md-1">编号</th>
						<th class="col-md-1">姓名</th>
						<th class="col-md-1">性别</th>
						<th class="col-md-1">电话号码</th>
						<th class="col-md-1">研究领域</th>
						<th class="col-md-1">电子邮箱</th>
						<th class="col-md-2">个人信息</th>
						<th class="col-md-2">研究成果</th>
						<th class="col-md-1">发明专利</th>
						<th class="col-ma-1">操作</th>
					</tr>
                        <c:forEach var="u" items="${listDoc}">
                        <tr>
                            <td>
                                ${u.DOCid }
                           </td>
                           <td>
                                ${u.DOCname }
                           </td>
                           <td>
                                ${u.DOCgender }
                           </td>
                           <td>
                                ${u.DOCtele }
                           </td>
                           <td>
                                ${u.DOCfield }
                           </td>
                           <td>
                                ${u.DOCemail }
                           </td>
                           <td>
                                ${u.DOCMes }
                           </td>
                           <td>
                                ${u.DOCresult }
                           </td>
                           <td>
                                ${u.DOCpatent }
                           </td>
                           <td>
                                
							
                                <a class="link-del" href="adminDOCdelete?id=${u.DOCid }">删除</a>
                            </td>
                        </tr>
                         </c:forEach>
                    </table>
                    </div>
            </form>
            <br/>
            <br/>
            <br/>
            <form name="myform1" id="myform1" method="post">
                <div class="result-title">
                    <div class="result-list">
                    <a href="admin_addMAS.jsp">
                    <button type="button" class="btn btn-info">
							新增人员信息
							</button>
                    
                    </a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="table table-striped table-bordered table-hover table-condensed" width="100%">
                        <tr class="success">
						<th class="col-md-1">编号</th>
						<th class="col-md-1">姓名</th>
						<th class="col-md-1">性别</th>
						<th class="col-md-1">电话号码</th>
						<th class="col-md-1">研究领域</th>
						<th class="col-md-1">电子邮箱</th>
						<th class="col-md-2">个人信息</th>
						<th class="col-md-2">研究成果</th>
						<th class="col-md-1">发明专利</th>
						<th class="col-ma-1">操作</th>
					</tr>
                        <c:forEach var="m" items="${listMas}">
                        <tr>
                            <td>
                                ${m.MASid }
                           </td>
                           <td>
                                ${m.MASname }
                           </td>
                           <td>
                                ${m.MASgender }
                           </td>
                           <td>
                                ${m.MAStele }
                           </td>
                           <td>
                                ${m.MASfield }
                           </td>
                           <td>
                                ${m.MASemail }
                           </td>
                           <td>
                                ${m.MASMes }
                           </td>
                           <td>
                                ${m.MASresult }
                           </td>
                           <td>
                                ${m.MASpatent }
                           </td>
                           <td>
                                
							
                                <a class="link-del" href="adminMASdelete?id=${m.MASid }">删除</a>
                            </td>
                        </tr>
                         </c:forEach>
                    </table>
                    </div>
            </form>
            <br/>
            <br/>
            <br/>
            <form name="myform2" id="myform2" method="post">
                <div class="result-title">
                    <div class="result-list">
                    <a href="admin_addBAC.jsp">
                    <button type="button" class="btn btn-info">
							新增人员信息
							</button>
                    
                    </a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="table table-striped table-bordered table-hover table-condensed" width="100%">
                        <tr class="success">
						<th class="col-md-1">编号</th>
						<th class="col-md-1">姓名</th>
						<th class="col-md-1">性别</th>
						<th class="col-md-1">电话号码</th>
						<th class="col-md-1">电子邮箱</th>
						<th class="col-md-3">个人信息</th>
						<th class="col-ma-1">操作</th>
					</tr>
                        <c:forEach var="b" items="${listBac}">
                        <tr>
                            <td>
                                ${b.BACid }
                           </td>
                           <td>
                                ${b.BACname }
                           </td>
                           <td>
                                ${b.BACgender }
                           </td>
                           <td>
                                ${b.BACtele }
                           </td>
                           <td>
                                ${b.BACemail }
                           </td>
                           <td>
                                ${b.BACMes }
                           </td>
                           <td>
							
                                <a class="link-del" href="adminBACdelete?id=${b.BACid }">删除</a>
                            </td>
                        </tr>
                         </c:forEach>
                    </table>
                    </div>
            </form>

</body>
</html>