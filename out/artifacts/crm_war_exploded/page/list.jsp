<%@ page import="ca.bytetube.bean.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        th, td {
            border: 1px solid black;
        }

    </style>
</head>
<body>

<a href="page/add.html">add</a>

<div>
    <table>
        <thead>
        <tr>
            <th>name</th>
            <th>age</th>
            <th>height</th>
        </tr>
        </thead>
        <tbody>
        <%--        <%--%>
        <%--            List<Customer> customers = (List<Customer>)request.getAttribute("customers");--%>
        <%--            System.out.println("list.jsp");--%>
        <%--            System.out.println(customers);--%>
        <%--        %>--%>
        <c:forEach items="${customers}" var="customer" varStatus="s">
            <tr>
            <%--  getXXX ---> getName ---> Name ---> name--%>
                <td>${customer.name}</td>
                <td>${customer.age}</td>
                <td>${customer.height}</td>
            </tr>
        </c:forEach>


        <%--        <tr>--%>
        <%--            <td>abc</td>--%>
        <%--            <td>22</td>--%>
        <%--            <td>190.4</td>--%>
        <%--        </tr>--%>
        <%--        <tr>--%>
        <%--            <td>bcd</td>--%>
        <%--            <td>24</td>--%>
        <%--            <td>160.8</td>--%>
        <%--        </tr>--%>
        <%--        <tr>--%>
        <%--            <td>def</td>--%>
        <%--            <td>31</td>--%>
        <%--            <td>170.2</td>--%>
        <%--        </tr>--%>


        </tbody>
    </table>


</div>

</body>
</html>