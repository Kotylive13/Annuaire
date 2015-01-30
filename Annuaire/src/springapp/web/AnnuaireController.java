package springapp.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springapp.groupe.Groupe;
import springapp.groupe.IGroupeManager;
import springapp.persons.IPersonManager;
import springapp.persons.Person;
import springapp.util.RegexPerson;

@Controller()
public class AnnuaireController {

	@Autowired
	IPersonManager personManager;

	@Autowired
	IGroupeManager groupeManager;

	@RequestMapping(value = "/annuaire_persons")
	public ModelAndView annuaire_persons() {
		return new ModelAndView("annuaire_persons", "persons",
				personManager.findAll());
	}

	@RequestMapping(value = "/create_person")
	public ModelAndView create_persons() {
		return new ModelAndView("edit_person");
	}

	@RequestMapping(value = "/detail_person")
	public ModelAndView detail_persons(@RequestParam(required = true) String id) {
		return new ModelAndView("detail_person", "person",
				personManager.find(id));
	}

	@RequestMapping(value = "/edit_person")
	public ModelAndView edit_persons(@RequestParam(required = true) String id) {
		return new ModelAndView("edit_person", "person", personManager.find(id));
	}

	@RequestMapping(value = "/delete_person")
	public ModelAndView delete_persons(@RequestParam(required = true) String id) {
		personManager.delete(id);
		return new ModelAndView("annuaire_persons", "persons",
				personManager.findAll());
	}

	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	@RequestMapping(value = "/save_person")
	public ModelAndView save_persons(@RequestParam(required = true) String id,
			@RequestParam(required = true) String firstName,
			@RequestParam(required = true) String lastName,
			@RequestParam(required = true) String mail,
			@RequestParam(required = true) String website,
			@RequestParam(required = true) String birthDate,
			@RequestParam(required = true) String password,
			@RequestParam(required = true) String groupe) throws ParseException {

		Person p;
		RegexPerson regex = new RegexPerson();

		if (id == "")
			p = new Person();
		else
			p = personManager.find(id);

		if (regex.isCorrectName(firstName)) {
			p.setFirstName(firstName);
		}
		if (regex.isCorrectName(lastName)) {
			p.setLastName(lastName);
		}
		if (regex.isCorrectEmail(mail)) {
			p.setMail(mail);
		}
		if (regex.isCorrectWebsite(website)) {
			p.setWebsite(website == "" ? null : website);
		}
		if (regex.isCorrectDate(birthDate)) {
			p.setBirthDate(formatter.parse(birthDate));
		}
		if (regex.isCorrectPassword(password)) {
			p.setPassword(password);
		}
		p.setGroupe(groupeManager.find(groupe));

		personManager.save(p);
		return new ModelAndView("edit_person");
	}

	@RequestMapping(value = "/annuaire_groupes")
	public ModelAndView annuaire_groupes() {
		return new ModelAndView("annuaire_groupes", "groupes",
				groupeManager.findAll());
	}

	@RequestMapping(value = "/create_groupe")
	public ModelAndView create_groupe() {
		return new ModelAndView("edit_groupe");
	}

	@RequestMapping(value = "/detail_groupe")
	public ModelAndView detail_groupe(@RequestParam(required = true) String id) {
		return new ModelAndView("detail_groupe", "groupe",
				groupeManager.find(id));
	}

	@RequestMapping(value = "/edit_groupe")
	public ModelAndView edit_groupe(@RequestParam(required = true) String id) {
		return new ModelAndView("edit_groupe", "groupe", groupeManager.find(id));
	}

	@RequestMapping(value = "/delete_groupe")
	public ModelAndView delete_groupe(@RequestParam(required = true) String id) {
		groupeManager.delete(id);
		return new ModelAndView("annuaire_groupes", "groupes",
				groupeManager.findAll());
	}

	@RequestMapping(value = "/save_groupe")
	public ModelAndView save_groupe(@RequestParam(required = true) String id,
			@RequestParam(required = true) String name) throws ParseException {

		Groupe g;

		if (id == "")
			g = new Groupe();
		else
			g = groupeManager.find(id);

		g.setName(name);

		groupeManager.save(g);
		return new ModelAndView("edit_groupe");
	}

	@RequestMapping(value = "/connection")
	public ModelAndView connection() {
		return new ModelAndView("connection");
	}

	@RequestMapping(value = "/login")
	public String login(@RequestParam(required = true) String login,
			@RequestParam(required = true) String password, HttpSession session) {

		if (login.equals("admin") && password.equals("admin")
				|| personManager.find(login).getPassword().equals(password))
			session.setAttribute("user", login);

		return "redirect:annuaire_persons.htm";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:annuaire_persons.htm";
	}

	@RequestMapping(value = "/login_forgot")
	public ModelAndView login_forgot() {
		return new ModelAndView("login_forgot");
	}

	@RequestMapping(value = "/generate_login")
	public ModelAndView generate_login() {

		// Recipient's email ID needs to be mentioned.
		String to = "marcel.venturino@gmail.com";// change accordingly

		// Sender's email ID needs to be mentioned
		String from = "annuaire.m2isl@gmail.com";// change accordingly
		final String username = "annuaire.m2isl";// change accordingly
		final String password = "Annuaire";// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Gros caca");

			// Now set the actual message
			message.setText("Je te chie dessus");

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		return new ModelAndView("connection");
	}
}