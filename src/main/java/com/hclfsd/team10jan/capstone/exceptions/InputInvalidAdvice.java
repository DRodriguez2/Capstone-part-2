package com.hclfsd.team10jan.capstone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class InputInvalidAdvice {

  @ResponseBody
  @ExceptionHandler(InputInvalidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String inputInvalidHandler(InputInvalidException ex) {
    return ex.getMessage();
  }
}