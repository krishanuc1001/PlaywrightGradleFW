package com.customexceptions;

public class FrameworkExceptions extends RuntimeException {

  public FrameworkExceptions(String message) {
    super(message);
  }

  // Overloaded Constructors
  public FrameworkExceptions(String message, Throwable cause) {
    super(message, cause);
  }
}
