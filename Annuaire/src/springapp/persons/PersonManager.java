/**
 * Classe représentant le PersonManager
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package springapp.persons;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import springapp.util.PasswordUtils;

@Stateless
@LocalBean()
@Startup
public class PersonManager implements IPersonManager {

	/**
	 * EntityManager
	 */
	@PersistenceContext(unitName = "myData")
	EntityManager em;

	/**
	 * Constructeur vide
	 */
	public PersonManager() {
	}

	/**
	 * Méthode appelée après la création de la classe
	 */
	@PostConstruct
	public void init() {
		System.out.println("INIT EJB = " + this);
	}

	/**
	 * Redéfinition de la méthode findAll
	 * @return Collection<Person>
	 */
	@Override
	public Collection<Person> findAll() {
		return em.createQuery(
				"Select p from Person p order by p.lastName, p.firstName",
				Person.class).getResultList();
	}

	/**
	 * Redéfinition de la méthode find
	 * @param String id
	 * @return Person
	 */
	@Override
	public Person find(String id) {
		PasswordUtils passwordUtil = new PasswordUtils();
		Person p = em.find(Person.class, id);
		if (p != null)
			p.setPassword(passwordUtil.decrypt(p.getPassword()));
		return p;
	}

	/**
	 * Redéfinition de la méthode save
	 * @param Person p
	 * @return Person
	 */
	@Override
	public Person save(Person p) {
		PasswordUtils passwordUtil = new PasswordUtils();
		String password = p.getPassword();
		p.setPassword(passwordUtil.encryptPassword(p.getPassword()));
		p = em.merge(p);
		p.setPassword(password);
		return p;
	}

	/**
	 * Redéfinition de la méthode delete
	 * @param String id
	 * @return int
	 */
	@Override
	public int delete(String id) {
		return em.createQuery("delete from Person p where p.id = :id")
				.setParameter("id", id).executeUpdate();
	}

}
