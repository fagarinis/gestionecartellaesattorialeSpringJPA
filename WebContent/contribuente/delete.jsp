<%@page
	import="it.gestionecartellaesattorialeSpringJPA.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancellazione Contribuente</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>
	<%
		Contribuente contribuenteInPagina = (Contribuente) request.getAttribute("contribuenteAttr");
	%>

	<div class="container">

		<%@ include file="/header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Conferma Cancellazione</h3>
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

			
			
		<form action = "/gestionecartellaesattorialeSpringJPA/ExecuteDeleteContribuenteServlet" method ="post">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				<a href = "javascript:history.back()" class="btn btn-primary btn-md">Torna Indietro</a>
				
					<input type="hidden" name="idContribuente" value = "<%= contribuenteInPagina.getId()%>">
				
					<button type="submit" class="btn btn-primary btn-md" 
					onclick="return confirm('Attenzione, la cancellazione del contribuente comporta anche la cancellazione di TUTTE le cartelle esattoriali ad esso associate sul sistema. \n\n Continuare?')" >
					Conferma Cancellazione</button>
						
						
				</div>
			</div>
		</form>
			
		</div>
<%@ include file="/footer.jsp"%>
	</div>

	
</body>
</html>