<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/css/register.css";
    %>
    <link rel="stylesheet" href="<%=basePath%>">
</head>
<body>
<div class="rg_layout">
    <div class="rg_form clearfix">
        <%--左侧--%>
        <div class="rg_form_left">
            <p>用户登录</p>
            <p>USER LOGIN</p>
        </div>
        <div class="rg_form_center">
            <!--注册表单-->
            <form id="pwdLoginForm" action="${pageContext.request.contextPath}/user/pwdLogin" method="post">
                <!--提交处理请求的标识符-->
                <input type="hidden" name="action" value="register">
                <table style="margin-top: 25px;width: 558px">
                    <tr>
                        <td class="td_left">
                            <label for="username">用户名</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="username" name="username" placeholder="请输入账号">
                            <span id="userInfo" style="font-size:10px"></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="password">密码</label>
                        </td>
                        <td class="td_right">
                            <input type="password" id="password" name="password" placeholder="请输入密码">
                        </td>
                    </tr>
                    <tr>
                    <td class="td_left">
                        <input type="checkbox" id="rememberPassword">
                    </td>
                        <td class="td_right check">
                            <p>记住密码 <a style="margin-left: 100px" href="#">忘记密码</a></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                        </td>
                        <td class="td_right check">
                            <input id="pwdLogin" type="submit" class="submit" value="登录">
                            <span id="msg" style="color: red;">${resultInfo.message}</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <p>其他方式：</p>
                        </td>
                        <td class="td_right check">
                            <a href="#">短信验证码登录</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <%--右侧--%>
        <div class="rg_form_right">
            <p>
                没有账号？
                <a href="register.jsp">立即注册</a>
            </p>
        </div>
    </div>
</div>
</body>
</html>
