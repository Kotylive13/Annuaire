<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Création</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div class="menu_bar">
            <ul>
                <li class="left_button">Accueil</li>
                <li class="left_button">Editer fiche personnelle</li>
                <li class="left_button">Ajouter personne</li>
                <li class="right_button">Déconnexion</li>
            </ul>
        </div>
        <div class="main">
            <div class="column">
                <h1>Ajout personne</h1>
                <div class="head">
                    <img src="user.png" alt=""/>
                </div>
                <form method="post" action="actions/annuaire">
                    <input type="text" class="text" value="NOM" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'NOM';}">
                    <input type="text" class="text" value="PRENOM" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'PRENOM';}">
                    <input type="text" class="text" value="MAIL" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'MAIL';}">
                    <input type="text" class="text" value="SITE WEB" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'SITE WEB';}">
                    <input type="text" class="text" value="DATE DE NAISSANCE" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'DATE DE NAISSANCE';}">
                    <input type="text" class="text" value="MOT DE PASSE" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'MOT DE PASSE';}">
                    <div class="submit">
                        <input type="submit" value="Valider" >
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>