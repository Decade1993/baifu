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
public class ModuleDataMeasure extends BaseEntity {
  private static final long serialVersionUID = 1L;

  public ModuleDataMeasure() {}

  public ModuleDataMeasure(Long projectId, String url) {
    this.projectId = projectId;
    this.url = url;
  }

  public static ModuleDataMeasure create(Long projectId, String url) {
    return new ModuleDataMeasure(projectId, url);
  }
  
  /**
   * 工程id
   */
  private Long projectId;
  
  /**
   * url
   */
  private String url;
}
