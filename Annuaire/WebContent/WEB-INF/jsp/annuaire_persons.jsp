<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xml:lang="fr" xmlns="http://www.w3.org/1999/xhtml">
	<head>
    	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
        <title>Annuaire de personnes</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
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
				<h1>Annuaire de personnes</h1>
				<div class="head">
					<a href="/Annuaire/"><img class="anim" src="user.png" alt="Accueil"/></a>
				</div>
				<form id="findPersons" action="/Annuaire/find_persons.htm" method="get">
                	<jsp:include page="search.jsp" />
                </form>
				<c:choose>
			  		<c:when test="${not empty elements}">         
						<ul>
							<c:forEach var="person" items="${elements}">
							<li><a href="/Annuaire/detail_person.htm?id=<c:out value="${person.id}"/>"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></a></li>
							</c:forEach>
				        </ul>
					</c:when>
			  		<c:otherwise>
			  	  		<h2 class="center">Aucune personne présente dans l'annuaire.</h2>
			  	  	</c:otherwise>
				</c:choose>
				<div class="container">
					<div class="left">
						<c:if test="${currentPage - 1 > 0}">
							<a class="arrow" href="/Annuaire/annuaire_persons.htm?page=<c:out value="${firstPage}"/>">&#171; </a>
							<a class="arrow" href="/Annuaire/annuaire_persons.htm?page=<c:out value="${currentPage - 1}"/>"> &#8249;</a>
						</c:if>						
					</div>
					<div class="middle">
						<p class="page">
							<c:forEach var="page" begin="${firstPage}" end="${lastPage}">
								<c:choose>
							  		<c:when test="${page eq currentPage}">         
										[<c:out value="${page}"/>]
									</c:when>
							  		<c:otherwise>
							  	  		<a href="/Annuaire/annuaire_persons.htm?page=<c:out value="${page}"/>"><c:out value="${page}"/></a>
							  	  	</c:otherwise>
								</c:choose>
							</c:forEach>
						</p>
					</div>
					<div class="right">
						<c:if test="${currentPage + 1 <= veryLastPage}">
							<a class="arrow" href="/Annuaire/annuaire_persons.htm?page=<c:out value="${currentPage + 1}"/>">&#8250; </a>
							<a class="arrow" href="/Annuaire/annuaire_persons.htm?page=<c:out value="${veryLastPage}"/>"> &#187;</a>
						</c:if>
					</div>
					<div class="espace"></div>
				</div>
		    </div>
		</div>
	</body>
</html>