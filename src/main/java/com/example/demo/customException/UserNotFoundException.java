package com.example.demo.customException;

public class UserNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	long resourceValue;

	public UserNotFoundException(String resourceName, String fieldName, long resourceValue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, resourceValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.resourceValue = resourceValue;
	}

}
