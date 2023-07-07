package com.hibernate.assignment3.exception;

public class PlayerNotFound extends RuntimeException {

  public PlayerNotFound(String message) {
    super(message);
  }
}
