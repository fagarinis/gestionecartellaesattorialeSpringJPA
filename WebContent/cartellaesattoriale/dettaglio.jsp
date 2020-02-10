<%@page
	import="it.gestionecartellaesattorialeSpringJPA.model.CartellaEsattoriale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detteglio Cartella Esattoriale</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>
	
	<div class="container">
	
		<%@ include file="/header.jsp"%>
		<c:set var="cartellaEsattorialeInPagina" value='${requestScope["cartellaEsattorialeAttr"]}' />

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Denominazione</dt>
				<dd class="col-sm-9"><c:out value="${cartellaEsattorialeInPagina.getDenominazione()}"/></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9"><c:out value="${cartellaEsattorialeInPagina.getDescrizione()}"/></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Importo</dt>
				<dd class="col-sm-9"><c:out value="${cartellaEsattorialeInPagina.getImporto()}"/></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Contribuente</dt>
				<dd class="col-sm-9"><c:out value="${cartellaEsattorialeInPagina.getContribuente().getCf()}"/></dd>
			</dl>

			<a href = "javascript:history.back()" class="btn btn-primary btn-md">Torna Indietro</a>
			
		</div>
<%@ include file="/footer.jsp"%>
	</div>

	
</body>
</html>