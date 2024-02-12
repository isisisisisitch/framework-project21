<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="crt crt-nav-on crt-nav-type1 crt-main-nav-on crt-sidebar-on crt-layers-2">
<head>
    <title>ByteTube - Contact</title>
    <%@ include file="common/head.jsp" %>
</head>
<body>
<div class="crt-wrapper">
    <%@ include file="common/header.jsp" %>

    <div id="crt-container" class="crt-container">
        <%@ include file="common/nav.jsp" %>

        <div class="crt-container-sm">
            <div class="crt-paper-layers">
                <div class="crt-paper clear-mrg">
                    <div class="crt-paper-cont paper-padd clear-mrg">
                        <div class="padd-box">
                            <h2 class="title-lg text-upper">contact me</h2>
                            <div class="padd-box-xs">
                                <header class="contact-head">
                                    <h3 class="title text-upper">Thanks for connection! </h3>
                                </header>
                            </div>
                            <div class="padd-box-sm">
                                <form action="${ctx}/contact/frontSave" method="post" class="contact-form">
                                    <div class="form-group">
                                        <label class="form-label" for="name">name</label>
                                        <div class="form-item-wrap">
                                            <input id="name" name="name" maxlength="20" class="form-item" type="text"
                                                   required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label" for="email">email</label>
                                        <div class="form-item-wrap">
                                            <input id="email" name="email" maxlength="50"
                                                   value="@gmail.com"
                                                   class="form-item" type="email" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label" for="subject">subject</label>
                                        <div class="form-item-wrap">
                                            <input id="subject" name="subject" class="form-item" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group"><label class="form-label" for="comment">comment</label>
                                        <div class="form-item-wrap">
                                            <textarea id="comment" name="comment" class="form-item" required></textarea>
                                        </div>
                                    </div>
                                    <div class="form-submit form-item-wrap">
                                        <input class="btn btn-primary btn-lg" type="submit" value="leave a message">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- .crt-paper -->
                </div><!-- .crt-paper-layers -->
            </div><!-- .crt-container-sm -->
        </div>
    </div>
    <!-- .crt-container -->
    <footer id="crt-footer" class="crt-container-lg">
        <div class="crt-container">
            <div class="crt-container-sm clear-mrg text-center"><p>${website.footer}</p></div>
        </div><!-- .crt-container -->
    </footer><!-- #crt-footer -->
    <svg id="crt-bg-shape-1" class="hidden-sm hidden-xs" height="519" width="758">
        <polygon class="pol" points="0,455,693,352,173,0,92,0,0,71"/>
    </svg>
    <svg id="crt-bg-shape-2" class="hidden-sm hidden-xs" height="536" width="633">
        <polygon points="0,0,633,0,633,536"/>
    </svg>
</div><!-- .crt-wrapper --><!-- Scripts -->

<%@ include file="common/foot.jsp" %>

</body>
</html>