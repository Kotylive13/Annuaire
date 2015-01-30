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

	@Id
	@GeneratedValue
	private String id;

	@Column
	private String name;

	@OneToMany(mappedBy = "groupe")
	private Set<Person> persons;

	public Groupe() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
}
