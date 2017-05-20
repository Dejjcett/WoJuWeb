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



  <div style="width:50%;height:40px;float:left;font-family:楷体;font-size:72px">   
   &nbsp;&nbsp;&nbsp;&nbsp;我聚--近期活动
   </div>
   <div style="width:50%;height:20px;float:right;font-family:宋体;font-size:24px">
    <br><br>
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
      &nbsp;
        <%
    	if(loginname!=null&&loginname!=""&&password!=null&&password!="")
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
    </div>
    <br><br>
    <br><br>
    <%
    String pagenum=request.getParameter("page");
 //   out.println(pagenum);
   	int pageNum = 0;
    	if(pagenum==null)
    		pagenum="0";
    	pageNum = new Integer(pagenum).intValue();
    	    	
    int totalNum = DB.numData("activity_info");  //数据库中的活动总数   //可以调用java中的方法
    	
    	int pageMax = totalNum/numTotal;
    	
    	if(pageNum<0)pageNum=0;
    	else if(pageNum>pageMax)pageNum=pageMax;
    	
    %>
    <br><br><br><br>

    <div style="width:100%;float:left;font-family:楷体;font-size:48px;text-align: center">  
    总活动数：<%=totalNum%>
     </div>
     
     <br><br>
    
 <table cellspacing="0" cellpadding="0" border="0"   style="font-size:32px" align="center">
<% 	
//  	ActivityInfor actList=new ActivityInfor() ;
  	int i=totalNum-numTotal*pageNum;
  	while(i>totalNum-numTotal*(pageNum+1)&&i>0){
  			DB.displayData(i);  			
  			i--;
%>
        
    <%
    String type="";
    if(ActivityInfor.getType().equals("game"))type = "001.png";  //不能用 ActivityInfor.getType()=="game"
    else if(ActivityInfor.getType().equals("sport"))type = "002.jpg";
    else if(ActivityInfor.getType().equals("study"))type = "003.jpg";
    else if(ActivityInfor.getType().equals("geek"))type = "004.png";
    else  type = "004.png";
 /* 
   switch (ActivityInfor.getType())  //jdk1.7以下switch不支持String
    {
	    case "game":
	    	type = "001.png";
	    	break;
	    case "sport":
	    	type = "002.jpg";
	    	break;
	     case "study":
	    	type = "003.jpg";
	    	break;
	    case "geek":
	    	type = "004.png";
	    	break;
	    default:
	    	break;
    }
    */
     %>
     <tr>
    	<td><a href="/woju/servlet/detial1?id=<%=ActivityInfor.getActivityID()%> " target="_blank"><img src="<%=type%>" hspace="40" vspace="30" width="80" height="60"></a></td><tr>
    	<td><b>活动序号：</b></td><td> <%=ActivityInfor.getActivityID()%></td><tr>
 		<td><b>活动名称：</b></td><td> <%=ActivityInfor.getActName()%></td><tr>
 		<td><b>发布人：</b></td><td> <%=ActivityInfor.getReleaser()%></td><tr>
    			<td><b>报名截止时间：</b></td><td> <%=ActivityInfor.getDeadtime()%></td><tr>
    			<td><b>活动开始时间：</b></td><td> <%=ActivityInfor.getStarttime()%></td><tr>    			
    		    <td><b>人数限制：</b></td><td> <%=ActivityInfor.getMember()%></td><tr>
    			<td><b>活动简介：</b></td><td> <%=ActivityInfor.getActabstract()%></td><tr>
    
     <%
    }     //为什么时好时坏？？？？
     %>  
    </table>  
    <br><br>
    <br><br>
    
    <table border="0" align="center">
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
      <br><br><br>
  </body>
</html>


  