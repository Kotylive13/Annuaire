/**
 * Classe JUNIT testant la classe RegexPerson
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import springapp.util.RegexFactory;

public class TestRegexPerson {

	/**
	 * Variable RegexFactory
	 */
	private RegexFactory regex;
	
	/**
	 * Initialisation de la regexFactory
	 */
	public TestRegexPerson() {
		regex = new RegexFactory();
	}
	
	/**
	 * Fonction testant la méthode isCorrectName
	 */
	@Test
	public void testRegexName() {
		assertTrue(regex.isCorrectName("VENTURINO"));
		assertFalse(regex.isCorrectName("13456"));
	}
	
	/**
	 * Fonction testant la méthode isCorrectEmail
	 */
	@Test
	public void testRegexEmail() {
		assertTrue(regex.isCorrectEmail("toto@toto.com"));
		assertTrue(regex.isCorrectEmail("mona-lisa@toto.com"));
		assertFalse(regex.isCorrectEmail("toto@toto"));
		assertFalse(regex.isCorrectEmail("mona-lisa@toto."));
	}
	
	/**
	 * Fonction testant la méthode isCorrectDate
	 */
	@Test
	public void testRegexDate() {
		assertTrue(regex.isCorrectDate("19/02/1990"));
		assertTrue(regex.isCorrectDate("19-02-1990"));
		assertFalse(regex.isCorrectDate("19/02/90"));
	}
	
	/**
	 * Fonction testant la méthode isCorrectWebsite
	 */
	@Test
	public void testRegexWebsite(){
		assertTrue(regex.isCorrectWebsite("http://www.pistache.com"));
		assertTrue(regex.isCorrectWebsite("http://pistache.com"));
		assertTrue(regex.isCorrectWebsite("www.pistache.com"));
	}

}
