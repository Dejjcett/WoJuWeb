<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import = "DB.DB" %>
<%@ page import="entity.Comment" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的评论</title>
    
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
   &nbsp;&nbsp;&nbsp;&nbsp; 我聚--活动评论
   </div>
    <div style="width:50%;height:20px;float:right;font-family:宋体;font-size:24px">
    <br><br>
    <a href="welcome.jsp" target="_top" title="welcome">首页</a> &nbsp;&nbsp;
    <a href="activity.jsp" target="_self" title="activity">所有活动</a> &nbsp;&nbsp;
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
    <br><br><br><br>
  
  
  <br><br>
  <% 	
		String actid = session.getAttribute("id").toString();

		int i = DB.numComm(actid);
 %>
 	<h1>该活动共有<%=i %>条评论</h1>
  	<table cellspacing="0" cellpadding="0" border="0"   style="font-size:32px" align="center" width="1500" height="10">
  <%
    	while(i>0){
  			DB.displayComm(actid,i);  			
  			i--;
%>
     <tr><td align="right"><b>评论序号：</b></td><td align="left"> <%=Comment.getComId()%></td></tr>
 	<tr><td align="right"><b>评论人：</b></td><td align="left"> <%=Comment.getReviewer()%></td></tr>
 	<tr><td align="right"><b>评论内容：</b></td><td align="left"> <%= Comment.getComment()%></td></tr>
 	<tr><td align="right"><a href="/woju/servlet/commDelete?aid=<%=actid%>&cid=<%=Comment.getComId()%> ">删除该评论</a></td><td align="left"> &nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
 	<tr><td align="right"><b>&nbsp;&nbsp;&nbsp;&nbsp;</b></td><td align="left"> &nbsp;&nbsp;&nbsp;&nbsp;</td></tr>

 		 
 <%
    }     //为什么时好时坏？？？？
     %>  
   </table>  
    <br><br>
    <br><br>
  
  
    <h1>请输入您的评论：</h1>
    <br>
    <form action="/woju/servlet/addComment" name="myform" method="post" onsubmit="return validate(this)">
    <textarea id="comment" name="comment" rows="5" cols="200"></textarea>  
    <br><br><br>  
    <%if(loginname==""||loginname==null)
    {
	    out.println("<input type=\"button\"  value=\"尚未登录，无法评论\">" );
	    out.print("<a href=\"/woju/login.jsp\">登录/注册</a>");
	    out.print("<br><br><br>");
    }
    else 
    out.println("<input type=\"submit\"  value=\"发布评论\">");
    %>
    </form>
    
    <script type="text/javascript">
        function validate(myform) {  
        //JavaScript判空，如果确定  
        if(myform.comment.value.length==0){  
            alert("评论为空，无法提交！"); 
            return  false;
        }        
		return true;
    }
    
    
</script>	
    
  </body>
</html>
