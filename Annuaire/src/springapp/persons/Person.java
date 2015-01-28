package springapp.persons;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.bval.constraints.Email;

@Entity
@Table(name = "PERSON")
public class Person {

	@Id
    @GeneratedValue
	@NotNull
    private int id;
	
	@Column
	@NotNull
    @Size(min = 1, message = "Le prénom est obligatoire")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Le prénom contient des caractères invalides")
	private String firstName;
	
	@Column
	@NotNull
    @Size(min = 1, message = "Le nom est obligatoire")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Le nom contient des caractères invalides")
	private String lastName;
	
	@Column
	@NotNull
	@Email(message = "L'adresse mail n'est pas valide")
	private String mail;
	
	@Column
	private String website;
	
	@Column
	@NotNull
	@Past(message = "La date de naissance doit être passée")
	private Date birthDate;
	
	@Column
	@NotNull
	@Size(min = 1, message = "Le mot de passe est obligatoire")
	private String password;
	
	@Column
	@NotNull
	@Size(min = 1, message = "Le groupe est obligatoire")
	private String group;
	
	public Person() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}
