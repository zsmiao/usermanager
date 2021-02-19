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
    <script type="text/javascript">
        function selectAll(all) {
            var deleteId = document.getElementsByName("deleteId");
            for (var i = 0; i <= deleteId.length; i++) {
                deleteId[i].checked = all.checked;
            }
        }

        function changeForm() {
            document.getElementById("oprate").value = "batchReview";
            document.forms[0].submit();
        }


    </script>
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
                    <a href="${pageContext.request.contextPath}/user.jsp">用户管理</a>
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
                        新闻管理
                    </h1>
                </div>
            </div>
            <!-- Page Heading -->
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询条件
                </div>
                <div class='panel-body'>
                    <div class="row">
                        <form role="form">
                            <div class="col-sm-6 col-md-6 col-lg-4">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">文章ID</div>
                                        <input class="form-control" type="email">
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-6 col-lg-4">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">标题内容</div>
                                        <input type="text" class="form-control">
                                    </div>
                                </div>

                            </div>
                            <div class="col-sm-6 col-md-6 col-lg-4">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">状态</div>
                                        <select class="form-control">
                                            <option value="1">待审核</option>
                                            <option value="2">全部</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-6 col-lg-4">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">开始时间</div>
                                        <input type="datetime-local" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-6 col-lg-4">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">所属栏目</div>
                                        <select class="form-control">
                                            <option value="1">html</option>
                                            <option value="2">java</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-6 col-lg-4">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">结束时间</div>
                                        <input type="datetime-local" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <hr class="mt5 mb15">
                                <button type="submit" class="king-btn king-info">查询</button>
                                <button type="submit" class="king-btn king-success">重置</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
            <!---->
            <div class="panel panel-default">
                <div class="panel-heading">
                    文章信息
                </div>
                <div class='panel-body'>

                    <form class="table-responsive" action="#" method="post">

                        <table class="table table-bordered table-hover table-striped">
                            <button type="submit" class="king-btn king-success" style="margin-bottom: 15px">
                                <a href="${pageContext.request.contextPath}/addNew.jsp">添加文章</a></button>
                            <button type="submit" class="king-btn king-info" style="margin-bottom: 15px">批量删除</button>
                            <button type="button" class="king-btn king-success" onclick="changeForm()"
                                    style="margin-bottom: 15px">批量审核
                            </button>
                            <%--    <input type="submit" value="批量删除"/>--%>
                            <%--    <input type="button" value="批量审核" onclick="changeForm()"/>--%>
                            <input type="hidden" id="oprate" name="oprate" value="batchDeletion">
                            <tr>
                                <th><input type="checkbox" name="all" onclick="selectAll(this)"/></th>
                                <th>文章ID</th>
                                <th>文章标题</th>
                                <th>所属栏目</th>
                                <th>创建时间</th>
                                <th>是否审核</th>
                                <th>操作</th>
                            </tr>

                            <%--@elvariable id="newsList" type="java.util.List"--%>
                            <c:forEach items="${newsList}" var="news">
                                <tr>
                                    <td><input type="checkbox" name="deleteId" value="${news.newsId}"/></td>
                                    <td>${news.newsId}</td>
                                    <td>${news.newsTitle}</td>
                                    <td>${news.newsType}</td>
                                    <td>${news.createTime}</td>
                                    <td>${news.newsStatus}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/news/update?id=${news.newsId}"> 编辑</a>
                                        |
                                        <a href="${pageContext.request.contextPath}/news/deleteNewsById?id=${news.newsId}">删除</a></td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="7">
                                    <div class="pagination-info pull-left">共4条记录，当前第1/1页，每页20条记录</div>
                                    <div class="pull-right king-page-box">
                                        <ul class="pagination pagination-small pull-right">
                                            <li page-index="1" class="disabled"><a>«</a></li>
                                            <li page-index="1" class="active"><a>1</a></li>
                                            <li page-index="1"><a href="javascript:;">2</a></li>
                                            <li page-index="1"><a href="javascript:;">3</a></li>
                                            <li page-index="1"><a href="javascript:;">4</a></li>
                                            <li page-index="1"><a href="javascript:;">»</a></li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </form>
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
