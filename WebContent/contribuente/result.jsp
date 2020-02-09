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
	
	<!-- Messaggio di modifica avvenuta con successo -->
	<%if(request.getAttribute("messaggioUpdate") != null){ %>
		<div class="alert alert-success" role="alert">
			<%=request.getAttribute("messaggioUpdate") %>
		</div>
	<% } %>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Action</th>
			</tr>
		</thead>
		<% List<Contribuente> listaContribuenti = (List<Contribuente>)request.getAttribute("resultListAttr"); 
			for(Contribuente contribuenteItem: listaContribuenti){ %>
			<tr>
				<td><%=contribuenteItem.getNome() %></td>
				<td><%=contribuenteItem.getCognome() %></td>
				<td>
					<a href="VisualizzaDettaglioContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PrepareUpdateContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PrepareDeleteContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>
	
	<a href = "home.jsp" class="btn btn-primary btn-md">Torna alla Home</a>
	<a href = "contribuente/search.jsp" class="btn btn-primary btn-md">Nuova Ricerca</a>

	<%@ include file="../footer.jsp" %>
	
	</div>

</body>
</html>