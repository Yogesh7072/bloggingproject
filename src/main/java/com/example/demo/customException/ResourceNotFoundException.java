package com.example.demo.customException;

public class ResourceNotFoundException extends RuntimeException {
	String resourceName;
	String fieldName;
	long resourceValue;

	public ResourceNotFoundException(String resourceName, String fieldName, long resourceValue) {
		super(String.format("%s user not found %s : %s", resourceName, fieldName, resourceValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.resourceValue = resourceValue;
	}
}
