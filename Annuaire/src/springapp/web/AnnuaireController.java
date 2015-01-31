/**
 * Classe permettant l'aguillage des pages
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package springapp.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import springapp.util.Pages;
import springapp.util.PasswordUtils;
import springapp.util.RegexFactory;

@Controller()
public class AnnuaireController {
	
	@Autowired
    IPersonManager personManager;
	
	@Autowired
    IGroupeManager groupeManager;
	
    @RequestMapping(value = "/annuaire_persons")
    public ModelAndView annuairePersons(@RequestParam(required = false) Integer page) {	
    	if(page == null) return new ModelAndView("redirect:annuaire_persons.htm?page=1");
    	    	     	
    	try {
    		Pages p = new Pages(page, new ArrayList<Object>(personManager.findAll()));
    	
    		Map<String, Object> model = new HashMap<String, Object>();
        	model.put("persons", p.getSubList());
        	model.put("firstPage", p.getFirstPage());
        	model.put("lastPage", p.getLastPage());
            return new ModelAndView("annuaire_persons", model);
    	}
    	catch(Exception e) {
    		return new ModelAndView("redirect:annuaire_persons.htm?page=1");
    	}    	
    }
    
	@RequestMapping(value = "/find_persons")
	public ModelAndView findPersons(@RequestParam(required = true) String name) {
		return new ModelAndView("annuaire_persons", "persons",
				personManager.findByName(name));
	}
        
    @RequestMapping(value = "/create_person")
    public ModelAndView createPerson(HttpSession session) {
    	if(session.getAttribute("user") == null ||
    	   !session.getAttribute("user").equals("admin"))
    		return new ModelAndView("redirect:annuaire_persons.htm?page=1");
    	
        return new ModelAndView("edit_person", "groupes", groupeManager.findAll());
    }
    
    @RequestMapping(value = "/detail_person")
    public ModelAndView detailPerson(@RequestParam(required = true) String id) {
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("person", personManager.find(id));
    	model.put("groupes", groupeManager.findAll());
        return new ModelAndView("detail_person", model);
    }
    
    @RequestMapping(value = "/edit_person")
    public ModelAndView editPerson(@RequestParam(required = true) String id,
    		HttpSession session) {

    	if(session.getAttribute("user") == null ||
    	   !session.getAttribute("user").equals("admin") && 
    	   !session.getAttribute("user").equals(id))
    		return new ModelAndView("redirect:annuaire_persons.htm?page=1");
    	
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("person", personManager.find(id));
    	model.put("groupes", groupeManager.findAll());
    	
        return new ModelAndView("edit_person", model);
    }
    
    @RequestMapping(value = "/delete_person")
    public ModelAndView deletePerson(@RequestParam(required = true) String id,
    		HttpSession session) {
    	
    	if(session.getAttribute("user") == null ||
    	   !session.getAttribute("user").equals("admin"))
    		return new ModelAndView("redirect:annuaire_persons.htm?page=1");
    		
    	personManager.delete(id);
    	return new ModelAndView("redirect:annuaire_persons.htm?page=1");
    }
    
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    @RequestMapping(value = "/save_person")
	public ModelAndView savePerson(@RequestParam(required = true) String id,
			@RequestParam(required = true) String firstName,
			@RequestParam(required = true) String lastName,
			@RequestParam(required = true) String mail,
			@RequestParam(required = true) String website,
			@RequestParam(required = true) String birthDate,
			@RequestParam(required = true) String password,
			@RequestParam(required = true) String groupe,
			HttpSession session) {

    	if(session.getAttribute("user") == null ||
    	   !session.getAttribute("user").equals("admin") && 
    	   !session.getAttribute("user").equals(id))
    		return new ModelAndView("redirect:annuaire_persons.htm?page=1");
    	
		Person p;
		RegexFactory regex = new RegexFactory();
		
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
			p.setWebsite(website);
		}
		if (regex.isCorrectDate(birthDate)) {
			try {
				p.setBirthDate(formatter.parse(birthDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (regex.isCorrectPassword(password)) {
			p.setPassword(password);
		}
		
		p.setGroupe(groupeManager.find(groupe));
		
		p = personManager.save(p);
		
		Email email = new Email();
		String message;
		message = "Bonjour, voici vos identifiants : \n\n" +
				  "login : " + p.getId() + "\n" +
				  "mot de passe : " + p.getPassword() + "\n\n" +
				  "Cordialement.";
		email.send(p.getMail(), "Identifiants annuaire", message);
		
		return new ModelAndView("edit_person", "groupes", groupeManager.findAll());
	}
	
    @RequestMapping(value = "/annuaire_groupes")
    public ModelAndView annuaireGroupes(@RequestParam(required = false) Integer page) {	
    	if(page == null) return new ModelAndView("redirect:annuaire_groupes.htm?page=1");
    	    	     	
    	try {
    		Pages p = new Pages(page, new ArrayList<Object>(groupeManager.findAll()));
    	
    		Map<String, Object> model = new HashMap<String, Object>();
        	model.put("groupes", p.getSubList());
        	model.put("firstPage", p.getFirstPage());
        	model.put("lastPage", p.getLastPage());
            return new ModelAndView("annuaire_groupes", model);
    	}
    	catch(Exception e) {
    		return new ModelAndView("redirect:annuaire_groupes.htm?page=1");
    	}    	
    }
    
	@RequestMapping(value = "/find_groupes")
	public ModelAndView findGroupes(@RequestParam(required = true) String name) {
		return new ModelAndView("annuaire_groupes", "groupes",
				groupeManager.findByName(name));
	}
    
    @RequestMapping(value = "/create_groupe")
    public ModelAndView createGroupe(HttpSession session) {
    	
    	if(session.getAttribute("user") == null ||
    	   !session.getAttribute("user").equals("admin"))
    		return new ModelAndView("redirect:annuaire_persons.htm?page=1");
    	
        return new ModelAndView("edit_groupe");
    }
    
    @RequestMapping(value = "/detail_groupe")
    public ModelAndView detailGroupe(@RequestParam(required = true) String id) {
        return new ModelAndView("detail_groupe", "groupe", groupeManager.find(id));
    }
    
    @RequestMapping(value = "/edit_groupe")
    public ModelAndView editGroupe(@RequestParam(required = true) String id,
    		HttpSession session) {
    	
    	if(session.getAttribute("user") == null ||
    	   !session.getAttribute("user").equals("admin"))
    		return new ModelAndView("redirect:annuaire_persons.htm?page=1");
    	
        return new ModelAndView("edit_groupe", "groupe", groupeManager.find(id));
    }
    
    @RequestMapping(value = "/delete_groupe")
    public ModelAndView deleteGroupe(@RequestParam(required = true) String id,
    		HttpSession session) {
    	
    	if(session.getAttribute("user") == null ||
    	   !session.getAttribute("user").equals("admin"))
    		return new ModelAndView("redirect:annuaire_persons.htm?page=1");
    	
    	if (groupeManager.find(id).getPersons().isEmpty()) {
    		groupeManager.delete(id);
    	}
    	else {
    		// TODO
    	}
    	
    	return new ModelAndView("redirect:annuaire_groupes.htm?page=1");
    }
    
    @RequestMapping(value = "/save_groupe")
    public ModelAndView saveGroupe(
    		@RequestParam(required = true) String id,
    		@RequestParam(required = true) String name,
    		HttpSession session) {
    	
    	if(session.getAttribute("user") == null ||
    	   !session.getAttribute("user").equals("admin"))
    		return new ModelAndView("redirect:annuaire_persons.htm?page=1");
    	    	
    	Groupe g;
    	RegexFactory regex = new RegexFactory();
    	Map<String, String> model = new HashMap<String, String>();
    	
    	if(id == "")
    		g = new Groupe();
    	else g = groupeManager.find(id);
    	
    	if (!regex.isCorrectName(name)) {
        	model.put("type", "error");
        	model.put("message", "Ce nom de groupe n'est pas valable.");
        	model.put("name", name);
    		return new ModelAndView("edit_groupe", model);
    	}
    	
    	g.setName(name);
    	
        g = groupeManager.save(g);
        model.put("type", "success");
    	model.put("message", "Le groupe a été ajouté avec succès.");
        return new ModelAndView("edit_groupe", model);
    }
    
    @RequestMapping(value = "/connection")
    public ModelAndView connection() {
        return new ModelAndView("connection");
    }

	@RequestMapping(value = "/login")
	public ModelAndView login(
			@RequestParam(required = true) String login,
			@RequestParam(required = true) String password, 
			HttpSession session) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		if (login.equals("admin") && password.equals("admin") 
			    || personManager.find(login) != null 
			    && personManager.find(login).getPassword().equals(password)) {
			
			session.setAttribute("user", login);	    	
	    	return new ModelAndView("redirect:annuaire_groupes.htm?page=1");
	    }
		
		model.put("type", "error");
    	model.put("message", "Le login ou le mot de passe n'est pas correct.");
		return new ModelAndView("connection", model);
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
		Map<String, String> model = new HashMap<String, String>();
		
		if (mail.equals(p.getMail())) {
			
			PasswordUtils passwordUtils = new PasswordUtils();
			p.setPassword(passwordUtils.generatePassword());
			
			p = personManager.save(p);
			
			String message;
			message = "Bonjour, voici vos nouveaux identifiants : \n\n" +
					  "login : " + p.getId() + "\n" +
					  "mot de passe : " + p.getPassword() + "\n\n" +
					  "Ce mot de passe a été généré automatiquement, " +
					  "nous vous conseillons de le modifier.\n\n" +
					  "Cordialement.";
			
			Email email = new Email();
			email.send(p.getMail(), "Changement mot de passe", message);
			model.put("type", "success");
	    	model.put("message", "Un nouveau mot de passe vous a été envoyé par e-mail.");
			return new ModelAndView("connection", model);
		} else {
			model.put("type", "error");
	    	model.put("message", "Cette adresse e-mail est introuvable dans l'annuaire.");
			return new ModelAndView("login_forgot", model);
		}
	}
}
