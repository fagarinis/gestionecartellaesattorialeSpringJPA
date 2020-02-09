<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Cartella Esattoriale</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Ricerca Cartella Esattoriale</h3>
	</div>
	
	<!-- Messaggio di errore cf non presente -->
	<%if(request.getAttribute("messaggioErrore") != null){ %>
		<div class="alert alert-danger" role="alert">
			<%=request.getAttribute("messaggioErrore") %>
		</div>
	<% } %>
	
	<!-- Messaggio di inserimento avvenuto con successo -->
	<%if(request.getAttribute("messaggioInsert") != null){ %>
		<div class="alert alert-success" role="alert">
			<%=request.getAttribute("messaggioInsert") %>
		</div>
	<% } %>

      	<form class="form-horizontal" action="/gestionecartellaesattorialeSpringJPA/ExecuteSearchCartellaEsattorialeServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId" name="denominazioneInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="number" min="0" step ="0.01" id="importoInputId" name="importoInput" placeholder = "0,00" >
			 	</div>
  			</div>
  			
  			
		    <div class="form-group">
				<label class="control-label col-sm-2" for="cfInputId">Codice Fiscale Contribuente:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cfInputId"
						name="cfInput">
				</div>
			</div>
			
			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effettua Ricerca</button>
		        <a href="/gestionecartellaesattorialeSpringJPA/PrepareInsertCartellaEsattorialeServlet" class="btn btn-primary btn-md">Inserisci Nuovo Elemento</a>
		      </div>
		    </div>
		</form>
		
		<%@ include file="../footer.jsp" %>
    </div><!-- /.container -->



</body>
</html>