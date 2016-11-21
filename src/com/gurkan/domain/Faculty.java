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
import javax.persistence.OneToMany;

@Entity
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
//	@OneToMany(mappedBy="departmentRecord",cascade=CascadeType.ALL)
//	/*(cascade= CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Department.class)
//    @JoinTable(joinColumns =
//    @JoinColumn(name = "faculty_id"),
//    inverseJoinColumns =
//    @JoinColumn(name = "department_id"))*/
//	private Set<Department> departmentRecord = new HashSet();
	
	public Faculty() {
		super();
	}

	public Faculty(String name) {
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

//	public Set getDepartmentRecord() {
//		return departmentRecord;
//	}
//
//	public void setDepartmentRecord(Set departmentRecord) {
//		this.departmentRecord = departmentRecord;
//	}
	
	
}
