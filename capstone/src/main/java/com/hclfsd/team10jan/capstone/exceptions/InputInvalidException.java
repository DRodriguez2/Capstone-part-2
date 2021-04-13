package com.hclfsd.team10jan.capstone.exceptions;

public class InputInvalidException extends RuntimeException{
	public InputInvalidException(String s) {
	    super("Invalid Input given in the FORM data!!! : " + s);

	}
}
