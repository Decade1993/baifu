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
public class DepartmentRelationCriteria extends EntityCriteria {
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
