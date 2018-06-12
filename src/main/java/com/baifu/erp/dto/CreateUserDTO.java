package com.baifu.erp.dto;

import com.baifu.erp.validator.ExistDepartmentName;
import com.baifu.erp.validator.UniqueAccount;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author decade
 * @date 2018年06月12日09:44:20
 */
@Data
public class CreateUserDTO {

  @NotBlank(message = "姓名不能为空")
  private String name;

  @NotBlank(message = "账号不能为空")
  @UniqueAccount
  private String account;

  @NotBlank(message = "密码不能为空")
  private String password;

  @NotBlank(message = "隶属部门不能为空")
  @ExistDepartmentName
  private String belongsTopLevelDepartment;

  @NotBlank(message = "所属级别不能为空")
  private String accountLevelName;

  @NotBlank(message = "所属子部门不能为空")
  @ExistDepartmentName
  private String belongsDepartment;

}
