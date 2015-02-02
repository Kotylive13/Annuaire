<%@ include file="/WEB-INF/jsp/include.jsp" %>
<div class="container">
	<div class="search_left">
		<c:choose>
			<c:when test="${not empty param.name}">
	        	<input name="name" id="label_search" type="text" value="<c:out value="${param.name}"/>" />
	        </c:when>
			<c:otherwise>
				<input name="name" id="label_search" type="text" value="RECHERCHE" onfocus="this.value = '';" />
			</c:otherwise>
		</c:choose>
	</div>
	<div class="search_right">
		<input class="img_search" type="image" src="search.png"></input>
	</div>
</div>





