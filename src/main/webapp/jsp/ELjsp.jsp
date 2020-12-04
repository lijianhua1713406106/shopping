
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${name eq '张三丰'}">
        欢迎您
    </c:if>
    <br>
    <c:choose>
        <c:when test="${user.age == 20}">
            年龄是20
        </c:when>
        <c:otherwise>
            年龄不详
        </c:otherwise>

    </c:choose>
    <br>



</body>
</html>
