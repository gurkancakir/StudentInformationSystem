package com.gurkan.domain;

import java.util.Date;
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
import javax.persistence.ManyToMany;

@Entity
public class Season {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private Date startDate;
	private Date endDate;
	
	@ManyToMany(cascade= CascadeType.ALL,  fetch = FetchType.EAGER, targetEntity = Lesson.class)
    @JoinTable(name = "season_lesson",
    joinColumns = {
        @JoinColumn(name = "season")},
    inverseJoinColumns = {
        @JoinColumn(name = "lesson")})
	private Set lessons = new HashSet();
	
	@ManyToMany(cascade= CascadeType.ALL,  fetch = FetchType.EAGER, targetEntity = Lesson.class)
    @JoinTable(name = "season_userlesson",
    joinColumns = {
        @JoinColumn(name = "season")},
    inverseJoinColumns = {
        @JoinColumn(name = "userlesson")})
	private Set userLessons = new HashSet();
	
	public Season() {
		super();
	}

	public Season(String title, Date startDate, Date endDate) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set getLessons() {
		return lessons;
	}

	public void setLessons(Set lessons) {
		this.lessons = lessons;
	}

	public Set getUserLessons() {
		return userLessons;
	}

	public void setUserLessons(Set userLessons) {
		this.userLessons = userLessons;
	}
	
	
}
