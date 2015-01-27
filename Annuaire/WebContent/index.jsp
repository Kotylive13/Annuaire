<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Identification</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
	<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('input[name=type]').change(function() {
			if ($('input[name=type]:checked').val() == 'administrateur')
				$('#label').text('Mot de passe');
			else
				$('#label').text('Identifiant');
		});
	});
	</script>
</head>
<body>
	<div class="main">
		<div class="login-form">
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
				<p><a href="#">Mot de passe oublié ?</a></p>
			</form>
		</div>
	</div>
</body>
</html>
<c:redirect url="/welcome.htm"/>
