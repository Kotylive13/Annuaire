/**
 * Interface du GroupeManager
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package springapp.groupe;

import java.util.Collection;

public interface IGroupeManager {

	/**
	 * Récupérer les groupes
	 * @return Collection<Groupe>
	 */
	Collection<Groupe> findAll();

	/**
	 * Lire un groupe
	 * @param id
	 * @return Groupe
	 */
	Groupe find(String id);

	/**
	 * Modification ou ajout d'une nouvelle personne
	 * @param Groupe g
	 * @return Groupe
	 */
	Groupe save(Groupe g);
	
	/**
	 * Suppression d'une personne
	 * @param String id
	 * @return int
	 */
	int delete(String id);

	/**
	 * Fonction cherchant un ensemble de groupe à partir de son nom
	 * @param name
	 * @return
	 */
	Collection<Groupe> findByName(String name);
}
