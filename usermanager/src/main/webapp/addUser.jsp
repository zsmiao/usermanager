<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/19
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <a href="javascript:;"><i class="fa fa-fw fa-user"></i> 个人资料</a>
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

        <div class="main-wrap">
            <div class="panel panel-default">
                <div class="panel-heading">
                    新增用户
                </div>
                <div class="panel-body">
                    <div class="col-sm-8">

                        <form class="form-horizontal mt15" id="user_form" action="${pageContext.request.contextPath}/user/addUser" method="post">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">账号：</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="请填写帐号" id="user_account"
                                           name="user_account">
                                    <span class="king-required-tip text-danger ml5">*</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">角色：</label>
                                <div class="col-sm-10">
                                    <select class="form-control" id="user_role" name="user_role">
                                        <option>管理员</option>
                                        <option>普通用户</option>
                                    </select>
                                    <span class="king-required-tip text-danger ml5">*</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">密码：</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" placeholder="请填写密码" id="user_password"
                                           name="user_password">
                                    <span class="king-required-tip text-danger ml5">*</span>
                                </div>
                                <div class="col-sm-1"></div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">确认密码：</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" placeholder="请填再次写密码"
                                           id="user_password2" name="user_password2">
                                    <span class="king-required-tip text-danger ml5">*</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名：</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="请填写姓名" id="user_name"
                                           name="user_name">
                                    <span class="king-required-tip text-danger ml5">*</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">性别：</label>
                                <div class="col-sm-10">
                                    <div class="radio">
                                        <label class="mr10">
                                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="男"
                                                   checked>男
                                        </label>
                                        <label>
                                            <input type="radio" name="optionsRadios" id="optionsRadios2"
                                                   value="女">女
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">年龄：</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="请选择你的生日" id="user_birthday"
                                           name="user_birthday">
                                    <span class="king-required-tip text-danger ml5">*</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">手机号码：</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="请填写手机号码" id="user_phone"
                                           name="user_phone">
                                    <span class="king-required-tip text-danger ml5">*</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">电子邮箱：</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="请填写电子邮箱" id="user_email"
                                           name="user_email">
                                    <span class="king-required-tip text-danger ml5">*</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">地址：</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" style="height:60px;" placeholder="请填写地址" name="user_address"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label"></label>
                                <div class="col-sm-10">
                                    <button class="king-btn king-info mr10" title="保存" type="submit">
                                        <i class="fa fa-save btn-icon"></i>保存
                                    </button>
                                    <a class="king-btn king-default" title="返回" href="${pageContext.request.contextPath}/user/getUsers">
                                        <i class="fa fa-mail-reply-all btn-icon"></i>返回
                                    </a>
                                    <span style="color: #4cae4c">${resultInfo.message}</span>
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
