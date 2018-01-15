<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/11
  Time: 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <a href="/say">say</a>











<a href="/hello">hello</a>

  <form name="Form2" action="/springUpload" method="post"  enctype="multipart/form-data">
    <h1>使用spring mvc提供的类的方法上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
  </form>




  <form action="/modellogin" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit">
  </form>





  </body>
</html>
