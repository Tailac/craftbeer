package com.beerhouse.exception;

public class ExceptionResponse {

	private String error;

	public ExceptionResponse(String error) {
		super();
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
