package com.gurkan.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SuccessLesson {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private byte avarage;
	private String letterGrade;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserLesson userLesson;
	
	public SuccessLesson() {
		super();
	}

	public SuccessLesson(byte avarage, String letterGrade) {
		super();
		this.avarage = avarage;
		this.letterGrade = letterGrade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAvarage() {
		return avarage;
	}

	public void setAvarage(byte avarage) {
		this.avarage = avarage;
	}

	public String getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public UserLesson getUserLesson() {
		return userLesson;
	}

	public void setUserLesson(UserLesson userLesson) {
		this.userLesson = userLesson;
	}
	
	
	
}
