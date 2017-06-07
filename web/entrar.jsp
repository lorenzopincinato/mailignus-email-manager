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
        <script src="js/jquery.js"></script>
	<script src="js/script.js"></script>
        
        <minha:Logar email="${param.txtUsuario}" senha="${param.txtSenha}"/>
        <c:if test="${resultado.equals('logou')}">
            <script language= "JavaScript"> parent.location = 'paginaInicial.html'; </script>
        </c:if>
        <c:if test="${resultado.equals('nlogou')}">
            <script>
                $(function() {
                    estadoFormulario('entrar.html', false);
                });
            </script>
        </c:if>
    </body>
</html>