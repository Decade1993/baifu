package com.baifu.erp.service;

import com.baifu.erp.dto.CreateUserDTO;
import com.baifu.erp.dto.UpdateUserDTO;
import com.baifu.erp.entity.User;

import java.util.List;

/**
* @author generator
*/
public interface UserService {

    User findById(Long id);
    int create(CreateUserDTO createUserDTO);
    int update(String account, UpdateUserDTO updateUserDTO);
    int delete(Long id);
    List<User> listAll();
    User findByAccount(String account);

}