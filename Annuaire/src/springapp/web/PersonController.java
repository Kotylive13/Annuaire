package springapp.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springapp.persons.IPersonManager;
import springapp.persons.Person;

@Controller()
@RequestMapping("/person")
public class PersonController {

    @Autowired
    IPersonManager personManager;

    @RequestMapping(value = "/list")
    public ModelAndView list() {
    	return new ModelAndView("showAnnuaire", "persons", personManager.findAll());
    }

    @RequestMapping(value = "/details")
    public ModelAndView find(@RequestParam(required = true) int id) {    	
    	return new ModelAndView("showDetails", "person", personManager.find(id));
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
        return /*new ModelAndView(TODO);*/ null;
    }

    protected final Log logger = LogFactory.getLog(getClass()); 

    @RequestMapping(value = "/delete")
    public ModelAndView remove(@RequestParam(required = true) int id) {    
    	int n = personManager.delete(id);
    	if(n == 1) logger.info("Person number " + id + " deleted");
        return /*new ModelAndView(TODO);*/ null;
    }
}