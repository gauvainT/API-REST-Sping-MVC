<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>list-sessions</title>
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
				<li class="nav-item active"><a class="nav-link"
					href="/SpringMVC/session/list">Sessions</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/SpringMVC/specialite/list">Specialités</a></li>
			</ul>

		</div>

	</nav>
	<br />
	<br />

	<div align="center">

		<h2>Liste des Sessions</h2>

		<br />
		<table class="table">
			<thead class="thead-dark">
				<tr>

					<th scope="col">#</th>
					<th scope="col">Date de Début</th>
					<th scope="col">Date de Fin</th>
					<th scope="col">Lieu</th>
					<th scope="col">Specialité</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="element" items="${listeDesSessions}">
					<c:url var="Delete" value="/session/deleteSession">
						<c:param name="sessionId" value="${element.idsession}" />
					</c:url>
					<c:url var="Update" value="/session/catchSession">
						<c:param name="id" value="${element.idsession}" />
					</c:url>

					<tr>

						<td><c:out value="${element.idsession}" /></td>
						<td><fmt:formatDate value="${element.date_debut}" pattern="dd-MM-yyyy" /></td>
						<td><fmt:formatDate value="${element.date_fin}" pattern="dd-MM-yyyy" /></td>
						<td><c:out value="${element.lieu}" /></td>
						

						<td><a href="${Update}">Update</a> | <a href="${Delete}"
							onclick="if (!(confirm('Are you sure you want to delete this session?'))) return false">Delete</a>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<br /> <br /> <br />
		<h2>
			<c:if test="${target != null}">
		        	Modifier la session ${target.idsession} ${target.intitule}
		        </c:if>
			<c:if test="${target == null}">
		        	Ajouter une session
		        </c:if>
		</h2>
		<c:if test="${target == null}">
			<form action="saveSession" method="post" class="form-example">
		</c:if>
		<c:if test="${target != null}">
			<form action="updateSession" method="post" class="form-example">
				<input type="hidden" name="idsession" id="idsession"
					value="<c:out value='${target.idsession}' />">
		</c:if>

		<div class="form-group">
			<label for="nom">Entrez la date de début: </label> <input
				class="form-control" type="text" name="date_debut" id="date_debut"
				value="<fmt:formatDate value='${target.date_debut}' pattern="dd-MM-yyyy" />" required>
		</div>
		<div class="form-group">
			<label for="nom">Entrez la date de fin: </label> <input
				class="form-control" type="text" name="date_fin" id="date_fin"
				value="<fmt:formatDate value='${target.date_fin}' pattern="dd-MM-yyyy" />" required>
		</div>
		<div class="form-group">
			<label for="prenom">Entrez le lieu: </label> <input
				class="form-control" type="text" name="lieu" id="lieu"
				value="<c:out value='${target.lieu}' />" required>
		</div>
		<div class="form-group">
			<label for="idSpecialite">Entrez la specialité: </label>
			 <select
				class="form-control" name="idSpecialite"
				id="idSpecialite">
				<c:forEach var="spe" items="${listeDesSpecialites}">
					<option value="${spe.idspecialite}">${spe.intitule}
					</option>
				</c:forEach>
			</select>



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