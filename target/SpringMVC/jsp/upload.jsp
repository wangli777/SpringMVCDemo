<%--
  Created by IntelliJ IDEA.
  User: 11517
  Date: 2018/4/3
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

    <fieldset >
        <legend>文件上传</legend>
        <form action="/upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file"><br>
            <input type="submit" value="提交">
        </form>
    </fieldset>
</body>
</html>
