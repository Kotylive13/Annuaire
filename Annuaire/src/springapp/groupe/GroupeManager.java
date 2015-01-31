/**
 * Classe représentant le GroupeManager
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package springapp.groupe;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean()
@Startup
public class GroupeManager implements IGroupeManager {

	/**
	 * EntityManager
	 */
	@PersistenceContext(unitName = "myData")
	EntityManager em;

	/**
	 * Constructeur vide de la classe
	 */
	public GroupeManager() {
	}

	/**
	 * Fonction appelée après la création de l'objet
	 */
	@PostConstruct
	public void init() {
		System.out.println("INIT EJB = " + this);
	}

	/**
	 * Redéfinition de la méthode findAll
	 * @return Collection<Groupe>
	 */
	@Override
	public Collection<Groupe> findAll() {
		return em.createQuery("Select g from Groupe g order by g.name",
				Groupe.class).getResultList();
	}

	/**
	 * Redéfinition de la méthode find
	 * @param String id
	 * @return Groupe 
	 */
	@Override
	public Groupe find(String id) {
		System.out.println(em.find(Groupe.class, id).getPersons());
		return em.find(Groupe.class, id);
	}

	/**
	 * Redéfinition de la méthode save
	 * @param Groupe g
	 * @return Groupe 
	 */
	@Override
	public Groupe save(Groupe g) {
		return em.merge(g);
	}

	/**
	 * Redéfinition de la méthode delete
	 * @param String id
	 * @return int
	 */
	@Override
	public int delete(String id) {
		return em.createQuery("delete from Groupe g where g.id = :id")
				.setParameter("id", id).executeUpdate();
	}
}
