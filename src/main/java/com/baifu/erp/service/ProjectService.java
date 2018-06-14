package com.baifu.erp.service;

import com.baifu.erp.entity.Project;

import java.util.List;

/**
* @author generator
*/
public interface ProjectService {

    Project findById(Long id);
    Project create();
    int update(Project project);
    int delete(Long id);
    List<Project> list(Integer type);
}