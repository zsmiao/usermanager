<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册成功</title>

</head>
<body>

<div style="text-align:center;height: 290px;margin-top: 50px">
    <span style="font-size: 30px">恭喜您，注册成功！</span>
    <div><span style="color: red;font-size: 16px" id=jump></span></div>
</div>
<script>
    var t = 5;//设定跳转的时间
    setInterval("refer()", 1000); //启动1秒定时
    function refer() {
        if (t == 0) {
            location = "index.jsp"; //#设定跳转的链接地址
        }
        document.getElementById('jump').innerHTML = "" + t + "秒后跳转到首页"; // 显示倒计时
        t--; // 计数器递减
        //本文转自：
    }
</script>
</body>
</html>
