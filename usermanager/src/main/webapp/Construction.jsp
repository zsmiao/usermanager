<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>新闻管理系统</title>
    <!-- Bootstrap css -->
    <link href="https://magicbox.bk.tencent.com/static_api/v3/assets/bootstrap-3.3.4/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="https://magicbox.bk.tencent.com/static_api/v3/assets/fontawesome/css/font-awesome.css" rel="stylesheet">
    <!-- 当前项目样式文件 -->
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/css/sb-admin.css";
        String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/css/sb-bk-theme.css";
    %>
    <link rel="stylesheet" href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath1%>">
    <!--蓝鲸平台APP 公用的样式文件 -->

    <link href="https://magicbox.bk.tencent.com/static_api/v3/bk/css/bk.css" rel="stylesheet">
    <!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
    <![endif]-->
</head>
<body>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="main.jsp">
                <i class="fa fa-leaf f20 mr5"></i>
                后台管理系统
            </a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li class="dropdown">
                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i
                        class="fa fa-user"></i> ${user.name}
                    <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/updateUser.jsp"><i class="fa fa-fw fa-user"></i>
                            个人资料</a>
                    </li>
                    <li>
                        <a href="javascript:;"><i class="fa fa-fw fa-envelope"></i> 消息盒</a>
                    </li>
                    <li>
                        <a href="javascript:;"><i class="fa fa-fw fa-gear"></i> 设置</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="${pageContext.request.contextPath}/user/quit"><i class="fa fa-fw fa-power-off"></i> 退出</a>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">

                <li class="">
                    <a href="${pageContext.request.contextPath}/news/getNews"><i></i>新闻管理</a>
                </li>
                <li class="">
                    <a href="${pageContext.request.contextPath}/user/getUsers">用户管理</a>
                </li>
                <li class="">
                    <a href="${pageContext.request.contextPath}/system/systemInfo"><i></i>服务器监控</a>
                </li>
                <li class="">
                    <a href="">数据源监控</a>
                </li>
                <li class="">
                    <a href="">在线用户监控</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">
        <div class="king-page-box">
            <div class="king-container clearfix">
                <div class="king-panel8 m15">
                    <div class="king-panel8-header">
                        <h2 class="king-panel8-title king-info">功能正在建设中...</h2>
                    </div>
                    <div class="king-panel8-content pt25">
                        <div class="king-exception-box king-403-page">
                            <img src="https://magicbox.bk.tencent.com/static_api/v3/components/exception_building/images/building.png">
                            <h1>功能正在建设中...</h1> <a href="javascript:;" class="king-btn king-info">立即跳转</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->

<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
<script src="https://magicbox.bk.tencent.com/static_api/v3/assets/js/jquery-1.10.2.min.js"></script>
<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
<script src="https://magicbox.bk.tencent.com/static_api/v3/assets/bootstrap-3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
