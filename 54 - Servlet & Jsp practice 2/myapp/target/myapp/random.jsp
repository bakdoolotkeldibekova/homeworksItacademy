<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Bakdoolot
  Date: 14.03.2020
  Time: 5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Random </title>
</head>
<body>
    <% int a = (int)request.getAttribute("a"); %>
    <%=a%>
    <% if(a%2 == 0){ %>
    <p> => Число чётное </p>
    <% } else{ %>
    <p> => Число нечётное </p>
    <% } %>


</body>
</html>
