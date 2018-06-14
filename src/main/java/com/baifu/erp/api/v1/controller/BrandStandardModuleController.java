package com.baifu.erp.api.v1.controller;

import com.baifu.erp.constant.ResultCode;
import com.baifu.erp.constant.ResultMsg;
import com.baifu.erp.dto.ProjectAllInfoDTO;
import com.baifu.erp.entity.ModuleBrandStandard;
import com.baifu.erp.entity.Project;
import com.baifu.erp.service.ModuleBrandStandardService;
import com.baifu.erp.service.ProjectService;
import com.baifu.erp.web.BaseController;
import com.baifu.erp.web.ResponseBean;
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

@Api(value = "品牌标准API", description = "品牌标准API")
@RestController
@RequestMapping("/v1/project/id/{id}/brandStandard")
public class BrandStandardModuleController extends BaseController {

  @ApiOperation(value = "通过工程id获取品牌标准")
  @GetMapping("/type/{type}")
  public ResponseBean get(@ApiParam(required = true) @PathVariable("id")Long id, @PathVariable("type") Integer type) {
    List<ModuleBrandStandard> list = moduleBrandStandardService.findByProjectIdAndType(id, type);
    Project project = projectService.findById(id);
    ProjectAllInfoDTO projectAllInfoDTO = new ProjectAllInfoDTO();
    projectAllInfoDTO.setBrandStandards(list);
    projectAllInfoDTO.setBaseInfo(project);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, projectAllInfoDTO);
  }

  @ApiOperation(value = "保存品牌标准")
  @PostMapping("")
  public ResponseBean create(@PathVariable("id")Long id, @RequestBody List<ModuleBrandStandard> list) {
    moduleBrandStandardService.create(list, id);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }


  @ApiOperation(value = "删除品牌标准")
  @DeleteMapping("")
  public ResponseBean delete(@PathVariable("id")Long id, @ApiParam(value = "list of 要删除的文件id") @RequestBody List<Long> ids) {
    moduleBrandStandardService.deletes(ids);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }

  @Autowired
  ModuleBrandStandardService moduleBrandStandardService;
  @Autowired
  ProjectService projectService;
}
