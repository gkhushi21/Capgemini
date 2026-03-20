package com.hackerrank.restcontrolleradvice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.dto.GlobalError;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

	// TODO:: implement handler methods for FizzException, BuzzException and
	// FizzBuzzException

	@ResponseBody
	@ExceptionHandler(FizzException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public GlobalError handleFizzException(FizzException exception) {
		return new GlobalError("Fizz Exception has been thrown", "Internal Server Error");
	}

	@ResponseBody
	@ExceptionHandler(BuzzException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public GlobalError handleBuzzException(BuzzException exception) {
		return new GlobalError("Buzz Exception has been thrown", "Bad Request");
	}

	@ResponseBody
	@ExceptionHandler(FizzBuzzException.class)
	@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
	public GlobalError handleFizzBuzzException(FizzBuzzException exception) {
		return new GlobalError("FizzBuzz Exception has been thrown", "Insufficient Storage");
	}

}
