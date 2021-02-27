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

        <div class="container-fluid">
            <div class="row page-header-box">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        <b>服务器监控</b>
                    </h1>
                </div>
            </div>
            <!-- Page Heading -->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b>服务器信息</b>
                </div>
                <div class='panel-body'>
                    <div class="row">
                        <form role="form" method="post" action="${pageContext.request.contextPath}/news/getNews">
                            <table class="table table-bordered table-hover table-striped">
                                <tr>
                                    <th>服务器名称</th>
                                    <th>操作系统</th>
                                    <th>服务器IP</th>
                                    <th>系统架构</th>
                                    <th>服务器路径</th>
                                </tr>
                                <tr>
                                    <td>${sys.computerName}</td>
                                    <td>${sys.osName}</td>
                                    <td>${sys.computerIp}</td>
                                    <td>${sys.osArch}</td>
                                    <td>${sys.userDir}</td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <b>Java虚拟机信息</b>
                </div>
                <div class='panel-body'>
                    <div class="row">
                        <table class="table mb0 pr15 ranger-box ">
                            <thead>
                            <tr>
                                <td style="width: 15%;">Java名称</td>
                                <td style="width: 35%;">${name}</td>
                                <td style="width: 15%;">Java版本</td>
                                <td style="width: 35%;">${jvm.version}</td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td style="width: 15%;">启动时间</td>
                                <td style="width: 35%;">${startTime}</td>
                                <td style="width: 15%;">运行时长</td>
                                <td style="width: 35%;">${runTime}</td>
                            </tr>
                            <tr>
                                <td style="width: 15%;">安装路径</td>
                                <td style="width: 35%;">${jvm.home}</td>
                                <td style="width: 15%;"></td>
                                <td style="width: 35%;"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class='panel-body'>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="panel king-panel1 mb0  ">
                                <div class="panel-heading king-panel-head1 king-panel-top1">
                                    <h3 class="panel-title">Cpu信息</h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table mb0 pr15 ranger-box ">
                                        <thead>
                                        <tr>
                                            <th style="width: 50%;">属性</th>
                                            <th style="width: 50%;">值</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>核心数</td>
                                            <td>${cpu.cpuNum}核</td>
                                        </tr>
                                        <tr>
                                            <td>系统使用率</td>
                                            <td>${cpu.sys}%</td>
                                        </tr>
                                        <tr>
                                            <td>用户使用率</td>
                                            <td>${cpu.used}%</td>
                                        </tr>
                                        <tr>
                                            <td>当前空闲率</td>
                                            <td>${cpu.free}%</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="panel king-panel1 mb0  ">
                                <div class="panel-heading king-panel-head1 king-panel-top1">
                                    <h3 class="panel-title">内存信息</h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table mb0 pr15 ranger-box ">
                                        <thead>
                                        <tr>
                                            <th style="width: 33%">属性</th>
                                            <th style="width: 33%;">内存</th>
                                            <th style="width: 33%;">JVM</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>总内存</td>
                                            <td>${mem.total}GB</td>
                                            <td>${jvm.max}MB</td>
                                        </tr>
                                        <tr>
                                            <td>已用内存</td>
                                            <td>${mem.used}GB</td>
                                            <td>${jvm.total}MB</td>
                                        </tr>
                                        <tr>
                                            <td>空闲内存</td>
                                            <td>${mem.free}GB</td>
                                            <td>${jvm.free}MB</td>
                                        </tr>
                                        <tr>
                                            <td>当前空闲率</td>
                                            <td>${mem.free}GB</td>
                                            <td>${jvm.free}MB</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <b>磁盘信息</b>
                </div>
                <div class='panel-body'>
                    <div class="row">
                        <form role="form" method="post" action="${pageContext.request.contextPath}/news/getNews">
                            <table class="table table-bordered table-hover table-striped">
                                <tr>
                                    <th>盘符路径</th>
                                    <th>文件系统</th>
                                    <th>盘符类型</th>
                                    <th>总大小</th>
                                    <th>可用大小</th>
                                    <th>已用大小</th>
                                    <th>已用百分比</th>
                                </tr>

                                <%--@elvariable id="newsList" type="java.util.List"--%>
                                <c:forEach items="${sysFiles}" var="files">
                                    <tr>
                                        <td>${files.dirName}</td>
                                        <td>${files.sysTypeName}</td>
                                        <td>${files.typeName}</td>
                                        <td>${files.total}</td>
                                        <td>${files.free}</td>
                                        <td>${files.used}</td>
                                        <td>${files.usage}%</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
<script src="https://magicbox.bk.tencent.com/static_api/v3/assets/js/jquery-1.10.2.min.js"></script>
<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
<script src="https://magicbox.bk.tencent.com/static_api/v3/assets/bootstrap-3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
