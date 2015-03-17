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
		return em.find(Person.class, id);
	}

	
	@Override
	/**
	 * Redéfinition de la méthode findByName
	 * @param String name
	 * @return Collection<Person>
	 */
	public Collection<Person> findByName(String name) {
		return em.createQuery(
			"Select p from Person p " + 
			"where p.firstName like :firstName OR " + 
			"p.lastName like :lastName " + 
			"order by p.lastName, p.firstName", Person.class)
			.setParameter("firstName", "%" + name + "%")
			.setParameter("lastName", "%" + name + "%").getResultList();
	}

	
	@Override
	/**
	 * Redéfinition de la méthode save
	 * @param Person p
	 * @return Person
	 */
	public Person save(Person p) {
		PasswordUtils passwordUtils = new PasswordUtils();
		p.setPassword(passwordUtils.encryptPassword(p.getPassword()));
		
		String firstName = p.getFirstName();
		
		p.setFirstName(firstName.substring(0, 1).toUpperCase() + 
				firstName.substring(1, firstName.length()).toLowerCase());
		p.setLastName(p.getLastName().toUpperCase());
		
		p = em.merge(p);
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
