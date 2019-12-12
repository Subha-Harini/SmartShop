package com.cognizant.smartshop.signupservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="us_id")
	private int id;
	
	@Column(name="us_first_name")
	@NotNull 
	private String firstName;
	
	@Column(name="us_last_name")
	@NotNull
	private String lastName;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Column(name="us_age")
	@NotNull
	private int age;
	
	@Column(name="us_gender")
	@NotNull
	private String gender;
	
	@Column(name="us_contact_number")
	@NotNull
	private long contactNumber;
	
	@Column(name="us_user_id")
	@NotNull
	private String userId;
	
	@Column(name="us_password")
	private String password;
	
	@Column(name="us_user_type")
	@NotNull
	private String userType;
	
	@Column(name="us_status")
	@NotNull
	private String status;
	
	@Column(name="us_secret_question_one")
	@NotNull
	private String secretQuestionOne;
	
	@Column(name="us_secret_Answer_one")
	@NotNull
	private String secretAnswerOne;
	
	@Column(name="us_secret_question_two")
	@NotNull
	private String secretQuestionTwo;
	
	@Column(name="us_secret_Answer_two")
	@NotNull
	private String secretAnswerTwo;
	
	@Column(name="us_secret_question_three")
	@NotNull
	private String secretQuestionThree;
	
	@Column(name="us_secret_Answer_three")
	@NotNull
	private String secretAnswerThree;
	
	
	public User() {
		super();
	}

	public User(int id, @NotNull @Size(min = 2, max = 50) String firstName,
			@NotNull @Size(min = 2, max = 50) String lastName, @NotNull @Size(min = 2, max = 2) int age,
			@NotNull @Size(min = 2, max = 7) String gender, @NotNull @Size(min = 10, max = 10) long contactNumber,
			@NotNull @Size(min = 6, max = 15) String userId, String password,
			@NotNull @Size(min = 1, max = 1) String userType, @NotNull @Size(min = 1, max = 1) String status,
			@NotNull @Size(min = 2, max = 50) String secretQuestionOne,
			@NotNull @Size(min = 2, max = 50) String secretAnswerOne,
			@NotNull @Size(min = 1, max = 1) String secretQuestionTwo,
			@NotNull @Size(min = 1, max = 1) String secretAnswerTwo,
			@NotNull @Size(min = 1, max = 1) String secretQuestionThree,
			@NotNull @Size(min = 1, max = 1) String secretAnswerThree) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.userId = userId;
		this.password = password;
		this.userType = userType;
		this.status = status;
		this.secretQuestionOne = secretQuestionOne;
		this.secretAnswerOne = secretAnswerOne;
		this.secretQuestionTwo = secretQuestionTwo;
		this.secretAnswerTwo = secretAnswerTwo;
		this.secretQuestionThree = secretQuestionThree;
		this.secretAnswerThree = secretAnswerThree;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSecretQuestionOne() {
		return secretQuestionOne;
	}

	public void setSecretQuestionOne(String secretQuestionOne) {
		this.secretQuestionOne = secretQuestionOne;
	}

	public String getSecretAnswerOne() {
		return secretAnswerOne;
	}

	public void setSecretAnswerOne(String secretAnswerOne) {
		this.secretAnswerOne = secretAnswerOne;
	}

	public String getSecretQuestionTwo() {
		return secretQuestionTwo;
	}

	public void setSecretQuestionTwo(String secretQuestionTwo) {
		this.secretQuestionTwo = secretQuestionTwo;
	}

	public String getSecretAnswerTwo() {
		return secretAnswerTwo;
	}

	public void setSecretAnswerTwo(String secretAnswerTwo) {
		this.secretAnswerTwo = secretAnswerTwo;
	}

	public String getSecretQuestionThree() {
		return secretQuestionThree;
	}

	public void setSecretQuestionThree(String secretQuestionThree) {
		this.secretQuestionThree = secretQuestionThree;
	}

	public String getSecretAnswerThree() {
		return secretAnswerThree;
	}

	public void setSecretAnswerThree(String secretAnswerThree) {
		this.secretAnswerThree = secretAnswerThree;
	}

	
}
