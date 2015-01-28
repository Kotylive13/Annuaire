package springapp.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    public ModelAndView createPerson() {
        return new ModelAndView("edit");
    }
    
    @RequestMapping(value = "/detail")
    public ModelAndView detail(@RequestParam(required = true) int id) {
        return new ModelAndView("detail", "person", personManager.find(id));
    }
    
    @RequestMapping(value = "/edit")
    public ModelAndView editPerson(@RequestParam(required = true) int id) {
        return new ModelAndView("edit", "person", personManager.find(id));
    }
    
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    
    @RequestMapping(value = "/save")
    public ModelAndView save(
    		@RequestParam(required = true) String firstName,
    		@RequestParam(required = true) String lastName,
    		@RequestParam(required = true) String mail,
    		@RequestParam(required = true) String website,
    		@RequestParam(required = true) String birthDate,
    		@RequestParam(required = true) String password,
    		@RequestParam(required = true) String groupe
    		) throws ParseException {
    	
    	Person p = new Person();
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
}