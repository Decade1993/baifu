package com.baifu.erp.api.v1.controller;

import com.baifu.erp.constant.ResultCode;
import com.baifu.erp.constant.ResultMsg;
import com.baifu.erp.dto.CreateDepartmentDTO;
import com.baifu.erp.entity.Department;
import com.baifu.erp.service.DepartmentService;
import com.baifu.erp.validator.ExistDepartmentName;
import com.baifu.erp.vo.DepartmentVO;
import com.baifu.erp.web.BaseController;
import com.baifu.erp.web.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author decade
 * @date 2018年06月11日14:59:42
 */
@Api(value = "部门API", description = "部门API")
@RestController
@RequestMapping("/v1/department")
public class DepartmentController extends BaseController {


  @ApiOperation(value = "查询所有的部门，下级部门在上级部门的children中展示,递归获取")
  @GetMapping("/listAllAsTree")
  public ResponseBean listAsTree() {
    List<DepartmentVO> data = departmentService.listAllAsTree();
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, data);
  }


  @ApiOperation(value = "创建一个部门")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "parentDepartmentName", value = "隶属部门", required = true, paramType = "form"),
    @ApiImplicitParam(name = "departmentName", value = "部门名", required = true, paramType = "form")
  })
  @PostMapping("")
  public ResponseBean create(@Validated CreateDepartmentDTO createDepartmentDTO, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return validateError(bindingResult);
    }
    departmentService.create(createDepartmentDTO);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }

  @ApiOperation(value = "通过部门id查询该部门")
  @GetMapping("/id/{id}")
  public ResponseBean getById(@PathVariable("id") Long id) {
    Department data = departmentService.findById(id);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, data);
  }

  @ApiOperation(value = "通过部门层级查询部门列表[level=0 代表顶级部门]")
  @GetMapping("/level/{level}")
  public ResponseBean getByLevel(@PathVariable("level") Integer level) {
    List<Department> data = departmentService.listByLevel(level);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, data);
  }

  @ApiOperation(value = "通过部门id查询其下属部门列表")
  @GetMapping("/id/{id}/children")
  public ResponseBean getChildrenById(@PathVariable("id") Long id) {
    List<Department> data = departmentService.listChild(id);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, data);
  }

  @ApiOperation(value = "通过部门id删除该部门以及其下所有部门")
  @DeleteMapping("id/{id}")
  public ResponseBean deleteOne(@PathVariable("id") Long id) {
    departmentService.delete(id);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }

  @Autowired
  DepartmentService departmentService;

}
