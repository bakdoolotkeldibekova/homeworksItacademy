<%@ page import="db.UserDb" %>
<%@ page import="model.User" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="servlet.UserServlet" %><%--
  Created by IntelliJ IDEA.
  User: Bakdoolot
  Date: 08.03.2020
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view</title>
</head>
<body>
    <% UserDb userDb = new UserDb(); %>
    <p> <%=userDb.getUser() %> </p>
</body>
</html>