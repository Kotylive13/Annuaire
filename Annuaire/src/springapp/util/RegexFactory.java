/**
 * Classe testant plusieurs regex
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package springapp.util;

public class RegexFactory {

	/**
	 * Expression de la regex
	 */
	private String expression;
	
	/**
	 * Constructeur vide de la classe
	 */
	public RegexFactory() {}
	
	/**
	 * Méthode permettant de vérifier un nom ou un prénom
	 * @param String name
	 * @return boolean
	 */
	public boolean isCorrectName(String name) {
		expression = "^[a-zA-Z\\s]+"; 
	    return name.matches(expression);  
	}
	
	/**
	 * Méthode permettant de vérifier
	 * @param String email
	 * @return boolean
	 */
	public boolean isCorrectEmail(String email) {
		expression = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$";
		return email.matches(expression);  
	}
	
	/**
	 * Méthode permettant de vérifier un siteweb
	 * @param String website
	 * @return boolean
	 */
	public boolean isCorrectWebsite(String website) {
		expression = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";
		return website.matches(expression);
	}
	
	/**
	 * Méthode permettant de vérifier une date
	 * @param String date
	 * @return boolean
	 */
	public boolean isCorrectDate(String date) {
		expression = "(0?[1-9]|[12][0-9]|3[01])(/|-)(0?[1-9]|1[012])(/|-)((19|20)\\d\\d)";
		return date.matches(expression);
	}
	
	/**
	 * Méthode permettant de vérifier un mot de passe
	 * @param String password
	 * @return boolean
	 */
	public boolean isCorrectPassword(String password) {
		expression = "(?=.*[a-z])*(?=.*d)*(?=.*[@#$%])*(?=.*[A-Z])*.{6,16}";
		return password.matches(expression);
	}
	
	/**
	 * Méthode permettant de vérifier le nom d'un groupe
	 * @param String name
	 * @return boolean
	 */
	public boolean isCorrectGroupe(String name) {
		expression = "^[a-zA-Z0-9\\s]+";
		return name.matches(expression);
	}
}
