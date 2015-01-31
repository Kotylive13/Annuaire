/**
 * Interface du PersonManager
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package springapp.persons;

import java.util.Collection;

public interface IPersonManager {

	/**
	 * Récupérer les personnes
	 * @return Collection<Person>
	 */
	Collection<Person> findAll();

	/**
	 * Lire une personne
	 * @param String id
	 * @return Person
	 */
	Person find(String id);

	Collection<Person> findByName(String name);
	
	/**
	 * Modification ou ajout d'une nouvelle personne
	 * @param Person p
	 * @return Person
	 */
	Person save(Person p);
	
	/**
	 * suppression d'une personne
	 * @param String id
	 * @return int
	 */
	int delete(String id);
}