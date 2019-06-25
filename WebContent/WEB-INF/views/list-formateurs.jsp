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
<title>list-formateurs</title>
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
				<li class="nav-item  active"><a class="nav-link"
					href="/SpringMVC/formateur/list">Formateurs</a></li>
				<li class="nav-item "><a class="nav-link"
					href="/SpringMVC/session/list">Sessions</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/SpringMVC/specialite/list">Specialités</a></li>
			</ul>

		</div>

	</nav>
	<br />
	<br />


	<div align="center">

		<h2>Liste des Formateurs</h2>

		<br />
		<table class="table">
			<thead class="thead-dark">
				<tr>

					<th scope="col">Nom</th>
					<th scope="col">Prenom</th>
					<th scope="col">Age</th>
					<th scope="col">Identifiant</th>
					<th scope="col">Salaire</th>
					<th scope="col">Action</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="element" items="${listeDesFormateurs}">
					<c:url var="Delete" value="/formateur/deleteFormateur">
						<c:param name="formateurId" value="${element.id}" />
					</c:url>
					<c:url var="Update" value="/formateur/catchFormateur">
						<c:param name="id" value="${element.id}" />
					</c:url>

					<tr>

						<td><c:out value="${element.nom}" /></td>
						<td><c:out value="${element.prenom}" /></td>
						<td><c:out value="${element.age}" /></td>
						<td><c:out value="${element.identifiant}" /></td>
						<td><c:out value="${element.salaire}" /></td>
						<td><a href="${Update}">Update</a> | <a href="${Delete}"
							onclick="if (!(confirm('Are you sure you want to delete this formateur?'))) return false">Delete</a>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<br /> <br /> <br />
		<h2>
			<c:if test="${target != null}">
		        	Modifier le compte de ${target.prenom} ${target.nom}
		        </c:if>
			<c:if test="${target == null}">
		        	Ajouter un formateur
		        </c:if>
		</h2>
		<c:if test="${target == null}">
			<form action="saveFormateur" method="post" class="form-example">
		</c:if>
		<c:if test="${target != null}">
			<form action="updateFormateur" method="post" class="form-example">
				<input type="hidden" name="id" id="id"
					value="<c:out value='${target.id}' />">
		</c:if>

		<div class="form-group">
			<label for="nom">Entrez le nom: </label> <input class="form-control"
				type="text" name="nom" id="nom"
				value="<c:out value='${target.nom}' />" required>
		</div>
		<div class="form-group">
			<label for="prenom">Entrez le prénom: </label> <input
				class="form-control" type="text" name="prenom" id="prenom"
				value="<c:out value='${target.prenom}' />" required>
		</div>
		<div class="form-group">
			<label for="age">Entrez l'age: </label> <input class="form-control"
				type="number" name="age" id="age"
				value="<c:out value='${target.age}' />" required>
		</div>
		<div class="form-group">
			<label for="idPoleEmploi">Entrez l'identifiant </label> <input
				class="form-control" type="number" name="identifiant"
				id="identifiant" value="<c:out value='${target.identifiant}' />"
				required>
		</div>
		<div class="form-group">
			<label for="indemnite">Entrez le montant du salaire </label> <input
				class="form-control" type="number" name="salaire" id="salaire"
				value="<c:out value='${target.salaire}' />" required>
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