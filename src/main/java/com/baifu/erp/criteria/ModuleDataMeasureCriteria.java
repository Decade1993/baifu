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
public class ModuleDataMeasureCriteria extends EntityCriteria {
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
