<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'contact.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 <h1> 我聚--联系我们</h1>
    <a href="welcome.jsp" target="_top" title="welcome">首页</a> &nbsp;&nbsp;
    <a href="activity.jsp" target="_self" title="activity">所有活动</a> &nbsp;&nbsp;
        <%
 		String loginname="";
    	String password="";
    	if(session.getAttribute("loginUser")!=null)    	
    	loginname = session.getAttribute("loginUser").toString();    	
    	if(session.getAttribute("passWord")!=null)
    	password = session.getAttribute("passWord").toString();
  %>
    	
   <a href="/wjw/myactivity.jsp?username=<%=loginname%>" target="_parent" title="myactivity">发布活动</a>
  	&nbsp;&nbsp;
  	  <a href="contact.jsp"title="contact">联系我们</a> 
      &nbsp;&nbsp;&nbsp;&nbsp;
        <%
    	if(loginname!=""&&password!="")
    	{
	    	out.print("欢迎你 ");
	    	out.print("<b>");
	    	out.print(loginname);
	    	out.print("</b>   ");
	    	out.print("<a href=\"/woju/loginout.jsp\">退出登录</a>");   	
    	}
    	else
    	out.print("<a href=\"/woju/login.jsp\">登录/注册</a>");
      %>
    <br><br><br><br>
    
    
  </body>
</html>
