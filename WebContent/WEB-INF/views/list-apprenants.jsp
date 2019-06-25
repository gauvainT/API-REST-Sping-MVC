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
<title>list-apprenants</title>
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

				<li class="nav-item active"><a class="nav-link"
					href="/SpringMVC/apprenant/list">Apprenants</a></li>
				<li class="nav-item"><a class="nav-link"
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

		<h2>Liste des Apprenants</h2>

		<br />
		<table class="table">
			<thead class="thead-dark">
				<tr>

					<th scope="col">Nom</th>
					<th scope="col">Prenom</th>
					<th scope="col">Age</th>
					<th scope="col"># Pole Emploi</th>
					<th scope="col">Indemnite</th>
					<th scope="col">Diplome</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="element" items="${listeDesApprenants}">
					<c:url var="Delete" value="/apprenant/deleteApprenant">
						<c:param name="apprenantId" value="${element.id}" />
					</c:url>
					<c:url var="Update" value="/apprenant/catchApprenant">
						<c:param name="id" value="${element.id}" />
					</c:url>

					<tr>

						<td><c:out value="${element.getNom()}" /></td>
						<td><c:out value="${element.getPrenom()}" /></td>
						<td><c:out value="${element.getAge()}" /></td>
						<td><c:out value="${element.getIdPoleEmploi()}" /></td>
						<td><c:out value="${element.getIndemnite()}" /></td>
						<td><c:out value="${element.getDiplome()}" /></td>
						<td><a href="${Update}">Update</a> | <a href="${Delete}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
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
		        	Ajouter un apprenant
		        </c:if>
		</h2>
		<c:if test="${target == null}">
			<form action="saveApprenant" method="post" class="form-example">
		</c:if>
		<c:if test="${target != null}">
			<form action="updateApprenant" method="post" class="form-example">
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
			<label for="idPoleEmploi">Entrez l'id pôle emploi </label> <input
				class="form-control" type="number" name="idPoleEmploi"
				id="idPoleEmploi" value="<c:out value='${target.idPoleEmploi}' />"
				required>
		</div>
		<div class="form-group">
			<label for="indemnite">Entrez le montant de l'indemnité </label> <input
				class="form-control" type="number" name="indemnite" id="indemnite"
				value="<c:out value='${target.indemnite}' />" required>
		</div>
		<div class="form-group">
			<label for="diplome">Entrez le diplome </label> <input
				class="form-control" type="text" name="diplome" id="diplome"
				value="<c:out value='${target.diplome}' />" required>
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