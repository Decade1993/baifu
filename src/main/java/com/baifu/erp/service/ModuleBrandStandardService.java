package com.baifu.erp.service;

import com.baifu.erp.entity.ModuleBrandStandard;

import java.util.List;

/**
* @author generator
*/
public interface ModuleBrandStandardService {

    ModuleBrandStandard findById(Long id);
    int create(List<ModuleBrandStandard> list, Long projectId);
    int update(ModuleBrandStandard moduleBrandStandard);
    int delete(Long id);
    int deletes(List<Long> ids);
    List<ModuleBrandStandard> findByProjectIdAndType(Long projectId, Integer type);

}