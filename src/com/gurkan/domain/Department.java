package com.gurkan.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_id")
	private int id;
	private String name;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "facultyId")
	private Faculty faculty;
	
	@OneToMany(cascade= CascadeType.ALL,  fetch = FetchType.EAGER, targetEntity = Lesson.class)
    @JoinTable(name = "department_lesson", joinColumns =
    @JoinColumn(name = "department"),
    inverseJoinColumns =
    @JoinColumn(name = "lesson"))
	private Set departmentRecord= new HashSet();
	
	public Department() {
		super();
	}

	public Department(String name) {
		super();
		this.name = name;
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

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Set getDepartmentRecord() {
		return departmentRecord;
	}

	public void setDepartmentRecord(Set departmentRecord) {
		this.departmentRecord = departmentRecord;
	}
		
	
}
