package com.baifu.erp.support;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * entity 抽象父类
 * @author ChenZenghui
 */
@Data
public abstract class BaseEntity implements Serializable {
  private static final long serialVersionUID = -2901727305844590152L;

  @ApiModelProperty(value = "id", required = true)
  private Long id;

  @ApiModelProperty(value = "更新时间")
  private Date updatedAt;

  @ApiModelProperty(value = "创建时间")
  private Date createdAt;

}
