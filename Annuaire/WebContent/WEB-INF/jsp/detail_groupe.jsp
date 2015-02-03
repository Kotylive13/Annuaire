<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<title><c:out value="${groupe.name}" /></title>
	<link href="style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="menu.jsp" />
	
		<div class="main">
			<div class="column">
				<h1>${groupe.name}</h1>
				<div class="head">
					<a href="/Annuaire/"><img class="anim" src="user.png" alt="Accueil" /></a>
				</div>
				<c:choose>
			  		<c:when test="${not empty groupe.persons}">
			  	  		<ul>
							<c:forEach var="person" items="${groupe.persons}">
								<li><a
									href="/Annuaire/detail_person.htm?id=<c:out value="${person.id}"/>"><c:out
										value="${person.firstName}" /> <c:out value="${person.lastName}" /></a></li>
							</c:forEach>
						</ul>
				 	</c:when>
			  		<c:otherwise>
				  		<div class="list">
				  	  		<h2>Personne n'est inscrit à ce groupe.</h2>
				  	  	</div>
			  	  	</c:otherwise>
				</c:choose>
				<c:if test="${sessionScope.user == 'admin'}">
					<div class="list_without_top">
						<a
							href="/Annuaire/edit_groupe.htm?id=<c:out value="${groupe.id}"/>">
							<button class="editButton">Editer</button>
						</a>
						<a
							href="/Annuaire/delete_groupe.htm?id=<c:out value="${groupe.id}"/>">
							<button class="removeButton">Supprimer</button>
						</a>
					</div>
				</c:if>
	
			</div>
		</div>
	</body>
</html>
