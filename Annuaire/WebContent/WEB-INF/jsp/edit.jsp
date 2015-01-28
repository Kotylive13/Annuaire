<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xml:lang="fr" xmlns="http://www.w3.org/1999/xhtml">
    <head>      
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
        <title>Création</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="menu_bar">
            <ul>
                <li class="left_button">Accueil</li>
                <li class="left_button">Editer fiche personnelle</li>
                <li class="left_button">Ajouter personne</li>
                <li class="right_button">Déconnexion</li>
            </ul>
        </div>
        <div class="main">
            <div class="column">
                <h1>Ajout personne</h1>
                <div class="head">
                    <img alt="" src="user.png" />
                </div>
                
                <c:if test="${not empty person}">
				  	<c:set var="firstName" value="${person.firstName}"/>
				  	<c:set var="lastName" value="${person.lastName}"/>
				  	<c:set var="mail" value="${person.mail}"/>
				  	<c:set var="website" value="${person.website}"/>
				  	<c:set var="birthDate" value="${person.birthDate}"/>
				  	<c:set var="password" value="${person.password}"/>
				  	<c:set var="groupe" value="${person.groupe}"/>
				</c:if>
                
                <form action="/Annuaire/save.htm" method="post">
                	<h2>Prénom</h2>
                    <input name="firstName" type="text" class="text" value="<c:out value="${firstName}"/>" />
                    <h2>Nom</h2>
                    <input name="lastName" type="text" class="text" value="<c:out value="${lastName}"/>" />
                    <h2>Mail</h2>
                    <input name="mail" type="text" class="text" value="<c:out value="${mail}"/>" />
                    <h2>Site web</h2>
                    <input name="website" type="text" class="text" value="<c:out value="${website}"/>" />
                    <h2>Date de naissance</h2>
                    <input name="birthDate" type="text" class="text" value="<c:out value="${birthDate}"/>" />
                    <h2>Mot de passe</h2>
                    <input name="password" type="text" class="text" value="<c:out value="${password}"/>" />
                    <h2>Groupe</h2>
                    <input name="groupe" type="text" class="text" value="<c:out value="${groupe}"/>" />
                    <div class="submit">
                        <input type="submit" value="Valider" />
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>