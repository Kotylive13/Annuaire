package springapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springapp.persons.IPersonManager;

@Controller()
public class AnnuaireController {
    
	@Autowired
    IPersonManager personManager;
	
    @RequestMapping(value = "/annuaire")
    public ModelAndView afficherAnnuaire() {
        return new ModelAndView("showAnnuaire", "persons", personManager.findAll());
    }
}