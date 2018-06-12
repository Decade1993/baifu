package com.baifu.erp.validator;

import com.baifu.erp.criteria.UserCriteria;
import com.baifu.erp.dao.UserDao;
import com.baifu.erp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 验证账号唯一
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {UniqueAccount.UniqueAccountValidator.class})
public @interface UniqueAccount {

  String message() default "该账号已经存在";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  class UniqueAccountValidator implements ConstraintValidator<UniqueAccount, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      UserCriteria userCriteria = new UserCriteria();
      userCriteria.setAccount(value);
      List<User> userList = userDao.list(userCriteria);
      return userList.size() == 0;
    }
    @Autowired
    UserDao userDao;
  }

}
