<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="minha" uri="/tags.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>Mailignus</title>

		<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/animate.css" rel="stylesheet">

		<link href="css/style.css" rel="stylesheet">

                <style>
                    form {
                        display: inline;
                    }
                </style>
	</head>
	<body>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>

		<script src="js/script.js"></script>
                <input type="text" value="${param.emailCadastro}" hidden="true" name="emailCadastro">

		<div id="barraTopo" class="div-topo">
			<img src="images/logo_low_low.png" style="margin: 7.5px; margin-left: 78px; margin-right: 70px"/>

                        <form action="sair.jsp">
                            <button type="submit" class="btn btn-default pull-right" style="margin: 10px; margin-left: 0px">
                                    <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                            </button>
                        </form>
		</div>
		<div>
			<div id="barraLateral" class="div-lateral" style="float:left;">
				<br>
                                <a href="escerverEmail.jsp" class="btn btn-escrever center-block" style="width: 274px; color: #5a5a5a">
					<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span><b> Escrever</b></a>
				<hr style="color: #d35400; background-color: #d35400; height: 1px;">
				<table class="table center-block" style="width: 274px; margin-left:25px; color: #5a5a5a">
                                            <minha:ListarEmails usuario="${sessionScope.login}"/>
                                            <c:forEach var="value" items="${resultado}">
                                                <tr>
                                                    <form action="assuntoEmails.jsp">
                                                        <td><b><input name="emailCadastro" type="submit" value="<c:out value='${value}'/>"> 
                                                    </form>
                                                    <form action="alterarEmail.jsp">
                                                        <input type="text" name="emailCadastro" value="<c:out value='${value}'/>" hidden="true">
                                                        <button type="submit">
                                                            <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>
                                                        </button>
                                                    </form>
                                                    <form action="excluirEmail.jsp">
                                                        <input type="text" name="emailCadastro" value="<c:out value='${value}'/>" hidden="true">
                                                        <button type="submit">
                                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></b></td>  
                                                        </button>
                                                    </form>
                                                                                                           
                                                </tr>
                                            </c:forEach>
					<tr>
						<td><a href="cadastrarEmail.jsp"><b><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Novo E-Mail</b></a></td>
					</tr>
				</table>
			</div>    
                        <div class="pull-right" style="width: calc(100% - 324px); height: calc(100vh - 60px)">

                        </div>
		</div>
	</body>
</html>
