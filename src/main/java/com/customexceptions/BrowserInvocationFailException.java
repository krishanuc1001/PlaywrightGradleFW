/**
 * 
 */
package com.customexceptions;

public class BrowserInvocationFailException extends FrameworkExceptions {

	public BrowserInvocationFailException(String message) {
		super(message);
	}

	public BrowserInvocationFailException(String message, Throwable cause) {
		super(message, cause);
	}

}
