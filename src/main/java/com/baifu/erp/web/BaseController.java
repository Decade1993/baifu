package com.baifu.erp.web;

import com.baifu.erp.config.ResultCode;
import com.baifu.erp.config.ResultMsg;
import com.google.common.collect.ImmutableMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BaseController {

  protected ResponseBean validateError(BindingResult bindingResult) {
    List<Map<String, String>> errors = bindingResult.getFieldErrors().stream()
      .map(error -> ImmutableMap.of(error.getField(),error.getDefaultMessage()))
      .collect(Collectors.toList());

    return new ResponseBean(ResultCode.PARAM_ERROR,ResultMsg.PARAM_ERROR, errors);
  }
}
