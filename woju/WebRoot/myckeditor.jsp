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
        //JavaScript�пգ����ȷ��  
        var editor_data = CKEDITOR.instances.content.getData();  
        if(editor_data==null||editor_data==""){  
            alert("����Ϊ�ղ����ύ");  
        }else{  
            if(confirm(editor_data)){  
            document.myform.submit();  
            }  
        }         
    }  
</script>  
        <title>ckeditor���ı�����</title>  
    </head>  
    <body>  
    <form action="/woju/servlet/activitySubmit" name="myform" method="post">  
        <textarea class="ckeditor" cols="80" id="content" name="content"  
            rows="10">
         CKEditor Test......(�˴������ݻ��ڱ༭������ʾ)</textarea>  
     <input type="button" onclick="test()" value="�����"/> 
     </form>
    </body>
</html> 