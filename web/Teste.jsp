
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" uri="/tags.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
       
        <my:LerCabecalho emailCadastro="${param.txtEmail}"/>
        <table class="table table-hover">
        <c:forEach var="value" items="${resultado}">
            <c:out value="${value}" escapeXml="false"/>
        </c:forEach>
        </table>
    </body>
</html>
