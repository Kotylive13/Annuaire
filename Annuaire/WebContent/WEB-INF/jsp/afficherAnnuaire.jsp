<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un client</title>
        <link type="text/css" rel="stylesheet" href="../style.css" />
    </head>
    <body>
    	<div class="main">
	        <table>
	        	<tr>
	        		<td>Nom</td>
	        		<td>${ personne.nom }</td>
	        	</tr>
	        	<tr>
	        		<td>Prénom</td>
	        		<td>${ personne.prenom }</td>
	        	</tr>
	        	<tr>
	        		<td>Site web</td>
	        		<td>${ personne.web }</td>
	        	</tr>
	        </table>
		</div>
    </body>
</html>