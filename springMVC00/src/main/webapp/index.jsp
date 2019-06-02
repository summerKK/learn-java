<%--
  Created by IntelliJ IDEA.
  User: summer
  Date: 2019-06-02
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springMVC</title>
</head>
<body>
<div>
    <a href="say-hello">say-hello</a>
</div>
<div>
    <h1>params</h1>
    <form action="params" method="post">
        id: <input type="text" name="id">
        username <input type="text" name="user.username">
        sex <input type="text" name="user.sex">
        <button>提交</button>
    </form>
</div>
</body>
</html>
