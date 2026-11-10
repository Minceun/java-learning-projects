<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/headAndTail/head.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
        </div>
        <div class="result-wrap">
            <div class="result-content" style="width: 600px; height: 100%;margin-left:auto;margin-right:auto;">
                <form action="/Lab/manage_admin_add" method="post" id="myform" name="myform">
                   
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                                <th><i class="require-red">*</i>ID号</th>
                                <td>
                                <br/>
                                    <input class="common-text required form-control" id="title" name="id" size="50"  type="text" >
                                	<br/>
                            
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>管理员账号：</th>
                                <td>	<br/>
                                    <input class="common-text required form-control" id="title" name="admin_num" size="50"  type="text" >
                              
                                	<br/> </td>
                               
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>管理员姓名：</th>
                                <td>	<br/>
                                    <input class="common-text required form-control" id="title" name="admin_name" size="50"  type="text" >
                               
                                	<br/></td>
                                
                            </tr>
                       
                            <tr>
                                <th><i class="require-red">*</i>管理员密码：</th>
                                <td>	<br/>
                                    <input class="common-text required form-control" id="title" name="admin_password" size="50"  type="text">
                             
                                	<br/></td>
                                
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>级别码：</th>
                                <td>	<br/>
                                    <input class="common-text required form-control" id="title" name="status" size="50"  type="text">
                              
                                	<br/></td>
                                
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>