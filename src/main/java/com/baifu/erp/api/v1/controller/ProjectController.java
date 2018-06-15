package com.baifu.erp.api.v1.controller;

import com.baifu.erp.constant.ResultCode;
import com.baifu.erp.constant.ResultMsg;
import com.baifu.erp.entity.Project;
import com.baifu.erp.service.ProjectService;
import com.baifu.erp.web.BaseController;
import com.baifu.erp.web.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(value = "工程API", description = "工程API")
@RestController
@RequestMapping("/v1/project")
@CrossOrigin
public class ProjectController extends BaseController {


  @ApiOperation(value = "获取所有意向工程")
  @GetMapping("/intent/list")
  public ResponseBean listAll() {
    List<Project> data = projectService.list(null);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, data);
  }

  @ApiOperation(value = "创建一个空的意向工程")
  @PostMapping("")
  public ResponseBean create() {
    Project project = projectService.create();
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, project);
  }

  @ApiOperation(value = "更新工程基本信息")
  @PutMapping("")
  public ResponseBean editBaseInfo(Project project) {
    projectService.update(project);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }

  @ApiOperation(value = "通过id删除工程")
  @DeleteMapping("/id/{id}")
  public ResponseBean deleteOne(@ApiParam(required = true) @PathVariable Long id) {
    projectService.delete(id);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }


  @Autowired
  ProjectService projectService;
}
