package com.gurkan.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class Role{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	
	@OneToMany(cascade= CascadeType.ALL,  fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinTable(name = "role_users", joinColumns =
    @JoinColumn(name = "role"),
    inverseJoinColumns =
    @JoinColumn(name = "user"))
	private Set userRecord = new HashSet();
	
	public Role() {
		super();
	}

	public Role(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set getUserRecord() {
		return userRecord;
	}

	public void setUserRecord(Set userRecord) {
		this.userRecord = userRecord;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", title=" + title+ "]";
	}
	
}
