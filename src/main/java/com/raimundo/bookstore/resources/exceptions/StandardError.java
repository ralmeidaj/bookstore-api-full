package com.raimundo.bookstore.resources.exceptions;

public class StandardError {
	
	private long timesTemp;
	private Integer status;
	private String error;
	
	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardError(long timesTemp, Integer status, String error) {
		super();
		this.timesTemp = timesTemp;
		this.status = status;
		this.error = error;
	}

	public long getTimesTemp() {
		return timesTemp;
	}

	public void setTimesTemp(long timesTemp) {
		this.timesTemp = timesTemp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	

}
