<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ByteTube resume management - login</title>
    <%@ include file="../WEB-INF/page/admin/common/head.jsp" %>
</head>

<body class="login-page">
    <div class="login-box">
        <div class="logo">
            <a href="javascript:void(0);"><b>bytetube resume management</b></a>

        </div>
        <div class="card">
            <div class="body">
                <form class="form-validation" method="post" action="${ctx}/user/login">
                    <div class="msg">Welcome! Please Login first</div>
                    <div class="input-group form-group form-float">
                        <span class="input-group-addon">
                            <i class="material-icons">email</i>
                        </span>
                        <div class="form-line">
                            <input type="email" class="form-control" name="email" maxlength="50" placeholder="email" required autofocus>
                        </div>
                    </div>
                    <div class="input-group form-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="hidden" name="password">
                            <input id="originPassword" type="password" class="form-control" maxlength="20" placeholder="password" required>
                        </div>
                    </div>
                    <div class="input-group form-group captcha">
                        <span class="input-group-addon">
                            <i class="material-icons">security</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="captcha" placeholder="captcha" required>
                        </div>
                        <img id="captcha" src="${ctx}/user/captcha" alt="captcha">
                    </div>
                    <div class="row">
                        <div class="col-xs-8 p-t-5">
                            <input type="checkbox" name="rememberme" id="rememberme" class="filled-in chk-col-pink">
                            <label for="rememberme">remember me</label>
                        </div>
                        <div class="col-xs-4">
                            <button class="btn btn-block bg-pink waves-effect" type="submit">login</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%@ include file="../WEB-INF/page/admin/common/foot.jsp" %>
    <script src="${ctx}/asset/plugin/JavaScript-MD5/md5.min.js"></script>
    <script>
        addValidatorRules('.form-validation', function () {
            $('[name=password]').val(md5($('#originPassword').val()))
            return true
        })

        $('#captcha').click(function () {
            $(this).hide().attr('src', '${ctx}/user/captcha?time=' + new Date().getTime()).fadeIn()
        })
    </script>
</body>

</html>