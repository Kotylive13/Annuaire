package springapp.util;

public class RegexPerson {

	private String expression;
	public RegexPerson() {}
	
	public boolean isCorrectName(String name) {
		expression = "^[a-zA-Z\\s]+"; 
	    return name.matches(expression);  
	}
	
	public boolean isCorrectEmail(String email) {
		expression = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$";
		return email.matches(expression);  
	}
	
	public boolean isCorrectWebsite(String website) {
		expression = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";
		return website.matches(expression);
	}
	
	public boolean isCorrectDate(String date) {
		expression = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
		return date.matches(expression);
	}
	
	public boolean isCorrectPassword(String password) {
		expression = "?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16}";
		return password.matches(expression);
	}
}
