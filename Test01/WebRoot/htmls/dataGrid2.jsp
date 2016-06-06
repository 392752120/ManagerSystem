<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>dataGrid2l.jsp</title>
	
    <meta name="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="../jquery-easyui-1.4.2/jquery.min.js"></script>
	<script type="text/javascript" src="../jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
	
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4.2/themes/icon.css">


  </head>
  
  <body>
  	<script type="text/javascript">
 
  	
  	
  	</script>
	
  
  
    <table id="#tt" class="easyui-datagrid" title="用户信息" style="width:700px;height:250px
    	data-options="singleSelect:true,collapsible:true">
    	<thead>
    		<tr>
    			<th data-options="field:'name',width:80">用户名</th>
    			<th data-options="field:'age',width:80">年龄</th>
    			<th data-options="field:'sex',width:80">性别
    			</th>
    		</tr>
    	</thead>
    	<tbody>
    	<c:if test="${not empty resultList}">
    		<c:forEach items="${reultList}" var="userBean" >
    			<tr>
    				<td align="center">
    					${userBean.name}
    				</td>
    				<td align="center">
    				    ${userBean.age}
    				</td>
    				<td align="center">
    					${userBean.sex}
    				</td>
    			</tr>
    		</c:forEach>
    	</c:if>
    	</tbody>
    </table>
  </body>
</html>
