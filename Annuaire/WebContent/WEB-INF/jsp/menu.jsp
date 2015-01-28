<%@ include file="/WEB-INF/jsp/include.jsp" %>
<div class="menu_bar">
    <ul>
        <li class="left_button"><a href="/Annuaire/">Accueil</a></li>
        <li class="left_button"><a href="/Annuaire/create.htm">Ajouter personne</a></li>
        
        <c:choose>
		  <c:when test="${sessionScope.user != null}">
		  	<li class="right_button">Déconnexion</li>
		  </c:when>
		  <c:otherwise>
		    <li class="right_button"><a href="/Annuaire/connection.htm">Connexion</a></li>
		  </c:otherwise>
		</c:choose>
    </ul>
</div>