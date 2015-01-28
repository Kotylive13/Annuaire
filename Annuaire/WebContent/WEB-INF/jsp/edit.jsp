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
                
                <c:choose>
				  <c:when test="${not empty person}">
				  	<c:set var="firstName" value="${person.firstName}"/>
				  	<c:set var="lastName" value="${person.lastName}"/>
				  	<c:set var="mail" value="${person.mail}"/>
				  	<c:set var="website" value="${person.website}"/>
				  	<c:set var="birthDate" value="${person.birthDate}"/>
				  	<c:set var="password" value="${person.password}"/>
				  	<c:set var="groupe" value="${person.groupe}"/>
				  </c:when>
				  <c:otherwise>
				    <c:set var="firstName" value="PRENOM"/>
				  	<c:set var="lastName" value="NOM"/>
				  	<c:set var="mail" value="MAIL"/>
				  	<c:set var="website" value="SITE WEB"/>
				  	<c:set var="birthDate" value="DATE DE NAISSANCE"/>
				  	<c:set var="password" value="MOT DE PASSE"/>
				  	<c:set var="groupe" value="GROUPE"/>
				  </c:otherwise>
				</c:choose>
                
                <form action="/Annuaire/save.htm" method="post">
                    <input name="firstName" type="text" onblur="if (this.value == '') {this.value = 'PRENOM';}" onfocus="if (this.value == 'PRENOM') {this.value = '';}" value="<c:out value="${firstName}"/>" class="text" />
                    <input name="lastName" type="text" onblur="if (this.value == '') {this.value = 'NOM';}" onfocus="if (this.value == 'NOM') {this.value = '';}" value="<c:out value="${lastName}"/>" class="text" />
                    <input name="mail" type="text" onblur="if (this.value == '') {this.value = 'MAIL';}" onfocus="if (this.value == 'MAIL') {this.value = '';}" value="<c:out value="${mail}"/>" class="text" />
                    <input name="website" type="text" onblur="if (this.value == '') {this.value = 'SITE WEB';}" onfocus="if (this.value == 'SITE WEB') {this.value = '';}" value="<c:out value="${webSite}"/>" class="text" />
                    <input name="birthDate" type="text" onblur="if (this.value == '') {this.value = 'DATE DE NAISSANCE';}" onfocus="if (this.value == 'DATE DE NAISSANCE') {this.value = '';}" value="<c:out value="${birthDate}"/>" class="text" />
                    <input name="password" type="text" onblur="if (this.value == '') {this.value = 'MOT DE PASSE';}" onfocus="if (this.value == 'MOT DE PASSE') {this.value = '';}" value="<c:out value="${password}"/>" class="text" />
                    <input name="groupe" type="text" onblur="if (this.value == '') {this.value = 'GROUPE';}" onfocus="if (this.value == 'GROUPE') {this.value = '';}" value="<c:out value="${groupe}"/>" class="text" />
                    <div class="submit">
                        <input type="submit" value="Valider" />
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>