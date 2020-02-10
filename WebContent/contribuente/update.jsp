<%@page import="it.gestionecartellaesattorialeSpringJPA.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Pagina di Modifica Contribuente</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>
	
	<!-- per gli attributi pattern e title dei tag <input> -->
	<%@ include file="/inputErrors.jsp"%>

	


	<div class="container">
		<%@ include file="/header.jsp"%>
		<c:set var="contribuenteInPagina" value='${requestScope["contribuenteAttr"]}' />

		<!-- header -->
		<div class="page-header">
			<h3>Modifica Contribuente</h3>
		</div>
		
		
		<!-- Messaggio di contribuente con cf di input gia' presente su DB -->
		<c:set var="messaggioErrore" value="${requestScope['messaggioErrore']}" />
		<c:if test="${messaggioErrore != null}"> 
			<div class="alert alert-danger" role="alert">
				<c:out value= "${messaggioErrore}"/>
			</div>
		</c:if>

		<form action="/gestionecartellaesattorialeSpringJPA/ExecuteUpdateContribuenteServlet" method="post">
		
		
		<input type="hidden" name="idInput" value = "<c:out value="${contribuenteInPagina.getId()}"/>">
						
						
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" required="required" id="nomeInputId"
						name="nomeInput" value = "<c:out value="${contribuenteInPagina.getNome()}"/>" pattern="<%=patternAlfabetico %>" title ="<%=inputAlfabetico %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" required="required" id="cognomeInputId"
						name="cognomeInput" value = "<c:out value="${contribuenteInPagina.getCognome()}"/>" pattern="<%=patternAlfabetico %>" title ="<%=inputAlfabetico %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cfInputId">Codice
					Fiscale:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" required="required" id="cfInputId"
						name="cfInput" value = "<c:out value="${contribuenteInPagina.getCf()}"/>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" required="required" id="indirizzoInputId"
						name="indirizzoInput" value = "<c:out value="${contribuenteInPagina.getIndirizzo()}"/>">
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