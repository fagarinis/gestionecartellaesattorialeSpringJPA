<%@page import="it.gestionecartellaesattorialeSpringJPA.model.CartellaEsattoriale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Pagina di Modifica Cartella Esattoriale</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>
	
	<!-- per gli attributi pattern e title dei tag <input> -->
	<%@ include file="/inputErrors.jsp"%>

	<% CartellaEsattoriale cartellaEsattorialeInPagina = (CartellaEsattoriale) request.getAttribute("cartellaEsattorialeAttr");%>


	<div class="container">
		<%@ include file="/header.jsp"%>

		<!-- header -->
		<div class="page-header">
			<h3>Modifica Cartella Esattoriale</h3>
		</div>
		
		
		<!-- Messaggio di contribuente con stesso cf gia' presente su DB -->
	<%if(request.getAttribute("messaggioErrore") != null){ %>
		<div class="alert alert-danger" role="alert">
			<%=request.getAttribute("messaggioErrore") %>
		</div>
	<% } %>

		<form action="/gestionecartellaesattorialeSpringJPA/ExecuteUpdateCartellaEsattorialeServlet" method="post">
		
			<input type="hidden" name="idInput" value = "<%= cartellaEsattorialeInPagina.getId()%>">
						
			<div class="form-group">
				<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" required="required" id="denominazioneInputId"
						name="denominazioneInput" value = "<%= cartellaEsattorialeInPagina.getDenominazione()%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text"  id="descrizioneInputId"
						name="descrizioneInput" value = "<%= cartellaEsattorialeInPagina.getDescrizione()%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="number" min="0" step ="0.01" placeholder = "0,00" id="importoInputId"
						name="importoInput" required="required" value = "<%= cartellaEsattorialeInPagina.getImporto()%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cfInputId">Codice Fiscale Contribuente:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" required="required" id="cfInputId"
						name="cfInput" value = "<%= cartellaEsattorialeInPagina.getContribuente().getCf()%>">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Conferma
						Modifica</button>
				</div>
			</div>
		</form>

		<%@ include file="/footer.jsp"%>
</body>
</html>