<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xml:lang="fr" xmlns="http://www.w3.org/1999/xhtml">
	<head>
    	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
        <title>Annuaire de groupes</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        
    	<div class="main">
    		<div class="column">
				<h1>Annuaire de groupes</h1>
				<div class="head">
					<a href="/Annuaire/"><img src="user.png" alt="Accueil"/></a>
				</div>
				
				<form id="findGroupes" action="/Annuaire/find_groupes.htm" method="get">
                	<h2>Recherche</h2>
                    <input name="name" type="text" value="<c:out value="${name}"/>" />
                    <div class="submit">
                        <input type="submit" value="Valider" />
                    </div>
                </form>
                
				<c:choose>
			  		<c:when test="${not empty elements}">     
						<ul>
							<c:forEach var="groupe" items="${elements}">
								<li><a href="/Annuaire/detail_groupe.htm?id=<c:out value="${groupe.id}"/>"><c:out value="${groupe.name}"/></a></li>
							</c:forEach>
				        </ul>
					</c:when>
			  		<c:otherwise>
			  	  		<h2 class="center">Aucun groupe présent dans l'annuaire.</h2>
			  	  	</c:otherwise>
				</c:choose>
				
				<p>
				<c:forEach var="page" begin="${firstPage}" end="${lastPage}">
				
					<c:choose>
				  		<c:when test="${page eq currentPage}">         
							[<c:out value="${page}"/>]
						</c:when>
				  		<c:otherwise>
				  	  		<a href="/Annuaire/annuaire_groupes.htm?page=<c:out value="${page}"/>"><c:out value="${page}"/></a>
				  	  	</c:otherwise>
					</c:choose>
				</c:forEach>
				</p>
		    </div>
		</div>
	</body>
</html>