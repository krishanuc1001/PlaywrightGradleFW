package com.customExceptions;

@SuppressWarnings("serial")
public class InvalidPathForFilesException extends FrameworkExceptions {

	public InvalidPathForFilesException(String message) {
		super(message);
	}

	public InvalidPathForFilesException(String message, Throwable cause) {
		super(message, cause);
	}

}
