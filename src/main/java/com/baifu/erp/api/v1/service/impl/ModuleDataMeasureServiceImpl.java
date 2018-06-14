package com.baifu.erp.api.v1.service.impl;

import com.baifu.erp.criteria.ModuleDataMeasureCriteria;
import com.baifu.erp.dao.ModuleDataMeasureDao;
import com.baifu.erp.entity.ModuleDataMeasure;
import com.baifu.erp.service.ModuleDataMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author generator
 */
@Slf4j
@Service
public class ModuleDataMeasureServiceImpl implements ModuleDataMeasureService {

  @Autowired
  private ModuleDataMeasureDao moduleDataMeasureDao;

  @Override
  public ModuleDataMeasure findById(Long id) {
    return moduleDataMeasureDao.findById(id);
  }

  @Override
  public List<ModuleDataMeasure> findByProjectId(Long projectId) {
    ModuleDataMeasureCriteria criteria = new ModuleDataMeasureCriteria();
    criteria.setProjectId(projectId);
    return moduleDataMeasureDao.list(criteria);
  }

  @Override
  public int create(List<String> urlList, Long projectId) {
    List<ModuleDataMeasure> collect = urlList.stream()
      .map(url -> ModuleDataMeasure.create(projectId, url))
      .collect(Collectors.toList());
    return moduleDataMeasureDao.creates(collect);
  }

  @Override
  public int update(ModuleDataMeasure moduleDataMeasure) {
    return moduleDataMeasureDao.update(moduleDataMeasure);
  }

  @Override
  public int delete(Long id) {
    return moduleDataMeasureDao.delete(id);
  }

  @Override
  public int deletes(List<Long> ids) {
    return moduleDataMeasureDao.deletes(ids);
  }
}