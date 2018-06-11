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
public class DepartmentRelation extends BaseEntity {
  private static final long serialVersionUID = 1L;

  
  
  /**
   * 父节点id
   */
  private Long parentId;
  
  /**
   * 子节点id
   */
  private Long childId;
}
