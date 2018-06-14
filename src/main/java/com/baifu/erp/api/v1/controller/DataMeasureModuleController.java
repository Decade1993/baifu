package com.baifu.erp.api.v1.controller;

import com.baifu.erp.constant.ResultCode;
import com.baifu.erp.constant.ResultMsg;
import com.baifu.erp.dto.ProjectAllInfoDTO;
import com.baifu.erp.entity.ModuleDataMeasure;
import com.baifu.erp.entity.Project;
import com.baifu.erp.service.ModuleDataMeasureService;
import com.baifu.erp.service.ProjectService;
import com.baifu.erp.util.BeanMapper;
import com.baifu.erp.web.ResponseBean;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "测量数据API", description = "测量数据API")
@RestController
@RequestMapping("/v1/project/id/{id}/dataMeasure")
public class DataMeasureModuleController {


  @ApiOperation(value = "通过工程id获取测量数据")
  @GetMapping("")
  public ResponseBean get(@PathVariable("id")Long id) {
    List<ModuleDataMeasure> files = moduleDataMeasureService.findByProjectId(id);
    Project project = projectService.findById(id);
    ProjectAllInfoDTO projectAllInfoDTO = new ProjectAllInfoDTO();
    projectAllInfoDTO.setBaseInfo(project);
    projectAllInfoDTO.setDataMeasures(files);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, projectAllInfoDTO);
  }

  @ApiOperation(value = "保存测量数据")
  @PostMapping("")
  public ResponseBean create(@PathVariable("id")Long id, @RequestBody List<String> urls) {
    moduleDataMeasureService.create(urls, id);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }

  @ApiOperation(value = "删除测量数据")
  @DeleteMapping("")
  public ResponseBean delete(@PathVariable("id")Long id,@ApiParam(value = "list of 要删除的文件id") @RequestBody List<Long> ids) {
    moduleDataMeasureService.deletes(ids);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }

  @Autowired
  ProjectService projectService;
  @Autowired
  ModuleDataMeasureService moduleDataMeasureService;
}
