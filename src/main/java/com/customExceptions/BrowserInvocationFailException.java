/**
 * 
 */
package com.customExceptions;

/**
 * Jun 29, 2021
 * 
 * @author Krishanu
 */
@SuppressWarnings("serial")
public class BrowserInvocationFailException extends FrameworkExceptions {

	/**
	 * @param message
	 * @param cause
	 */
	public BrowserInvocationFailException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BrowserInvocationFailException(String message, Throwable cause) {
		super(message, cause);
	}

}
