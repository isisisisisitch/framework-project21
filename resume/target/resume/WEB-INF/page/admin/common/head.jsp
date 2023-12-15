<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ctx = request.getContextPath();
    request.setAttribute("ctx", ctx);
    request.setAttribute("asset", ctx + "/asset");
    request.setAttribute("adminAsset", ctx + "/asset/admin");
    request.setAttribute("plugin", ctx + "/asset/plugin");
%>
<meta charset="UTF-8">
<link rel="icon" href="${asset}/img/favicon.png" type="image/x-icon">
<link href="${plugin}/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="${plugin}/bootstrap-fileinput/bootstrap-fileinput.css" rel="stylesheet">
<link href="${plugin}/bootstrap-tagsinput/bootstrap-tagsinput.css" rel="stylesheet">
<link href="${plugin}/node-waves/waves.css" rel="stylesheet">
<link href="${plugin}/animate-css/animate.min.css" rel="stylesheet">
<link href="${adminAsset}/css/material-icons.css" rel="stylesheet">
<link href="${adminAsset}/css/style.min.css" rel="stylesheet">
<link href="${adminAsset}/css/theme-blue.min.css" rel="stylesheet">
<link href="${adminAsset}/css/main.css" rel="stylesheet">
