<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xml:lang="fr" xmlns="http://www.w3.org/1999/xhtml">
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
	        	<div class="head"><img alt="" src="user.png" /></div>
	        	<div class="list">
					<h2>Prénom</h2>
					<div class="label"><p><c:out value="${person.firstName}"/></p></div>
					<h2>Nom</h2>
					<div class="label"><p><c:out value="${person.lastName}"/></p></div>
					<h2>Site web</h2>	
					<div class="label"><p><c:out value="${person.website}"/></p></div>
				</div>
		    </div>
		</div>
	</body>
</html>