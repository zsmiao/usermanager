<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--bootstrap--%>
<%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
<%--<link rel="stylesheet" type="text/css" href="css/common.css">--%>
<%
    String path = request.getContextPath();
    String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/css/bootstrap.min.css";
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/css/common.css";

%>
<link rel="stylesheet" href="<%=basePath1%>">
<link rel="stylesheet" href="<%=basePath%>">
<%--<script src="js/jquery-3.3.1.js"></script>--%>
<%--<script src="js/bootstrap.min.js"></script>--%>
<%--<script src="js/getParameter.js"></script>--%>

<!-- 头部 start -->
<header id="header">
    <%--右侧按钮--%>
    <div class="shortcut">
        <!-- 登录状态 -->
        <div class="login">
            <span>欢迎回来，${user.name}</span>
            <a href="${pageContext.request.contextPath}/user/quit">退出</a>
        </div>
    </div>
    <%--搜索框--%>
    <div style="text-align: center">
        <input id="rname" name="rname" type="text" placeholder="请输入文章标题"  value="${rname}"
               autocomplete="off">
        <a href="javascript:void(0);" onclick="searchClick()">搜索</a>
    </div>

</header>

