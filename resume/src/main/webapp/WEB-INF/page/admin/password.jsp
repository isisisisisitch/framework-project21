<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ByteTube resume management-edit password</title>
    <%@ include file="common/head.jsp" %>
</head>

<body class="theme-blue">
<%@ include file="common/nav.jsp" %>

<section class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>edit password</h2>
                    </div>
                    <div class="body">
                        <form class="form-validation" method="post" action="${ctx}/user/updatePassword">

                            <div class="row">
                                <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                    <label for="oldPassword">oldPassword</label>
                                </div>
                                <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="password" id="oldPassword" name="oldPassword" maxlength="20"
                                                   class="form-control"
                                                   placeholder="oldPassword"
                                                   required>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                    <label for="password">newPassword</label>
                                </div>
                                <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="password" id="password" name="password" maxlength="20"
                                                   class="form-control"
                                                   placeholder="newPassword"
                                                   required>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                    <label for="confirm">confirm</label>
                                </div>
                                <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="password" id="confirm" class="form-control"
                                                   placeholder="confirm" maxlength="20"
                                                   required>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-offset-2 col-md-offset-2 col-sm-offset-3 col-xs-offset-3">
                                    <button class="btn btn-primary waves-effect m-l-15" type="submit">save</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@ include file="common/foot.jsp" %>
<script src="${ctx}/asset/plugin/JavaScript-MD5/md5.min.js"></script>
<script>
    addValidatorRules('.form-validation', function () {
        $('[name=oldPassword]').val(md5($('#oldPassword').val()))
        $('[name=password]').val(md5($('#password').val()))
        return true
    })

</script>

<script>

</script>

<script>
    addValidatorRules('.form-validation')
    $('#confirm').rules("add", {
        equalTo: '[name=password]'
    })
</script>
</body>

</html>
