package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springapp.util.RegexFactory;

public class TestRegexPerson {

	private RegexFactory regex;
	
	public TestRegexPerson() {
		regex = new RegexFactory();
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegexName() {
		assertTrue(regex.isCorrectName("VENTURINO"));
		assertFalse(regex.isCorrectName("13456"));
	}
	
	@Test
	public void testRegexEmail() {
		assertTrue(regex.isCorrectEmail("toto@toto.com"));
		assertTrue(regex.isCorrectEmail("mona-lisa@toto.com"));
		assertFalse(regex.isCorrectEmail("toto@toto"));
		assertFalse(regex.isCorrectEmail("mona-lisa@toto."));
	}
	
	@Test
	public void testRegexDate() {
		assertTrue(regex.isCorrectDate("19/02/1990"));
		assertTrue(regex.isCorrectDate("19-02-1990"));
		assertFalse(regex.isCorrectDate("19/02/90"));
	}
	
	@Test
	public void testRegexWebsite(){
		assertTrue(regex.isCorrectWebsite("http://www.pistache.com"));
		assertTrue(regex.isCorrectWebsite("http://pistache.com"));
		assertTrue(regex.isCorrectWebsite("www.pistache.com"));
	}

}
