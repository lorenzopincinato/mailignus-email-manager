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
        <my:ConsultarEmail emailCadastro="${param.txtEmail}"/>
        <c:out value="${email}"/><br>
        <c:out value="${senha}"/><br>
        <c:out value="${portaLeitura}"/><br>
        <c:out value="${portaSMTP}"/><br>
        <c:out value="${servidorLeitura}"/><br>
        <c:out value="${servidorSMTP}"/><br>
        <c:out value="${sslLeitura}"/>
    </body>
</html>
