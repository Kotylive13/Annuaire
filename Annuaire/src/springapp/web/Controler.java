package springapp.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
  description = "Application controler",
  urlPatterns = { "*.htm" }
)
public class Controler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
    }

    public void destroy() {
    }

    // Les méthodes associées aux actions
    // - traitent la requête (ici rien à faire)
    // - prévoient les données pour les pages JSP
    // - renvoient le nom de la page JSP à appeler
    
    public String doHello(HttpServletRequest request) {
        request.setAttribute("message", "Bonjour");
        return "/message.jsp";
    }

    public String doBye(HttpServletRequest request) {
        request.setAttribute("message", "Au revoir");
        return "/message.jsp";
    }

    // Le contrôleur générique assure
    // - l'aiguillage vers la bonne méthode
    // - l'appel de la page JSP
    
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // Extraire la requête
        String action = request.getServletPath();
        String pageJsp = null;
        // Choisir la bonne méthode et traiter la requête
        if (action.equals("/hello.htm")) {
            pageJsp = doHello(request);
        } else if (action.equals("/bye.htm")) {
            pageJsp = doBye(request);
        } else {
            throw new ServletException("no action");
        }
        // Appeler la page JSP
        request.getRequestDispatcher(pageJsp).forward(request, response);
    }
}
