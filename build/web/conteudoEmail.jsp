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
        <my:ConteudoEmail emailCadastro="${email}" tituloEmail="${param.txtTitulo}" />
        <c:forEach var="value" items="${resultado}">
            <c:out value="${value}" escapeXml="false"/>
        </c:forEach>
    </body>
</html>

