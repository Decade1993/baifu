package com.baifu.erp.config;

import com.baifu.erp.web.ResponseBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.OK)
  public ResponseBean ValidationExceptionHandler(ConstraintViolationException cve) {
    Set<ConstraintViolation<?>> cves = cve.getConstraintViolations();
    Map map = new HashMap();
    for (ConstraintViolation<?> constraintViolation : cves) {
      map.put(constraintViolation.getPropertyPath(),constraintViolation.getMessage());
    }
    return new ResponseBean(ResultCode.PARAM_ERROR, ResultMsg.PARAM_ERROR, map);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.OK)
  public ResponseBean globalException(HttpServletRequest request, Throwable ex) {
    return new ResponseBean(200000, "SYSTEM ERROR", null);
  }
}
