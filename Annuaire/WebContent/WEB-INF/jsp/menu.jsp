<%@ include file="/WEB-INF/jsp/include.jsp" %>

<div class="menu_bar">
    <ul>
        <li class="left_button"><a href="/Annuaire/annuaire_persons.htm">Personnes</a></li>
        <li class="left_button"><a href="/Annuaire/annuaire_groupes.htm">Groupes</a></li>
        
        <c:choose>
		  <c:when test="${not empty sessionScope.user}">
		  
		  	<c:choose>
		  	  <c:when test="${sessionScope.user == 'admin'}">
		  	  	<li class="left_button"><a href="/Annuaire/create_person.htm">Ajouter personne</a></li>
		  	  	<li class="left_button"><a href="/Annuaire/create_groupe.htm">Ajouter groupe</a></li>
		  	  </c:when>
		  	  <c:otherwise>
		  	  	<li class="left_button"><a href="/Annuaire/edit_person.htm?id=<c:out value="${sessionScope.user}"/>">Modifier ma fiche</a></li>
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