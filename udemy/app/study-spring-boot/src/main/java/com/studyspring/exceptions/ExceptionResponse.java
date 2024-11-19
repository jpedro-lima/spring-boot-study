package com.studyspring.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Date	timestump;
	private String	message;
	private String	details;

	public ExceptionResponse (Date timestump, String message, String details) {
		super();
		this.timestump = timestump;
		this.message = message;
		this.details = details;
	}

	public Date getTimestump() { return timestump; }
	public void setTimestump(Date timestump) { this.timestump = timestump; }

	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }

	public String getDetails() { return details; }
	public void setDetails(String details) { this.details = details; }
}