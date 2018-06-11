package com.baifu.erp.support;

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

  private Long id;
  private Date updatedAt;
  private Date createdAt;

}
