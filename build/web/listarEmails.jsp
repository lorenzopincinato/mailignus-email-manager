

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" uri="/tags.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <my:ListarEmails usuario="${param.txtUsuario}"/>
        <c:forEach var="value" items="${resultado}">
            <c:out value="${value}"></c:out>
        </c:forEach>
    </body>
</html>
