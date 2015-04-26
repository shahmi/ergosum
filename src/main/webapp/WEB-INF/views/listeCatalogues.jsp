<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date,java.text.*"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<t:genericPage>
   	<jsp:attribute name="title">
      <title>Affichage de la liste des catalogues</title>
    </jsp:attribute>
    <jsp:body>
	    <div class="container">
	    	<div class="row">
	        	<div class="col-md-12">
	        
	        <h3>Voici la liste des catalogues de ${anneeDepart} à ${anneeFin}:</h3>
	        	
	    	<TABLE class="table table-hover">
			  <TR>
			 <TH> Année catalogue </TH>
			 <TH> Quantité affectée  </TH>
			 <TH> Quantité distibuée  </TH>
			 <TH> Différence </TH>
			 </TR>
			 
			 <c:forEach  items="${MesCatalogues}"  var="item" >
			  <tr>
			     <td>${item.id.annee}</td>
			     <td>${item.quantite}</td>
		     	 <td>${item.catalogue.quantiteDistribuee}</td>
				 <td>${item.quantite - item.catalogue.quantiteDistribuee}</td>
			  </tr>
			 </c:forEach>
			</TABLE>
			</div>
			</div>
	    </div>
  		</jsp:body>
</t:genericPage>