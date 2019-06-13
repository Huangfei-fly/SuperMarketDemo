<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>弟弟超市业务管理系统 - 登录</title>

	<link href="static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="static/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="static/css/animate.css" rel="stylesheet">
    <link href="static/css/style.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">弟</h1>

            </div>
            <h3>欢迎使用弟中弟超市业务管理系统</h3>

            <form id="form1"class="m-t" role="form" action="${pageContext.request.contextPath }/dologin">
                <div class="info">${error }</div>
                <div class="form-group">
                    <input type="text" class="form-control" id="userId" name="userId" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="密码" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="static/js/jquery.min.js?v=2.1.4"></script>
    <script src="static/js/bootstrap.min.js?v=3.3.6"></script>
</body>
</html>
