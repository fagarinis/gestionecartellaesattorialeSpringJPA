<%@page import="it.gestionecartellaesattorialeSpringJPA.model.Contribuente"%>
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
	
	
	<!-- Messaggio di modifica avvenuta con successo (JSTL) -->
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
				<th>Nome</th>
				<th>Cognome</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:set var="listaContribuenti" value='${requestScope["resultListAttr"]}' />
		<c:forEach var = "contribuenteItem" items="${listaContribuenti}">
			<tr>
				<td><c:out value= "${contribuenteItem.getNome()}"/></td>
				<td><c:out value= "${contribuenteItem.getCognome()}"/></td>
				<td>
					<a href="/gestionecartellaesattorialeSpringJPA/VisualizzaDettaglioContribuenteServlet?idContribuente=<c:out value= "${contribuenteItem.getId()}"/>" class="btn btn-info">Dettaglio</a>
					<a href="/gestionecartellaesattorialeSpringJPA/PrepareUpdateContribuenteServlet?idContribuente=<c:out value= "${contribuenteItem.getId()}"/>" class="btn btn-info">Modifica</a>
					<a href="/gestionecartellaesattorialeSpringJPA/PrepareDeleteContribuenteServlet?idContribuente=<c:out value= "${contribuenteItem.getId()}"/>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
		</c:forEach>
	
	</table>
	
	<a href = "home.jsp" class="btn btn-primary btn-md">Torna alla Home</a>
	<a href = "contribuente/search.jsp" class="btn btn-primary btn-md">Nuova Ricerca</a>

	<%@ include file="../footer.jsp" %>
	
	</div>

</body>
</html>