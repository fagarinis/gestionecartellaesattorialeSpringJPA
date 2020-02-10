<%@page import="it.gestionecartellaesattorialeSpringJPA.model.CartellaEsattoriale"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Risultato Ricerca</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>
	<div class="container">
	
    <%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Pagina dei Risultati</h3>
	</div>
	
	<!-- Messaggio di modifica avvenuta con successo (JSTL)-->
	<c:set var="messaggioUpdate" value="${requestScope['messaggioUpdate']}" />
	<c:if test="${messaggioUpdate != null}"> 
		<div class="alert alert-success" role="alert">
			<c:out value= "${messaggioUpdate}"/>
		</div>
	</c:if>
	
	<!-- Messaggio di cancellazione avvenuta con successo (JSTL) -->
	<c:set var="messaggioDelete" value="${requestScope['messaggioDelete']}" />
	<c:if test="${messaggioDelete != null}"> 
		<div class="alert alert-success" role="alert">
			<c:out value= "${messaggioDelete}"/>
		</div>
	</c:if>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Denominazione Cartella Esattoriale</th>
				<th>Contribuente (CF)</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:set var="listaCartelleEsattoriali" value='${requestScope["resultListAttr"]}' />
			<c:forEach var = "cartellaEsattorialeItem" items="${listaCartelleEsattoriali}">
				<tr>
				<td><c:out value= "${cartellaEsattorialeItem.getDenominazione()}"/></td>
				<td><c:out value= "${cartellaEsattorialeItem.getContribuente().getCf()}"/></td>
				<td>	
					<a href="/gestionecartellaesattorialeSpringJPA/VisualizzaDettaglioCartellaEsattorialeServlet?idCartellaEsattoriale=<c:out value= "${cartellaEsattorialeItem.getId()}"/>" class="btn btn-info">Dettaglio</a>
					<a href="/gestionecartellaesattorialeSpringJPA/PrepareUpdateCartellaEsattorialeServlet?idCartellaEsattoriale=<c:out value= "${cartellaEsattorialeItem.getId()}"/>" class="btn btn-info">Modifica</a>
					<a href="/gestionecartellaesattorialeSpringJPA/PrepareDeleteCartellaEsattorialeServlet?idCartellaEsattoriale=<c:out value= "${cartellaEsattorialeItem.getId()}"/>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
			</c:forEach>
				
		
	
	</table>
	
	<a href = "home.jsp" class="btn btn-primary btn-md">Torna alla Home</a>
	<a href = "cartellaesattoriale/search.jsp" class="btn btn-primary btn-md">Nuova Ricerca</a>
	
	<%@ include file="../footer.jsp" %>
	
	</div>

</body>
</html>