<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发布活动</title>
    
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
   <h1> 我聚--发布活动</h1>
      <a href="/woju/welcome.jsp" target="_top" title="welcome">首页</a> &nbsp;&nbsp;
    <a href="/woju/activity.jsp" target="_self" title="activity">所有活动</a> &nbsp;&nbsp;
    	<%
    	String loginname="";
    	loginname = request.getParameter("username");
    	 %>
   <a href="/wjw/myactivity.jsp?username=<%=loginname%>" target="_parent" title="myactivity">发布活动</a>
  	&nbsp;&nbsp;
    <a href="/woju/contact.jsp"title="contact">联系我们</a> 
      &nbsp;&nbsp;&nbsp;&nbsp;
        <%
    	if(loginname!="")
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
   
<form action="/woju/servlet/activitySubmit" name="myform" method="post" onsubmit="return validate(this)">
<h2>活动概况</h2>
	<table>
	<tr>
	<td>活动名：</td><td><input type="text" name="acttivityName" size="10" maxlength="10"></td>	
	</tr>
	<tr>
	<td>活动类型：</td>
	<td><input type="radio" name="activitytype" value="game" checked="checked">游戏
			<input type="radio" name="activitytype" value="study" >学习
			<input type="radio" name="activitytype" value="sport" >运动
			<input type="radio" name="activitytype" value="geek" >极客</td>
	</tr>
	<tr>
	<td>报名截止时间：</td><td><input type="text" name="deadtime"></td>
	</tr>
	<tr>
	<td>活动时间：</td><td><input type="text" name="starttime"></td>
	</tr>
	<tr>
	<td>活动人数：</td><td><input type="text" name="member"></td>
	</tr>
	<tr>
	<td>活动简介：</td><td><input type="text" name="actabstract" value="请用30个以内的字简述你的活动" maxlength="100" size="120"></td>
	</tr>
	</table>
	<h2>活动详情</h2>
    <textarea id="content" name="content"></textarea>
    <input type="submit"  value="发布活动"/> 
    
</form>
  <script type="text/javascript"  src="/wjw/ckeditor/ckeditor.js">
  //   只要改这个东西   就有问题     为什么。。。。。。。。。。。。。?????????。。。。
  </script>
<script type="text/javascript" >
    var editor = null;
    window.onload = function(){
        editor = CKEDITOR.replace('content'); //参数‘content’是textarea元素的name属性值，而非id属性值
        editor.setData('这里是需要传递给CKEditor编辑器实例的值');
		editor.getData();
    };
        function validate(myform) {  
        //JavaScript判空，如果确定  
        var editor_data = CKEDITOR.instances.content.getData();
  
        if(myform.acttivityName.value.length == 0||myform.deadtime.value.length ==0||
  		myform.starttime.value.length == 0||myform.actabstract.value.length ==0||myform.member.value.length ==0)
  		{
  			alert("活动简介信息不能为空");
 			return false;
  		}
 /* 		 if(loginname==""||loginname==null)  
        {
  			alert("对不起，您不是会员，无权发布活动");
 			return false;
  		}*/
        if(editor_data==null||editor_data==""){  
            alert("活动详情为空不能提交"); 
            return  false;
        }
        else{  
 //           if(confirm(editor_data)){  
  //          document.myform.submit();  
  
		for ( instance in CKEDITOR.instances ) 
		CKEDITOR.instances[instance].updateElement();
 //           }  
        }
//		editor.updateElement(); //非常重要的一句代码        干什么用的？
		return true;
    }
    
    
</script>		
  </body>
  
  
</html>


