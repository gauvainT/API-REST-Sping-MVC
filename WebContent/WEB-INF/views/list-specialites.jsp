<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>list-specialites</title>
</head>
<body class="container">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<!-- Navbar content -->
		<a class="navbar-brand" href="/SpringMVC/">Formation Adaming</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">

				<li class="nav-item"><a class="nav-link"
					href="/SpringMVC/apprenant/list">Apprenants</a></li>
				<li class="nav-item  "><a class="nav-link"
					href="/SpringMVC/formateur/list">Formateurs</a></li>
				<li class="nav-item "><a class="nav-link"
					href="/SpringMVC/session/list">Sessions</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/SpringMVC/specialite/list">Specialités</a></li>
			</ul>

		</div>

	</nav>
	<br />
	<br />

	<div align="center">

		<h2>Liste des specialites</h2>
		
		<br />
		<table class="table">
			<thead class="thead-dark">
				<tr>
					
					<th scope="col">#</th>
					<th scope="col">Specialite</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="element" items="${listeDesSpecialites}">
					<c:url var="Delete" value="/specialite/deleteSpecialite">
								<c:param name="specialiteId" value="${element.idspecialite}" />
					</c:url>
					<c:url var="Update" value="/specialite/catchSpecialite">
								<c:param name="idspecialite" value="${element.idspecialite}" />
					</c:url>
					
					<tr>
						
						<td><c:out value="${element.idspecialite}" /></td>
						<td><c:out value="${element.intitule}" /></td>
						<td><a href="${Update}">Update</a>
         					|
         					<a href="${Delete}"
         					onclick="if (!(confirm('Are you sure you want to delete this specialite?'))) return false">Delete</a>
						</td>						

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<br /> <br /> <br />
		<h2>
				<c:if test="${target != null}">
		        	Modifier la specialite ${target.idspecialite} ${target.intitule}
		        </c:if>
		        <c:if test="${target == null}">
		        	Ajouter une specialite
		        </c:if>
			</h2>
			<c:if test="${target == null}">
				<form action="saveSpecialite" method="post" class="form-example">
			</c:if>
			<c:if test="${target != null}">
				<form action="updateSpecialite" method="post" class="form-example">
				<input type="hidden" name="idspecialite" id="idspecialite" value="<c:out value='${target.idspecialite}' />">
			</c:if>
				
				<div class="form-group">
					<label for="intitule">Entrez la specialité: </label>
					<input class="form-control" type="text" name="intitule" id="intitule" value="<c:out value='${target.intitule}' />" required>
				</div>
				
				
				<div class="form-group">
					<c:if test="${target != null}">
						<input class="btn btn-primary" type="submit" value="Modifier">
			        </c:if>
			        <c:if test="${target == null}">
						<input class="btn btn-primary" type="submit" value="Ajouter">
			        </c:if>
				</div>
			</form>

		<br />
		<bt />


	</div>


</body>
</html>