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
    <style>
        .normal {
            color: black;
            background-color: greenyellow;
        }

        .exceeded {
            color: black;
            background-color: palevioletred;
        }
    </style>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h2>Meal list</h2>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th>Дата</th>
                <th>Описание</th>
                <th>Килокалории</th>
                <th>Редактировать</th>
                <th>Удалить</th>
            </tr>
        </thead>

        <c:set var="parsePattern" value="yyyy-MM-dd'T'HH:mm"/>
        <c:set var="dateTimePattern" value="yyyy.MM.dd HH:mm"/>

        <jsp:useBean id="meals" scope="request" type="java.util.List"/>

        <c:forEach var="meal" items="${meals}" >
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}" >
                <fmt:parseDate value="${meal.dateTime}" pattern="${parsePattern}" var="parsedDateTime"/>
                <td><fmt:formatDate value="${parsedDateTime}" pattern="${dateTimePattern}"/></td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?action=edit&id=<c:out value="${meal.id}"/>">Редактировать</a></td>
                <td><a href="meals?action=delete&id=<c:out value="${meal.id}"/>">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
