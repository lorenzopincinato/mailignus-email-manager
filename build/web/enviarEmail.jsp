<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="minha" uri="/tags.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <minha:EnviarEmail assunto="${param.txtAssunto}" destinatario="${param.txtDestino}" emailCadastro="${param.txtEmail}" mensagem="${param.txtMsg}"/>
        <c:if test="${resultado.equals('enviou')}">
            aoaoaoaoao ao ao
        </c:if>
        <c:if test="${resultado.equals('nenviou')}">
            <c:out value="${erro}"/>
        </c:if>
    </body>
</html>
