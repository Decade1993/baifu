package com.baifu.erp.service;

import com.baifu.erp.entity.ModuleDataMeasure;

import java.util.List;

/**
* @author generator
*/
public interface ModuleDataMeasureService {

    ModuleDataMeasure findById(Long id);
    int create(List<String> urlList, Long projectId);
    int update(ModuleDataMeasure moduleDataMeasure);
    int delete(Long id);
    int deletes(List<Long> ids);
    List<ModuleDataMeasure> findByProjectId(Long projectId);

}