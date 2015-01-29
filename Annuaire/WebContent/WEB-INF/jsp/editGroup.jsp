<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xml:lang="fr" xmlns="http://www.w3.org/1999/xhtml">
    <head>      
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
        <title>Edition</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
        <script type="text/javascript" src="jquery-1.11.1.js"></script>
		<script type="text/javascript" src="jquery.validate.js"></script>
		<script type="text/javascript" src="messages_fr.js"></script>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        
        <div class="main">
            <div class="column">
                <h1>Edition d'un groupe</h1>
				<div class="head">
					<a href="/Annuaire/"><img src="user.png" alt="Accueil"/></a>
				</div>
                
                <c:if test="${not empty person}">
                	<c:set var="id" value="${person.id}"/>
				  	<c:set var="firstName" value="${person.firstName}"/>
				  	<c:set var="lastName" value="${person.lastName}"/>
				  	<c:set var="mail" value="${person.mail}"/>
				  	<c:set var="website" value="${person.website}"/>
				  	<fmt:formatDate var="birthDate" pattern="dd/MM/yyyy" value="${person.birthDate}"/>
				  	<c:set var="password" value="${person.password}"/>
				  	<c:set var="groupe" value="${person.groupe}"/>
				</c:if>
                
                <form id="editForm" action="/Annuaire/save.htm" method="post">
                	<input name="id" type="hidden" value="<c:out value="${id}"/>" />
                	<h2>Nom du groupe</h2>
                    <input name="groupName" type="text" value="<c:out value="${groupName}"/>" />
                    <div class="submit">
                        <input type="submit" value="Valider" />
                    </div>
                </form>
                <script type="text/javascript" src="script.js"></script>
            </div>
        </div>
    </body>
</html>
