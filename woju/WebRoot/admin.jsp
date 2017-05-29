<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  <body background="2.jpg">

  <script language="javascript">
     
  	function validate(myform)
  	{
  		if(myform.username.value.length == 0||myform.password.value.length ==0)
  		{
  			alert("帐号或密码有误！");
 			myform.username.focus();
 			    //??关闭alert时 输入栏里会有光标一闪而过  其他没有任何影响?    然后输入焦点或者光标定位到这个为空的文本框里
  			return false;
  		}
  		return true;
  	}
  </script>
  
   <div style="width:50%;height:40px;float:left;font-family:楷体;font-size:72px">   
   &nbsp;&nbsp;&nbsp;&nbsp;登录
   </div>
    <div style="width:50%;height:20px;float:right;font-family:宋体;font-size:24px">
    <br><br>
    <a href="welcome.jsp" target="_top" title="welcome">首页</a> &nbsp;&nbsp;
    <a href="activity.jsp" target="_self" title="activity">所有活动</a> &nbsp;&nbsp;
    <a href="/wjw/myactivity.jsp" target="_parent" title="myactivity">发布活动</a> &nbsp;&nbsp;
    <a href="contact.jsp"title="contact">联系我们</a> 
      &nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <br><br>  <br><br>
    <br><br>  <br><br>
  <br><br>  <br><br>
  <br><br>
    <div style="width:40%;height:40px;float:right;font-family:宋体;font-size:48px">
    <br>
    &nbsp;&nbsp;登录信息栏：
    </div>
    <br><br><br><br><br><br><br>
    <div style="width:35%;height:40px;float:right;">
    <form name="adminlogin"  action="/woju/servlet/adminlogin"  method="post" 
    							 onsubmit="return validate(this)">
    	<table bgColor="#ffffff"  style="font-family:楷体;font-size:30px">    	
    		<tr>
    		  <td align="right">管理员帐号：</td>
    		  <td align="left"><input type="text" name="username" size="20" maxlength="10"style=" height:30px;" /></td>
    		</tr>
    		<tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr>
    		<tr>
    		  <td align="right">密码：</td>
    		  <td align="left"><input type="password" name="password" size="20" maxlength="10"style=" height:30px;" /></td>
    		</tr>
    		<tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr>
    		<tr>
    		  <td align="right"><input type="reset" name="reset" value="重置"style=" height:30px;" /></td>
    		  <td align="center"><input type="submit" name="submit" value="确认"style=" height:30px;" /></td>
      		  <td align="right" ><a href="login.jsp"title="refind" target="_self">用户登录</a></td>
   			</tr>
    		
    	</table>  
   	</form>
   	</div>
   	
  </body>
</html>
