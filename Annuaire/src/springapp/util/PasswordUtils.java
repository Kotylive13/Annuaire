/**
 * Classe étant une trousse à outil pour les password
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package springapp.util;

import java.util.Random;

public class PasswordUtils {

	/**
	 * Mot de passe
	 */
	private String password;
	
	/**
	 * Ensemble des caractères pouvant être dans un mot de passe
	 */
	private static final String CHARACTER = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	/**
	 * Taille d'un mot de passe généré
	 */
	private int passwordLength = 8;
	
	/**
	 * Random pour générer le mot de passe aléatoirement
	 */
	private static Random rnd = new Random();

	/**
	 * Constructeur vide de la classe
	 */
	public PasswordUtils() {
	}

	/**
	 * Récupère le mot de passe
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Met à jour le mot de passe
	 * @param String password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Fonction permettant de générer aléatoirement un mot de passe
	 * @return String
	 */
	public String generatePassword() {
		StringBuilder sb = new StringBuilder(passwordLength);
		for (int i = 0; i < passwordLength; i++)
			sb.append(CHARACTER.charAt(rnd.nextInt(CHARACTER.length())));
		this.password = sb.toString();
		return password;
	}

	/**
	 * Fonction d'encryptage de mot de passe
	 * @param String password
	 * @return String
	 */
	public String encryptPassword(String password) {
		String crypte = "";
		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i) ^ 48;
			crypte = crypte + (char) c;
		}
		return crypte;
	}

	/**
	 * Fonction de décryptage de mot de passe
	 * @param String password
	 * @return String
	 */
	public String decryptPassword(String password) {
		String aCrypter = "";
		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i) ^ 48;
			aCrypter = aCrypter + (char) c;
		}
		return aCrypter;
	}
}
