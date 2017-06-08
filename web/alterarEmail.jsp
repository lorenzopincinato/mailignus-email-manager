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
                            <minha:ConsultarEmail emailCadastro="${param.emailCadastro}"/>
                                <div class="panel panel-default center-div" style="width: 400px; height: 466px">
                                        <div class="panel-heading" style="font-size: 18px; font-weight: bold">Alterar E-Mail</div>
                                        <div class="panel-body">
                                                <form action="cadastrarEmail.jsp" method="post">
                                                        <div class="input-group" style="margin-bottom: 15px">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                                                                <input id="txtNovoEmail" name="txtNovoEmail" type="text" class="form-control" placeholder="E-Mail" disabled="true" required="required" maxlength="40" value='<c:out value="${email}"/>'>
                                                        </div>
                                                        <div class="input-group" style="margin-bottom: 20px">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                                                <input id="txtSenha" name="txtSenha" type="password" class="form-control" placeholder="Senha" required="required" maxlength="30" value='<c:out value="${senha}"/>'>
                                                        </div>
                                                        <div class="input-group" style="margin-bottom: 15px; width: 65%">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-transfer"></span></span>
                                                                <input id="txtServidorLeitura" name="txtServidorLeitura" type="text" class="form-control" placeholder="Servidor de Leitura" required="required" maxlength="40" value='<c:out value="${servidorLeitura}"/>'>
                                                        </div>
                                                        <div class="input-group" style="margin-bottom: 20px; width: 40%">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-sort-by-order"></span></span>
                                                                <input id="txtPortaLeitura" name="txtPortaLeitura" type="text" class="form-control" placeholder="Porta" required="required" maxlength="6" value='<c:out value="${portaLeitura}"/>'>
                                                        </div>
                                                        <div class="input-group" style="margin-bottom: 15px; width: 65%">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-transfer"></span></span>
                                                                <input id="txtServidorSMTP" name="txtServidorSMTP" type="text" class="form-control" placeholder="Servidor SMTP" required="required" maxlength="40" value='<c:out value="${servidorSMTP}"/>'>
                                                        </div>
                                                        <div class="input-group" style="margin-bottom: 20px; width: 40%">
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-sort-by-order"></span></span>
                                                                <input id="txtPortaSMTP" name="txtPortaSMTP" type="text" class="form-control" placeholder="Porta" required="required" maxlength="6" value='<c:out value="${portaSMTP}"/>'>
                                                        </div>
                                                        <div style="margin-left: 5px">
                                                                <label class="radio-inline" style="margin-right: 56px;"><input type="radio" name="rbSSL" value="1" checked="checked">Com SSL</label>
                                                                <label class="radio-inline"><input type="radio" name="rbSSL" value="0">Sem SSL</label>
                                                        </div>
                                                        <input type="submit" value="Alterar" id="btnAlterar" name="btnAlterar" method="post" type="button" class="btn btn-parao" style="width: 368px; margin-top: 15px; height: 45px; font-size: 18px; font-weight: bold;"/>
                                                </form>
                                        </div>
                                </div>
                        </div>
		</div>
	</body>
</html>
