<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Contribuente</title>
</head>
<body>

<div class="container">

	<!-- per gli attributi pattern e title dei tag <input> -->
   <%@ include file="/inputErrors.jsp"%>
   
   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Ricerca Contribuente</h3>
	</div>
	
	<!-- Messaggio di inserimento avvenuto con successo -->
	<%if(request.getAttribute("messaggioInsert") != null){ %>
		<div class="alert alert-success" role="alert">
			<%=request.getAttribute("messaggioInsert") %>
		</div>
	<% } %>
	

      	<form class="form-horizontal" action="/gestionecartellaesattorialeSpringJPA/ExecuteSearchContribuenteServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" pattern="<%=patternAlfabetico %>" title ="<%=inputAlfabetico %>" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" name="cognomeInput" pattern="<%=patternAlfabetico %>" title ="<%=inputAlfabetico %>">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="cfInputId">Codice Fiscale:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cfInputId" name="cfInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="indirizzoInputId" name="indirizzoInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effettua Ricerca</button>
		        <a href="/gestionecartellaesattorialeSpringJPA/PrepareInsertContribuenteServlet" class="btn btn-primary btn-md">Inserisci Nuovo Elemento</a>
		      </div>
		    </div>
		</form>
		
		<%@ include file="../footer.jsp" %>
    </div><!-- /.container -->



</body>
</html>