<%@ page language="java" import="java.util.*" import="DB.DB" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'preview.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<title>活动预览</title>
  </head>

  <body>
		  <h1>活动预览</h1>

<%
		  response.setContentType("text/html;charset=utf-8"); 
		  request.setCharacterEncoding("utf-8");   
		  String Content = request.getParameter("content");
		  int actID = DB.numData("activity_info");   //必须是静态成员函数  
%>
	
	<%=Content %>


<form method="post" name="release" action="/woju/servlet/activitySubmit">
<input type="hidden" name="content"value="<%=Content%>">
<input type="hidden" name="id" value="<%=actID%>">
<input type="submit" name="submit" value="确认发布">
</form> 

<br><br><br><br>
		<b>该活动Id为:</b><%= actID+1%>
		
  </body>
</html>
