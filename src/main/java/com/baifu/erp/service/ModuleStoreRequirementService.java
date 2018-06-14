package com.baifu.erp.service;

import com.baifu.erp.entity.ModuleStoreRequirement;

import java.util.List;

/**
* @author generator
*/
public interface ModuleStoreRequirementService {

    ModuleStoreRequirement findById(Long id);
    int create(List<String> urls, Long projectId);
    int update(ModuleStoreRequirement moduleStoreRequirement);
    int delete(Long id);
    int deletes(List<Long> ids);
    List<ModuleStoreRequirement> findByProjectId(Long projectId);

}