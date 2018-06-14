package com.baifu.erp.criteria;

import com.baifu.erp.support.EntityCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
* @author generator
*/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserCriteria extends EntityCriteria {
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
