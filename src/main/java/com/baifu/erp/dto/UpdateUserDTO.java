package com.baifu.erp.dto;

import lombok.Data;

/**
 * 修改用户信息DTO
 * @author decade
 * @date 2018年06月12日10:43:12
 */
@Data
public class UpdateUserDTO {

  private Long id;

  /**
   * 老密码
   */
  private String password;

  /**
   * 新密码
   */
  private String newPassword;


}
