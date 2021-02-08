<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/css/register.css";
    %>
    <link rel="stylesheet" href="<%=basePath%>">

    <script type="text/javascript" src="./js/jquery-2.1.0.min.js"></script>
    <script>
        <%--        页面加载事件--%>
        $(function () {
            //获取用户名的文本框，绑定失去焦点事件，失去焦点时，校验用户名
            $("#username").blur(function () {
                // 获取文本框内容
                let username = $(this).val();
                if (username != null) {
                    //    发送ajax
                    let url = '/user/findByUsername';
                    let data = 'username=' + username;
                    $.post(url, data, function (resp) {
                        if (resp.success == false) {
                            $("#userInfo").html("<font color='red'>" + resp.message);
                        } else {
                            $("#userInfo").html("<font color='green'>" + resp.message);
                        }
                    });
                }
            });
        });
    </script>
    <script>
        <%--        页面加载事件--%>
        $(function () {
            //获取用户名的文本框，绑定失去焦点事件，失去焦点时，校验用户名
            $("#telephone").blur(function () {
                // 获取文本框内容
                let telephone = $(this).val();
                //    发送ajax
                let url = '/user/findByTelephone';
                let data = 'telephone=' + telephone;
                $.post(url, data, function (resp) {
                    if (resp.success == false) {
                        $("#telephoneInfo").html("<font color='red'>" + resp.message);
                    } else {
                        $("#telephoneInfo").html("<font color='green'>" + resp.message);
                    }
                });
            });
            $("#sendSmsCode").click(function () {
                //    获取手机号文本框中的value值
                let telephone = $("#telephone").val();
                //    发送ajax
                let url = '/user/sendSms';
                let data = 'telephone=' + telephone;
                $.post(url, data, function (resp) {
                    alert(resp.message);
                })
            });
        });
    </script>
</head>
<body>
<div class="rg_layout">
    <div class="rg_form clearfix">
        <%--左侧--%>
        <div class="rg_form_left">
            <p>新用户注册</p>
            <p>USER REGISTER</p>
        </div>
        <div class="rg_form_center">
            <!--注册表单-->
            <form id="registerForm" action="${pageContext.request.contextPath}/user/register" method="post"
                  autocomplete="off">
                <!--提交处理请求的标识符-->
                <input type="hidden" name="action" value="register">
                <table style="margin-top: 25px;width: 558px">
                    <tr>
                        <td class="td_left">
                            <label for="username">用户名</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="username" name="username" placeholder="请输入账号" required="required">
                            <span id="userInfo" style="font-size:12px"></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="telephone">手机号</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="telephone" name="telephone" placeholder="请输入您的手机号"
                                   required="required">
                            <span id="telephoneInfo" style="font-size:12px"></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="password">密码</label>
                        </td>
                        <td class="td_right">
                            <input type="password" id="password" name="password" placeholder="请输入密码"
                                   required="required">
                            <span id="passwordInfo" style="font-size:12px"></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="smsCode">验证码</label>
                        </td>
                        <td class="td_right check">
                            <input type="text" id="smsCode" name="smsCode" class="check" placeholder="请输入验证码"
                                   required="required">
                            <a href="javaScript:void(0)" id="sendSmsCode">发送手机验证码</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                        </td>
                        <td class="td_right check">
                            <input type="submit" class="submit" value="注册">
                            <span id="msg" style="color: red;">${msg}</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <%--右侧--%>
        <div class="rg_form_right">
            <p>
                已有账号？
                <a href="login.jsp">立即登录</a>
            </p>
        </div>
    </div>
</div>
</body>
</html>
