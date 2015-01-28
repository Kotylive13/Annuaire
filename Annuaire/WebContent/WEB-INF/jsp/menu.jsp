<%@ include file="/WEB-INF/jsp/include.jsp" %>

<div class="menu_bar">
    <ul>
        <li class="left_button"><a href="/Annuaire/">Accueil</a></li>
        
        <c:choose>
		  <c:when test="${not empty sessionScope.user}">
		  
		  	<c:choose>
		  	  <c:when test="${sessionScope.user == 'admin'}">
		  	  	<li class="left_button"><a href="/Annuaire/create.htm">Ajouter personne</a></li>
		  	  </c:when>
		  	  <c:otherwise>
		  	  	<li class="left_button"><a href="/Annuaire/edit.htm?id=<c:out value="${sessionScope.user}"/>">Modifier ma fiche</a></li>
		  	  </c:otherwise>
			</c:choose>
		  
		  	<li class="right_button"><a href="/Annuaire/logout.htm">Déconnexion</a></li>
		  </c:when>
		  <c:otherwise>
		    <li class="right_button"><a href="/Annuaire/connection.htm">Connexion</a></li>
		  </c:otherwise>
		</c:choose>
    </ul>
</div>