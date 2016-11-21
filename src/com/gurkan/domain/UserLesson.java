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
public class UserLesson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private User user;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private Lesson lesson;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private Season season;
	
	
	@OneToMany(cascade= CascadeType.ALL,  fetch = FetchType.EAGER, targetEntity = Evaluation.class)
    @JoinTable(name = "userlesson_evaluation", joinColumns =
    @JoinColumn(name = "userlesson"),
    inverseJoinColumns =
    @JoinColumn(name = "evaluation"))
	private Set evaluationRecord = new HashSet();
	
	
	public UserLesson() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Set getEvaluationRecord() {
		return evaluationRecord;
	}

	public void setEvaluationRecord(Set evaluationRecord) {
		this.evaluationRecord = evaluationRecord;
	}
	
	
}
