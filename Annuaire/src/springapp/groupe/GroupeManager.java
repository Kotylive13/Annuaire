package springapp.groupe;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import springapp.persons.Person;

@Stateless
@LocalBean()
@Startup
public class GroupeManager implements IGroupeManager {

	@PersistenceContext(unitName = "myData")
	EntityManager em;

	public GroupeManager() {
	}

	@PostConstruct
	public void init() {
		System.out.println("INIT EJB = " + this);
	}

	@Override
	public Collection<Groupe> findAll() {
		return em.createQuery("Select g from Groupe g", Groupe.class)
				.getResultList();
	}

	@Override
	public Groupe find(String id) {
		//System.out.println(em.find(Groupe.class, id).getPersons());
		em.find(Groupe.class, id).setPersons(new HashSet<Person>());
		return em.find(Groupe.class, id);
	}

	@Override
	public void save(Groupe p) {
		em.merge(p);
	}

	@Override
	public int delete(String id) {
		return em.createQuery("delete from Groupe g where g.id = :id")
				.setParameter("id", id).executeUpdate();
	}
}
