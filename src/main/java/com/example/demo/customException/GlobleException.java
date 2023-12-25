package com.example.demo.customException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.apiResponse.ApiResponse;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobleException {
	/**
	 * @note This method is triggered when resource not found exception we can
	 *       handel it
	 * 
	 * @return error messages.
	 * @see FieldError
	 * @see ResourceNotFoundException , NullPointerException , UserNotFoundException
	 * @see ResponseEntity
	 * @author Yogeshwar Chate
	 */
	@ExceptionHandler({ ResourceNotFoundException.class, NullPointerException.class, UserNotFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ApiResponse> handleNotFoundException(RuntimeException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is triggered when we add duplicate entity in gmail column then
	 * getting this exception
	 * 
	 * @return field names and error messages.
	 * @see FieldError
	 * @see SQLIntegrityConstraintViolationException
	 * @author Yogeshwar Chate
	 */

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<String> handleIntegrityConstraintViolation(SQLIntegrityConstraintViolationException ex) {
		String errorMessage = ex.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(SQLException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<String> SQLException(SQLException ex) {
		String errorMessage = ex.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
	}

	/**
	 * This method is triggered when a {@link MethodArgumentNotValidException}
	 * occurs. typically due to validation failure in request parameters annotated
	 * with {@code @Valid} in the controller methods.
	 * 
	 * @return A {@code ResponseEntity} containing a map of field names and error
	 *         messages.
	 * @see FieldError
	 * @see MethodArgumentNotValidException
	 * @see ResponseEntity
	 * @author Yogeshwar Chate
	 */
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldname = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			map.put(fieldname, message);
		});

		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);

//		for (ObjectError objectError : allErrors) {
//			objectError.getDefaultMessage();
//			objectError.getObjectName();
//
//		}

	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ApiResponse> handleGenericException(Exception ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	@ExceptionHandler({ ResourceNotFoundException.class, NullPointerException.class, Exception.class,
//			UserNotFoundException.class })
//	public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandelar(ResourceNotFoundException ex) {
//		String message = ex.getMessage();
//
//		ApiResponse apiResponse = new ApiResponse(message, false);
//
//		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
//	}

//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandelar(ResourceNotFoundException ex) {
//		String message = ex.getMessage();
//		ApiResponse apiResponse = new ApiResponse(message, false);
//
//		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
//	}
//	
}
