package com.gurkan.response;

import java.io.Serializable;

public class BaseError implements Serializable {

	private String code;
	private String errors;
	
	public BaseError() {
		
	}

	public BaseError(String code, String errors) {
		super();
		this.code = code;
		this.errors = errors;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}
	
}
