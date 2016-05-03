package mum.ea.movie.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Director")
public class Director implements Serializable {

	private static final long serialVersionUID = 4362584978367242292L;

	@Id
	@GeneratedValue
	@Column(name = "directorId", nullable = false)
	private int directorId;

	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "dateOfBirth")
	private LocalDate dateOfBirth;
	
	
	public Director() {
		
	}

	public Director(String firstName, String lastName, LocalDate dateOfBirth) {
		this.firstname = firstName;
		this.lastname = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastName
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}

