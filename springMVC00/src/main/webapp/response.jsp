<%--
  Created by IntelliJ IDEA.
  User: summer
  Date: 2019-06-04
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response</title>
</head>
<body>
<button class="btn">response</button>
</body>

<script src="js/jquery.min.js"></script>

<script>
    $(function () {
        $('.btn').click(function () {
            $.ajax({
                // 编写json格式，设置属性和值
                url: "response/json",
                contentType: "application/json;charset=UTF-8",
                data: '{"username": "Summer", "sex": "男", "birthday": "2019-02-22"}',
                dataType: "json",
                type: "post",
                success: function (data) {
                    console.log(data)
                }
            });
        })
    })
</script>

</html>
