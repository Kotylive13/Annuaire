package springapp.util;

import java.util.Random;

public class PasswordUtils {

	private String password;
	private static final String CHARACTER = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private int passwordLength = 8;
	private static Random rnd = new Random();

	public PasswordUtils() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String generatePassword() {
		StringBuilder sb = new StringBuilder(passwordLength);
		for (int i = 0; i < passwordLength; i++)
			sb.append(CHARACTER.charAt(rnd.nextInt(CHARACTER.length())));
		this.password = sb.toString();
		return password;
	}

	public String encryptPassword(String password) {
		String crypte = "";
		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i) ^ 48;
			crypte = crypte + (char) c;
		}
		return crypte;
	}

	public String decrypt(String password) {
		String aCrypter = "";
		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i) ^ 48;
			aCrypter = aCrypter + (char) c;
		}
		return aCrypter;
	}
}
