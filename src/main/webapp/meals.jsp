<%--
  Created by IntelliJ IDEA.
  User: nemchinov
  Date: 12.07.2017
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
    <h2><a href="index.html">Home</a></h2>
    <h2>Meal list</h2>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th>Дата</th>
                <th>Описание</th>
                <th>Килокалории</th>
                <th>Превышение</th>
            </tr>
        </thead>

        <c:set var="parsePattern" value="yyyy-MM-dd'T'HH:mm"/>
        <c:set var="dateTimePattern" value="yyyy.MM.dd HH:mm"/>

        <jsp:useBean id="meals" scope="request" type="java.util.List"/>

        <c:forEach var="meal" items="${meals}" >
            <tr style="background-color: <c:out value="${meal.exceed ? 'palevioletred' : 'greenyellow'}" />; color: black;">
                <fmt:parseDate value="${meal.dateTime}" pattern="${parsePattern}" var="parsedDateTime"/>
                <td><fmt:formatDate value="${parsedDateTime}" pattern="${dateTimePattern}"/></td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td>${meal.exceed}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
