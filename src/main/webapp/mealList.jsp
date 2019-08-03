<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User meal list</title>
</head>
<body>
<section>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Description</th>
            <th>Calories</th>
            <th>Date time</th>
        </tr>
        </thead>
        <c:forEach items="${userMeals}" var="userMeal">
            <jsp:useBean id="userMeal" type="javawebinar.topjava.model.UserMeal"/>
            <tr>
                <td><c:out value="${userMeal.description}"/></td>
                <td>${userMeal.calories}</td>
                <td><%=userMeal.getDateTime()%>
                </td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
