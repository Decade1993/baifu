package com.baifu.erp.entity;

import com.baifu.erp.support.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * @author generator
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
  private static final long serialVersionUID = 1L;

  
  
  /**
   * 名称
   */
  private String name;
  
  /**
   * 账号
   */
  private String account;
  
  /**
   * 密码
   */
  private String password;
  
  /**
   * token
   */
  private String token;
  
  /**
   * 所属部门
   */
  private String belongsDepartment;
  
  /**
   * 账号级别名称
   */
  private String accountLevelName;
  
  /**
   * 账号级别
   */
  private Integer accountLevel;
  
  /**
   * 所属顶级部门
   */
  private String belongsTopLevelDepartment;
}
