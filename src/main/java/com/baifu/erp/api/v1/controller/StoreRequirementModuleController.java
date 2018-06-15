package com.baifu.erp.api.v1.controller;

import com.baifu.erp.config.ResultCode;
import com.baifu.erp.config.ResultMsg;
import com.baifu.erp.dto.ProjectAllInfoDTO;
import com.baifu.erp.entity.ModuleStoreRequirement;
import com.baifu.erp.entity.Project;
import com.baifu.erp.service.ModuleStoreRequirementService;
import com.baifu.erp.service.ProjectService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "商场要求API", description = "商场要求API")
@RestController
@RequestMapping("/v1/project/id/{id}/storeRequirement")
@CrossOrigin
public class StoreRequirementModuleController {

  @ApiOperation(value = "通过工程id获取商场要求")
  @GetMapping("")
  public ResponseBean get(@PathVariable("id")Long id) {
    List<ModuleStoreRequirement> files = moduleStoreRequirementService.findByProjectId(id);
    Project project = projectService.findById(id);
    ProjectAllInfoDTO projectAllInfoDTO = new ProjectAllInfoDTO();
    projectAllInfoDTO.setBaseInfo(project);
    projectAllInfoDTO.setStoreRequirements(files);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, projectAllInfoDTO);
  }

  @ApiOperation(value = "保存商场要求")
  @PostMapping("")
  public ResponseBean create(@PathVariable("id")Long id, @RequestBody List<String> urls) {
    moduleStoreRequirementService.create(urls, id);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }

  @ApiOperation(value = "删除商场要求")
  @DeleteMapping("")
  public ResponseBean deletes(@PathVariable("id")Long id,@ApiParam(value = "list of 要删除的文件id") @RequestBody List<Long> ids) {
    moduleStoreRequirementService.deletes(ids);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }

  @Autowired
  ModuleStoreRequirementService moduleStoreRequirementService;
  @Autowired
  ProjectService projectService;
}
