package springapp.groupe;

import java.util.Collection;

public interface IGroupeManager {

	// récupérer les groupes
	Collection<Groupe> findAll();

	// lire un groupe
	Groupe find(String id);

	// modification ou ajout d'une nouvelle personne
	void save(Groupe g);
	
	// suppresion d'une personne
	int delete(String id);
}
