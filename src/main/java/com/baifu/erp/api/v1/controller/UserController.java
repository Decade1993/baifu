package com.baifu.erp.api.v1.controller;

import com.baifu.erp.constant.ResultCode;
import com.baifu.erp.constant.ResultMsg;
import com.baifu.erp.dto.CreateUserDTO;
import com.baifu.erp.dto.UpdateUserDTO;
import com.baifu.erp.entity.User;
import com.baifu.erp.service.UserService;
import com.baifu.erp.web.BaseController;
import com.baifu.erp.web.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(value = "账号API", description = "账号API")
@RestController
@RequestMapping("/v1/user")
public class UserController extends BaseController {

  @ApiOperation(value = "新建账号")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "name", value = "姓名", required = true, paramType = "form"),
    @ApiImplicitParam(name = "account", value = "账号", required = true, paramType = "form"),
    @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form"),
    @ApiImplicitParam(name = "belongsTopLevelDepartment", value = "隶属部门", required = true, paramType = "form"),
    @ApiImplicitParam(name = "accountLevelName", value = "所属级别", required = true, paramType = "form"),
    @ApiImplicitParam(name = "belongsDepartment", value = "所属子部门名称", required = true, paramType = "form")
  })
  @PostMapping("")
  public ResponseBean create(@Validated CreateUserDTO createUserDTO, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return validateError(bindingResult);
    }
    userService.create(createUserDTO);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }

  @ApiOperation(value = "列出所有账号")
  @GetMapping("/list")
  public ResponseBean list() {
    List<User> data = userService.listAll();
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, data);
  }

  @ApiOperation(value = "通过id获取账号数据")
  @GetMapping("/id/{id}")
  public ResponseBean getOneById(@PathVariable("id") Long id) {
    User data = userService.findById(id);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, data);
  }

  @ApiOperation(value = "通过account获取账号数据")
  @PutMapping("/account/{account}")
  public ResponseBean getOneByAccount(@PathVariable("account") String account) {
    User data = userService.findByAccount(account);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, data);
  }

  @ApiOperation(value = "修改账号信息")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "password", value = "老密码", required = true, paramType = "form"),
    @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, paramType = "form")
  })
  @PutMapping("/account/{account}")
  public ResponseBean update(@PathVariable("account") String account, @ApiIgnore UpdateUserDTO updateUserDTO) {
    userService.update(account, updateUserDTO);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }

  @ApiOperation(value = "通过id删除该账号")
  @DeleteMapping("id/{id}")
  public ResponseBean deleteOne(@PathVariable("id") Long id) {
    userService.delete(id);
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, null);
  }

  @Autowired
  private UserService userService;
}
