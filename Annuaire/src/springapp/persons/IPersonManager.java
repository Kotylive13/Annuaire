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

	/**
	 * Fonction cherchant un ensemble de personnes à partir de leur nom ou prénom
	 * @param name
	 * @return
	 */
	Collection<Person> findByName(String name);
	
	/**
	 * Modification ou ajout d'une nouvelle personne
	 * @param Person p
	 * @return Person
	 */
	Person save(Person p);
	
	/**
	 * Suppression d'une personne
	 * @param String id
	 * @return int
	 */
	int delete(String id);
}