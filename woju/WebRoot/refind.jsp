<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'refind.jsp' starting page</title>
    
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
  <script language="javascript">
  	function validate(myform)
  	{
  		if(myform.telphone.value.length != 11)
  		{
  			alert("手机号码输入有误！");
 			myform.telphone.focus();
 			return false;
  		}
  		if((myform.password.value.length <6)||(myform.password.value!=myform.passwResure.value))
  		{
  			alert("新密码过于简单或确认密码有误！");
 			myform.password.focus();
 			return false;
  		}
  		return true;
  	}
  	function sendCode()
    {
   		 alert("验证码已发送！");
   		 
   		 return true;
    }
  </script>
    <h1>找回密码</h1>
    <form name="refind"  action="/woju/servlet/refind"  method="post" 
    							 onsubmit="return validate(this)">
    	<table bgColor="#ffffff" border="0">
    		<tr>
    		  <td align="right">请输入您的手机：</td>
    		  <td align="left"><input type="text" name="telphone" size="20" maxlength="11"></td>
    		  <td align="center"><input type="button" onClick="return sendCode()" name="send" value="发送验证码"></td>
    		</tr>
    		<tr>
    		  <td align="right">新密码：</td>
    		  <td align="left"><input type="password" name="password" size="20" maxlength="10"></td>
    		</tr>
    		<tr>
    		  <td align="right">确认密码：</td>
    		  <td align="left"><input type="password" name="passwResure" size="20" maxlength="10"></td>
    		</tr>    		
    		<tr>
    		  <td align="right">手机验证码：</td>
    		  <td align="left"><input type="text" name="verifiCode" size="5" maxlength="4"></td>
    		</tr>
    		
    		<tr>
    		  <td align="right"><input type="reset" name="reset" value="重置"></td>
    		  <td align="left"><input type="submit" name="submit" value="确认"></td>
    		</tr>
    	</table>

	</form>
  </body>
</html>
