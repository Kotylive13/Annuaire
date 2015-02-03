<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
	<head>
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
        <title><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></title>
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        
    	<div class="main">
	        <div class="column">
	        	<h1>Fiche personnelle</h1>
				<div class="head">
					<a href="/Annuaire/"><img class="anim" src="user.png" alt="Accueil"/></a>
				</div>
	        	<div class="list">
					<h2>Prénom</h2>
					<div class="label"><p><c:out value="${person.firstName}"/></p></div>
					<h2>Nom</h2>
					<div class="label"><p><c:out value="${person.lastName}"/></p></div>
					<h2>Site web</h2>	
					<div class="label"><p><c:out value="${person.website}"/></p></div>
					<c:choose>
				  		<c:when test="${not empty sessionScope.user}">
					  		<h2>Mail</h2>	
							<div class="label"><p><c:out value="${person.mail}"/></p></div>
							<h2>Date de naissance</h2>	
							<fmt:formatDate var="birthDate" pattern="dd/MM/yyyy" value="${person.birthDate}"/>
							<div class="label"><p><c:out value="${birthDate}"/></p></div>
				  	  	</c:when>
					</c:choose>
					<h2>Groupe</h2>
					<c:forEach var="groupe" items="${groupes}">
						<c:if test="${person.groupe.id == groupe.id}">
		                	<div class="label"><p><a href="/Annuaire/detail_groupe.htm?id=<c:out value="${groupe.id}"/>"><c:out value="${groupe.name}"/></a></p></div>
						</c:if>
					</c:forEach>			
					<c:choose>
				  		<c:when test="${sessionScope.user == 'admin'}">
				  	  		<a href="/Annuaire/edit_person.htm?id=<c:out value="${person.id}"/>" >
				  	  			<button class="editButton">Editer</button>
				  	  		</a>
				  	  		<a href="/Annuaire/delete_person.htm?id=<c:out value="${person.id}"/>" >
				  	  			<button class="removeButton">Supprimer</button>
				  	  		</a>
				  	  	</c:when>
				  	  	<c:when test="${sessionScope.user == person.id}">
				  	  		<a href="/Annuaire/edit_person.htm?id=<c:out value="${person.id}"/>" >
				  	  			<button class="editButton">Editer</button>
				  	  		</a>
				  	  	</c:when>
					</c:choose>
				</div>
		    </div>
		</div>
	</body>
</html>