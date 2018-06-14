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
public class ModuleStoreRequirement extends BaseEntity {
  private static final long serialVersionUID = 1L;

  
  
  /**
   * 工程id
   */
  private Long projectId;
  
  /**
   * url
   */
  private String url;
}
