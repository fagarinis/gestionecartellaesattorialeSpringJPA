<%@page
	import="it.gestionecartellaesattorialeSpringJPA.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detteglio Contribuente</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>
	<%
		Contribuente contribuenteInPagina = (Contribuente) request.getAttribute("contribuenteAttr");
	%>

	<div class="container">

		<%@ include file="/header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getCognome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice Fiscale</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getCf()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Indirizzo</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getIndirizzo()%></dd>
			</dl>

			<a href = "javascript:history.back()" class="btn btn-primary btn-md">Torna Indietro</a>
			
		</div>
<%@ include file="/footer.jsp"%>
	</div>

	
</body>
</html>