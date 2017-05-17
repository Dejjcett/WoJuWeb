<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myactivity.jsp' starting page</title>
    
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
      <a href="welcome.jsp" target="_top" title="welcome">首页</a> &nbsp;&nbsp;
    <a href="activity.jsp" target="_self" title="activity">所有活动</a> &nbsp;&nbsp;
    <a href="/wjw/myactivity.jsp" target="_parent" title="myactivity">发布活动</a> &nbsp;&nbsp;
    <a href="contact.jsp"title="contact">联系我们</a> 
      &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="login.jsp"title="login" >登录/注册</a>
    <br><br><br><br>
    
   
<form action="/woju/servlet/activitySubmit" name="myform" method="post">
    <textarea id="content" name="content"></textarea>
    <input type="button" onclick="test()" value="发布活动"/> 
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
        function test() {  
        //JavaScript判空，如果确定  
        var editor_data = CKEDITOR.instances.content.getData();  
        if(editor_data==null||editor_data==""){  
            alert("数据为空不能提交");  
        }else{  
            if(confirm(editor_data)){  
            document.myform.submit();  
            }  
        }
		editor.updateElement(); //非常重要的一句代码        
    }
</script>		
  </body>
  
  
</html>


