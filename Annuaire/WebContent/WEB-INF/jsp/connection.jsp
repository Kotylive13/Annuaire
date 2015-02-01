<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<title>Identification</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery-1.11.1.js"></script>
	<script type="text/javascript" src="jquery.validate.js"></script>
	<script type="text/javascript" src="messages_fr.js"></script>
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
				<h1>Bienvenue</h1>
				<div class="head">
					<a href="/Annuaire/"><img class="anim" src="user.png" alt="Accueil"/></a>
				</div>
				<form id="loginForm" method="post" action="/Annuaire/login.htm">
					<input id="login" name="login" type="text" value="LOGIN" onfocus="this.value = '';"/>
					<input id="password" name="password" type="password" value="******" onfocus="this.value = '';"/>
					<div class="submit">
						<input type="submit" value="Connexion" />
					</div>	
					<script type="text/javascript" src="script.js"></script>
				</form>
				<p class="bottom"><a href="/Annuaire/login_forgot.htm">Mot de passe oublié ?</a></p>
			</div>
		</div>
	</body>
</html>
