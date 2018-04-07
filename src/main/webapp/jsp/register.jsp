<%--
  Created by IntelliJ IDEA.
  User: 11517
  Date: 2018/3/29
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <fieldset>
        <legend>用户注册</legend>
        <form action="/register" method="post">
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="userName"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </fieldset>
</body>
</html>
