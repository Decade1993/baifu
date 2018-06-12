package com.baifu.erp.api.v1.service.impl;

import com.baifu.erp.criteria.UserCriteria;
import com.baifu.erp.dao.UserDao;
import com.baifu.erp.dto.CreateUserDTO;
import com.baifu.erp.dto.UpdateUserDTO;
import com.baifu.erp.entity.User;
import com.baifu.erp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author generator
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public User findById(Long id) {
    return userDao.findById(id);
  }

  @Override
  public int create(CreateUserDTO createUserDTO) {
    User user = new User();
    user.setAccount(createUserDTO.getAccount());
    user.setAccountLevelName(createUserDTO.getAccountLevelName());
    user.setBelongsTopLevelDepartment(createUserDTO.getBelongsTopLevelDepartment());
    user.setName(createUserDTO.getName());
    user.setPassword(createUserDTO.getPassword());
    user.setBelongsDepartment(createUserDTO.getBelongsDepartment());
    user.setToken("token");
    userDao.create(user);
    return 0;
  }

  @Override
  public int update(String account, UpdateUserDTO updateUserDTO) {
    User oldUser = findByAccount(account);
    if (oldUser == null || !oldUser.getPassword().equals(updateUserDTO.getPassword())) {
      return 1;
    }
    User user = new User();
    user.setId(oldUser.getId());
    user.setPassword(updateUserDTO.getNewPassword());
    userDao.update(user);
    return 0;
  }

  @Override
  public User findByAccount(String account) {
    UserCriteria criteria = new UserCriteria();
    criteria.setAccount(account);
    List<User> userList = userDao.list(criteria);
    if (userList.size() > 0) {
      return userList.get(0);
    }
    return null;
  }

  @Override
  public int delete(Long id) {
    return userDao.delete(id);
  }

  @Override
  public List<User> listAll() {
    return userDao.listAll();
  }


}