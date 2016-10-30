package com.gurkan.response;

import java.io.Serializable;

public class BaseSuccess implements Serializable{

	private String title;
	private String body;
	
	public BaseSuccess() {
	}

	public BaseSuccess(String title, String body) {
		super();
		this.title = title;
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
