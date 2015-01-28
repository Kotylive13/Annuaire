package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import springapp.persons.Person;
import springapp.persons.PersonManager;

public class TestPersonManager {

	private PersonManager personManager;
	
	private Person p1;
	private Person p2;
	
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
	
	@Test
	public void find() {		
		assertEquals(p1, personManager.find(p1.getId()));
	}
	
	@Test
	public void findAll() {
		Collection<Person> persons = personManager.findAll();
		assertEquals(persons.size(), 2);
		assertTrue(persons.contains(p1));
		assertTrue(persons.contains(p2));
	}
	
	@Test
	public void delete() {
		personManager.delete(p2.getId());
		assertEquals(null, personManager.find(p2.getId()));
	}
}
