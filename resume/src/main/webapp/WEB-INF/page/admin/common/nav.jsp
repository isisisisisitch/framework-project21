<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Overlay For Sidebars -->
<div class="overlay"></div>
<!-- #END# Overlay For Sidebars -->
<!-- Search Bar -->
<div class="search-bar">
    <div class="search-icon">
        <i class="material-icons">search</i>
    </div>
    <input type="text" placeholder="Search">
    <div class="close-search">
        <i class="material-icons">close</i>
    </div>
</div>
<!-- #END# Search Bar -->
<!-- Top Bar -->
<nav class="navbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
            <a href="javascript:void(0);" class="bars"></a>
            <a class="navbar-brand" href="#">ByteTube Resume Management</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <!-- Call Search -->
                <li><a href="javascript:void(0);" class="js-search" data-close="true"><i class="material-icons">search</i></a></li>
                <!-- #END# Tasks -->
                <li><a href="javascript:void(0);" data-close="true"><i class="material-icons">more_vert</i></a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- #Top Bar -->
<section>
    <!-- Left Sidebar -->
    <aside id="leftsidebar" class="sidebar">
        <!-- User Info -->
        <div class="user-info">
            <div class="image">
                <c:choose>
                    <c:when test="${empty user.photo}">
                        <img src="${adminAsset}/img/noimage.png" alt="img">
                    </c:when>
                    <c:otherwise>
                        <img src="${ctx}/${user.photo}" alt="img">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="info-container">
                <div class="name">${user.name}</div>
                <div class="email">${user.job}</div>
                <div class="btn-group user-helper-dropdown">
                    <i class="material-icons" data-toggle="dropdown">keyboard_arrow_down</i>
                    <ul class="dropdown-menu pull-right">
                        <li><a href="${ctx}/user/front"><i class="material-icons">person</i>my resume</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${ctx}/user/logout"><i class="material-icons">input</i>exit</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- #User Info -->
        <!-- Menu -->
        <div class="menu">
            <ul class="list">
                <li class="user">
                    <a href="${ctx}/user/admin">
                        <i class="material-icons">person</i>
                        <span>person info</span>
                    </a>
                </li>
                <li class="skill">
                    <a href="${ctx}/skill/admin">
                        <i class="material-icons">accessibility</i>
                        <span>skill</span>
                    </a>
                </li>
                <li class="password">
                    <a href="${ctx}/user/editPassword">
                        <i class="material-icons">lock</i>
                        <span>change password</span>
                    </a>
                </li>
                <li class="education">
                    <a href="${ctx}/education/admin">
                        <i class="material-icons">school</i>
                        <span>education experience</span>
                    </a>
                </li>
                <li class="company">
                    <a href="${ctx}/company/admin">
                        <i class="material-icons">domain</i>
                        <span>company</span>
                    </a>
                </li>
                <li class="experience">
                    <a href="${ctx}/experience/admin">
                        <i class="material-icons">work</i>
                        <span>work experience</span>
                    </a>
                </li>
                <li class="project">
                    <a href="${ctx}/project/admin">
                        <i class="material-icons">build</i>
                        <span>project experience</span>
                    </a>
                </li>
                <li class="award">
                    <a href="${ctx}/award/admin">
                        <i class="material-icons">plus_one</i>
                        <span>award</span>
                    </a>
                </li>
                <li class="contact">
                    <a href="${ctx}/contact/admin">
                        <i class="material-icons">comment</i>
                        <span>contact</span>
                    </a>
                </li>
                <li class="website">
                    <a href="${ctx}/website/admin">
                        <i class="material-icons">language</i>
                        <span>website</span>
                    </a>
                </li>
            </ul>
        </div>
        <!-- #Menu -->
    </aside>
    <!-- #END# Left Sidebar -->
</section>