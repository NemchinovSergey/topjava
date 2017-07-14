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

    <%--<p>contextPath: "${pageContext.servletContext.contextPath}"</p>--%>

    <table border="1">
        <thead>
            <tr>
                <th>Дата</th>
                <th>Описание</th>
                <th>Килокалории</th>
                <th>Превышение</th>
            </tr>
        </thead>
        <c:forEach var="meal" items="${meals}" >
            <c:choose>
                <c:when test="${meal.exceed}">
                    <tr style="background-color:palevioletred;color:black;" >
                </c:when>
                <c:otherwise>
                    <tr style="background-color:greenyellow;color:black;" >
                </c:otherwise>
            </c:choose>

                <td>${meal.dateTimeStr}</td>
                <%--<td><fmt:formatDate value="${meal.dateTime}" pattern="HH:mm dd.MM.yyyy"/></td>--%>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td>${meal.exceed}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
