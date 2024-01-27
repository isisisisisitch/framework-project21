<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="crt crt-nav-on crt-nav-type1 crt-main-nav-on crt-sidebar-on crt-layers-2">
<head>
    <title>ByteTube - educations</title>
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
                        <h2 class="title-lg text-upper padd-box">educations</h2>
                        <div class="education">
                            <c:forEach items="${educations}" var="education">
                                <div class="education-box">
                                    <time class="education-date">
                                    <span>
                                        <strong class="text-upper">${education.beginDayYear}</strong>/${education.beginDayMonth} -
                                        <strong>${education.endDayYear}</strong>/${education.endDayMonth}
                                    </span>
                                    </time>
                                    <h3>${education.typeString}</h3>
                                    <span class="education-company">${education.name}</span>
                                    <p>${education.intro}</p>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <!-- .crt-paper -->
            </div><!-- .crt-paper-layers -->
        </div><!-- .crt-container-sm -->
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