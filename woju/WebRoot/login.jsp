<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  
    <h1>登录</h1>
    <a href="welcome.jsp" target="_top" title="welcome">首页</a> &nbsp;&nbsp;
    <a href="activity.jsp" target="_self" title="activity">所有活动</a> &nbsp;&nbsp;
    <a href="/wjw/myactivity.jsp" target="_parent" title="myactivity">发布活动</a> &nbsp;&nbsp;
    <a href="contact.jsp"title="contact">联系我们</a> 
      &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="regist.jsp"title="regist" >没有帐号，注册</a>
    <br><br><br><br>
    <br><br><br><br>
    <br><br><br><br>
    <div style="width:30%;height:40px;float:right;font-family:宋体;font-size:24px">
    &nbsp;&nbsp;登录信息栏：<br><br><br>
    <form name="login"  action="/woju/servlet/login"  method="post" 
    							 onsubmit="return validate(this)">
    	<table bgColor="#ffffff"  >
    	
    		<tr>
    		  <td align="right">帐号：</td>
    		  <td align="left"><input type="text" name="username" size="20" maxlength="10"></td>
    		</tr>
    		<tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr>
    		<tr>
    		  <td align="right">密码：</td>
    		  <td align="left"><input type="password" name="password" size="20" maxlength="10"></td>
    		</tr>
    		<tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr>
    		<tr>
    		  <td align="right"><input type="reset" name="reset" value="重置"></td>
    		  <td align="center"><input type="submit" name="submit" value="确认"></td>
      		  <td align="right" ><a href="refind.jsp"title="refind" target="_blank">找回密码</a></td>
   			</tr>
    		
    	</table>  
   	</form>
   	</div>
   	
  </body>
</html>
