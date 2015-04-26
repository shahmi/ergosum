<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<t:genericPage>
	    	<jsp:attribute name="title">
		      <title>Dictionnaire</title>
		    </jsp:attribute>
		    <jsp:body>
		     <div class="container">
	    	  <div class="row">
	    	  <div class="col-md-3">
	    	  		<label for="annee">Statistiques pour l'année : </label>
	    	  </div>
	    	  
	    	  
	    	  <div class="col-md-6">
		    		<select>
		    			 <c:forEach  items="${catalogues}"  var="item" >
		    			 	<option value="${item.annee}"> ${item.annee} </option>
						 </c:forEach>
		    		</select>	
		      </div>
	    	  		     
		     <c:forEach  items="${dictionnaire}"  var="item" >
		     <TABLE id="${item.annee}" class="table table-bordered">
			  <TR>
			 <TH> Catégorie </TH>
			 <TH> Quantité distrubuée  </TH>
			 </TR>
			 
			 
			  <c:forEach  items="${item.cat}"  var="cat" >
			  <tr>
			     <td>${cat.cat.libcateg}</td>
			     <td>${cat.nbJouet}</td>
			  </tr>
			  </c:forEach>
			
			</TABLE>
			 </c:forEach>
			</div>	
				</div>
		     </div>   
		     
		     <script>
			    $("select").change(function () {
			          var str = "";
			          $("select option:selected").each(function () {
			                str += $(this).val();
			              });
			          $("select option").each(function () {
			        	  var temp = $(this).val()
			        	  if(str == temp){
			        		  $("#"+temp).removeClass('hidden').addClass('display');
				          }
				          else{
				              $("#"+temp).removeClass('display').addClass('hidden');
				          }
			              }); 
			          
			        })
			        .change();
			</script>
     
    		</jsp:body>
	</t:genericPage>
	