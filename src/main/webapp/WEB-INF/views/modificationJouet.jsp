<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:genericPage>
	    	<jsp:attribute name="title">
		      <title>Modification d'un jouet</title>
		    </jsp:attribute>
		    <jsp:body>
				<h1 class="center">Formulaire de modification d'un jouet</h1>
		  <br>
		  		  <input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
		  
		  <form class="form-horizontal" method="post" action="modifierJouet.htm">
		  
			  <input type="hidden" name="type" value="ajout"  id="type"/>
			  <input type="hidden" name="action" value="ajoutStage" />
			  <input name="id" value="${jouet.numero}" type="text" hidden="true">
			  
		  		  <div class="form-group col-sm-12">
		    		<label for="libelle" class="col-sm-3 control-label">Libellé</label>
		    		<div class="col-sm-7">
		    			<input type="text" name="libelle" class="form-control" id="libelle" value="${jouet.libelle}" required>
		    		</div>
		  		  </div>
		  		  <div class="form-group col-sm-12">
		    		<label for="categorie" class="col-sm-3 control-label">Categorie</label>
		    		<div class="col-sm-7">
		    			<select id="categorie" class="form-control" name="categorie">
		    				<c:forEach  items="${categories}"  var="item" >
			    				<c:choose>
								      <c:when test="${item.codecateg == jouet.categorie.codecateg}">
								      		<option value="${item.codecateg}" selected>${item.libcateg}</option>
								      </c:when>
								      <c:otherwise>
								      		<option value="${item.codecateg}">${item.libcateg}</option>
								      </c:otherwise>
								</c:choose>
		    				</c:forEach>
						</select>
		    		</div>
		  		  </div>
		  		  <div class="form-group col-sm-12">
		    		<label for="tranche" class="col-sm-3 control-label">Tranche d'age</label>
		    		<div class="col-sm-7">
		    			<select id="tranche" class="form-control" name="tranche">
		    				<c:forEach  items="${tranches}"  var="item" >
		    					<c:choose>
								      <c:when test="${item.codetranche == jouet.trancheage.codetranche}">
								      		<option value="${item.codetranche}" selected>${item.agemin} - ${item.agemax}</option>
								      </c:when>
								      <c:otherwise>
								      		<option value="${item.codetranche}">${item.agemin} - ${item.agemax}</option>
								      </c:otherwise>
								</c:choose>
		    				</c:forEach>
						</select>
		    		</div>
				  </div>
		  		  <div class="form-group col-sm-12">
		    		<label for="quantite" class="col-sm-3 control-label">Quantité de distribution</label>
		    		<div class="col-sm-7">
		    			<input type="text" name="quantite" class="form-control" id="quantite" value="${qAndY.quantite}" required>
		    		</div>
		  		  </div>
				  <div class="form-group col-sm-12">
				    <div class="col-sm-offset-3 col-sm-9">
				      <button type="submit" class="btn btn-primary">Modifier</button>
				      <button type="reset" name="reset" class="btn btn-default">Reset</button>
				    </div>
				  </div> 
		  </form>
    		</jsp:body>
	</t:genericPage>