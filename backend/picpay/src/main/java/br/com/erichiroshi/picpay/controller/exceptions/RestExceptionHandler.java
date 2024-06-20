package br.com.erichiroshi.picpay.controller.exceptions;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.erichiroshi.picpay.service.exception.PicPayException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(PicPayException.class)
	public ProblemDetail handlePicPayException(PicPayException e) {
		return e.toProblemDetail();
	}
}