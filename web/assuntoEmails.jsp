<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" uri="/tags.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>Mailignus: Gerenciador de E-Mails</title>

		<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/animate.css" rel="stylesheet">

		<link href="css/style.css" rel="stylesheet">

	</head>
	<body class="body-iframe">
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>

		<script src="js/script.js"></script>

    <my:LerCabecalho emailCadastro="${param.txtEmail}"/>
    <table class="table table-hover">
    <c:forEach var="value" items="${resultado}">
        <c:out value="${value}" escapeXml="false"/>
    </c:forEach>
    </table>
	</body>
</html>
