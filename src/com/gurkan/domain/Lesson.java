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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Lesson {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private double ects;
	private byte credit;
	private String lessonAbstract;
	private String code;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private User instructor;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private Department department;
	
	@ManyToMany(cascade= CascadeType.ALL,  fetch = FetchType.EAGER, targetEntity = Season.class)
    @JoinTable(name = "season_lesson",
    joinColumns = {
        @JoinColumn(name = "lesson")},
    inverseJoinColumns = {
        @JoinColumn(name = "season")})
	private Set seasons = new HashSet();
	
	
	@ManyToMany(cascade= CascadeType.ALL,  fetch = FetchType.EAGER, targetEntity = Season.class)
    @JoinTable(name = "userlesson_lesson",
    joinColumns = {
        @JoinColumn(name = "lesson")},
    inverseJoinColumns = {
        @JoinColumn(name = "userlesson")})
	private Set userLessons = new HashSet();
	
	public Lesson() {
		super();
	}

	public Lesson(String name, double ects, byte credit, String lessonAbstract) {
		super();
		this.name = name;
		this.ects = ects;
		this.credit = credit;
		this.lessonAbstract = lessonAbstract;
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

	public double getEcts() {
		return ects;
	}

	public void setEcts(double ects) {
		this.ects = ects;
	}

	public byte getCredit() {
		return credit;
	}

	public void setCredit(byte credit) {
		this.credit = credit;
	}

	public String getLessonAbstract() {
		return lessonAbstract;
	}

	public void setLessonAbstract(String lessonAbstract) {
		this.lessonAbstract = lessonAbstract;
	}

	public User getInstructor() {
		return instructor;
	}

	public void setInstructor(User instructor) {
		this.instructor = instructor;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set getSeasons() {
		return seasons;
	}

	public void setSeasons(Set seasons) {
		this.seasons = seasons;
	}

	public Set getUserLessons() {
		return userLessons;
	}

	public void setUserLessons(Set userLessons) {
		this.userLessons = userLessons;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
