<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<title>我聚网</title>
    
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
   <div style="width:50%;height:40px;float:left;font-family:楷体;font-size:68px">   
   &nbsp;&nbsp;&nbsp;&nbsp; 我聚--首页
   </div>
    <div style="width:50%;height:20px;float:right;font-family:宋体;font-size:24px">
    <br><br>
    <a href="welcome.jsp" target="_top" title="welcome">首页</a> &nbsp;&nbsp;
    <a href="activity.jsp?page=2" target="_self" title="activity">所有活动</a> &nbsp;&nbsp;
    
    <%
      	String loginname="";
    	String password="";
    	String flag="";
    	if(session.getAttribute("loginUser")!=null)
    	loginname = session.getAttribute("loginUser").toString();
    	if(session.getAttribute("passWord")!=null)
    	password = session.getAttribute("passWord").toString();
    	if(session.getAttribute("adminFlag")!=null)
    	flag = session.getAttribute("adminFlag").toString();
 //   	if(loginname!=""&&password!="")
  %>
    	
   <a href="/wjw/myactivity.jsp?username=<%=loginname%>&Flag=<%=flag%>" target="_parent" title="myactivity">发布活动</a>
  	&nbsp;&nbsp;
  	

   <%
   if(loginname==""||password=="")
   {%>
   <a href="contact.jsp"title="contact">联系我们</a>  
   &nbsp;&nbsp;
   <%}
    	if(loginname!=""&&password!="")
    	{
    	if(flag.equals("0"))
    	{
    	%>
    	 <a href="contact.jsp"title="contact">联系我们</a>     
      		&nbsp;&nbsp;欢迎你
    	<%
    	}
	    if(flag.equals("1"))
	    {
	    %>
	    <a href="allusers.jsp"title="用户管理">用户管理</a>     
      		&nbsp;&nbsp;管理员
      		<%
      		}
	    	out.print("<b>");
	    	out.print(loginname);
	    	out.print("</b>   ");
	    	out.print("<a href=\"/woju/loginout.jsp\">退出登录</a>");   	
    	}
    	else
    	out.print("<a href=\"/woju/login.jsp\">登录/注册</a>");
      %>
      </div>
      
      <!--
       http://anshansuixinsuoyu.blog.163.com/blog/static/33765229201211142412148/
       jsp+mysql实现对数据库的增删改查 
       -->
      
    <br><br><br><br>
  </body>
</html>
