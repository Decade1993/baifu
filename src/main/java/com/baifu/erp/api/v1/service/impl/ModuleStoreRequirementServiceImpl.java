package com.baifu.erp.api.v1.service.impl;

import com.baifu.erp.criteria.ModuleStoreRequirementCriteria;
import com.baifu.erp.dao.ModuleStoreRequirementDao;
import com.baifu.erp.entity.ModuleStoreRequirement;
import com.baifu.erp.service.ModuleStoreRequirementService;
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
public class ModuleStoreRequirementServiceImpl implements ModuleStoreRequirementService {

    @Autowired
    private ModuleStoreRequirementDao moduleStoreRequirementDao;

    @Override
    public ModuleStoreRequirement findById(Long id){
        return moduleStoreRequirementDao.findById(id);
    }

  @Override
  public int create(List<String> urls, Long projectId) {
    List<ModuleStoreRequirement> collect = urls.stream()
      .map(url -> {
        ModuleStoreRequirement requirement = new ModuleStoreRequirement();
        requirement.setProjectId(projectId);
        requirement.setUrl(url);
        return requirement;
      })
      .collect(Collectors.toList());
    return moduleStoreRequirementDao.creates(collect);
  }

  @Override
    public List<ModuleStoreRequirement> findByProjectId(Long projectId) {
        ModuleStoreRequirementCriteria criteria = new ModuleStoreRequirementCriteria();
        criteria.setProjectId(projectId);
        return moduleStoreRequirementDao.list(criteria);
    }

    @Override
    public int update(ModuleStoreRequirement moduleStoreRequirement){
        return moduleStoreRequirementDao.update(moduleStoreRequirement);
    }

    @Override
    public int delete(Long id){
        return moduleStoreRequirementDao.delete(id);
    }

  @Override
  public int deletes(List<Long> ids) {
    return moduleStoreRequirementDao.deletes(ids);
  }
}