<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xml:lang="fr" xmlns="http://www.w3.org/1999/xhtml">
	<head>
    	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
        <title>Annuaire de groupe</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        
    	<div class="main">
    		<div class="column">
				<h1>Annuaire de groupe</h1>
				<div class="head">
					<a href="/Annuaire/"><img src="user.png" alt="Accueil"/></a>
				</div> 
				<h2>NOM DU GROUPE</h2>       
				<ul>
					<c:forEach var="person" items="${persons}">
					<li><a href="/Annuaire/detail.htm?id=<c:out value="${person.id}"/>"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></a></li>
					</c:forEach>
		        </ul>
		    </div>
		</div>
	</body>
</html>