package springapp.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
import springapp.util.Email;
import springapp.util.PasswordUtils;
import springapp.util.RegexFactory;

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
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("person", personManager.find(id));
    	model.put("groupes", groupeManager.findAll());
        return new ModelAndView("detail_person", model);
    }
    
    @RequestMapping(value = "/edit_person")
    public ModelAndView edit_persons(@RequestParam(required = true) String id) {
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("person", personManager.find(id));
    	model.put("groupes", groupeManager.findAll());
    	
        return new ModelAndView("edit_person", model);
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
		PasswordUtils passwordUtils = new PasswordUtils();
		
		if (id == "")
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
		if (regex.isCorrectWebsite(website) && !website.isEmpty() ) {
			p.setWebsite(website == "" ? null : website);
		}
		if (regex.isCorrectDate(birthDate) && !birthDate.isEmpty()) {
			p.setBirthDate(formatter.parse(birthDate));
		}
		if (regex.isCorrectPassword(password) && !password.isEmpty()) {
			p.setPassword(password);
		}
		
		p.setGroupe(groupeManager.find(groupe));
		
		p = personManager.save(p);
		
		Email email = new Email();
		String message;
		message = "Bonjour, voici vos identifiants : \n\n" +
				  "login : " + p.getId() + "\n" +
				  "mot de passe : " + passwordUtils.decrypt(p.getPassword()) + "\n\n" +
				  "Cordialement.";
		email.send(p.getMail(), "Identifiants annuaire", message);
		
		return new ModelAndView("edit_person", "groupes", groupeManager.findAll());
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
    	if (groupeManager.find(id).getPersons().isEmpty()) {
    		groupeManager.delete(id);
    	}
//    	else
//    		System.out.println("coucouuuuuu");
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
    	
        g = groupeManager.save(g);
        return new ModelAndView("edit_groupe");
    }
    
    @RequestMapping(value = "/connection")
    public ModelAndView connection() {
        return new ModelAndView("connection");
    }

	@RequestMapping(value = "/login")
	public String login(@RequestParam(required = true) String login,
			@RequestParam(required = true) String password, HttpSession session) {
		PasswordUtils passwordUtil = new PasswordUtils();
		if (login.equals("admin") && password.equals("admin")
				|| personManager.find(login).getPassword().equals(password))
			session.setAttribute("user", login);

		return "redirect:annuaire_persons.htm";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:connection.htm";
	}

	@RequestMapping(value = "/login_forgot")
	public ModelAndView login_forgot() {
		return new ModelAndView("login_forgot");
	}

	@RequestMapping(value = "/generate_login")
	public ModelAndView generate_login(
			@RequestParam(required = true) String login,
    		@RequestParam(required = true) String mail
			) throws ParseException {

		Person p = personManager.find(login);
		
		if (mail.equals(p.getMail())) {
			
			PasswordUtils passwordUtils = new PasswordUtils();
			p.setPassword(passwordUtils.generatePassword());
			
			p = personManager.save(p);
			
			String message;
			message = "Bonjour, voici vos nouveaux identifiants : \n\n" +
					  "login : " + p.getId() + "\n" +
					  "mot de passe : " + passwordUtils.decrypt(p.getPassword()) + "\n\n" +
					  "Ce mot de passe a été généré automatiquement, " +
					  "nous vous conseillons de le modifier.\n\n" +
					  "Cordialement.";
			
			Email email = new Email();
			email.send("philippe.mothais@gmail.com", "Changement mot de passe", message);
		}
		
		return new ModelAndView("connection");
	}
}
