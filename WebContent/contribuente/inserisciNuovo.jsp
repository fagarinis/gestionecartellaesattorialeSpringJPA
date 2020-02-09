
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Pagina di Inserimento Contribuente</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>

	<!-- per gli attributi pattern e title dei tag <input> -->
	<%@ include file="/inputErrors.jsp"%>

	<div class="container">
		<%@ include file="/header.jsp"%>

		<!-- header -->
		<div class="page-header">
			<h3>Inserisci Contribuente</h3>
		</div>


		<!-- Messaggio di cf gia' presente sul DB -->
		<%
			if (request.getAttribute("messaggioErrore") != null) {
		%>
		<div class="alert alert-danger" role="alert">
			<%=request.getAttribute("messaggioErrore")%>
		</div>
		<%
			}
		%>

		<form action="/gestionecartellaesattorialeSpringJPA/ExecuteInsertContribuenteServlet" method="post">
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" pattern="<%=patternAlfabetico %>" title ="<%=inputAlfabetico %>"
						name="nomeInput" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" pattern="<%=patternAlfabetico %>" title ="<%=inputAlfabetico %>"
					required="required" name="cognomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cfInputId">Codice Fiscale:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cfInputId"
						name="cfInput" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="indirizzoInputId"
						name="indirizzoInput">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Conferma
						Inserimento</button>
				</div>
			</div>
		</form>

		<%@ include file="/footer.jsp"%>
</body>
</html>