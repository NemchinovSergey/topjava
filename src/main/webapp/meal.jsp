<%--
  Created by IntelliJ IDEA.
  User: nemchinov
  Date: 19.07.2017
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
<section>
    <h2><a href="index.html">Home</a></h2>
    <h2>Meal Add or Update</h2>

    <c:set var="parsePattern" value="yyyy-MM-dd'T'HH:mm"/>
    <c:set var="dateTimePattern" value="yyyy.MM.dd HH:mm"/>

    <%--<jsp:useBean id="meal" scope="page" class="ru.javawebinar.topjava.model.Meal"/>--%>

    <form method="POST" action='meals' name="frmAddMeal">
        <input type="hidden" name="id" value="${meal.id}">

        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <td>Дата/время</td>
                <fmt:parseDate value="${meal.dateTime}" pattern="${parsePattern}" var="parsedDateTime"/>
                <td><input type="datetime" name="both" value="<fmt:formatDate value="${parsedDateTime}" pattern="${dateTimePattern}"/>"/></td>
            </tr>
            <tr>
                <td>Описание</td>
                <td><input type="text" name="desc" value="<c:out value="${meal.description}" />"/></td>
            </tr>
            <tr>
                <td>Калории</td>
                <td><input type="number" name="calories" value="<c:out value="${meal.calories}" />"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Сохранить"/>
                </td>
            </tr>
        </table>
    </form>
</section>
</body>
</html>
