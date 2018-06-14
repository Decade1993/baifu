package com.baifu.erp.api.v1.service.impl;

import com.baifu.erp.dao.ProjectDao;
import com.baifu.erp.entity.Project;
import com.baifu.erp.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author generator
*/
@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public Project findById(Long id){
        return projectDao.findById(id);
    }

    @Override
    public Project create(){
        Project project = new Project();
        projectDao.create(project);
        return project;
    }

    @Override
    public int update(Project project){
        return projectDao.update(project);
    }

    @Override
    public int delete(Long id){
        return projectDao.delete(id);
    }

  /**
   * 通过工程类别列出所有工程
   * @param type 工程类别：意向工程，跑单工程，交付工程
   * @return 工程list
   */
  @Override
  public List<Project> list(Integer type) {
      return projectDao.listAll();
    }

}