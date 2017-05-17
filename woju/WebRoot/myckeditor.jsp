<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <script type="text/javascript"  
            src="ckeditor/ckeditor.js"></script>  
        <script type="text/javascript">  
    //<![CDATA[    
    CKEDITOR.replace('content', { 
        toolbar : 'Full', 
        skin : 'kama' 
    }); 
    //]]>    
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
    }  
</script>  
        <title>ckeditor富文本测试</title>  
    </head>  
    <body>  
    <form action="/woju/servlet/activitySubmit" name="myform" method="post">  
        <textarea class="ckeditor" cols="80" id="content" name="content"  
            rows="10">
         CKEditor Test......(此处的内容会在编辑器中显示)</textarea>  
     <input type="button" onclick="test()" value="发布活动"/> 
     </form>
    </body>
</html> 