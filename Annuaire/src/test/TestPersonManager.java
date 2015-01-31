/**
 * Classe JUNIT testant la classe PersonManager
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import springapp.persons.Person;
import springapp.persons.PersonManager;

public class TestPersonManager {

	/**
	 * PersonManager
	 */
	private PersonManager personManager;
	
	/**
	 * Person1
	 */
	private Person p1;
	
	/**
	 * Person2
	 */
	private Person p2;
	
	/**
	 * Constructeur de la classe et initialisation de variables
	 */
	public TestPersonManager() {
		personManager = new PersonManager();
		assertNotNull(personManager);
		
		p1 = new Person();
		p1.setFirstName("Jonathan");
		p1.setLastName("KATT");
		
		p2 = new Person();
		p2.setFirstName("Philippe");
		p2.setLastName("MOTHAIS");

		personManager.save(p1);
		personManager.save(p2);
	}
	
	/**
	 * Fonction testant la méthode find
	 */
	@Test
	public void find() {		
		assertEquals(p1, personManager.find(p1.getId()));
	}
	
	/**
	 * Fonction testant la méthode findAll
	 */
	@Test
	public void findAll() {
		Collection<Person> persons = personManager.findAll();
		assertEquals(persons.size(), 2);
		assertTrue(persons.contains(p1));
		assertTrue(persons.contains(p2));
	}
	
	/**
	 * Fonction testant la méthode delete
	 */
	@Test
	public void delete() {
		personManager.delete(p2.getId());
		assertEquals(null, personManager.find(p2.getId()));
	}
}
