package springapp.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
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
import springapp.util.RegexFactory;

import springapp.util.Email;

@Controller()
public class AnnuaireController {

	@Autowired
    IPersonManager personManager;
	
	@Autowired
    IGroupeManager groupeManager;
	
    @RequestMapping(value = "/annuaire_persons")
    public ModelAndView annuaire_persons() {
        return new ModelAndView("annuaire_persons", "persons", personManager.findAll());
    }
    
    @RequestMapping(value = "/create_person")
    public ModelAndView create_persons() {
        return new ModelAndView("edit_person", "groupes", groupeManager.findAll());
    }
    
    @RequestMapping(value = "/detail_person")
    public ModelAndView detail_persons(@RequestParam(required = true) String id) {
        return new ModelAndView("detail_person", "person", personManager.find(id));
    }
    
    @RequestMapping(value = "/edit_person")
    public ModelAndView edit_persons(@RequestParam(required = true) String id) {
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("person", personManager.find(id));
    	model.put("groupes", groupeManager.findAll());
    	
        return new ModelAndView("edit_person", "person", personManager.find(id));
    }
    
    @RequestMapping(value = "/delete_person")
    public ModelAndView delete_persons(@RequestParam(required = true) String id) {
    	personManager.delete(id);
    	return new ModelAndView("annuaire_persons", "persons", personManager.findAll());
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
		RegexFactory regex = new RegexFactory();

		/*if (id == "")
			p = new Person();
		else
			p = personManager.find(id);

		if (regex.isCorrectName(firstName) && !firstName.isEmpty()) {
			p.setFirstName(firstName);
		}
		if (regex.isCorrectName(lastName) && !lastName.isEmpty()) {
			p.setLastName(lastName);
		}
		if (regex.isCorrectEmail(mail) && !mail.isEmpty()) {
			p.setMail(mail);
		}
		if (regex.isCorrectWebsite(website) && !mail.isEmpty() ) {
			p.setWebsite(website == "" ? null : website);
		}
		if (regex.isCorrectDate(birthDate) && !birthDate.isEmpty()) {
			p.setBirthDate(formatter.parse(birthDate));
		}
		if (regex.isCorrectPassword(password) && !birthDate.isEmpty()) {
			p.setPassword(password);
		}*/
		
		if (id == "")
			p = new Person();
		else
			p = personManager.find(id);

		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setMail(mail);
		p.setWebsite(website == "" ? null : website);
		p.setBirthDate(formatter.parse(birthDate));
		p.setPassword(password);
		
		p.setGroupe(groupeManager.find(groupe));

		System.out.println("----------------personID " + id + " " + password);
		
		personManager.save(p);
		
		Email email = new Email();
		email.send(p.getMail(), "Coucou", p.getId()+p.getPassword());
		
		return new ModelAndView("edit_person");
	}
	
    @RequestMapping(value = "/annuaire_groupes")
    public ModelAndView annuaire_groupes() {
        return new ModelAndView("annuaire_groupes", "groupes", groupeManager.findAll());
    }
    
    @RequestMapping(value = "/create_groupe")
    public ModelAndView create_groupe() {
        return new ModelAndView("edit_groupe");
    }
    
    @RequestMapping(value = "/detail_groupe")
    public ModelAndView detail_groupe(@RequestParam(required = true) String id) {
        return new ModelAndView("detail_groupe", "groupe", groupeManager.find(id));
    }
    
    @RequestMapping(value = "/edit_groupe")
    public ModelAndView edit_groupe(@RequestParam(required = true) String id) {
        return new ModelAndView("edit_groupe", "groupe", groupeManager.find(id));
    }
    
    @RequestMapping(value = "/delete_groupe")
    public ModelAndView delete_groupe(@RequestParam(required = true) String id) {
    	groupeManager.delete(id);
    	return new ModelAndView("annuaire_groupes", "groupes", groupeManager.findAll());
    }
    
    @RequestMapping(value = "/save_groupe")
    public ModelAndView save_groupe(
    		@RequestParam(required = true) String id,
    		@RequestParam(required = true) String name
    		) throws ParseException {
    	
    	Groupe g;
    	
    	if(id == "")
    		g = new Groupe();
    	else g = groupeManager.find(id);
    	
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

		Email email = new Email();
		email.send("philippe.mothais@gmail.com", "Test", "Ca marche !!");
		
		return new ModelAndView("connection");
	}
}
