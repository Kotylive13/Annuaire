package springapp.util;

import java.util.Random;

public class Generate {

	private String password;
	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private int passwordLength = 8;
	private static Random rnd = new Random();

	public Generate() {
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
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		this.password = sb.toString();
		return password;
	}
}
