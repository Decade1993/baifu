package com.baifu.erp.api.v1.service.impl;

import com.baifu.erp.criteria.ModuleBrandStandardCriteria;
import com.baifu.erp.dao.ModuleBrandStandardDao;
import com.baifu.erp.entity.ModuleBrandStandard;
import com.baifu.erp.service.ModuleBrandStandardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author generator
*/
@Slf4j
@Service
public class ModuleBrandStandardServiceImpl implements ModuleBrandStandardService {

    @Autowired
    private ModuleBrandStandardDao moduleBrandStandardDao;

    @Override
    public ModuleBrandStandard findById(Long id){
        return moduleBrandStandardDao.findById(id);
    }

  @Override
  public int create(List<ModuleBrandStandard> list, Long projectId) {
    for (ModuleBrandStandard moduleBrandStandard : list) {
      moduleBrandStandard.setProjectId(projectId);
    }
    return moduleBrandStandardDao.creates(list);
  }

  @Override
  public List<ModuleBrandStandard> findByProjectIdAndType(Long projectId, Integer type) {
    ModuleBrandStandardCriteria criteria = new ModuleBrandStandardCriteria();
    criteria.setProjectId(projectId);
    criteria.setType(type);
    return moduleBrandStandardDao.list(criteria);
  }

  @Override
    public int update(ModuleBrandStandard moduleBrandStandard){
        return moduleBrandStandardDao.update(moduleBrandStandard);
    }

    @Override
    public int delete(Long id){
        return moduleBrandStandardDao.delete(id);
    }

    @Override
    public int deletes(List<Long> ids) {
        return moduleBrandStandardDao.deletes(ids);
    }
}