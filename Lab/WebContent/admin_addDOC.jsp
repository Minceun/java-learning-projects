<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/headAndTail/head.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
        </div>
        <div class="result-wrap">
            <div class="result-content" style="width: 600px; height: 100%;margin-left:auto;margin-right:auto;">
                <form action="/Lab/manage_admin_addDOC" method="post" id="myform" name="myform">
                   
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                                <th><i class="require-red">*</i>ID号</th>
                                <td>
                                <br/>
                                    <input class="common-text required form-control" id="title" name="DOCid" size="50"  type="text" >
                                	<br/>
                             
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>姓名：</th>
                                <td><br/>
                                    <input class="common-text required form-control" id="title" name="DOCname" size="50"  type="text" >
                                <br/>
                              </td>
                               
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>性别：</th>
                                <td><br/>
                                    <input class="common-text required form-control" id="title" name="DOCgender" size="50"  type="text" >
                       
                                	<br/></td>
                                
                            </tr>
                       
                            <tr>
                                <th><i class="require-red">*</i>电话号码：</th>
                                <td><br/>
                                    <input class="common-text required form-control" id="title" name="DOCtele" size="50"  type="text">
                       
                                	<br/></td>
                                
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>研究领域：</th>
                                <td><br/>
                                    <input class="common-text required form-control" id="title" name="DOCfield" size="50"  type="text">
                         
                                	<br/></td>
                                
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>电子邮箱：</th>
                                <td><br/>
                                    <input class="common-text required form-control" id="title" name="DOCemail" size="50"  type="text">
                     
                                	<br/></td>
                                
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>个人信息：</th>
                                <td><br/>
                                    <input class="common-text required form-control" id="title" name="DOCMes" size="50"  type="text">
                  
                                	<br/></td>
                                
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>研究成果：</th>
                                <td><br/>
                                    <input class="common-text required form-control" id="title" name="DOCresult" size="50"  type="text">
                  
                                	<br/></td>
                                
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>发明专利：</th>
                                <td><br/>
                                    <input class="common-text required form-control" id="title" name="DOCpatent" size="50"  type="text">
                  
                                	<br/></td>
                                
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>状态码：</th>
                                <td><br/>
                                    <input class="common-text required form-control" style="display:hidden;" id="title" name="status" size="50"  type="text" value="0" readonly unselectable="on">
                 
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
</body>
</html>