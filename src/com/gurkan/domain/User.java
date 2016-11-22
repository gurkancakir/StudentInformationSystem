package com.gurkan.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class User{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private String tcNo;
	private boolean active;
	private String avatar;
	private String email;
	private String password;
	

	//@ManyToOne(cascade= CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "roleId", insertable = true, updatable = true, nullable=true)
	private Role role;
	
	@OneToMany(cascade= CascadeType.ALL,  fetch = FetchType.EAGER, targetEntity = Lesson.class)
    @JoinTable(name = "instructor_lesson", joinColumns =
    @JoinColumn(name = "instructor"),
    inverseJoinColumns =
    @JoinColumn(name = "lesson"))
	private Set intructorRecord = new HashSet();
	
	@OneToMany(cascade= CascadeType.ALL,  fetch = FetchType.EAGER, targetEntity = Department.class)
    @JoinTable(name = "userlesson_user", joinColumns =
    @JoinColumn(name = "user"),
    inverseJoinColumns =
    @JoinColumn(name = "userlesson"))
	private Set userLessonRecord = new HashSet();
	
	public User() {
		super();
	}

	public User(String name, String surname, String tcNo, boolean active, String avatar) {
		super();
		this.name = name;
		this.surname = surname;
		this.tcNo = tcNo;
		this.active = active;
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Set getIntructorRecord() {
		return intructorRecord;
	}

	public void setIntructorRecord(Set intructorRecord) {
		this.intructorRecord = intructorRecord;
	}

	public Set getUserLessonRecord() {
		return userLessonRecord;
	}

	public void setUserLessonRecord(Set userLessonRecord) {
		this.userLessonRecord = userLessonRecord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname +
				", tcNO="+ tcNo+",email="+email+",password="+password+", role="+ role+ "]";
	}
		
}
