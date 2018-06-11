package com.baifu.erp.service;

import com.baifu.erp.dto.CreateDepartmentDTO;
import com.baifu.erp.entity.Department;
import com.baifu.erp.vo.DepartmentVO;

import java.util.List;

/**
* @author generator
*/
public interface DepartmentService {

    Department findById(Long id);
    int create(CreateDepartmentDTO createDepartmentDTO);
    int update(Department department);
    int delete(Long id);

    List<DepartmentVO> listAllAsTree();
    List<Department> listByLevel(Integer level);
    List<Department> listChild(Long parentId);

}