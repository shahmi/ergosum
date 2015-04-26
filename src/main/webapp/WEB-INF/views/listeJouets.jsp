<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date,java.text.*"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<t:genericPage>
   	<jsp:attribute name="title">
      <title>Affichage de la liste des jouets</title>
    </jsp:attribute>
    <jsp:body>
	    <div class="container">
	    	<div class="row">
	        	<div class="col-md-12">
	        
	        <h3>Voici la liste de tout les jouets :</h3>
	        	
	    	<TABLE class="table table-hover">
			  <TR>
			 <TH> Numéro </TH>
			 <TH> Libellé  </TH>
			 <TH> Catégorie  </TH>
			 <TH> Trache d'âge </TH>
			 </TR>
			 
			 <c:forEach  items="${mesJouets}"  var="item" >
			  <tr>
			     <td>${item.numero}</td>
			     <td>${item.libelle}</td>
		     	 <td>${item.categorie.libcateg}</td>
				 <td>${item.trancheage.agemin}-${item.trancheage.agemax}</td>
			  	 <td>
				  	 <form class="form-inline" action="formModifJouet.htm" method="get">
			  			<div class="form-group">
			  				<input name="action" value="modifierStage" type="text" hidden="true">
			  				<input name="idJouet" value="${item.numero}" type="text" hidden="true">
						   <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> Modifier</button>
						</div>
					 </form>				
				  	<form class="form-inline" action="effacerJouet.htm" method="get">
			  			<div class="form-group">
			  				<input name="action" value="supprimerStage" type="text" hidden="true">
			  				<input name="idJouetaSup" value="${item.numero}" type="text" hidden="true">
						   <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Supprimer</button>
						</div>
					</form>
				</td> 
			  </tr>
			 </c:forEach>
			</TABLE>
			</div>
			</div>
	    </div>
  		</jsp:body>
</t:genericPage>