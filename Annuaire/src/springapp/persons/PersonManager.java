package springapp.persons;

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
public class PersonManager implements IPersonManager {

	@PersistenceContext(unitName = "myData")
	EntityManager em;

	public PersonManager() {
	}

	@PostConstruct
	public void init() {
		System.out.println("INIT EJB = " + this);
	}

	@Override
	public Collection<Person> findAll() {
		return em.createQuery("Select p from Person p", Person.class)
				.getResultList();
	}

	@Override
	public Person find(String id) {		 
		return em.find(Person.class, id);
	}

	@Override
	public Person save(Person p) {
		return em.merge(p);
	}

	@Override
	public int delete(String id) {
		return em.createQuery("delete from Person p where p.id = :id")
				.setParameter("id", id).executeUpdate();
	}

}
