<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ByteTube resume management - contact</title>
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
                        <h2>messages</h2>
                    </div>
                    <div class="body table-responsive">
                        <div class="menus">
                            <form id="search-form" action="${ctx}/contact/admin" method="post">
                                <div class="search-box input-group">
                                    <input type="hidden" name="pageNo" value="${result.pageNo}">
                                    <input type="hidden" name="pageSize" value="${result.pageSize}">
                                    <select name="type">
                                        <option value="2">all</option>
                                        <option value="1">read</option>
                                        <option value="0">unread</option>
                                    </select>
                                    <div class="form-line datetime-input">
                                        <input type="date" name="beginDay"
                                               value="${result.beginDayString}"
                                               class="form-control" placeholder="beginDay">
                                    </div>
                                    <div class="form-line datetime-input">
                                        <input type="date" name="endDay"
                                               value="${result.endDayString}"
                                               class="form-control" placeholder="endDay">
                                    </div>
                                    <span class="input-group-addon">
                                            <i class="material-icons">search</i>
                                        </span>
                                    <div class="form-line keyword">
                                        <input type="text" name="keyword"
                                               value="${result.keyword}"
                                               class="form-control" placeholder="subject,keyword">
                                    </div>
                                    <button type="submit"
                                            class="btn bg-blue waves-effect btn-sm">Search
                                    </button>
                                </div>
                            </form>
                        </div>

                        <c:if test="${not empty result.beans}">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>read</th>
                                    <th>name</th>
                                    <th>email</th>
                                    <th>date</th>
                                    <th>subject</th>
                                    <th>comment</th>
                                    <th>details</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${result.beans}" var="contact">
                                    <tr>
                                        <td>
                                            <div class="switch">
                                                <label>
                                                    <c:choose>
                                                        <c:when test="${contact.alreadyRead}">
                                                            <input type="checkbox" disabled checked>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" disabled>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <span class="lever switch-col-blue"></span>
                                                </label>
                                            </div>
                                        </td>
                                        <td>${contact.name}</td>
                                        <td>${contact.email}</td>
                                        <td>${contact.createdTimeString}</td>
                                        <td>${contact.subject}</td>
                                        <td>${contact.comment}</td>
                                        <td>
                                            <button type="button" class="btn bg-blue waves-effect btn-xs"
                                                    onclick="view(${contact.json})">
                                                <i class="material-icons">edit</i>
                                                <span>details</span>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                            <div class="page-box">
                                <div class="page-size">
                                    total ${result.count} items ${result.pages} page, each page
                                    <select name="pageSize">
                                        <option value="10">10</option>
                                        <option value="20">20</option>
                                        <option value="30">30</option>
                                        <option value="40">40</option>
                                        <option value="50">50</option>
                                    </select>
                                    items
                                </div>
                                <nav>
                                    <ul class="pagination">
                                        <c:if test="${result.pageNo != 1}">
                                            <li>
                                                <a href="javascript:prev()">
                                                    <i class="material-icons">chevron_left</i>
                                                </a>
                                            </li>
                                        </c:if>

                                        <c:forEach begin="1" end="${result.pages}" var="i">
                                            <c:choose>
                                                <c:when test="${i == result.pageNo}">
                                                    <li class="active"><a>${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="javascript:go('${i}')"
                                                           class="waves-effect">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>

                                        <c:if test="${result.pages > 0 && result.pageNo != result.pages}">
                                            <li>
                                                <a href="javascript:next()">
                                                    <i class="material-icons">chevron_right</i>
                                                </a>
                                            </li>
                                        </c:if>
                                    </ul>
                                </nav>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="modal fade" id="view-form-box" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">messages</h4>
            </div>
            <div class="modal-body">
                <form method="post">
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                            <label for="name">name</label>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                            <div class="form-group">
                                <div class="form-line">
                                    <input type="text" id="name" name="name" maxlength="20" class="form-control"
                                           placeholder="name"
                                           disabled>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                            <label for="email">email</label>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                            <div class="form-group">
                                <div class="form-line">
                                    <input type="email" id="email" name="email" maxlength="50" class="form-control"
                                           placeholder="email"
                                           disabled>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                            <label for="createdTimeString">time</label>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                            <div class="form-group">
                                <div class="form-line">
                                    <input type="text" id="createdTimeString" name="createdTimeString"
                                           class="form-control"
                                           placeholder="time"
                                           disabled>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                            <label for="subject">subject</label>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                            <div class="form-group">
                                <div class="form-line">
                                    <input type="text" id="subject" name="subject" class="form-control"
                                           placeholder="subject" maxlength="20"
                                           disabled>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                            <label for="comment">comment</label>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                            <div class="form-group">
                                <div class="form-line">
                                        <textarea name="comment" id="comment"
                                                  maxlength="1000"
                                                  cols="30" rows="5" class="form-control no-resize"
                                                  placeholder="comment" disabled></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-offset-2 col-md-offset-2 col-sm-offset-3 col-xs-offset-3">
                            <button class="btn btn-info waves-effect m-l-15" data-dismiss="modal">close</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="common/foot.jsp" %>
<script>
    const $viewFormBox = $('#view-form-box')

    function view(contact) {
        for (const key in contact) {
            $viewFormBox.find('[name=' + key + ']').val(contact[key])
        }
        $viewFormBox.modal()
    }

    const $searchForm = $('#search-form')
    const $pageNo = $searchForm.find('[name=pageNo]')
    const $pageSize = $searchForm.find('[name=pageSize]')

    function prev() {
        go(${result.pageNo - 1})
    }

    function next() {
        go(${result.pageNo + 1})
    }

    function go(pageNo) {
        $pageNo.val(pageNo)
        $searchForm.submit()
    }

    $('.page-box [name=pageSize]').change(function () {
        $pageNo.val(1)
        $pageSize.val($(this).val())
        $searchForm.submit()
    }).val(${result.pageSize})

    $searchForm.find('[name=type]').change(function () {
        $pageNo.val(1)
        $searchForm.submit()
    }).val(${result.type})
</script>
</body>

</html>
