<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Identification</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>

	<div class="main">
		<div class="column">
			<h1>Bienvenue</h1>
			<div class="head">
				<img src="user.png" alt=""/>
			</div>
			<form method="post" action="actions/annuaire">
				<input type="text" class="text" value="LOGIN" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'LOGIN';}" >
				<input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
				<div class="submit">
					<input type="submit" value="Connexion" >
				</div>	
			</form>
			<p class="bottom"><a href="#">Mot de passe oublié ?</a></p>
		</div>
	</div>
</body>
</html>
