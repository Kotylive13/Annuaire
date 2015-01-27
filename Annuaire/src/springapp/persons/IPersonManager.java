package springapp.persons;

import java.util.Collection;

public interface IPersonManager {

	// récupérer les personnes
	Collection<Person> findAll();

	// lire une personne
	Person find(Integer id);

	// modification ou ajout d'une nouvelle personne
	void save(Person p);
	
	// suppresion d'une personne
	int delete(int id);
}