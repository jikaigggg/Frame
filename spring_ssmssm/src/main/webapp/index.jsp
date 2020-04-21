<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>index</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script>
        function login() {
            $.post({
                url: "${pageContext.request.contextPath}/user/login",
                data: {name: $("#username").val()},
                success: function (data) {
                    if (data === "OK") {
                        $("#msg").css("color", "green");
                        $("#msg").html("对勾");
                    } else {
                        $("#msg").css("color", "red");
                        $("#msg").html("有问题啊");
                    }
                }
            })
        }

        $(function () {
            $("#l")
        })
    </script>
</head>
<body>
<div>
    <form action="/user/password" method="post">
        <div class="form-group">
            <label for="username">username</label>
            <span id="msg" style="color: red"></span>
            <input type="text" class="form-control" id="username" placeholder="username" onblur="login()">
        </div>
        <div class="form-group">
            <label for="password">password</label>
            <input type="password" class="form-control" id="password" placeholder="password">
        </div>
        <a href="javascript:void(0)" class="btn btn-default" name="login_btn">Submit</a>
    </form>
</div>
</body>
</html>
