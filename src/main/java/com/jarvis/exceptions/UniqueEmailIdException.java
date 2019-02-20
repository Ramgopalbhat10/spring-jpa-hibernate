package com.jarvis.exceptions;

/**
 * UniqueEmailIdException
 */
public class UniqueEmailIdException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public UniqueEmailIdException(String exception) {
    super(exception);
  }

}