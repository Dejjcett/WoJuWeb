<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'regist.jsp' starting page</title>
    
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
  <body>
  <div style="width:50%;height:40px;float:left;font-family:楷体;font-size:72px">   
   &nbsp;&nbsp;&nbsp;&nbsp;注册
</div>
<div style="width:50%;height:20px;float:right;font-family:宋体;font-size:24px">
    <br><br>
      <a href="welcome.jsp" target="_top" title="welcome">首页</a> &nbsp;&nbsp;
    <a href="activity.jsp" target="_self" title="activity">所有活动</a> &nbsp;&nbsp;
    <a href="/wjw/myactivity.jsp" target="_parent" title="myactivity">发布活动</a> &nbsp;&nbsp;
    <a href="contact.jsp"title="contact">联系我们</a> 
      &nbsp;&nbsp;&nbsp;&nbsp;
       <a href="login.jsp"title="login" >已有帐号，登录</a>
       </div>
 	<br><br><br><br>
  
  <script language="javascript">
     
  	function validate(myform)
  	{
  		if(myform.username.value.length == 0)
  		{
  			alert("请填写用户名！");
 			myform.username.focus();
 			    //??关闭alert时 输入栏里会有光标一闪而过  其他没有任何影响?    然后输入焦点或者光标定位到这个为空的文本框里
  			return false;
  		}
  		if((myform.password.value.length <6)||(myform.password.value!=myform.passwResure.value))
  		{
  			alert("密码过于简单或确认密码有误！");
 			myform.password.focus();
 			return false;
  		}
  		return true;
  		 /* 		if(myform.telphone.value.length != 11)
  		{
  			alert("手机号码输入有误！");
 			myform.telphone.focus();
 			return false;
  		}
  		*/
  	}
  	function sendCode()
    {
   		 alert("验证码已发送！");
   		 return true;
    }
  </script>
  
  <br><br>
  <br><br>
  <br><br>
  <br><br>
  <br><br>
  
    <div style="width:40%;height:40px;float:right;font-family:宋体;font-size:48px">
    <br>
    &nbsp;&nbsp; 注册信息栏：
    </div>
    <br><br><br><br><br><br><br>
    <div style="width:35%;height:40px;float:right;">
    <form name="regist"  action="/woju/servlet/regist"  method="post" 
    							 onsubmit="return validate(this)">
    	<table bgColor="#ffffff" border="0"style="font-family:楷体;font-size:30px">
    	<tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr>
    		<tr>
    		  <td align="right">用户名：</td>
    		  <td align="left"><input type="text" name="username" size="20" maxlength="10"style=" height:30px;" /></td>
    		</tr>
    		<tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr>
<!--     		<tr>
    		  <td align="right">手机：</td>
    		  <td align="left"><input type="text" name="telphone" size="20" maxlength="11"></td>
    		  <td align="center"><input type="button" onClick="return sendCode()" name="send" value="发送验证码"></td>
    		</tr>
  -->  	
  			<tr>
    		  <td align="right">密码：</td>
    		  <td align="left"><input type="password" name="password" size="20" maxlength="10"style=" height:30px;" /></td>
    		</tr>
    		<tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr>
    		<tr>
    		  <td align="right">确认密码：</td>
    		  <td align="left"><input type="password" name="passwResure" size="20" maxlength="10"style=" height:30px;" /></td>
    		</tr>
  <!--  		
    		<tr>
    		  <td align="right">手机验证码：</td>
    		  <td align="left"><input type="text" name="verifiCode" size="5" maxlength="4"></td>
    		</tr>
 -->   	<tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr><tr>	</tr><tr></tr><tr></tr>	
    		<tr>
    		  <td align="right"><input type="reset" name="reset" value="重置"style=" height:30px;" /></td>
    		  <td align="center"><input type="submit" name="submit" value="确认"style=" height:30px;" /></td>
    		</tr>
    	</table>

	</form>
</div>
  </body>
</html>
