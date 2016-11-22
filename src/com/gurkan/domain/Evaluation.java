package com.gurkan.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String value;
	private byte percent;
	
	@ManyToOne(cascade= CascadeType.REFRESH)
	private UserLesson userLesson;
	
	public Evaluation() {
		super();
	}

	public Evaluation(String name, String value, byte percent) {
		super();
		this.name = name;
		this.value = value;
		this.percent = percent;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public byte getPercent() {
		return percent;
	}

	public void setPercent(byte percent) {
		this.percent = percent;
	}

	public UserLesson getUserLesson() {
		return userLesson;
	}

	public void setUserLesson(UserLesson userLesson) {
		this.userLesson = userLesson;
	}
	
}
