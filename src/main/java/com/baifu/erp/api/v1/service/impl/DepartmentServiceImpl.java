package com.baifu.erp.api.v1.service.impl;

import com.baifu.erp.criteria.DepartmentCriteria;
import com.baifu.erp.criteria.DepartmentRelationCriteria;
import com.baifu.erp.dao.DepartmentDao;
import com.baifu.erp.dao.DepartmentRelationDao;
import com.baifu.erp.dto.CreateDepartmentDTO;
import com.baifu.erp.entity.Department;
import com.baifu.erp.entity.DepartmentRelation;
import com.baifu.erp.service.DepartmentService;
import com.baifu.erp.util.BeanMapper;
import com.baifu.erp.vo.DepartmentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.baifu.erp.constant.TreeParameter.DEPARTMENT_CHILD_SEARCH_DEPTH;

/**
 * @author generator
 */
@Slf4j
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentDao departmentDao;
  @Autowired
  private DepartmentRelationDao departmentRelationDao;

  @Override
  public Department findById(Long id) {
    return departmentDao.findById(id);
  }

  @Override
  public int create(CreateDepartmentDTO createDepartmentDTO) {
    String parentDepartmentName = createDepartmentDTO.getParentDepartmentName();
    String departmentName = createDepartmentDTO.getDepartmentName();
    DepartmentCriteria departmentCriteria = new DepartmentCriteria();
    departmentCriteria.setName(parentDepartmentName);
    List<Department> list = departmentDao.list(departmentCriteria);
    Long parentId = list.get(0).getId();
    int level = list.get(0).getLevel() + 1;

    Department department = new Department();
    department.setName(departmentName);
    department.setLevel(level);
    departmentDao.create(department);
    Long childId = department.getId();



    DepartmentRelation departmentRelation = new DepartmentRelation();
    departmentRelation.setParentId(parentId);
    departmentRelation.setChildId(childId);
    departmentRelationDao.create(departmentRelation);

    return 0;
  }

  @Override
  public int update(Department department) {
    return departmentDao.update(department);
  }

  @Override
  public int delete(Long id) {
    List<Long> deleteList = new ArrayList<>();
    deleteList.add(id);
    List<Department> childList = getChildList(id);

    long level = 0;
    while (!childList.isEmpty() && ++level < DEPARTMENT_CHILD_SEARCH_DEPTH) {
      deleteList.addAll(childList.stream().map(item -> item.getId()).collect(Collectors.toList()));

      List<Department> collect = childList.stream()
        .map(item -> getChildList(item.getId()))
        .flatMap(item -> item.stream())
        .collect(Collectors.toList());

      childList.clear();
      childList.addAll(collect);
    }
    return departmentDao.deletes(deleteList);
  }

  @Override
  public List<Department> listChild(Long parentId) {
    if (parentId == null) {
      return null;
    }
    return getChildList(parentId);
  }

  @Override
  public List<Department> listByLevel(Integer level) {
    if (level == null) {
      return null;
    }
    DepartmentCriteria departmentCriteria = new DepartmentCriteria();
    departmentCriteria.setLevel(level);
    return departmentDao.list(departmentCriteria);
  }

  @Override
  public List<DepartmentVO> listAllAsTree() {

    DepartmentCriteria departmentCriteria = new DepartmentCriteria();
    departmentCriteria.setLevel(0);
    List<Department> departmentList = departmentDao.list(departmentCriteria);
    List<DepartmentVO> departmentVOList = BeanMapper.mapList(departmentList, DepartmentVO.class);
    for (DepartmentVO departmentVO : departmentVOList) {
      fillDescendants(departmentVO, 0);
    }
    return departmentVOList;
  }

  /**
   * 给父部门填充children
   * @param parent 父部门
   * @return 填充的子部门个数
   */
  private int fillChildren(DepartmentVO parent) {
    long parentId = parent.getId();
    DepartmentRelationCriteria relationCriteria = new DepartmentRelationCriteria();
    relationCriteria.setParentId(parentId);
    List<DepartmentRelation> childList = departmentRelationDao.list(relationCriteria);
    List<DepartmentVO> children = childList.stream()
      .map(departmentRelation -> departmentDao.findById(departmentRelation.getChildId()))
      .map(department -> BeanMapper.map(department, DepartmentVO.class))
      .collect(Collectors.toList());
    parent.setChildren(children);
    return children.size();
  }

  private List<Department> getChildList(Long parentId) {
    DepartmentRelationCriteria relationCriteria = new DepartmentRelationCriteria();
    relationCriteria.setParentId(parentId);
    List<DepartmentRelation> childList = departmentRelationDao.list(relationCriteria);
    return childList.stream()
      .map(departmentRelation -> departmentDao.findById(departmentRelation.getChildId()))
      .collect(Collectors.toList());
  }

  /**
   * 填充子孙
   * @param parent 父部门
   * @param level 当前递归深度
   */
  private void fillDescendants(DepartmentVO parent, int level) {
    int childCount = fillChildren(parent);
    if (childCount > 0 && level < DEPARTMENT_CHILD_SEARCH_DEPTH) {
      for (DepartmentVO departmentVO : parent.getChildren()) {
        fillDescendants(departmentVO, ++level);
      }
    }
  }
}