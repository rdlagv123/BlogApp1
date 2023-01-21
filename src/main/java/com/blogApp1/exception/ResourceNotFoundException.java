package com.blogApp1.exception;

import lombok.Getter;
import lombok.Setter;

public class ResourceNotFoundException extends RuntimeException {
	@Getter
	@Setter
 String resourceName;
 String fieldName;
 long fieldValue;

public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
	super(String.format("%s not found with %s:%l", resourceName,fieldName,fieldValue));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
}

}
