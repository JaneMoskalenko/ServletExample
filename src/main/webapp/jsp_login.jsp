<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01.07.2017
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/server/login" method="post">

        <input type="text" name="login" id="login"/>
        <input type="text" name="password" id="password"/>
        <input type="submit" value="Login" />
    </form>

</body>
</html>
