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
        
        <minha:Cadastrar email="${param.txtNovoUsuario}" senha="${param.txtNovaSenha}"/>
        <c:if test="${resultado.equals('cadastrou')}">
            <script>
                $(function() {
                    estadoFormulario('cadastrar.html', true);
                });
            </script>
        </c:if>
        <c:if test="${resultado.equals('ncadastrou')}">
            <script>
                $(function() {
                    estadoFormulario('cadastrar.html', false);
                });
            </script>
        </c:if>
    </body>
</html>
