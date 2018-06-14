package com.baifu.erp.dto;

import com.baifu.erp.entity.ModuleDataMeasure;
import com.baifu.erp.entity.ModuleStoreRequirement;
import com.baifu.erp.entity.Project;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author generator
 */
@Data
public class ProjectAllInfoDTO {
  private Project baseInfo;
  private List<ModuleDataMeasure> dataMeasures;
  private List<ModuleStoreRequirement> storeRequirements;
}
