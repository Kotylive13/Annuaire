<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xml:lang="fr" xmlns="http://www.w3.org/1999/xhtml">
    <head>      
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
        <title>Création</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
        <script type="text/javascript" src="jquery-1.11.1.js"></script>
		<script type="text/javascript" src="jquery.validate.js"></script>
		<script type="text/javascript" src="messages_fr.js"></script>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <c:if test="${not empty type}">
	        <div class="popup">
	            <p class="<c:out value="${type}"/>"><c:out value="${message}"/></p>
	        </div>
		</c:if>
        <div class="main">
            <div class="column">
            	<c:choose>
            	<c:when test="${not empty person}">
                	<h1>Modifier personne</h1>
                </c:when>
                <c:otherwise>
                	<h1>Ajouter personne</h1>
                </c:otherwise>
                </c:choose>
				<div class="head">
					<a href="/Annuaire/"><img class="anim" src="user.png" alt="Accueil"/></a>
				</div>
                
                <c:if test="${not empty person}">
                	<c:set var="id" value="${person.id}"/>
				  	<c:set var="firstName" value="${person.firstName}"/>
				  	<c:set var="lastName" value="${person.lastName}"/>
				  	<c:set var="mail" value="${person.mail}"/>
				  	<c:set var="website" value="${person.website}"/>
				  	<fmt:formatDate var="birthDate" pattern="dd/MM/yyyy" value="${person.birthDate}"/>
				  	<c:set var="password" value="${person.password}"/>
				  	<c:set var="passwordConfirm" value="${person.password}"/>
				</c:if>
                
                <form id="editPerson" action="/Annuaire/save_person.htm" method="post">
                	<input name="id" type="hidden" value="<c:out value="${id}"/>" />
                	<h2>Prénom</h2>
                    <input name="firstName" type="text" value="<c:out value="${firstName}"/>" />
                    <h2>Nom</h2>
                    <input name="lastName" type="text" value="<c:out value="${lastName}"/>" />
                    <h2>Site web</h2>
                    <input name="website" type="text" value="<c:out value="${website}"/>" />
                    <h2>Mail</h2>
                    <input name="mail" type="text" value="<c:out value="${mail}"/>" />
                    <h2>Date de naissance</h2>
                    <input name="birthDate" type="text" value="<c:out value="${birthDate}"/>" />
                    <h2>Mot de passe</h2>
                    <input id="password" name="password" type="password" value="<c:out value="${password}"/>" />
                    <h2>Confirmation</h2>
                    <input name="passwordConfirm" type="password" value="<c:out value="${password}"/>" />
                    <h2>Groupe</h2>
                    <select name="groupe">
                    	<c:choose>
	                    	<c:when test="${not empty person}">	                    	
								<c:forEach var="groupe" items="${groupes}">
									<c:choose>
									<c:when test="${person.groupe.id eq groupe.id}">
										<option  value="<c:out value="${groupe.id}"/>" selected="selected" ><c:out value="${groupe.name}"/></option>
									</c:when>
									<c:otherwise>
										<option value="<c:out value="${groupe.id}"/>"><c:out value="${groupe.name}"/></option>
									</c:otherwise>
									</c:choose>
								</c:forEach>	
							</c:when>
							
							<c:otherwise>
								<c:forEach var="groupe" items="${groupes}">
									<option value="<c:out value="${groupe.id}"/>"><c:out value="${groupe.name}"/></option>
								</c:forEach>
							</c:otherwise>
						</c:choose>
                    </select>
                    <div class="submit">
                        <input type="submit" value="Valider" />
                    </div>
                    <script type="text/javascript" src="script.js"></script>
                </form>
            </div>
        </div>
    </body>
</html>
