package com.mindtree.industry.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.industry.dto.AccountDto;
import com.mindtree.industry.exception.ExceptionResponse;
import com.mindtree.industry.exception.IndustryException;
import com.mindtree.industry.exception.ServiceException;




@RestControllerAdvice(assignableTypes= {AppRunner.class})
public class ControllerExceptionHandller {

	  @ExceptionHandler(IndustryException.class)
	  @ResponseStatus(value = HttpStatus.NOT_FOUND)
	  public ExceptionResponse handlerExceptionResponse(final IndustryException exception,final HttpServletRequest request)
	  {
		  ExceptionResponse exceptionResponse=new ExceptionResponse();
		  exceptionResponse.setErrorMessage(exception.getMessage());
		  exceptionResponse.setRequesturl(request.getRequestURI());
		  
		  return exceptionResponse;
		  
	  }

	}