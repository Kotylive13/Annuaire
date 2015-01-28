<%@ page pageEncoding="UTF-8" %>
<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xml:lang="fr" xmlns="http://www.w3.org/1999/xhtml">
    <head>      
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
        <title>Création</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
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
                    <img alt="" src="user.png" />
                </div>
                <form action="actions/annuaire" method="post">
                    <input type="text" onblur="if (this.value == '') {this.value = 'NOM';}" onfocus="this.value = '';" value="NOM" class="text" />
                    <input type="text" onblur="if (this.value == '') {this.value = 'PRENOM';}" onfocus="this.value = '';" value="PRENOM" class="text" />
                    <input type="text" onblur="if (this.value == '') {this.value = 'MAIL';}" onfocus="this.value = '';" value="MAIL" class="text" />
                    <input type="text" onblur="if (this.value == '') {this.value = 'SITE WEB';}" onfocus="this.value = '';" value="SITE WEB" class="text" />
                    <input type="text" onblur="if (this.value == '') {this.value = 'DATE DE NAISSANCE';}" onfocus="this.value = '';" value="DATE DE NAISSANCE" class="text" />
                    <input type="text" onblur="if (this.value == '') {this.value = 'MOT DE PASSE';}" onfocus="this.value = '';" value="MOT DE PASSE" class="text" />
                    <div class="submit">
                        <input type="submit" value="Valider" />
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>