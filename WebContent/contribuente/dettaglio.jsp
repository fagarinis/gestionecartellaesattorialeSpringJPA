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
	<div class="container">
	<%@ include file="/header.jsp"%>

	<c:set var="contribuenteInPagina" value='${requestScope["contribuenteAttr"]}' />

		<div class="page-header">
			<h3>Pagina di Dettaglio Contribuente</h3>
		</div>
		
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><c:out value="${contribuenteInPagina.getNome()}"/></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9"><c:out value="${contribuenteInPagina.getCognome()}"/></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice Fiscale</dt>
				<dd class="col-sm-9"><c:out value="${contribuenteInPagina.getCf()}"/></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Indirizzo</dt>
				<dd class="col-sm-9"><c:out value="${contribuenteInPagina.getIndirizzo()}"/></dd>
			</dl>

			<a href = "javascript:history.back()" class="btn btn-primary btn-md">Torna Indietro</a>
			
		</div>
	<%@ include file="/footer.jsp"%>
	</div>

	
</body>
</html>