<%--
  Created by IntelliJ IDEA.
  User: Bakdoolot
  Date: 08.03.2020
  Time: 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User form</title>
</head>
<body>
<form action="/project52/create-user" method="post">
    Login: <input type="text" name="login" /> <br>

    Password: <input type="password" name="password" /> <br>

    Email: <input type="text" name="email" /> <br>

    Gender:<label for="is_woman"></label>
    <select id="is_woman" name="is_woman">
        <option value="true">Woman</option>
        <option value="false">Man</option>
    </select> <br>

    <input type="submit" value="submit" />
</form>

</body>
</html>
