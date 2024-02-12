<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="crt-nav-wrap" class="hidden-sm hidden-xs">
    <div id="crt-nav-inner">
        <div class="crt-nav-cont">
            <div id="crt-nav-scroll">
                <nav id="crt-nav" class="crt-nav">
                    <ul class="clear-list">
                        <li>
                            <a href="${ctx}/user/front" data-tooltip="home page">
                                <c:choose>
                                    <c:when test="${empty user.photo}">
                                    <img class="avatar avatar-42" src="../asset/front/img/avatar/avatar-42x42.png" alt="">
                                    </c:when>
                                    <c:otherwise>
                                        <img class="avatar avatar-42" src="${ctx}/${user.photo}" alt="">
                                    </c:otherwise>
                                </c:choose>
                            </a>
                        </li>
                        <li><a href="${ctx}/education/front" data-tooltip="education"><span
                                class="crt-icon crt-icon-book"></span></a></li>
                        <li><a href="${ctx}/experience/front" data-tooltip="work experience"><span
                                class="crt-icon crt-icon-experience"></span></a></li>
                        <li><a href="${ctx}/project/front" data-tooltip="project experience"><span
                                class="crt-icon crt-icon-wrench"></span></a></li>
                        <li><a href="${ctx}/contact/front" data-tooltip="contact me"><span
                                class="crt-icon crt-icon-contact"></span></a></li>
<%--                        <li><a href="${ctx}/user/admin" data-tooltip="admin"><span--%>
<%--                                class="crt-icon crt-icon-key"></span></a></li>--%>
                    </ul>
                </nav>
            </div>
            <div id="crt-nav-tools" class="hidden"><span class="crt-icon crt-icon-dots-three-horizontal"></span>
                <button id="crt-nav-arrow" class="clear-btn"><span
                        class="crt-icon crt-icon-chevron-thin-down"></span></button>
            </div>
        </div>
        <div class="crt-nav-btm"></div>
    </div>
</div>
<!-- .crt-nav-wrap -->