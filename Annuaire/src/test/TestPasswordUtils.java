/**
 * Test de la classe PasswordUtils
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import springapp.util.PasswordUtils;

public class TestPasswordUtils {

	/**
	 * Instance de la classe PasswordUtils
	 */
	PasswordUtils passwordUtil;
	
	public TestPasswordUtils() {
		passwordUtil = new PasswordUtils();
	}
	
	/**
	 * Méthode testant la fonction generatePassword de la classe PasswordUtils
	 */
	@Test
	public void testGeneratePassword() {
		assertNotNull(passwordUtil.generatePassword());
	}

	/**
	 * Méthode testant la fonction EncryptPassword et DecryptPassword
	 */
	@Test
	public void testEncryptPassword() {
		String password = "JETESTUNMOTDEPASSE";
		String password2 = passwordUtil.encryptPassword(password);
		assertTrue(password.equals(passwordUtil.decryptPassword(password2)));
	}
	
}
