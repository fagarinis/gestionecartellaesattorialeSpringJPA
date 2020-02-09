
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Pagina di Inserimento Cartella Esattoriale</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>

	<!-- per gli attributi pattern e title dei tag <input> -->
	<%@ include file="/inputErrors.jsp"%>

	<div class="container">
		<%@ include file="/header.jsp"%>

		<!-- header -->
		<div class="page-header">
			<h3>Inserisci Cartella Esattoriale</h3>
		</div>


		<!-- Messaggio di cf contribuente non trovato sul DB -->
		<%
			if (request.getAttribute("messaggioErrore") != null) {
		%>
		<div class="alert alert-danger" role="alert">
			<%=request.getAttribute("messaggioErrore")%>
		</div>
		<%
			}
		%>

		<form action="ExecuteInsertCartellaEsattorialeServlet" method="post">
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId"
						name="denominazioneInput" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="descrizioneInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="number" min="0" step ="0.01" placeholder = "0,00" id="importoInputId"
						name="importoInput" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cfInputId">Codice Fiscale Contribuente:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cfInputId"
						name="cfInput" required="required">
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