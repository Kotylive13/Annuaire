<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<title>Mot de passe oublié</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
	<script type="text/javascript" src="jquery-1.11.1.js"></script>
	<script type="text/javascript" src="jquery.validate.js"></script>
	<script type="text/javascript" src="messages_fr.js"></script>
</head>
	<body>	
		<div class="main">
			<div class="column">
				<h1>Mot de passe oublié</h1>
				<div class="head">
					<a href="/Annuaire/"><img src="user.png" alt="Accueil"/></a>
				</div>
				<form id="loginForgotForm" method="post" action="/Annuaire/generate_login.htm">
					<input id="login" name="login" type="text" value="ADRESSE E-MAIL" onfocus="this.value = '';"/>
					<div class="submit">
						<input type="submit" value="Envoyer" />
					</div>	
				</form>
				<script type="text/javascript" src="script.js"></script>
			</div>
		</div>
	</body>
</html>
