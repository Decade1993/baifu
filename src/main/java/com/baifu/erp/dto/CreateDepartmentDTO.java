package com.baifu.erp.dto;

import com.baifu.erp.validator.ExistDepartmentName;
import com.baifu.erp.validator.NotExistDepartmentName;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 创建部门dto
 * @author decade
 * @date 2018年06月11日20:19:14
 */
@Data
public class CreateDepartmentDTO {

  @NotBlank
  @ExistDepartmentName
  private String parentDepartmentName;

  @NotBlank
  @NotExistDepartmentName
  private String departmentName;
}
