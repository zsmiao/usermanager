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
<%--    <script>--%>
<%--        function deleteUserById(id) {--%>
<%--            let url = '/user/deleteUser';--%>
<%--            let data = 'id=' + id;--%>
<%--            $.post(url, data, function (resp) {--%>
<%--                if (resp.success == false && resp.message!=null) {--%>
<%--                    $("#msg").html("<font color='red'>" + resp.message);--%>
<%--                } else {--%>
<%--                    $("#msg").html("<font color='green'>" + resp.message);--%>
<%--                }--%>
<%--            });--%>
<%--        }--%>
<%--    </script>--%>
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
                        <a href="javascript:;"><i class="fa fa-fw fa-user"></i> 用户</a>
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

            <!-- Page Heading -->
            <div class="row page-header-box">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        用户管理
                    </h1>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    用户列表
                </div>
                <div>
                    <div class="king-wrapper">
                        <form class="form-inline king-search-form king-no-bg mt15 mb15 pull-left" method="post" action="${pageContext.request.contextPath}/user/getUsers">
                            <div class="form-group">
                                <label>用户姓名：</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="请输入姓名" name="name">
                                    <span class="input-group-addon"><i
                                            class="glyphicon glyphicon-time fa fa-calendar-o"></i></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label>用户账号：</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="请输入用户名" name="username">
                                    <span class="input-group-addon"><i
                                            class="glyphicon glyphicon-time fa fa-calendar-o"></i></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label>状态：</label>
                                <div class="input-group">
                                    <select class="form-control" name="status">
                                        <option value="1">全部</option>
                                        <option value="2">正常</option>
                                        <option value="3">异常</option>
                                    </select>
                                </div>
                            </div>

                            <button type="submit" class="king-btn king-info">搜索</button>
                        </form>
                        <a type="button" id="transferID" class="king-btn king-success pull-right mt15 ml15">
                            <i class="fa fa-gavel mr5"></i>删除
                        </a>
                        <a href="${pageContext.request.contextPath}/addUser.jsp"
                           class="king-btn king-info pull-right mt15 ml15">
                            <i class="fa fa-user-plus mr5"></i>新增用户
                        </a>
                    </div>

                    <table class="table table-out-bordered table-hover">
                        <thead>
                        <tr>
                            <th style="width: 10px">
                                <input type="checkbox" class="del-all-cb">
                            </th>
                            <th style="width:50px;">序号</th>
                            <th>姓名</th>
                            <th>角色</th>
                            <th>用户名</th>
                            <th>性别</th>
                            <th>年龄</th>
                            <th>地区</th>
                            <th>邮件</th>
                            <th>电话</th>
                            <th>注册时间</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%--@elvariable id="userPageInfo" type="java.util.List"--%>
                        <c:forEach items="${userPageInfo.list}" var="users">
                            <tr>
                                <td><input type="checkbox" name="deleteId" value="${users.id}"/></td>
                                <td>${users.id}</td>
                                <td>${users.name}</td>
                                <td>管理员</td>
                                <td>${users.username}</td>
                                <td>${users.sex}</td>
                                <td>${users.age}</td>
                                <td>${users.address}</td>
                                <td>${users.email}</td>
                                <td>${users.telephone}</td>
                                <td>2020-02-21 08:52</td>
                                <td style="color: #4cae4c">正常</td>
                                    <%-- <c:choose>
                                         <c:when test="${users.newsStatus=='正常'}">
                                             <td style="color:red">异常</td>
                                         </c:when>
                                         <c:otherwise>
                                             <td style="color: limegreen">正常</td>
                                         </c:otherwise>
                                     </c:choose>--%>
                                <td>
                                    <a href="${pageContext.request.contextPath}/updateUser.jsp"> 编辑</a>
                                    |
                                    <a href="${pageContext.request.contextPath}/user/deleteUser?id=${users.id}" id="deleteUserById">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="13">
                                <div class="pagination-info pull-left">
                                    共${userPageInfo.total}条记录，当前第${userPageInfo.pageNum}/${userPageInfo.pages}页，每页${userPageInfo.pageSize}条记录
                                    <span style="color: #4cae4c" >${resultInfo.message}</span>
                                </div>
                                <div class="pull-right king-page-box">

                                    <ul class="pagination pagination-small pull-right">
                                        <li page-index="1"><a
                                                href="${pageContext.request.contextPath}/user/getUsers?pageNumber=1">首页</a>
                                        </li>
                                        <li page-index="1"><a
                                                href="${pageContext.request.contextPath}/user/getUsers?pageNumber=${userPageInfo.prePage}">上一页</a>
                                        </li>
                                        <li page-index="1"><a
                                                href="${pageContext.request.contextPath}/user/getUsers?pageNumber=${userPageInfo.nextPage}">下一页</a>
                                        </li>
                                        <li page-index="1"><a
                                                href="${pageContext.request.contextPath}/user/getUsers?pageNumber=${userPageInfo.pages}">尾页</a>
                                        </li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
        <!-- /.container-fluid -->
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
