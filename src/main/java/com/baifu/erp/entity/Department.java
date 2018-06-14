package com.baifu.erp.entity;


import com.baifu.erp.support.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author generator
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Department extends BaseEntity {
  private static final long serialVersionUID = 1L;

  
  
  /**
   * 部门名称
   */
  private String name;
  
  /**
   * 部门级别
   */
  private Integer level;
}
