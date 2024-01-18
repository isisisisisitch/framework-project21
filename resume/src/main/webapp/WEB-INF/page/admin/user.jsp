<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ByteTube resume management-personal info</title>
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
                            <h2>personal info</h2>
                        </div>
                        <div class="body">
                            <form class="form-validation" method="post" action="${ctx}/user/save" enctype="multipart/form-data">
                                <input type="text" style="display: none" name="photo" value="${user.photo}">
                                <div class="row">
                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                        <label>profile</label>
                                    </div>
                                    <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                                        <div class="form-group">
                                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail">
                                                    <c:choose>
                                                        <c:when test="${empty user.photo}">
                                                            <img src="${adminAsset}/img/noimage.png" alt="">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <img src="${ctx}/${user.photo}" alt="">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                <i class="material-icons clear fileinput-exists" data-dismiss="fileinput">close</i>
                                                <input type="file" name="photoFile" accept="image/*">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                        <label for="email">email</label>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-9 col-xs-9">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="email" id="email" name="email" maxlength="50" class="form-control"
                                                       placeholder="email" disabled
                                                       value="${user.email}">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                        <label for="name">name</label>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-9 col-xs-9">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" id="name" name="name" maxlength="20" class="form-control"
                                                       placeholder="name" value="${user.name}">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                        <label for="job">job</label>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-9 col-xs-9">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" id="job" name="job" maxlength="20" class="form-control"
                                                       placeholder="job" value="${user.job}">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                        <label for="phone">phone</label>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-9 col-xs-9">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" id="phone" name="phone" maxlength="20" class="form-control"
                                                       placeholder="phone" value="${user.phone}">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                        <label for="trait">trait</label>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-9 col-xs-9">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input id="trait" name="trait" maxlength="100" type="text" class="form-control" data-role="tagsinput"
                                                       placeholder="Separate multiple traits with commas or returns"
                                                       value="${user.trait}">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                        <label for="interests">interests</label>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-9 col-xs-9">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input id="interests" name="interests" maxlength="100" type="text" class="form-control" data-role="tagsinput"
                                                       placeholder="Separate multiple interests with commas or returns"
                                                       value="${user.interests}">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                        <label for="birthday">birthday</label>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-9 col-xs-9">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="date" id="birthday" name="birthday"
                                                       class="form-control"
                                                       value="${user.birthdayString}">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                        <label for="address">address</label>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-9 col-xs-9">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" id="address" name="address" maxlength="100" class="form-control"
                                                       placeholder="address" value="${user.address}">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                        <label for="intro">intro</label>
                                    </div>
                                    <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <textarea name="intro" maxlength="1000" id="intro" cols="30" rows="5" class="form-control no-resize" placeholder="intro">${user.intro}</textarea>
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
    <script>
        addValidatorRules('.form-validation')
    </script>
</body>

</html>
