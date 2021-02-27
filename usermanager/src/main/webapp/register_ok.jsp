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
    <span style="font-size: 30px;margin-top: 80px">恭喜您，注册成功！</span>
    <div>
        <span style="color: red;font-size: 18px" id=jump></span>
    </div>
</div>
</body>
<script>
    //设定跳转的时间
    let t = 5;
    //启动1秒定时
    setInterval("refer()", 1000);

    function refer() {
        if (t === 0) {
            //#设定跳转的链接地址
            location.href = "index.jsp";
        }
        // 显示倒计时
        document.getElementById('jump').innerHTML = t + "秒后跳转到首页";
        // 计数器递减
        t--;
    }
</script>
</html>
