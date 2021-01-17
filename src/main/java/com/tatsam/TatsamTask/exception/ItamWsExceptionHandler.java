package com.tatsam.TatsamTask.exception;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class ItamWsExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		details.add(request.getDescription(true));
		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Server Error", details);
		log.error("Unknown exception occurred: " + error, ex);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(SocketTimeoutException.class)
	public final ResponseEntity<Object> handleSocketExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		details.add(request.getDescription(true));
		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "App Session Expired",
				details);
		log.error("Unknown exception occurred: {}", ex);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public final ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException ex,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		details.add(request.getDescription(true));
		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				"Access denied. Please check user permission", details);
		log.error("EmpyraWSException exception occurred: " + error, ex);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		details.add(request.getDescription(true));
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), "Validation Failed", details);
		log.error("Bean Validation exception occurred: " + error, ex);
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ItamWsException.class)
	public final ResponseEntity<Object> handleItsmWsException(ItamWsException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		details.add(request.getDescription(true));
		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Something went wrong",
				details);
		log.error("ItsmWsException exception occurred: " + error, ex);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		details.add(request.getDescription(true));
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.toString(), "Record not found", details);
		log.error("RecordNotFoundException exception occurred: " + error, ex);
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}

}
