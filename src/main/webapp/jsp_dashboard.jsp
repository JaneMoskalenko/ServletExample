<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01.07.2017
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Model.POJOs.User"%>
<%@ page import="Model.dao.UserDao" %>


<html>
<head>
    <title>Dashboard</title>
</head>
<body>
   <%-- <%=request.getAttribute("parameter")%>
    <h1>Hello!</h1>--%>

    <h1>Dashboard</h1>
    <h3>User List</h3>

    <table> <tr>
            <% HashMap<String, String> user = UserDao.getAllUser();
    for (HashMap.Entry<String, String> entry: user.entrySet()){ %>
        <%--   <%   ArrayList<POJOs.User> users = getAllUserInObject();
           for (POJOs.User u: users) {%>--%>
        <tr>
            <td><%=entry.getKey()%> </td>
            <td><%=entry.getValue()%> </td>

            <td>
                <form action="dashboard" method="post">
                    <input type="submit" name="delete_user" value="Delete user" />
                    <input type="hidden" name="user_delete" value="<%=entry.getKey()%>" />
                </form>
            </td>
        </tr>

        <%  }
        %>
    </table>
    <h3>Add User</h3>

    <form action="dashboard" method="post">

        <input type="text" name="login_add" id="login"/>
        <input type="text" name="password_add" id="password"/>
        <input type="submit" name="add_user" value="Add user" />
    </form>


</body>
</html>
