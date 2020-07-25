package com.tanwar.glaucustest.exception.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tanwar.glaucustest.domain.ErrorCodes;
import com.tanwar.glaucustest.domain.ExceptionTO;
import com.tanwar.glaucustest.exception.PersonNotFoundException;

/**
 * Exception handler class for handling exceptions thrown in Person application.
 * 
 * @author Tanwar
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class PersonExceptionHandler {

	/**
	 * Method to handle Person not found exception.
	 * 
	 * @param personNotFoundException
	 * @return
	 */
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = PersonNotFoundException.class)
	public ExceptionTO handlePersonNotFoundException(PersonNotFoundException personNotFoundException) {
		ExceptionTO exceptionTO = new ExceptionTO();
		exceptionTO.setCode(ErrorCodes.NOT_FOUND);
		exceptionTO.setMessage(personNotFoundException.getMessage());
		return exceptionTO;
	}

	/**
	 * Method to handle validation errors.
	 * 
	 * @param methodArgumentNotValidException
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ExceptionTO> handleValidationExceptions(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		List<ExceptionTO> errors = new ArrayList<>();
		methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			ExceptionTO exceptionTO = new ExceptionTO();
			exceptionTO.setCode(ErrorCodes.VALIDATION_ERROR);
			exceptionTO.setMessage(fieldName + " " + errorMessage);
			errors.add(exceptionTO);
		});
		return errors;
	}

}
