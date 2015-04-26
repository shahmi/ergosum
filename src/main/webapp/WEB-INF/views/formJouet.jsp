<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<t:genericPage>
	    	<jsp:attribute name="title">
		      <title>Ajoutd'un jouet</title>
		    </jsp:attribute>
		    <jsp:body>
				<h1 class="center">Formulaire d'ajout d'un jouet</h1>
		  <br>
		  <input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
		  
		  <form class="form-horizontal" method="post" action="ajoutJouet.htm">
		  
			  <input type="hidden" name="type" value="ajout"  id="type"/>
			  <input type="hidden" name="action" value="ajoutStage" />
				  <div class="form-group col-sm-12">
		    		<label for="numero" class="col-sm-3 control-label">Numéro</label>
		    		<div class="col-sm-7">
		    			<input type="text" name="id" class="form-control" id="numero" placeholder="Entrer un numéro..." required>
		    		</div>
		  		  </div>
		  		  <div class="form-group col-sm-12">
		    		<label for="libelle" class="col-sm-3 control-label">Libellé</label>
		    		<div class="col-sm-7">
		    			<input type="text" name="libelle" class="form-control" id="libelle" placeholder="Entrer un libellé..." required>
		    		</div>
		  		  </div>
		  		  <div class="form-group col-sm-12">
		    		<label for="categorie" class="col-sm-3 control-label">Categorie</label>
		    		<div class="col-sm-7">
		    			<select id="categorie" class="form-control" name="categorie">
		    				<c:forEach  items="${categories}"  var="item" >
		    				<option value="${item.codecateg}">${item.libcateg}</option>
		    				</c:forEach>
						</select>
		    		</div>
		  		  </div>
		  		  <div class="form-group col-sm-12">
		    		<label for="tranche" class="col-sm-3 control-label">Tranche d'age</label>
		    		<div class="col-sm-7">
		    			<select id="tranche" class="form-control" name="tranche">
		    				<c:forEach  items="${tranches}"  var="item" >
		    				<option value="${item.codetranche}">${item.agemin} - ${item.agemax}</option>
		    				</c:forEach>
						</select>
		    		</div>
				  </div>
		  		  <div class="form-group col-sm-12">
		    		<label for="quantite" class="col-sm-3 control-label">Quantité de distribution</label>
		    		<div class="col-sm-7">
		    			<input type="text" name="quantite" class="form-control" id="quantite" placeholder="Entrer une quantité..." required>
		    		</div>
		  		  </div>
		  		  <div class="form-group col-sm-12">
		    		<label for="annee" class="col-sm-3 control-label">Année catalogue</label>
		    		<div class="col-sm-7">
		    			<select id="annee" class="form-control" name="annee">
		    				<c:forEach  items="${annees}"  var="item" >
		    				<option value="${item.annee}">${item.annee}</option>
		    				</c:forEach>
						</select>
		    		</div>
		  		  </div>
				  <div class="form-group col-sm-12">
				    <div class="col-sm-offset-3 col-sm-9">
				      <button type="submit" class="btn btn-primary">Ajouter</button>
				      <button type="reset" name="reset" class="btn btn-default">Reset</button>
				    </div>
				  </div> 
		  </form>
		  </div>
    		</jsp:body>
	</t:genericPage>