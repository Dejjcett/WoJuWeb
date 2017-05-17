<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import = "DB.DB" %>
<%@ page import="entity.ActivityInfor" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有活动</title>
    
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
<%!int numTotal=20; 
//每页显示的最大活动数
%>



  <h1> 我聚--近期活动</h1>
    <a href="welcome.jsp" target="_top" title="welcome">首页</a> &nbsp;&nbsp;
    <a href="activity.jsp" target="_self" title="activity">所有活动</a> &nbsp;&nbsp;
        <%
     	String loginname = "";
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
    
    
    <br><br>
    <%String pagenum=request.getParameter("page");
 //   out.println(pagenum);
   	int pageNum = 0;
    	if(pagenum==null)
    		pagenum="0";
    	pageNum = new Integer(pagenum).intValue();
    	    	
    	int totalNum = DB.numData("activity_info");  //数据库中的活动总数
    	
    	int pageMax = totalNum/numTotal;
    	
    	if(pageNum<0)pageNum=0;
    	else if(pageNum>pageMax)pageNum=pageMax;
    	
    %>
    总活动数：<%=totalNum%>
     <br><br><br><br>
 <table width="1500" height="30" cellspacing="0" cellpadding="0" border="2">
<% 	
  	ActivityInfor actList=new ActivityInfor() ;
  	int i=totalNum-numTotal*pageNum;
  	while(i>totalNum-numTotal*(pageNum+1)&&i>0){
  			i--;
  			actList.setAbstractPic("111.png");
			actList.setActName("锤子"); 
			actList.setAdress("交大");
			actList.setId(i+1);
			actList.setStatement("这是一个游戏gr");	
%>
    <tr onmouseover="loadMore()">	
    <td>	
    		<div>
    			<dl>
    			<dt>
    				<a href="/woju/servlet/detial1?id=<%=actList.getId()%> " target="_blank"><img src="<%=actList.getAbstractPic() %>" hspace="40" vspace="30" width="40" height="30"></a>
    			</dt>
    			<dd class=dd_name><%=actList.getId()%></dd>
    			<dd class=dd_name><%=actList.getStatement()%></dd>
    			</dl>
    		</div>
     <%
    }     //为什么时好时坏？？？？
     %>  
    </table>  
    <br>
    <br>
    <table border="0">
    <tr>
    <td align="center" >
     <input type="button" name="lastpage" value="上一页"onclick="javascript:window.location.href='activity.jsp?page=<%=String.valueOf(pageNum-1) %>';" >
	</td>
	<td align="center" valign="top" rowspan="20" colspan="1">
<form name="changepage" action="activity.jsp">
     第<input type="text" name="page" size="3" maxlength="2" value=<%=String.valueOf(pageNum+1) %>>页
     <input type="submit" name="goto" value="跳转" >
</form>
</td>
<td align="center" >
     <input type="button" name="nextpage" value="下一页" onclick="javascript:window.location.href='activity.jsp?page=<%=String.valueOf(pageNum+1) %>';" >
     </td>
     </tr>
     </table>
      
  </body>
</html>


  