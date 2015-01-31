/**
 * Classe représentant l'entité Personne
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package springapp.persons;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import springapp.groupe.Groupe;

@Entity
@Table(name = "PERSON")
public class Person {
	
	/**
	 * Id de la personne et clé primaire de la table Person
	 */
	@Id
	@GeneratedValue
	private String id;
	
	/**
	 * Prénom de la personne
	 */
	@Column
	private String firstName;
	
	/**
	 * Nom de la personne
	 */
	@Column
	private String lastName;
	
	/**
	 * Email de la personne
	 */
	@Column
	private String mail;
	
	/**
	 * Site internet de la personne
	 */
	@Column
	private String website;
	
	/**
	 * Date de naissance de la personne
	 */
	@Column
	private Date birthDate;
	
	/**
	 * Mot de passe de la personne
	 */
	@Column
	private String password;
	
	/**
	 * Groupe auquel appartient la personne
	 * @see Groupe
	 */
	@ManyToOne
	@JoinColumn(name="ID_GROUPE")
	private Groupe groupe;

	/**
	 * Constructeur vide de la classe
	 */
	public Person() {
	}

	/**
	 * Récupération de l'ID de la personne
	 * @return String id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Mise à jour de l'id de la personne
	 * @param String id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Récupération du prénom de la personne
	 * @return String firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Mise à jour du prénom
	 * @param String firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Récupération du Nom de famille
	 * @return String lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Mise à jour du nom de famille
	 * @param String lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Récupération du mail d'une personne
	 * @return String mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Mise à jour du mail
	 * @param String mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Récupération du site internet
	 * @return String website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Mise à jour du site internet d'une personne
	 * @param String website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * Récupération de la date de naissance
	 * @return Date birthdate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Mise à jour de la date de naissance
	 * @param Date birthDate
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Récupération du mot de passe
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Mise à jour du mot de passe
	 * @param String password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Récupération du groupe de la personne
	 * @return Groupe groupe
	 */
	public Groupe getGroupe() {
		return groupe;
	}

	/**
	 * Mise à jour du groupe de la personne
	 * @param Groupe groupe
	 */
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
}