<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${plugin}/jquery/jquery.min.js"></script>
<script src="${plugin}/bootstrap/bootstrap.min.js"></script>
<script src="${plugin}/bootstrap-fileinput/bootstrap-fileinput.js"></script>
<script src="${plugin}/bootstrap-notify/bootstrap-notify.min.js"></script>
<script src="${plugin}/bootstrap-tagsinput/bootstrap-tagsinput.min.js"></script>
<script src="${plugin}/node-waves/waves.js"></script>
<script src="${plugin}/jquery-validation/jquery.validate.js"></script>
<script src="${plugin}/jquery-validation/messages_zh.js"></script>
<script src="${plugin}/sweetalert/sweetalert.min.js"></script>
<script src="${adminAsset}/js/default.js"></script>
<script src="${adminAsset}/js/main.js"></script>
<c:if test="${not empty menu}">
    <script>
        $('.menu .${menu}').addClass('active')
    </script>
</c:if>
