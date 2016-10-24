package com.lin.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

//@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(length = 16)
//	@NotEmpty
//	@EmptyOrSize(min = 3, max = 16, message = "{EmptyOrSize}")
	private String firstName;

	@Column(length = 16)
//	@EmptyOrSize(min = 3, max = 16, message = "{EmptyOrSize}")
	private String lastName;
	
//	private String username;
	
	private String gender;

	@Range(min = 18)
	@NotNull
	private Integer age;
	
	@Email
	@NotEmpty
	@Column(name = "username")
	private String email;

	@Range(min = 30, max = 300)
	@NotNull
	private Integer height;
	
	@Range(min = 30, max = 500)
	@NotNull
	private Integer weight;

	@OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL) 
	@JoinColumn(name="userCredential_id") 
	private UserCredentials userCredentials;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Integer getHeight() {
		return height;
	}
	
	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

}
