package com.tatsam.TatsamTask.exception;

public class RecordAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1237456L;

	public RecordAlreadyExistException(String exception) {
		super(exception);
	}
}
