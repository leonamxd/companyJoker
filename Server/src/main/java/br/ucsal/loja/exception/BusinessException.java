package br.ucsal.loja.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 8168777148496459731L;
	
	private HttpStatus status;
	
	public BusinessException(String msg, HttpStatus status) {
		super(msg);
		this.status = status;
	}
	
	public BusinessException(String msg, HttpStatus status, Throwable cause) {
		super(msg, cause);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
