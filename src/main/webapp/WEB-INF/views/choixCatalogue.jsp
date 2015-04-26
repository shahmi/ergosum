<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date,java.text.*"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<t:genericPage>
   	<jsp:attribute name="title">
      <title>Choix du catalogue :</title>
    </jsp:attribute>
    <jsp:body>
	    <div class="container">
	    	<div class="row">
	        	<div class="col-md-12">
	        
	        <h3>Veuillez renseigner les champs ci-dessous pour afficher la liste des catalogues :</h3>
	        <br>
		  
		  <form class="form-horizontal" method="post" action="afficherCatalogues.htm">
		  
			  <input type="hidden" name="type" value="ajout"  id="type"/>
			  <input type="hidden" name="action" value="vforAfficheC" />
				  <div class="form-group col-sm-12">
		    		<label for="anneeDepart" class="col-sm-3 control-label">Année de départ :</label>
		    		<div class="col-sm-7">
		    			<input type="text" name="anneeDepart" class="form-control" id="anneeDepart" placeholder="Enter une année..." required>
		    		</div>
		  		  </div>
		  		  <div class="form-group col-sm-12">
		    		<label for="nbAnnee" class="col-sm-3 control-label">Nombre d'années :</label>
		    		<div class="col-sm-7">
		    			<input type="text" name="nbAnnee" class="form-control" id="nbAnnee" placeholder="Enter le nombre d'année..." required>
		    		</div>
		  		  </div>
				  <div class="form-group col-sm-12">
				    <div class="col-sm-offset-3 col-sm-9">
				      <button type="submit" class="btn btn-primary">Afficher</button>
				    </div>
				  </div> 
		  </form>
	        	

			</div>
			</div>
	    </div>
  		</jsp:body>
</t:genericPage>