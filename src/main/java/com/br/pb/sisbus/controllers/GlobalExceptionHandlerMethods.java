package com.br.pb.sisbus.controllers;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandlerMethods {
/*
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception erro){
		return "/error/Exception";
	}
*/
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = NoHandlerFoundException.class)
	public String handleNoHandlerFoundException(HttpServletRequest request, Exception e){
		return "/error/404";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public String handleDataIntegrityViolationException(DataIntegrityViolationException erro){
		return "/error/500";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = ConstraintViolationException.class)
	public String handleConstraintViolationException(ConstraintViolationException erro){
		return "/error/500";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = MySQLIntegrityConstraintViolationException.class)
	public String handleMySQLIntegrityConstraintViolationException(MySQLIntegrityConstraintViolationException erro){
		return "/error/500";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = TransactionSystemException.class)
	public String handleTransactionSystemException(TransactionSystemException erro){
		return "/error/500";
	}
	
	
}
