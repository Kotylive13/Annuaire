package springapp.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springapp.persons.IPersonManager;
import springapp.persons.Person;

@Controller()
public class AnnuaireController {
    
	@Autowired
    IPersonManager personManager;
	
    @RequestMapping(value = "/annuaire")
    public ModelAndView annuaire() {
        return new ModelAndView("annuaire", "persons", personManager.findAll());
    }
    
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("edit");
    }
    
    @RequestMapping(value = "/detail")
    public ModelAndView detail(@RequestParam(required = true) String id) {
        return new ModelAndView("detail", "person", personManager.find(id));
    }
    
    @RequestMapping(value = "/edit")
    public ModelAndView edit(@RequestParam(required = true) String id) {
        return new ModelAndView("edit", "person", personManager.find(id));
    }
    
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    
    @RequestMapping(value = "/save")
    public ModelAndView save(
    		@RequestParam(required = true) String id,
    		@RequestParam(required = true) String firstName,
    		@RequestParam(required = true) String lastName,
    		@RequestParam(required = true) String mail,
    		@RequestParam(required = true) String website,
    		@RequestParam(required = true) String birthDate,
    		@RequestParam(required = true) String password,
    		@RequestParam(required = true) String groupe,
    		HttpSession session) throws ParseException {
    	
    	Person p;
    	
    	if(id == "")
    		p = new Person();
    	else p = personManager.find(id);
    	
    	p.setFirstName(firstName);
    	p.setLastName(lastName);
    	p.setMail(mail);
    	p.setWebsite(website == "" ? null : website);
    	p.setBirthDate(formatter.parse(birthDate));
    	p.setPassword(password);
    	p.setGroupe(groupe);
    	
        personManager.save(p);
        return new ModelAndView("edit");
    }
    
    @RequestMapping(value = "/connection")
    public ModelAndView connection() {
        return new ModelAndView("connection");
    }

    @RequestMapping(value = "/login")
    public String login(
    		@RequestParam(required = true) String login,
    		@RequestParam(required = true) String password,
    		HttpSession session) {
    	
    	if(login.equals("admin") && password.equals("admin") ||
    	   personManager.find(login).getPassword().equals(password))
    		session.setAttribute("user", login);
    	
        return "redirect:annuaire.htm";
    }
    
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {    	
    	session.invalidate();    	
        return "redirect:annuaire.htm";
    }
}