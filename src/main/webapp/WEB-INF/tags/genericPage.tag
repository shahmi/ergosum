<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<div id="title">
      <jsp:invoke fragment="title"/>
    </div>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="resources/css/style.css">
	
	<script src="resources/js/jquery-2.1.3.js"></script>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	
</head>
	
  <body>
	    <div id="header">
	      <div class="headerStyle">
		    <nav class="navbar navbar-inverse navbar-fixed-top">
		      <div class="container">
		        <div class="navbar-header">
		          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		          <a class="navbar-brand" href="accueil.htm">Ergosum</a>
		        </div>
		        <div id="navbar" class="navbar-collapse collapse">
		          <ul class="nav navbar-nav">
		            <li class="active"><a href="accueil.htm">Accueil</a></li>
		            <li class="dropdown">
	                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Jouets <span class="caret"></span></a>
	                  <ul class="dropdown-menu" role="menu">
	                    <li><a href="afficherJouets.htm">Lister</a></li>
	                    <li class="divider"></li>
	                    <li><a href="formJouet.htm">Ajouter</a></li>
	                  </ul>
	                </li>
	                <li><a href="choixCatalogue.htm">Catalogues</a></li>
		            <li><a href="afficherDictionnaire.htm">Dictionnaire</a></li>
		          </ul>
		         
		        </div><!--/.nav-collapse -->
		      </div>
		    </nav>
		 </div>
	    <div id="body">
	    	<jsp:doBody/>
	    </div>
	   </div>
	   <footer class="footer">
	      <div class="container">
	        <p class="text-muted">Réalisé par <a href="https://github.com/shahmi">Mickael SHAH</a> et <a href="https://github.com/Krakitos">Morgan FUNTOWICZ</a>. </p>
	      </div>
	    </footer>
  </body>
</html>