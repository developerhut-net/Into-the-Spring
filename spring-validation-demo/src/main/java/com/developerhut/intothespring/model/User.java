package com.developerhut.intothespring.model;

import java.util.Date;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {

	//Reference Java Doc - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraints/package-summary
	
	private int id;

	@Size(min = 5, max = 10, message = "Min 5 & Max 10 chars allowed")
	private String username;

	@Size(min = 8, message = "Password should be minimum 8 chars")
	private String password;

	@Pattern(regexp = "^[a-zA-Z0-9]{3,9}$", message = "name must be 3 to 9 long with no special chars")
	private String name;

	@Min(value = 15, message = "Age must be minimum 15 years")
	//@Max(75)
	private int age;

	@AssertTrue
	private boolean activeFlag;

	@Email
	private String email;

	@Past
	private Date birthDate;

	@Future(message = "Invalid meeting date")
	private Date meetingDate;
	
	public User(int id, String username, String password, String name, int age, boolean activeFlag, String email,
			Date birthDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
		this.activeFlag = activeFlag;
		this.email = email;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

}
