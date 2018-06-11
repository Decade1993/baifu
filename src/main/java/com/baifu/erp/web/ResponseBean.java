package com.baifu.erp.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "responseBean", description = "接口返回值")
public class ResponseBean<T> {
  @ApiModelProperty(notes = "状态码", required = true)
  private int ret;

  @ApiModelProperty(notes = "返回信息", required = true)
  private String msg;

  @ApiModelProperty(notes = "返回的数据")
  private T data;

  public ResponseBean(int ret, String msg, T data) {
    this.ret = ret;
    this.msg = msg;
    this.data = data;
  }
}
