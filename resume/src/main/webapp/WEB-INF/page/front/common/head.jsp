<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ctx = request.getContextPath();
    request.setAttribute("ctx", ctx);
    request.setAttribute("asset", ctx + "/asset");
    request.setAttribute("frontAsset", ctx + "/asset/front");
    request.setAttribute("plugin", ctx + "/asset/plugin");
%>
<meta charset="UTF-8">
<link rel="icon" href="${asset}/img/favicon.png" type="image/x-icon">
<link href="${frontAsset}/css/icmoon.css" rel="stylesheet"><!-- Styles -->
<link href="${frontAsset}/css/plugins.min.css" rel="stylesheet">
<link href="${frontAsset}/css/style.min.css" rel="stylesheet"><!-- Modernizer -->
<link href="${frontAsset}/css/main.css" rel="stylesheet"><!-- Modernizer -->
