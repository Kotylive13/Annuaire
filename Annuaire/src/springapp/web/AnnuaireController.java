package springapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class AnnuaireController {
    
    @RequestMapping(value = "/connexion")
    public ModelAndView connecter() {
        return new ModelAndView("connexion");
    }
    
    @RequestMapping(value = "/annuaire")
    public ModelAndView afficherAnnuaire() {
        return new ModelAndView("afficherAnnuaire");
    }
    
}