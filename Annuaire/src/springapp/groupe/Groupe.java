/**
 * Classe représentant l'entité Groupe
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package springapp.groupe;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import springapp.persons.Person;

@Entity
@Table(name = "GROUPE")
public class Groupe {

	/**
	 * C'est l'ID du groupe, il ne peut être modifié. De plus, il est clé primaire de la table Groupe
	 */
	@Id
	@GeneratedValue
	private String id;

	/**
	 * Représente le nom du groupe
	 */
	@Column
	private String name;

	/**
	 * Représente la liste des personnes appartenant au groupe
	 * @see Person
	 */
	@OneToMany(mappedBy = "groupe")
	private Set<Person> persons;

	/**
	 * Constructeur vide de la classe
	 */
	public Groupe() {
	}

	/**
	 * 
	 * @return String id du groupe
	 */
	public String getId() {
		return id;
	}

	/**
	 * Met à jour l'ID du groupe
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return String le nom du Groupe
	 */
	public String getName() {
		return name;
	}

	/**
	 * Met à jour le nom du groupe
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return Set<Person> la liste des personnes appartenant au groupe
	 */
	public Set<Person> getPersons() {
		return persons;
	}

	/**
	 * Met à jour la liste des personnes appartenant au groupe
	 * @param persons
	 */
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
}
