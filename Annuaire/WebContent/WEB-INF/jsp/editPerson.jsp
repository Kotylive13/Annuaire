<%@ page pageEncoding="UTF-8" %>
<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xml:lang="fr" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
        <title>Edition</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="menu_bar">
            <ul>
                <li class="left_button">Accueil</li>
                <li class="left_button">Editer fiche personnelle</li>
                <li class="left_button">Ajouter personne</li>
                <li class="right_button">Deconnecter</li>
            </ul>
        </div>
        <div class="main">
            <div class="column">
                <h1>Edition fiche personnelle</h1>
                <div class="head">
                    <img alt="" src="user.png" />
                </div>
                <form action="actions/annuaire" method="post">
                    <h2>Nom</h2>
                    <input type="text" value="NOM" class="text" />
                    <h2>Prénom</h2>
                    <input type="text" value="PRENOM" class="text" />
                    <h2>Mail</h2>
                    <input type="text" value="MAIL" class="text" />
                    <h2>Site web</h2>
                    <input type="text" value="SITE_WEB" class="text" />
                    <h2>Date de naissance</h2>
                    <input type="text" value="DATE_NAISSANCE" class="text" />
                    <h2>Mot de passe</h2>
                    <input type="text" value="MOT_DE_PASSE" class="text" />
                    <div class="submit">
                        <input type="submit" value="Valider" />
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>