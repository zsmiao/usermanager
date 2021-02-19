<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/19
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        String basePath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/kindeditor-4.1.10/kindeditor.js";
    %>
    <link rel="stylesheet" href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath1%>">
    <!--蓝鲸平台APP 公用的样式文件 -->

    <link href="https://magicbox.bk.tencent.com/static_api/v3/bk/css/bk.css" rel="stylesheet">


    <script type="text/javascript" src="<%=basePath2%>"></script>
    <script type="text/javascript">
        KindEditor.ready(function (K) {
            K.create('#content', {
                uploadJson: 'kindeditor-4.1.10/jsp/upload_json.jsp',
                fileManagerJson: 'kindeditor-4.1.10/jsp/file_manager_json.jsp',
                allowFileManager: true
            });
        });
    </script>
</head>
<body>
<div id="wrapper">
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

        <!-- Page Heading -->
        <div class="row page-header-box">
            <div class="col-lg-12">
                <h1 class="page-header">
                    新闻管理
                </h1>
            </div>
        </div>

        <div class="main-wrap">
            <div class="panel panel-default">
                <div class="panel-heading">
                    新增新闻
                </div>
                <div class="panel-body">
                    <div class="col-sm-8">

                        <form class="form-horizontal mt15" id="user_form" action="${pageContext.request.contextPath}/news/updateNews" method="post">
                            <input type="hidden" value="${news.newsId}" name="id"/>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">文章标题：</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="请输入文章标题" id="newstitle"
                                           name="newstitle" value="${news.newsTitle}">
                                    <span class="king-required-tip text-danger ml5">*</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">所属栏目：</label>
                                <div class="col-sm-10">
                                    <select class="form-control" id="newstype" name="newstype">
                                        <option <c:if test="${news.newsType==\"html\"}">selected</c:if> value="html">html</option>
                                        <option <c:if test="${news.newsType==\"Javascript\"}">selected</c:if> value="Javascript">Javascript</option>
                                        <option <c:if test="${news.newsType==\"oracle\"}">selected</c:if> value="oracle">oracle</option>
                                    </select>
                                    <span class="king-required-tip text-danger ml5">*</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">正文：</label>
                                <div class="col-sm-10">
                                    <textarea id="content" name="newscontent" rows="20">${news.newsContent}</textarea>
                                </div>

                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label"></label>
                                <div class="col-sm-10">
                                    <button class="king-btn king-info mr10" title="修改" type="submit">
                                        <i class="fa fa-save btn-icon"></i>确定修改
                                    </button>
                                    <a class="king-btn king-default" title="返回" href="${pageContext.request.contextPath}/news/getNews">
                                        <i class="fa fa-mail-reply-all btn-icon"></i>返回
                                    </a>
                                    <span>${message}</span>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /.container-fluid -->
</div>
</div>
</body>
</html>
