<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ByteTube education-Error</title>
    <%@ include file="admin/common/head.jsp" %>
</head>

<body class="five-zero-zero">
<div class="five-zero-zero-container">
    <div class="error-title">something is wrong</div>
    <div class="error-msg">${error}</div>
    <div class="button-place">
        <a href="${ctx}" class="btn btn-default btn-lg waves-effect">back home</a>
    </div>
</div>
</body>

</html>