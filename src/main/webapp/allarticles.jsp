<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Assets/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tous les articles</title>
</head>
<body>
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="http://localhost:8080/BlogAlexis/">Blog Alexis B2A</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/BlogAlexis/allarticles">Consulter tous les articles <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/BlogAlexis/addarticle">Ajouter un article <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/BlogAlexis/auteurs">Auteurs <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Connexion
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="http://localhost:8080/BlogAlexis/login">Login</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="http://localhost:8080/BlogAlexis/signup">Inscription</a>
        </div>
      </li>
      <c:if test="${ !empty sessionScope.utilisateur}">
      	<li class="nav-item active">
        	<a class="nav-link" href="http://localhost:8080/BlogAlexis/deconnexion">Deconnexion <span class="sr-only">(current)</span></a>
      	</li>
      </c:if>
    </ul>
  </div>
</nav>

<div class="text-center">
	<h2>Tous les articles</h2>
</div>
<div class="container-fluid">
	<div class="row">
	<div class="card-deck mx-auto">
		<c:forEach items="${articles}" var="article">
		<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  		<div class="card-header"><c:out value="${article.getAuteur()}"/></div>
  		<div class="card-body">
    		<h5 class="card-title"><c:out value="${article.getTitre()}"/></h5>
    		<hr/>
  			<p class="card-text"><c:out value="${article.getDescription()}"/></p>
  			<a href="http://localhost:8080/BlogAlexis/article?id=${article.getId_article()}" class="btn btn-primary">Acc�der � l'article</a>
  			<br>
  			<hr>
  			<a href="http://localhost:8080/BlogAlexis/update?id=${article.getId_article()}" class="card-link text-white">Modifier</a>
  			<a href="http://localhost:8080/BlogAlexis/delete?id=${article.getId_article()}" class="card-link text-white">Supprimer</a>
  		</div>
  		<p class="card-footer text-muted"><c:out value="${article.getDate()}"/></p>
  		</div>
  		</c:forEach>
	</div>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>