package com.baifu.erp.vo;

import com.baifu.erp.entity.Department;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author decade
 * @date 2018年06月11日15:23:36
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DepartmentVO extends Department {

  private List<DepartmentVO> children;
}
