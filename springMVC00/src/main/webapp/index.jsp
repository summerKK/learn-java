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
        username <input type="text" name="list[0].username">
        sex <input type="text" name="list[0].sex">
        username <input type="text" name="map['summer'].username">
        sex <input type="text" name="map['summer'].sex">
        <button>提交</button>
    </form>
</div>
<div>
    <h1>User</h1>
    <form action="user" method="post">
        username <input type="text" name="username">
        sex <input type="text" name="sex">
        birthday <input type="text" name="birthday">
        <button>提交</button>
    </form>
</div>
<div>
    <h1>SessionAttributes</h1>
    <a href="session-attirbutes">SessionAttributes</a>
</div>
</body>
</html>
